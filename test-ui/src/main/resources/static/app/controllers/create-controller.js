'use strict';

angular.module('test').controller('CreateController', function(UserService, $location) {
			
	var vm = this;

	vm.save = function() {
		UserService.save(vm.user).then(function(result){
			$location.path('user/' + result.data.id);
		});
	}

});
