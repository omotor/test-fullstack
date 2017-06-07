'use strict';

angular.module('test').controller('AppController', ['$scope', '$state',
	function ($scope, $state) {
		console.log("appController: " + $state);
}]);