var feuk = angular.module('feuk.routes', ['ngRoute']);

feuk.config(['$routeProvider', function($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl : '/static/app/html/partial/home.html'
        })
        .when('/namirnice', {
            templateUrl : '/static/app/html/partial/namirnice.html',
            controller : 'NamirnicaController'
        })
        .when('/namirnice/add', {
            templateUrl : '/static/app/html/partial/addEditNamirnica.html',
            controller : 'NamirnicaController',
            title: 'Dodaj namirnicu'
        })
        .when('/namirnice/edit/:id', {
            templateUrl : '/static/app/html/partial/addEditNamirnica.html',
            controller : 'NamirnicaController',
            title: 'Izmeni namirnicu'
        })
        .when('/calc', {
            templateUrl : '/static/app/html/partial/calc.html',
            controller : 'NamirnicaController'
        })
        .when('/calc/add', {
            templateUrl : '/static/app/html/partial/addCalc.html',
            controller : 'NamirnicaController',
            title: 'Dodaj unos'
        })
        .when('/calc/edit/:idcalc', {
            templateUrl : '/static/app/html/partial/editCalc.html',
            controller : 'NamirnicaController',
            title: 'Izmeni unos'
        })
        .otherwise({
            redirectTo: '/'
        });
}]);
