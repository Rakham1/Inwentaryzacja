MyApp.controller('groupsController', function ($scope, $http, $location, $window, $cookies, $route) {
    $scope.groups = [];
    $scope.change = -1;
    $scope.change1 = -1;
    $scope.active = false;
    $scope.inputs = [];

    $http.get("api/groups/allGroups").then(function (response) {
        $scope.groups = response.data; 
        $cookies.put("groupId", groups.id);
    });

    $scope.add = function () {
        $scope.inputs.push({});
        $scope.change1=true;
        $scope.active = true;
    };

    $scope.addNew = function(input){
        var params = {
            name: input.name,
            permanent: false
        }
        
        $.ajax({
            type: 'POST',
            url: "/api/groups/addGroup",
            data: JSON.stringify(params),
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            success: function (json) {
                $http.get("api/groups/allGroups").then(function (response) {
                    $scope.groups = response.data;
                });
                var index = $scope.inputs.indexOf(input);
                $scope.inputs.splice(index, 1);
                $scope.change1=false;
            },
            error: function (json) {
                $http.get("api/groups/allGroups").then(function (response) {
                    $scope.groups = response.data;
                });
                var index = $scope.inputs.indexOf(input);
                $scope.inputs.splice(index, 1);
                $scope.change1=false;
            }
        });

    }

    $scope.save =function(editGroup, gid){
        var params = {
            name: editGroup.name,
            permanent: false
        }

        $.ajax({
            type: 'PATCH',
            url: "/api/groups/" + gid + "/edit/",
            data: JSON.stringify(params),
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            success: function (json) {
                $http.get("api/groups/allGroups").then(function (response) {
                    $scope.groups = response.data;
                });
                $scope.change=-1;
                $scope.active = false;
            },
            error: function (json) {
                $http.get("api/groups/allGroups").then(function (response) {
                    $scope.groups = response.data;
                });
                $scope.change=-1;
                $scope.active = false;
            }
        });
    }

    $scope.delete = function (gid) {
        console.log($cookies.get("groupId"));
        var deleteGroup = $window.confirm('Czy aby na pewno chcesz usunąć grupę? ');
        if (deleteGroup) {
            $http.delete("/api/groups/" + gid + "/delete").then(function (response) {
                $route.reload();
            }), function (error) {
            }
            var index = $scope.groups.indexOf(gid);    
            $scope.groups.splice(index, 1);
        }
    }

    $scope.deleteInput = function (input) {
        var index = $scope.inputs.indexOf(input);
        $scope.inputs.splice(index, 1);
        $scope.active = false;
    }

    $scope.del = function(index){
        index = -1;
        $scope.change = index;
    }

    $scope.editG = function (index) {
        $scope.change = index;
    }

    $scope.changeGroup= function(value){
        if(value=="change"){
            $location.path("/groups");
        }
    }

    $scope.backToItem = function(){
        $location.path('/items');
    }
});