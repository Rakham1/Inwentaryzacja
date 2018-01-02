MyApp.controller('typesController', function ($scope, $http, $location, $cookies, $route, $window) {
    $scope.types = [];
    $scope.change = -1;
    $scope.change1 = false;
    $scope.inputs = [];

    $http.get("api/types/allTypes").then(function (response) {
        $scope.types = response.data;
    });

    $scope.add = function () {
        $scope.inputs.push({});
        $scope.change1=true;
    };

    $scope.addNew = function (input) {
        var params = {
            name: input.name
        }

        $.ajax({
            type: 'POST',
            url: "/api/types/addType",
            data: JSON.stringify(params),
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            success: function(json){
                $http.get("api/types/allTypes").then(function (response) {
                    $scope.types = response.data;
                });
                var index = $scope.inputs.indexOf(input);
                $scope.inputs.splice(index, 1);
                $scope.change1=false;
            },
            error: function (json) {
                $http.get("api/types/allTypes").then(function (response) {
                    $scope.types = response.data;
                });
                var index = $scope.inputs.indexOf(input);
                $scope.inputs.splice(index, 1);
                $scope.change1=false;
            }
        });
        
    }

    $scope.save = function (editType, tid) {
        var params = {
            name: editType.name
        }

        $.ajax({
            type: 'PATCH',
            url: "/api/types/" + tid + "/edit/",
            data: JSON.stringify(params),
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            success: function (json) {
                $http.get("api/types/allTypes").then(function (response) {
                    $scope.types = response.data;
                });
                $scope.change=-1;
            },
            error: function (json) {
                $http.get("api/types/allTypes").then(function (response) {
                    $scope.types = response.data;
                });
                $scope.change=-1;
            }
        });
    }

    $scope.delete = function (tid) {
        var deleteType = $window.confirm('Czy aby na pewno chcesz usunąć typ? ');
        if (deleteType) {
            $http.delete("/api/types/" + tid + "/delete").then(function (response) {
                $route.reload();
            }), function (error) {
            }
            var index = $scope.types.indexOf(tid);
            $scope.types.splice(index, 1);
        }
    }

    $scope.deleteInput = function (input) {
        var index = $scope.inputs.indexOf(input);
        $scope.inputs.splice(index, 1);
    }

    $scope.del = function(index){
        index = -1;
        $scope.change = index;
    }

    $scope.editG = function (index) {
        $scope.change = index;
    }

    $scope.changeType = function (value) {
        if (value == "change") {
            $location.path("/types");
        }
    }

    $scope.backToItem = function(){
        $location.path('/items');
    }
});