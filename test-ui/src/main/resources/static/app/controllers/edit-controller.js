'use strict';

angular.module('test').controller('EditController',
		function($stateParams, UserService, $location) {

			var vm = this;

			vm.get = function() {
				UserService.get($stateParams.id).then(function(result) {
					vm.user = result.data;
				});
			}

			vm.get();

			vm.save = function() {
				UserService.update(vm.user);
			}
			
			vm.deleteUser = function() {
				UserService.deleteUser(vm.user.id).then(function(data){
					$location.path('user');
				});
				
				
			}

		});
