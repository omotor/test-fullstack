
'use strict';

angular.module('test').config(['$stateProvider', function ($stateProvider) {

	$stateProvider.state('app', {
		url: '/home',
		templateUrl: '/app/app-template.html',
		controller: 'AppController'
	});


}]);