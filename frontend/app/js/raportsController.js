MyApp.controller('raportsController', function ($scope, $http, $location, $cookies, $route) {
    $scope.invRaps = [];
    $scope.depRaps = [];
    $scope.relRaps = [];
    $scope.allItems = [];
    $scope.allItemsDep = [];
    $scope.allItemsRel = [];
    $scope.thisInvRap;
    $scope.thisDepRap;
    $scope.thisRelRap;
    $scope.thisFirm;
    $scope.itId;
    $scope.invId;
    $scope.depId;
    $scope.depAmount;
    $scope.relAmount;

    $scope.invId = $cookies.get("invId");
    $scope.depId = $cookies.get("depId");
    $scope.relId = $cookies.get("relId");

    $http.get("api/invs/" + $cookies.get("userId") + "/invs").then(function (response) {
        $scope.invRaps = response.data;
    });

    $http.get("api/deps/" + $cookies.get("userId") + "/deps").then(function (response) {
        $scope.depRaps = response.data;
    });

    $http.get("api/releases/" + $cookies.get("userId") + "/rels").then(function (response) {
        $scope.relRaps = response.data;
    });

    $scope.generateInv = function (i) {
        $cookies.put("invId", i.id);
    }

    $scope.generateDep = function (d) {
        $cookies.put("depId", d.id);
    }

    $scope.generateRel = function (r) {
        $cookies.put("relId", r.id);
    }

    $http.get("api/invs/" + $cookies.get("invId")).then(function (response) {
        $scope.thisInvRap = response.data;
    });
    $http.get("api/deps/" + $cookies.get("depId")).then(function (response) {
        $scope.thisDepRap = response.data;
    });
    $http.get("api/releases/" + $cookies.get("relId")).then(function (response) {
        $scope.thisRelRap = response.data;
    });
    $http.get("api/firms/" + $cookies.get("firmId")).then(function (response) {
        $scope.thisFirm = response.data;
    });
    $http.get("api/items/allItems/invs/" + $cookies.get("invId")).then(function (response) {
        $scope.allItems = response.data;
    });
    $http.get("api/items/allItems/deps/" + $cookies.get("depId")).then(function (response) {
        $scope.allItemsDep = response.data;
    });
    $http.get("api/items/allItems/rels/" + $cookies.get("relId")).then(function (response) {
        $scope.allItemsRel = response.data;
    });

    $scope.getAmountInvById = function (array, id) {
        for (var i = 0; i < array.length; ++i) {
            if (id == array[i].inventory.id) {
                return array[i].amount;
            }
        }
    }

    $scope.getAmountDepById = function (array, id) {
        for (var i = 0; i < array.length; ++i) {
            if (id == array[i].storageDepot.id) {
                $scope.depAmount = array[i].amount;
                return $scope.depAmount;
            }
        }
    }

    $scope.getAmountRelById = function (array, id) {
        for (var i = 0; i < array.length; ++i) {
            if (id == array[i].itemRelease.id) {
                $scope.relAmount = array[i].amount;
                return $scope.relAmount;
            }
        }
    }

    $scope.shortage = function (array, item, id) {
        for (var i = 0; i < array.length; ++i) {
            if (id == array[i].inventory.id) {
                var stock = item.stock;
                var amount = array[i].amount;
                if (amount - stock >= 0)
                    return null
                else {
                    return amount - stock;
                }
            }
        }

    }

    $scope.overload = function (array, item, id) {
        for (var i = 0; i < array.length; ++i) {
            if (id == array[i].inventory.id) {
                var stock = item.stock;
                var amount = array[i].amount;
                if (amount - stock <= 0)
                    return null
                else {
                    return amount - stock;
                }
            }
        }
    }
    $scope.go = function (path) {
        $location.path(path);
    }


    $scope.generatePDF = function () {
        html2canvas(document.getElementById('exportthis'), {
            onrendered: function (canvas) {
                var data = canvas.toDataURL();
                var docDefinition = {
                    content: [{
                        image: data,
                        width: 500,
                    }]
                };
                pdfMake.createPdf(docDefinition).download("document");
            }
        });
    }

    $scope.openPDF = function() {
        html2canvas(document.getElementById('exportthis'), {
            onrendered: function (canvas) {
                var data = canvas.toDataURL();
                var docDefinition = {
                    content: [{
                        image: data,
                        width: 500,
                    }]
                };
                pdfMake.createPdf(docDefinition).open();
            }
        });
    }

    $scope.print = function() {
        html2canvas(document.getElementById('exportthis'), {
            onrendered: function (canvas) {
                var data = canvas.toDataURL();
                var docDefinition = {
                    content: [{
                        image: data,
                        width: 500
                    }]
                };
                pdfMake.createPdf(docDefinition).print();
            }
        });
    }

    $(function () {
        $(document).foundation();
        $('#raports-tabs').foundation('selectTab', 'panel1');
    });
});