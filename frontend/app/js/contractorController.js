MyApp.controller('contractorController', function ($scope, $http, $location, $cookies, $route, $window) {

    $scope.contractors = [];
    $scope.thisContractor;
    $scope.roles = [];
    $scope.show = false;
    $scope.edit = false;
    var scope = $scope;

    $http.get("api/firms/" + $cookies.get("firmId") + "/contractors").then(function (response) {
        $scope.contractors = response.data;
    });

    $scope.add = function () {
        $scope.show = true;
    }

    $scope.edit = function (c) {
        $scope.edit = true;
        $http.get("api/contractor/" + c.id).then(function (response) {
            $scope.thisContractor = response.data;
        })
    }

    scope.close = function (addContractor) {
        $scope.show = false;
        addContractor.firmName = '';
        addContractor.nip = '';
        addContractor.street = '';
        addContractor.postCode = '';
        addContractor.city = '';
    }

    scope.closeEdit = function (editContractor) {
        $scope.edit = false;
        editContractor.firmName = '';
        editContractor.nip = '';
        editContractor.street = '';
        editContractor.postCode = '';
        editContractor.city = '';
    }

    scope.apply = function (addContractor) {
        var params = {
            firmName: addContractor.firmName,
            nip: addContractor.nip,
            street: addContractor.street,
            postCode: addContractor.postCode,
            city: addContractor.city,
            firmId: $cookies.get("firmId")
        };
        $http.post("/api/contractor/addContractor", params, {
            headers: { 'Content-Type': "application/json; charset=utf-8" }
        }).then(function (response) {
            $http.get("api/firms/" + $cookies.get("firmId") + "/contractors").then(function (response) {
                $scope.contractors = response.data;
            });        
            scope.close(addContractor);
        }, function (error) {
            $http.get("api/firms/" + $cookies.get("firmId") + "/contractors").then(function (response) {
                $scope.contractors = response.data;
            });        
            scope.close(addContractor);
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

    scope.applyEdit = function (editContractor, tCid) {
        var params = {
            firmName: editContractor.firmName,
            nip: editContractor.nip,
            street: editContractor.street,
            postCode: editContractor.postCode,
            city: editContractor.city,
            firmId: $cookies.get("firmId")
        };

        $.ajax({
            type: 'PUT',
            url: "/api/contractor/" + tCid + "/edit",
            data: JSON.stringify(params),
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            success: function (json) {
                $http.get("api/firms/" + $cookies.get("firmId") + "/contractors").then(function (response) {
                    $scope.contractors = response.data;
                });

            },
            error: function (json) {
                $http.get("api/firms/" + $cookies.get("firmId") + "/contractors").then(function (response) {
                    $scope.contractors = response.data;
                });
                scope.closeEdit(editContractor);
            }

        });
    }

    $scope.changeContractor= function(value){
        if(value=="change"){
            $location.path("/contractor");
        }
    }

    $scope.saveId = function(cId){
        $cookies.put("contractorId" , cId);
    }
})