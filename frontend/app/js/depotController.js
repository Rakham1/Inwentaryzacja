MyApp.controller('depotController', function ($scope, $http, $location, $cookies, $route, $window) {
    $scope.inputs = [];
    $scope.whs = [];
    $scope.cId;
    $scope.wId;
    var scope = $scope;

    var dateToday = new Date();
    $(function () {
        $("#datepicker").datepicker({
            showButtonPanel: true,
            minDate: -3,
            maxDate: 0
        });
    });

    // scope.newItem = function(){
    //     return{
    //         itemid:'',
    //         amount:''
    //     }
    // }

    $scope.chooseItem = function (depItId) {
        $scope.var1 = depItId;

        if (depItId == "change") {
            document.getElementById('pAdd').style.display = 'block';
            document.getElementById('gAdd').style.display = 'block';
        }
    }

    $(document).keydown(function (e) {
        if (e.keyCode == 27) {
            document.getElementById('pAdd').style.display = 'none';
            document.getElementById('gAdd').style.display = 'none';
            $scope.active = -1;
        }

    });

    $scope.changeInput = function (depAmount) {
        $scope.var2 = depAmount;
    }

    $scope.add = function () {
        $scope.inputs.push({});
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

    $scope.addDepotPage = function (addDepot) {
        var params = {
            invoiceName: addDepot.invoiceName,
            depotDate: addDepot.depotDate,
            comment: addDepot.comment,
            personId: $cookies.get("userId"),
            contractorId: $cookies.get("contractorId"),
            warehouseId: $scope.wId
        }
        $.ajax({
            type: 'POST',
            url: "/api/deps/addDep",
            data: JSON.stringify(params),
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            success: function (json) {
                var data = {
                    itemId: $scope.var1,
                    depotId: json.addedDepId,
                    amount: $scope.var2
                }
                $.ajax({
                    type: 'POST',
                    url: "/api/items/addItemDep",
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

    $scope.createItem = function (addItem) {
        var params = {
            itemName: addItem.iN,
            description: addItem.desc,
            stock: addItem.st,
            unit: addItem.un,
            price: addItem.pr,
            notes: addItem.no,
            barcode: addItem.bar,
            groupId: addItem.gId,
            typeId: addItem.tId
        }
        $.ajax({
            type: 'POST',
            url: "/api/items/addItem",
            data: JSON.stringify(params),
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            success: function (json) {
                var data = {
                    warehouseId: $scope.wId,
                    itemId: json.addedItemId
                }
                $.ajax({
                    type: 'POST',
                    url: "/api/items/addItemWh",
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

        document.getElementById('pAdd').style.display = 'none';
        document.getElementById('gAdd').style.display = 'none';
    }

    $(document).ready(function () {
        $('.av').on('click', function () {
            $('.rightInvColumn').css('overflow-y', 'scroll');
        });
    });
});