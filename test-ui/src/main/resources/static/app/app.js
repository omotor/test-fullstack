'use strict';

angular.module('test', ['ui.router','ngMessages'])
.config(['$urlRouterProvider', '$stateProvider', function ($urlRouterProvider, $stateProvider) {
		$urlRouterProvider.otherwise('/user');
}])
.run(['$rootScope', '$state',
	function ($rootScope, $state) {

}]);