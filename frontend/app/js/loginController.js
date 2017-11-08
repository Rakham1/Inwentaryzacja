MyApp.controller('loginController', function($scope, $http, $location, $cookies, $route){
	$scope.user = {
		username: '',
		password: ''
	}

	$scope.loginUser = function(){
		$http.post("", $scope.user, {
			headers: { 'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'},
			transformRequest: transform
		})
		.then(function(response){
			if(response.data.status == "success"){
				$cookies.put('login', response.data.username);
				$cookies.put('permissions', response.data.permission);
				$cookies.put('userId', response.data.uid);
				$location.path('/user');
				$route.reload();
			} else {
				showalert("Podano błędne dane","alert-danger");
			}
		}, function(error){
			showalert(error.data.value, "alert-danger");
		});
	};

	var transform = function(data){
		return $.param(data);
	}
})