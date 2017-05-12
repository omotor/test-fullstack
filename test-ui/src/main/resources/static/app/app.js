'use strict';

angular.module('test', ['ui.router','ngResource','mensagem','validation','validation.rule'])

.config(['$urlRouterProvider', '$stateProvider',
	function ($urlRouterProvider, $stateProvider) {

	$urlRouterProvider.otherwise('/home');

}])

.run(['$rootScope', '$state',
	function ($rootScope, $state) {

}]);