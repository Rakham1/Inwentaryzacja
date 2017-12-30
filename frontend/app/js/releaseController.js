MyApp.controller('releaseController', function ($scope, $http, $location, $cookies, $route, $window) {
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

    // scope.newItem = function () {
    //     return {
    //         itemid: '',
    //         amount: ''
    //     }
    // }

    $scope.chooseItem = function(relItId){
        $scope.var1 = relItId;
    }

    $scope.changeInput = function(relAmount){
        $scope.var2 = relAmount;
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
                var data = {
                    itemId: $scope.var1,
                    itemReleaseId: json.addedRelId,
                    amount: $scope.var2
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
        $('.av').on('click', function () {
            $('.rightInvColumn').css('overflow-y', 'scroll');
        });
    });
});