MyApp.controller('firmController', function ($scope, $http, $location, $cookies, $route) {

    $scope.users = [];
    $scope.user = $scope.users[0];
    $scope.uid;
    $scope.disableBtn = true;
    $scope.editFi = false;
    var scope = $scope;

    $http.get("api/admin/allUsers").then(function (response) {
        $scope.users = response.data;
    });

    $scope.changeFirm = function (editFirm) {
        $http.get("api/users/" + $scope.uid).then(function (response) {
            $scope.user = response.data;
            $scope.disableBtn = false;
        });
        $scope.editFi = false;
        editFirm.firmName = '';
        editFirm.nip = '';
        editFirm.street = '';
        editFirm.postCode = '';
        editFirm.city = '';
    }

    $scope.add = function (addFirm) {
        var params = {
            firmName: addFirm.firmName,
            nip: addFirm.nip,
            street: addFirm.street,
            postcode: addFirm.postCode,
            city: addFirm.city,
            userId: $scope.uid
        };

        $.ajax({
            type: 'POST',
            url: "/api/firms/addFirm",
            data: JSON.stringify(params),
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            success: function (json) {
            },
            error: function (json) {
            }
        });
    };

    scope.applyEdit = function (editFirm, uFId) {
        var params = {
            firmName: editFirm.firmName,
            nip: editFirm.nip,
            street: editFirm.street,
            postcode: editFirm.postCode,
            city: editFirm.city,
            userId: $scope.uid
        };

        $.ajax({
            type: 'PUT',
            url: "/api/firms/" + uFId + "/edit",
            data: JSON.stringify(params),
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            success: function (json) {
                $http.get("api/users/" + $scope.uid).then(function (response) {
                    $scope.user = response.data;
                });

            },
            error: function (json) {
                $http.get("api/users/" + $scope.uid).then(function (response) {
                    $scope.user = response.data;
                });
                scope.back(editFirm);
            }
        });
    };
    $scope.editF = function () {
        $scope.editFi = true;
    };

    scope.back = function (editFirm) {
        $scope.editFi = false;
        editFirm.firmName = '';
        editFirm.nip = '';
        editFirm.street = '';
        editFirm.postCode = '';
        editFirm.city = '';
    }

    $('.myButton').on('click', function () {
        $('.addUserForm').toggleClass('active');
        return false;
    })

    $scope.change = function () {
        $(".myButton").html(($(".myButton").html() == 'Dodaj firmę') ? 'Anuluj' : 'Dodaj firmę');
    }
});  