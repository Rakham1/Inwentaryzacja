MyApp.controller('adminController', function ($scope, $http, $location, $cookies, $route, $window) {

    $scope.users = [];
    $scope.thisUser;
    $scope.roles = [];
    $scope.show = false;
    $scope.edit = false;
    var scope = $scope;

    $http.get("api/admin/allUsers").then(function (response) {
        $scope.users = response.data;
    });

    $http.get("api/roles/allRoles").then(function (response) {
        $scope.roles = response.data;
    })

    $scope.add = function () {
        $scope.show = true;
    }

    $scope.edit = function (u) {
        $scope.edit = true;
        $http.get("api/users/" + u.id).then(function (response) {
            $scope.thisUser = response.data;
        })
    }

    scope.close = function (addUser) {
        $scope.show = false;
        addUser.name = '';
        addUser.surname = '';
        addUser.username = '';
        addUser.password = '';
    }

    scope.closeEdit = function (editUser) {
        $scope.edit = false;
        editUser.name = '';
        editUser.surname = '';
        editUser.username = '';
        editUser.password = '';
    }

    scope.apply = function (addUser) {
        var params = {
            name: addUser.name,
            surname: addUser.surname,
            username: addUser.username,
            password: addUser.password,
            roleId: '2'
        };
        $http.post("/api/admin/addUser", params, {
            headers: { 'Content-Type': "application/json; charset=utf-8" }
        }).then(function (response) {
            $http.get("api/admin/allUsers").then(function (response) {
                $scope.users = response.data;
            });
            scope.close(addUser);
        }, function (error) {
            $http.get("api/admin/allUsers").then(function (response) {
                $scope.users = response.data;
            });
            scope.close(addUser);
        });
        // $.ajax({
        //     type: 'POST',
        //     url: "/api/admin/addUser",
        //     data: JSON.stringify(params),
        //     dataType: 'json',
        //     contentType: "application/json; charset=utf-8",
        //     success: function (json) {
        //         $http.get("api/admin/allUsers").then(function (response) {
        //             $scope.users = response.data;
        //         });

        //     },
        //     error: function (json) {
        //         $http.get("api/admin/allUsers").then(function (response) {
        //             $scope.users = response.data;
        //         });
        //         scope.close(addUser);
        //     }

        // });
    };

    scope.applyEdit = function (editUser, tUid) {
        var params = {
            name: editUser.name,
            surname: editUser.surname,
            username: editUser.username,
            password: editUser.password,
            roleId: editUser.rId
        };

        $.ajax({
            type: 'PUT',
            url: "/api/admin/" + tUid + "/edit",
            data: JSON.stringify(params),
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            success: function (json) {
                $http.get("api/admin/allUsers").then(function (response) {
                    $scope.users = response.data;
                });

            },
            error: function (json) {
                $http.get("api/admin/allUsers").then(function (response) {
                    $scope.users = response.data;
                });
                scope.closeEdit(editUser);
            }

        });
    }

    $scope.delete = function (uid) {
        console.log(uid);
        var deleteUser = $window.confirm('Czy aby na pewno chcesz usunąć użytkownika? ');
        if (deleteUser == true) {
            $http.delete("/api/admin/" + uid + "/delete").then(function (response) {
                $route.reload();
            }), function (error) {
            }
            // var index = $scope.users.indexOf(uid);    
            // $scope.users.splice(index, 1);
        }
    }

});