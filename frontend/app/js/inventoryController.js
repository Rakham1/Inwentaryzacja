MyApp.controller('inventoryController', function ($scope, $http, $location, $window, $cookies, $route, $anchorScroll) {
    $scope.inputs = [];
    $scope.whs = [];
    // $scope.items = [];
    var scope = $scope;
    // $scope.initial = {
    //     amount: '',
    //     itemid: ''
    // }
    var dateToday = new Date();
    $(function () {
        $("#datepicker").datepicker({
            showButtonPanel: true,
            minDate: -3,
            maxDate: 0
        });
    });

    scope.newItem = function(){
        return{
            itemid:'',
            amount:''
        }
    }

    $scope.add = function () {
        $scope.inputs.push(scope.newItem());
        for (i = 0; i < $scope.items.length; i++) {
            document.getElementById("index_" + i).disabled = true;
        }
    };

    $scope.delete = function (input) {
        var index = $scope.inputs.indexOf(input);
        $scope.inputs.splice(index, 1);
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

    $scope.addInvPage = function (addInv) {
        var params = {
            inventoryNumber: addInv.inventoryNumber,
            committeeSquad: addInv.committeeSquad,
            comment: addInv.comment,
            personId: $cookies.get("userId")
        }
        $.ajax({
            type: 'POST',
            url: "/api/invs/addInv",
            data: JSON.stringify(params),
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            success: function (json) {
                var data = {
                    itemId: $scope.initial.itemid,
                    inventoryId: json.addedInvId,
                    amount: $scope.initial.amount
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
        $('.av').on('click', function () {
            $('.rightInvColumn').css('overflow-y', 'scroll');
        });
    });
});