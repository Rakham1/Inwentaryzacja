MyApp.controller('navbarController', function ($scope, $http, $location, $cookies) {

    $scope.isHidden = function () {
        return $location.path() == '/';
    }
});