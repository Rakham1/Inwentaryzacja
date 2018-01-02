MyApp.controller('loginController', function ($scope, $http, $location, $cookies, $route, $interval) {
	$scope.user = {
		username: '',
		password: ''
	}
	$scope.show = false;
	$scope.users = [];
	$scope.u;
	var scope = $scope;

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
						$scope.user = {
							username: '',
							password: ''
						}
						// window.location.replace('/admin');
					}
					else if (response.data.privilege == "ROLE_USER") {
						$location.path('/user');
						$scope.user = {
							username: '',
							password: ''
						}
						// window.location.replace('/user');
					}
				});
			}, function (error) {
				showalert(error.data.value, "alert-danger");
			});
	};

	$http.get("/api/users/" + $cookies.get("userId")).then(function (response) {
		$scope.user = response.data;
	});

	var transform = function (data) {
		return $.param(data);
	}

	$scope.isHidden = function () {
		return $location.path() == '/';
	};

	$scope.adminRights = function () {
		return $cookies.get("adminRights") == "ROLE_ADMIN";
	}

	$scope.userRights = function () {
		return $cookies.get("adminRights") == "ROLE_USER";
	}

	// $http.get("/api/users/"+ $cookies.get("userId")).then(function (response) {
	//     $scope.user = response.data;
	//     $route.reload();
	// });

	$scope.logout = function () {
		$http.get("api/users/logout").then(function (response) {
			$cookies.remove('adminRights');
			$cookies.remove('login');
			$cookies.remove('itemId');
			$cookies.remove('userId', { path: '/' });
			$cookies.remove('invId');
			$cookies.remove('depId');
			$cookies.remove('firmId');
			$location.path('/')
		}, function (error) {
			showalert(error.data.value, "alert-danger");
		});
	};
})