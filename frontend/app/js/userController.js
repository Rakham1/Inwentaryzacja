MyApp.controller('userController', function ($scope, $http, $location, $cookies, $route,) {
    $scope.user;
    $scope.firm;
    $scope.wh;
    $scope.datas = [];
    $scope.whs = [];
    // $scope.fId = firm.fimId;

    // $cookies.put("firmId", user.firm.firmId);

    $http.get("api/firms/" + $cookies.get("userId") + "/user").then(function (response) {
        $scope.firm = response.data;
        $cookies.put("firmId", response.data.firmId);
    });

    $http.get("api/firms/" + $cookies.get("firmId") + "/whs").then(function (response) {
        $scope.whs = response.data;
    })

    $scope.getUserId = function () {
        return $cookies.get("userId");
    }

    $scope.getLogin = function () {
        return $cookies.get('login');
    }

    $http.get("/api/users/" + $scope.getUserId()).then(function (response) {
        $scope.user = response.data;
    });

    $scope.changeWh = function (wid) {
            $http.get("/api/whs/" + wid).then(function (response) {
                $scope.wh = response.data;
            })
    }
    // if(timer) clearTimeout(timer);
    // var timer = setTimeout(function () {
    //     window.location.reload(1);
    // }, 5000);
    
});