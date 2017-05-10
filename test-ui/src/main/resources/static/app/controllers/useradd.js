'use strict';

var useraddcontroller_callback= function($scope, $state, $stateParams, User) {
	console.log("User: " + User);

	$scope.user = new User();

	$scope.addUser = function() {
		$scope.user.$save(function() {
			$state.go('userlist');
		});
	};
};

angular.module('test').controller('useraddcontroller', ['$scope', '$state', '$stateParams', 'User', useraddcontroller_callback]);
