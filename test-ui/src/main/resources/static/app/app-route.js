'use strict';

angular.module('test').config(['$stateProvider', function ($stateProvider) {
	console.log('routing ...');
	$stateProvider.state('user-list', {
		url: '/user',
		templateUrl: 'app/views/users.html',
		controller: 'UserListController',
		controllerAs: 'vm'
	});
	
	$stateProvider.state('user-add', {
		url: '/user/add',
		templateUrl: 'app/views/user.html',
		controller: 'UserFormController',
		controllerAs: 'vm'
	});

	$stateProvider.state('user-edit', {
		url: '/user/:id',
		templateUrl: 'app/views/user.html',
		controller: 'UserFormController',
		controllerAs: 'vm'
	});

	$stateProvider.state('app', {
		url: '/home',
		templateUrl: 'app/app-template.html',
		controller: 'AppController'
	});

}]);