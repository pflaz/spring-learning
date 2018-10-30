'use strict';

angular.module('app', ['ngRoute', 'ngResource'])
    .constant('BOOK_ENDPOINT', '/api/books/:id')
    .constant('LOGIN_ENDPOINT', '/login')
    .config(function($routeProvider, $httpProvider) {
        $httpProvider.defaults.headers.common["X-Requestred-With"] = 'XMLHttpRequest';
        $routeProvider
            .when('/list', {
                templateUrl: 'partials/list.html',
                controller: 'ListController',
                controllerAs: 'listCtrl'
            })
            .when('/details/:id', {
                templateUrl: 'partials/details.html',
                controller: 'DetailsController',
                controllerAs: 'detailsCtrl'
            })
            .when('/new', {
                templateUrl: 'partials/new.html',
                controller: 'NewController',
                controllerAs: 'newCtrl'
            })
            .when('/login', {
                templateUrl: 'partials/login.html',
                controller: 'AuthenticationController',
                controllerAs: 'authController'
            })
            .otherwise({
                redirectTo:'/list'
            });
    })
    .factory('Book', function($resource, BOOK_ENDPOINT) {
        return $resource(BOOK_ENDPOINT);
    })
    .service('AuthenticationService', function($http, LOGIN_ENDPOINT) {
        this.authenticate = function(credentials, successCallback) {
            var authHeader = {Authorization: 'Basic ' + btoa(credentials.username+':'+credentials.password)};
            var config = {headers:authHeader};
            $http
                .post(LOGIN_ENDPOINT, {}, config)
                .then(function success(value) {
                    successCallback();
                }, function error(reason) {
                    console.log('Login error');
                    console.log(reason);
                });
        }
    })
    .service('Books', function(Book) {
        this.getAll = function() {
            return Book.query();
        }
        this.get = function(index) {
            return Book.get({id: index});
        }
        this.add = function(book) {
            book.$save();
        }
    })
    .controller('ListController', function(Books) {
        var vm = this;
        vm.books = Books.getAll();
    })
    .controller('DetailsController', function($routeParams, Books) {
        var vm = this;
        var bookIndex = $routeParams.id;
        vm.book = Books.get(bookIndex);
    })
    .controller('NewController', function(Books, Book) {
        var vm = this;
        vm.book = new Book();
        vm.saveBook = function() {
            Books.add(vm.book);
            vm.book = new Book();
        }
    })
    .controller('AuthenticationController', function($rootScope, $location, AuthenticationService) {
        var vm = this;
        vm.credentials = {};
        var loginSuccess = function() {
            $rootScope.authenticated = true;
            $location.path('/new');
        }
        vm.login = function() {
            AuthenticationService.authenticate(vm.credentials, loginSuccess());
        }
    });