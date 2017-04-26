
'use strict';

angular.module('test').config(['$stateProvider', function ($stateProvider) {

	$stateProvider.state('app', {
		url: '/home',
		templateUrl: '/app/view/app-template.html',
		controller: 'AppController'
	})
    .state('newUser', {
        url: '/user/add',
        templateUrl: '/app/view/createUpdateUser-template.html',
        controller: 'newUserController',
        params:{ newUser: true }
    })
	.state('detailUser', {
		url: '/user/:id?:newUser',
		templateUrl: '/app/view/createUpdateUser-template.html',
		controller: 'newUserController',
	})
	;


}]);