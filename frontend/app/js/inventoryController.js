MyApp.controller('inventoryController', function ($scope, $http, $location, $window, $cookies, $route, $anchorScroll) {
    $scope.inputs = [];
    $scope.whs = [];
    $scope.wId;
    $scope.items = [];
    $scope.disableBtn = true;
    var scope = $scope;
    $scope.initial = {
        amount: '',
    }
    var dateToday = new Date();
    $(function () {
        $("#datepicker").datepicker({
            showButtonPanel: true,
            minDate: -3,
            maxDate: 0
        });
    });

    scope.newItem = function () {
        return {
            itemId: '',
            amount: ''
        }
    }

    // scope.getData = function(){
    //     var data = scope.newItem();
    //     $scope.var1 = data.itemid;
    //     $scope.var2 = data.amount;
    // }

    $scope.chooseItem = function (itId) {
        $scope.var1 = itId;
    }

    $scope.changeInput = function (amount) {
        $scope.var2 = amount;
    }

    $scope.add = function () {
        $scope.disableBtn = false;
        $scope.inputs.push(scope.newItem());
        for (i = 0; i < $scope.items.length; i++) {
            document.getElementById("index_" + i).disabled = true;
        }
    };

    // $scope.add = function () {
    //     $scope.inputs.push({});
    //     for (i = 0; i < $scope.items.length; i++) {
    //         document.getElementById("index_" + i).disabled = true;
    //     }
    // };

    $scope.delete = function (input) {
        var index = $scope.inputs.indexOf(input);
        $scope.inputs.splice(index, 1);
        if(index == 0){
            $scope.disableBtn = true;
        }
    }

    $http.get("api/firms/" + $cookies.get("firmId") + "/whs").then(function (response) {
        $scope.whs = response.data;
    });

    $scope.chooseWh = function (wId) {
        $http.get("/api/items/allItems/" + wId).then(function (response) {
            console.log(JSON.stringify(response));
            $scope.items = response.data;
        });
    }

    $scope.addInvPage = function (addInv, inputs) {
        var params = {
            inventoryNumber: addInv.inventoryNumber,
            committeeSquad: addInv.committeeSquad,
            comment: addInv.comment,
            personId: $cookies.get("userId"),
            warehouseId: $scope.wId,
            invDate: addInv.invDate
        }
        $.ajax({
            type: 'POST',
            url: "/api/invs/addInv",
            data: JSON.stringify(params),
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            success: function (json) {
                var data = [];
                for (i = 0; i < inputs.length; ++i) {
                    data[i] = 
                        {
                            itemId: $scope.inputs[i].itemid,
                            inventoryId: json.addedInvId,
                            amount: $scope.inputs[i].amount
                        }
                    
                }
                    $.ajax({
                        type: 'POST',
                        url: "/api/items/addItemInv",
                        data: JSON.stringify(data),
                        dataType: 'json',
                        contentType: "application/json; charset=utf-8",
                        success: function (json) {
                        },
                        error: function (json) {
                        }
                    });
                },
            error: function (json) {
            }
        });
    }

    $(document).ready(function () {
        $('.addNextItem').on('click', function () {
            $('.rightInvColumn').css('overflow-y', 'scroll');
        });
    });
});