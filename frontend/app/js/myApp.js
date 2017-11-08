var MyApp = angular.module('inventpro', ['ngRoute', 'ngCookies']);

MyApp.config(function ($routeProvider, $locationProvider, $qProvider){
	$locationProvider.hashPrefix('!');
	$qProvider.errorOnUnhandledRejections(false);
	$routeProvider
		.when('/', {
			templateUrl: 'mainSite.html'
		})
		.otherwise({
			redirectTo: '/'
		});

		$locationProvider.html5Mode({
			enabled: true,
			requireBase: false
		});
});