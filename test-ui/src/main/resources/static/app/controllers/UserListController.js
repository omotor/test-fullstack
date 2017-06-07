'use strict';

angular.module('test').controller('UserListController', function($scope, UserService){
	console.log("userListController ...");
	var vm = this;
	vm.users = [];

	vm.remove = function remove(user, index){
		console.log(user);
		UserService.deleteUser(user.id).then(function(response) {
			$scope.message = "User has been removed.";
			console.log($scope.message);
			vm.users.splice(index,1);
		},function(error){
			console.log(error);
			$scope.errorMessage = error;
		});
	}

	UserService.getUsers().then(function(response) {
		console.log("getUsers: ");
		console.log(response);
		vm.users = response.data;
	}).catch(function(response){
		$scope.errorMessage = "Error at trying get users";
		console.log(response);
	});

});