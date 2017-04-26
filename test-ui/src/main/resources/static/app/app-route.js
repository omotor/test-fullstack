
'use strict';

angular.module('test').config(['$stateProvider', function ($stateProvider) {

	$stateProvider.state('app', {
		url: '/home',
		templateUrl: '/app/view/app-template.html',
		controller: 'AppController'
	})
    .state('newUser', {
        url: '/newUser',
        templateUrl: '/app/view/newUser-template.html',
        controller: 'newUserController'
    })
	.state('detailUser', {
		url: '/user/:id',
		templateUrl: '/app/view/detailUser-template.html',
		controller: 'detailUserController'
	})
	;


}]);