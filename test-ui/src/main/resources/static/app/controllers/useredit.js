'use strict';

var usereditcontroller_callback= function($scope, $state, $stateParams, User) {
	$scope.updateUser= function() {
		$scope.user.$update(function() {
			$state.go('userlist');
		});
	};

	$scope.loadUser = function() {
		$scope.user = User.get({ id: $stateParams.id });
	};

	$scope.loadUser();

};

angular.module('test').controller('usereditcontroller', ['$scope', '$state', '$stateParams', 'User', usereditcontroller_callback]);
