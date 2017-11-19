MyApp.controller('userController', function ($scope, $http, $location, $cookies, $route) {
    $scope.user;
    $scope.firm;
    $scope.datas = [];
    // $scope.fId = firm.firmId;

    $scope.getUserId = function(){
        return $cookies.get("userId");
    }

    $scope.getLogin = function(){
        return $cookies.get('login');
    }

    $http.get("/api/users/username/"+$scope.getLogin()) .then(function (response) {
        $scope.user = response.data;
    });

    // $http.get("/api/firms/" + scope.fId).then(function (response){
    //     $scope.firm = response.data;
    // })
});