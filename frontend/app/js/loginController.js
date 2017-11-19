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
				var data = response.config.data;
					console.log(response.config.data);
					console.log(JSON.stringify(response));
					$cookies.put('login', data.username)
					$cookies.put('userId', data.uid);
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