MyApp.controller('typesController', function ($scope, $http, $location, $cookies, $route) {
    $scope.types = [];

    $http.get("api/types/allTypes").then(function (response) {
        $scope.types = response.data;
    });
});