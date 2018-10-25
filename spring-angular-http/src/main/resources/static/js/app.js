angular.module('app', ['ngResource'])
    .controller('ProductController', function($resource) {
        var vm = this;
        var Product = $resource('api/products/:productId');
        vm.product = new Product();

        function refreshData() {
            vm.products = Product.query(
                function success(data, headers) {
                    console.log(data);
                    console.log(headers('Content-Type'));
                },
                function error(response) {
                    console.log('error: ' + response.status);
                }
            );
        }

        vm.addProduct = function(product) {
            console.log(vm.product.__proto__);
            vm.product.$save(function(data) {
                refreshData();
                vm.product = new Product();
            });
        }

        vm.loadData = function(id) {
            vm.details = Product.get({productId:id});
        }

        vm.appName = 'Product Manager';
        refreshData();
    });