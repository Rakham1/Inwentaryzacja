MyApp.controller('showWhController', function ($scope, $http, $location, $cookies, $route) {
    $scope.switch = function () {
        $('.portfolio-resume-wrapper').animate({ height: "toggle", opacity: "toggle" }, "500");
    };
    
    });