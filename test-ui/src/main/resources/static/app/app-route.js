
'use strict';

angular.module('test').config(['$stateProvider', function ($stateProvider) {

	$stateProvider.state('app', {
		url: '/home',
		templateUrl: '/app/pages/app-home.html',
		controller: 'AppController', 
		controllerAs: 'vm'
	}).
	
	state('list', {
		url: '/user',
		templateUrl: '/app/pages/app-list.html',
		controller: 'ListController', 
		controllerAs: 'vm'
	}).
	
	state('form-edit', {
		url: '/user/:id',
		templateUrl: '/app/pages/app-form-edit.html',
		controller: 'EditController', 
		controllerAs: 'vm'
	}).
	
	state('form-create', {
		url: '/useradd',
		templateUrl: '/app/pages/app-form-create.html',
		controller: 'CreateController', 
		controllerAs: 'vm'
	});

}]);