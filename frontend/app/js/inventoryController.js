MyApp.controller('inventoryController', function ($scope, $http, $location, $window, $cookies, $route) {
    var dateToday = new Date(); 
    $(function() {
        $( "#datepicker" ).datepicker({
            showButtonPanel: true,
            minDate: -3,
            maxDate: 0
        });
    });
});