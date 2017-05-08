
'use strict';

angular.module('test').config(['$stateProvider', function ($stateProvider) {
        $stateProvider
                .state('app', {
                    url: '/home',
                    templateUrl: '/app/app-template.html',
                    controller: 'AppController'
                })
                .state('user', {
                    url: '/user',
                    templateUrl: '/app/template/lista-usuarios.html',
                    controller: 'userController'

                })
                .state('useradd', {
                    url: '/user/add/:usuario',
                    templateUrl: '/app/template/adicionar-usuario.html',
                    controller: 'userAddController',
                    params: {usuario:null}                    
                })

                .state('userid', {
                    url: '/user/:id',
                    templateUrl: '/app/template/usuario.html',
                    controller: 'getUserAddController'
                })
    }]);