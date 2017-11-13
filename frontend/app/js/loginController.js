MyApp.controller('loginController', function ($scope, $http, $location, $cookies, $route) {
	$scope.user = {
		username: '',
		password: ''
	}

	$scope.loginUser = function () {
		$http.post("/api/login", $scope.user, {
			headers: { 'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8' },
			transformRequest: transform
		})
			.then(function (response) {
				$cookies.put('login', response.data.username)
				$cookies.put('uId', response.data.uid);
				$location.path('/user');
				$route.reload();

			}, function (error) {
				showalert(error.data.value, "alert-danger");
			});
	};

	var transform = function (data) {
		return $.param(data);
	}
})