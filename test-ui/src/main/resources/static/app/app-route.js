
'use strict';

angular.module('test')
.config(['$stateProvider', function ($stateProvider) {

	$stateProvider
		.state('app', {
			url: '/home',
			templateUrl: '/app/app-template.html',
			controller: 'AppController'
		})
		.state('users-list', {
			url: '/user/',
			templateUrl: '/app/views/user-list.html',
			controller: 'UserListController',
			controllerAs: 'userListCtrl'
		})
		.state('user-new', {
			url: '/user/add/:id',
			templateUrl: '/app/views/user-new.html',
			controller: 'UserNewController',
			controllerAs: 'userCtrl'
		})
		
		.state('user-update', {
			url: '/user/:id',
			templateUrl: '/app/views/user-update.html',
			controller: 'UserUpdateController',
			controllerAs: 'userCtrl'
		});

}]);