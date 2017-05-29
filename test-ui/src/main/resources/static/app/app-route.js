(function () {
	'use strict';

	angular.module('test').config(['$stateProvider', function ($stateProvider) {


		$stateProvider.state('user-list', {
			url: '/user/',
			templateUrl: '/app/views/list-user.html',
			controller: 'UserController'
		});

		$stateProvider.state('user-add', {
			url: '/user/add/',
			templateUrl: '/app/views/form-user.html',
			controller: 'UserFormController'
		});

		$stateProvider.state('user-edit', {
			url: '/user/:id',
			templateUrl: '/app/views/form-user.html',
			controller: 'UserFormController'
		});

		$stateProvider.state('app', {
			url: '/home',
			templateUrl: '/app/templates/app-template.html',
			controller: 'AppController'
		});

	}]);

})();