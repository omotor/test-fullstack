'use strict';

angular.module('test').config(['$stateProvider', function ($stateProvider) {
        $stateProvider
                .state('app', {
                    url: '/home',
                    templateUrl: '/app/templates/home.html',
                    controller: 'maincontroller'
                })
                .state('userlist', {
                    url: '/user',
                    templateUrl: '/app/templates/userlist.html',
                    controller: 'userlistcontroller'
                })
                .state('userdel', {
                    url: '/user/del/:id',
                    templateUrl: '/app/templates/userdelete.html',
                    controller: 'userdeletecontroller',
                    params: {id:null}
                })
                .state('useradd', {
                    url: '/user/add',
                    templateUrl: '/app/templates/useradd.html',
                    controller: 'useraddcontroller'
                })
                .state('useredit', {
                    url: '/user/:id',
                    templateUrl: '/app/templates/useredit.html',
                    controller: 'usereditcontroller',
                    params: {id:null}
                })
    }]);
