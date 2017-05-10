
'use strict';

angular.module('test').config(['$stateProvider', function ($stateProvider) {

        $stateProvider
                .state('app', {
                    url: '/home',
                    templateUrl: '/app/app-template.html',
                    controller: 'AppController'
                })
                .state('listar', {
                    url: '/user/',
                    templateUrl: '/app/controllers/app-listar.html',
                    controller: 'ListarController'
                })
                .state('cadastrar', {
                    url: '/user/add',
                    templateUrl: '/app/controllers/app-cadastrar.html',
                    controller: 'CadastrarController'
                })
                .state('alterar', {
                    url: '/user/:id',
                    templateUrl: '/app/controllers/app-alterar.html',
                    controller: 'AlterarController'
                });

    }]);