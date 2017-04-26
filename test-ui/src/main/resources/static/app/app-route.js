
'use strict';

angular.module('test').config(['$stateProvider', function ($stateProvider) {

	$stateProvider.state('app', {
		url: '/home',
		templateUrl: '/app/app-template.html',
		controller: 'AppController'
	})
    .state('newUser', {
        url: '/newUser',
        templateUrl: '/app/view/newUser-template.html',
        controller: 'newUserController'
    });


}]);