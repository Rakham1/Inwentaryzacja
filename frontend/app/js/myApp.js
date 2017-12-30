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
		.when('/whs',{
			templateUrl: 'html/warehouses.html',
			controller: 'whsController'
		})
		.when('/inventory',{
			templateUrl: 'html/inventory.html',
			controller: 'inventoryController'
		})
		.when('/release',{
			templateUrl: 'html/release.html',
			controller: 'releaseController'
		})
		.when('/depot',{
			templateUrl: 'html/depot.html',
			controller: 'depotController'
		})
		.when('/raport', {
			templateUrl: 'html/raports.html',
			controller: 'raportsController'
		})
		.when('/raport/invRaport', {
			templateUrl: 'html/inventoryRaport.html',
			controller: 'raportsController'
		})
		.when('/raport/relRaport', {
			templateUrl: 'html/releaseRaport.html',
			controller: 'raportsController'
		})
		.when('/raport/depRaport', {
			templateUrl: 'html/depotRaport.html',
			controller: 'raportsController'
		})
		.when('/contractor',{
			templateUrl: 'html/contractor.html',
			controller: 'contractorController'
		})
		.otherwise({
			redirectTo: '/'
		});

		$locationProvider.html5Mode({
			enabled: true,
			requireBase: false
		});
});