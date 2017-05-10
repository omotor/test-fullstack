'use strict';

angular.module('test', ['ui.router','ngResource'])

.config(['$urlRouterProvider', '$stateProvider',
	function ($urlRouterProvider, $stateProvider) {

	$urlRouterProvider.otherwise('/home');

}])

.run(['$rootScope', '$state',
	function ($rootScope, $state) {

}]);