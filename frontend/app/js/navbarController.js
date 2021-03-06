MyApp.controller('navbarController', function ($scope, $http, $location, $cookies, $route) {

    $scope.user;

    $scope.isHidden = function () {
        return $location.path() == '/';
    };

    $scope.adminRights = function () {
        return $cookies.get("adminRights") == "ROLE_ADMIN";
    }

    $scope.userRights = function(){
        return $cookies.get("adminRights") == "ROLE_USER";
    }

    $http.get("/api/users/"+ $cookies.get("userId")).then(function (response) {
        $scope.user = response.data;
        $route.reload();
    });

    $scope.logout = function(){
        $http.get("api/users/logout").then(function(response){
            $cookies.remove('adminRights');
            $cookies.remove('login');
            $cookies.remove('itemId');
            $cookies.remove('userId', {path: '/'});
            $cookies.remove('invId');
            $cookies.remove('depId');
            $cookies.remove('firmId');
            $location.path('/')
        }, function(error){
            showalert(error.data.value, "alert-danger");
        });
    };

    
}); 