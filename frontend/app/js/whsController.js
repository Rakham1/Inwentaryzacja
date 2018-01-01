MyApp.controller('whsController', function ($scope, $http, $location, $cookies, $route, $window) {
    $scope.firms = [];
    $scope.firm;
    $scope.whs = [];
    $scope.fid;
    $scope.show;
    $scope.disableBtn = true;
    var scope = $scope;

    $http.get("api/firms/allFirms").then(function (response) {
        $scope.firms = response.data;
    })

    $scope.changeFirm = function (editFirm) {
        $http.get("api/firms/" + $scope.fid + "/whs").then(function (response) {
            $scope.whs = response.data;
        });
        $http.get("api/firms/" + $scope.fid).then(function (response) {
            $scope.firm = response.data;
        });
        $scope.disableBtn = false;
    }

    $scope.edit = function (index) {
        $scope.show = index;
    }

    $scope.save = function (editWh, wId) {
        var params = {
            name: editWh.name,
            street: editWh.street,
            postCode: editWh.postCode,
            city: editWh.city,
            firmId: $scope.fid
        };

        $.ajax({
            type: 'PUT',
            url: "/api/whs/" + wId + "/edit",
            data: JSON.stringify(params),
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            success: function (json) {
                $http.get("api/firms/" + $scope.fid + "/whs").then(function (response) {
                    $scope.whs = response.data;
                });
                scope.close(editWh);
            },
            error: function (json) {
                $http.get("api/firms/" + $scope.fid + "/whs").then(function (response) {
                    $scope.whs = response.data;
                });
                scope.close(editWh);
            }
        });
    }

    scope.close = function (editWh) {
        $scope.show = null;
        editWh.name = '';
        editWh.street = '';
        editWh.postCode = '';
        editWh.city = '';
    }

    $scope.add = function (addWh) {
        var params = {
            name: addWh.name,
            street: addWh.street,
            postCode: addWh.postCode,
            city: addWh.city,
            firmId: $scope.fid
        };

        $.ajax({
            type: 'POST',
            url: "/api/whs/addWh",
            data: JSON.stringify(params),
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            success: function (json) {
                $('.addWhForm').toggleClass('active');
                $http.get("api/firms/" + $scope.fid + "/whs").then(function (response) {
                    $scope.whs = response.data;
                });
                addWh.name = '';
                addWh.street = '';
                addWh.postCode = '';
                addWh.city = '';
                scope.change();
            },
            error: function (json) {
                $('.addWhForm').toggleClass('active');
                $http.get("api/firms/" + $scope.fid + "/whs").then(function (response) {
                    $scope.whs = response.data;
                });
                addWh.name = '';
                addWh.street = '';
                addWh.postCode = '';
                addWh.city = '';
                scope.change();
            }
        });
    }

    $scope.delete = function (wId) {
        var deleteUser = $window.confirm('Czy aby na pewno chcesz usunąć użytkownika? ');
        if (deleteUser == true) {
            $http.delete("api/whs/" + wId + "/delete").then(function (response) {
                $http.get("api/firms/" + $scope.fid + "/whs").then(function (response) {
                    $scope.whs = response.data;
                });
            }), function (error) {
                $http.get("api/firms/" + $scope.fid + "/whs").then(function (response) {
                    $scope.whs = response.data;
                });
            };
        }
    };

    $('.myButton').on('click', function () {
        $('.addWhForm').toggleClass('active');
        return false;
    })

    scope.change = function () {
        $(".myButton").html(($(".myButton").html() == 'Dodaj magazyn') ? 'Anuluj' : 'Dodaj magazyn');
    }
});