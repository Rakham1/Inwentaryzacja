MyApp.controller('itemsController', function ($scope, $http, $location, $cookies, $route) {
    var items = {
        itemName: '',
        description: '',
        stock: '',
        unit: '',
        price: '',
        barcode: '',
    };
    $scope.items = [];
    $scope.groups = [];
    $scope.types = [];
    $scope.thisItem;
    $scope.id;
    $scope.searchKeyword = '';



    $http.get("/api/items/allItems").then(function (response) {
        console.log(JSON.stringify(response));
        $scope.items = response.data;
    });

    $scope.popUp = function (i) {
        $http.get("/api/groups/allgroups").then(function (response) {
            console.log(JSON.stringify(response));
            $scope.groups = response.data;
        });

        $http.get("/api/types/allTypes").then(function (response) {
            console.log(JSON.stringify(response));
            $scope.types = response.data;
        });
        $http.get("/api/items/" + i.id).then(function (response) {
            $scope.thisItem = response.data;
            $cookies.put("itemId", i.id);
            $cookies.put("itemName", i.itemName);
            $cookies.put("description", i.description);
            $cookies.put("stock", i.stock);
            $cookies.put("unit", i.unit);
            $cookies.put("price", i.price);
            $cookies.put("barcode", i.barcode);

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

    $scope.active = -1;

    $scope.edit = function (index) {
        $scope.active = index;
    }

    $scope.update = function (index) {
        // items.itemName = thisItem.itemName;
        // items.description = thisItem.description;
        // items.stock = thisItem.stock;
        // items.unit = thisItem.unit;
        // items.price = thisItem.price;
        // items.barcode = thisItem.barcode;

        $http.patch("/api/items/"+ $cookies.get('itemId')+ "/edit/", items, {
            headers: { 'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8' },
            transformRequest: transform
        }).then(function (response) {

            // thisItem.itemName = items.itemName;
            // thisItem.description = items.descprition;
            // thisItem.stock = items.stock;
            // thisItem.unit = items.unit;
            // thisItem.price = items.price;
            // thisItem.note = items.note;
            // thisItem.barcode = items.barcode;
        }, function (error) {
            $route.reload();
        });
        $scope.active = null;
    }

    $scope.delete = function () {
        $http.delete("/api/items/" + $cookies.get('itemId') + "/delete").then(function (response) {
            $route.reload();
        }), function (error) {
            console.log("Przedmiot nie istnieje");
        }
    };

    var transform = function (data) {
        return $.param(data);
    }
});
