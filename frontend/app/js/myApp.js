var MyApp = angular.module('inventpro', ['ngRoute', 'ngCookies']);

MyApp.config(function ($routeProvider,$locationProvider, $qProvider){
	$locationProvider.hashPrefix('!');
	$qProvider.errorOnUnhandledRejections(false);
	
	$routeProvider
		.when('/', {
			templateUrl: 'html/mainSite.html'
		})
		.when('/user', {
			templateUrl: 'html/user.html'
		})
		.when('/items',{
			templateUrl: 'html/items.html',
			controller: 'itemsController'
		})
		.otherwise({
			redirectTo: '/'
		});

		$locationProvider.html5Mode({
			enabled: true,
			requireBase: false
		});
});