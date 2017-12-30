MyApp.controller('itemsController', function ($scope, $http, $location, $cookies, $route) {

    $scope.items = [];
    $scope.groups = [];
    $scope.types = [];
    $scope.whs = [];
    $scope.wId;
    $scope.thisItem;
    $scope.id;
    $scope.searchKeyword = '';
    $scope.active = -1;
    $scope.disableBtn = true;

    $http.get("api/firms/" + $cookies.get("firmId") + "/whs").then(function (response) {
        $scope.whs = response.data;
    })

    $scope.chooseWh = function(wId){
        $cookies.put("whID", wId);
        $http.get("/api/items/allItems/" + $cookies.get("whID")).then(function (response) {
            console.log(JSON.stringify(response));
            $scope.items = response.data;
            $scope.disableBtn = false;
        });
    }

    $scope.addPopUp = function () {
        document.getElementById('pAdd').style.display = 'block';
        document.getElementById('gAdd').style.display = 'block';
    }

    

    $scope.popUp = function (i) {
        $http.get("/api/groups/allGroups").then(function (response) {

            $scope.groups = response.data;
            console.log(JSON.stringify(response));
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

            document.getElementById('pAdd').style.display = 'none';
            document.getElementById('gAdd').style.display = 'none';
            $scope.active = -1;
        }

    });

    $scope.close = function () {
        document.getElementById('p').style.display = 'none';
        document.getElementById('g').style.display = 'none';

        document.getElementById('pAdd').style.display = 'none';
        document.getElementById('gAdd').style.display = 'none';

        $scope.active = -1;
    };

    $scope.back = function () {
        $scope.active = -1;
    }

    $scope.edit = function (index) {
        $scope.active = index;
    }

    $scope.update = function (editItem) {
        // items.itemName = thisItem.itemName;
        // items.description = thisItem.description;
        // items.stock = thisItem.stock;
        // items.unit = thisItem.unit;
        // items.price = thisItem.price;
        // items.barcode = thisItem.barcode;
        // $http.put("/api/items/" + $cookies.get('itemId') + "/edit/", params, {
        //     headers: { 'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'},
        //     transformRequest: transform
        // }).then(function (response) {

        // }, function (error) {
        //     $route.reload();
        var params = {
            itemName: editItem.itemName,
            description: editItem.description,
            stock: editItem.stock,
            unit: editItem.unit,
            price: editItem.price,
            notes: editItem.notes,
            barcode: editItem.barcode,
            groupId: editItem.gId,
            typeId: editItem.tId
        };

        $.ajax({
            type: 'PUT',
            url: "/api/items/" + $cookies.get('itemId') + "/edit/",
            data: JSON.stringify(params),
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            success: function (json) {
                $location.path("/items");
            },
            error: function (json) {
            }
        });
        $scope.active = null;
    }

    // thisItem.itemName = items.itemName;
    // thisItem.description = items.descprition;
    // thisItem.stock = items.stock;
    // thisItem.unit = items.unit;
    // thisItem.price = items.price;
    // thisItem.note = items.note;
    // thisItem.barcode = items.barcode;
    $scope.delete = function () {
        $http.delete("/api/items/" + $cookies.get('itemId') + "/delete").then(function (response) {
            $route.reload();
        }), function (error) {
            console.log("Przedmiot nie istnieje");
        }
    };

    $scope.createItem = function (addItem) {
        var params = {
            itemName: addItem.iN,
            description: addItem.desc,
            stock: addItem.st,
            unit: addItem.un,
            price: addItem.pr,
            notes: addItem.no,
            barcode: addItem.bar,
            groupId: addItem.gId,
            typeId: addItem.tId
        }
        $.ajax({
            type: 'POST',
            url: "/api/items/addItem",
            data: JSON.stringify(params),
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            success: function (json) {
                var data = {
                    warehouseId: $cookies.get("whID"),
                    itemId: json.addedItemId
                }
                $.ajax({
                    type: 'POST',
                    url: "/api/items/addItemWh",
                    data: JSON.stringify(data),
                    dataType: 'json',
                    contentType: "application/json; charset=utf-8",
                    success: function (json) {
                    },
                    error: function (json) {
                    }
                });
            },
            error: function (json) {
            }
        });

        // $http.post("/api/items/addItem" + params, {
        //     // headers: { 'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'},
        //     headers: { 'Content-Type': 'application/json; charset=UTF-8'},
        //     transformRequest: transform
        // }).then(function (response) {
        //     $location.path('/items');
        //     $route.reload();
        // }), function (error) {
        //     console.log("Nie można dodać przedmiotu");
        // }
        document.getElementById('pAdd').style.display = 'none';
        document.getElementById('gAdd').style.display = 'none';
    }

    var transform = function (data) {
        return $.param(data);
    }

    $scope.clearSearch = function () {
        $scope.searchKeyword = "";
    }

    $scope.addItem= function(value){
        if(value=="change"){
            $location.path("/groups");
        }
    }
});
