(function () {

	'use strict';

	angular.module('test', [
		'ui.router',
		'ngResource',
		'angular-ladda',
		'ui.utils.masks',
		'idf.br-filters',
		'angular-growl'
	])

	.config(['$urlRouterProvider', '$stateProvider',
		function ($urlRouterProvider, $stateProvider) {

		$urlRouterProvider.otherwise('/user/');

	}])

	.run(['$rootScope', '$state',
		function ($rootScope, $state) {

	}]);

})();