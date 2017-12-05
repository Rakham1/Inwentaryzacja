MyApp.controller('groupsController', function ($scope, $http, $location, $cookies, $route) {
    $scope.groups = [];

    $http.get("api/groups/allGroups").then(function (response) {
        $scope.groups = response.data;
    });
});