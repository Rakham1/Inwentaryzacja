var MyApp = angular.module('inventpro', ['ngRoute', 'ngCookies']);

MyApp.config(function ($routeProvider,$locationProvider, $qProvider){
	$locationProvider.hashPrefix('!');
	$qProvider.errorOnUnhandledRejections(false);
	
	$routeProvider
		.when('/', {
			templateUrl: 'html/mainSite.html'
		})
		.when('/admin',{
			templateUrl: 'html/admin.html',
			controller: 'adminController'
		})
		.when('/firms',{
			templateUrl: 'html/firms.html',
			controller: 'firmController'
		})
		.when('/user', {
			templateUrl: 'html/user.html',
			controller: 'userController'
		})
		.when('/items',{
			templateUrl: 'html/items.html',
			controller: 'itemsController'
		})
		.when('/groups',{
			templateUrl: 'html/groups.html',
			controller: 'groupsController'
		})
		.when('/types',{
			templateUrl: 'html/types.html',
			controller: 'typesController'
		})
		.otherwise({
			redirectTo: '/'
		});

		$locationProvider.html5Mode({
			enabled: true,
			requireBase: false
		});
});