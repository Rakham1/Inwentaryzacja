MyApp.controller('loginController', function ($scope, $http, $location, $cookies, $route) {
	$scope.user = {
		username: '',
		password: ''
	}
	$scope.show = false;
	$scope.users = [];

	$scope.loginUser = function () {
		$http.post("/api/login", $scope.user, {
			headers: { 'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8' },
			transformRequest: transform
		})
			.then(function (response) {
				if (response.data.status == "success") {
					$cookies.put('login', response.data.username);
					$cookies.put('userId', response.data.uid);
				}
				$http.get("/api/users/authorities").then(function (response) {
					$cookies.put("adminRights", response.data.privilege);
					console.log($cookies.get("adminRights"));
					if (response.data.privilege == "ROLE_ADMIN") {
						$location.path('/admin');
						$route.reload();
					}
					else if (response.data.privilege == "ROLE_USER") {
						$location.path('/user');
						$route.reload();
					}
				});
				// var data = response.config.data;
				// console.log(response.config.data);
				console.log(JSON.stringify(response.data));
				console.log($cookies.get("userId"));

			}, function (error) {
				showalert(error.data.value, "alert-danger");
			});
	};

	var transform = function (data) {
		return $.param(data);
	}
})