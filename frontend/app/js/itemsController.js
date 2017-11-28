MyApp.controller('itemsController', function ($scope, $http, $location, $cookies, $route) {
    $scope.items = {
        item_name: '',
        description: '',
        stock: '',
        unit: '',
        barcode: '',
        timestamp: '',
        min_stock: ''
    };
    $scope.items = [];
    $scope.thisItem;

    $scope.searchKeyword = '';

    $http.get("/api/items/allItems").then(function (response) {
        console.log(JSON.stringify(response));
        $scope.items = response.data;
    });

    $scope.popUp = function (i) {
        $http.get("/api/items/" + i.id).then(function (response) {
            $scope.thisItem = response.data;
        });
        document.getElementById('p').style.display = 'block';
        document.getElementById('g').style.display = 'block';
    };

    $(document).keydown(function (e) {
        if (e.keyCode == 27) {
            document.getElementById('p').style.display = 'none';
            document.getElementById('g').style.display = 'none';
        }
    });
    
    $scope.close = function () {
        document.getElementById('p').style.display = 'none';
        document.getElementById('g').style.display = 'none';
    };
});
