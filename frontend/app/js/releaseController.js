MyApp.controller('releaseController', function ($scope, $http, $location, $cookies, $route, $window) {
    $scope.inputs = [];
    $scope.whs = [];
    $scope.cId;
    $scope.wId;
    $scope.disableBtn = true;
    var scope = $scope;

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
            itemid: '',
            amount: ''
        }
    }

    $scope.chooseItem = function(relItId){
        $scope.var1 = relItId;
    }

    $scope.changeInput = function(relAmount){
        $scope.var2 = relAmount;
    }

    $scope.add = function () {
        $scope.disableBtn = false;
        $scope.inputs.push(scope.newItem());
        for (i = 0; i < $scope.items.length; i++) {
            document.getElementById("index_" + i).disabled = true;
        }
    };

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

    $scope.addRelPage = function (addRel) {
        var params = {
            relDocName: addRel.relDocName,
            releaseDate: addRel.releaseDate,
            comment: addRel.comment,
            personId: $cookies.get("userId"),
            warehouseId: $scope.wId,
            contractorId: $cookies.get("contractorId")
        }
        $.ajax({
            type: 'POST',
            url: "/api/releases/addRel",
            data: JSON.stringify(params),
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            success: function (json) {
                var data = [];
                for (i = 0; i < inputs.length; ++i) {
                    data[i] = 
                        {
                            itemId: $scope.inputs[i].itemid,
                            inventoryId: json.addedRelId,
                            amount: $scope.inputs[i].amount
                        }
                    
                }
                $.ajax({
                    type: 'POST',
                    url: "/api/items/addItemRel",
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