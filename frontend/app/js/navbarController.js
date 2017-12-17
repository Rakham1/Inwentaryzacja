MyApp.controller('navbarController', function ($scope, $http, $location, $cookies, $route) {

    $scope.isHidden = function () {
        return $location.path() == '/';
    };

    $scope.adminRights = function () {
        return $cookies.get("adminRights") == "ROLE_ADMIN";
    }

    $scope.userRights = function(){
        return $cookies.get("adminRights") == "ROLE_USER";
    }

    $scope.logout = function(){
        $http.get("api/users/logout").then(function(response){
            $cookies.remove('adminRights');
            $cookies.remove('login');
            $cookies.remove('itemId');
            $location.path('/')
        }, function(error){
            showalert(error.data.value, "alert-danger");
        });
    };
}); 