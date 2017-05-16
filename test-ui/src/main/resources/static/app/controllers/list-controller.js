'use strict';

angular.module('test').controller('ListController',
		function($location, UserService) {
			var vm = this;

			vm.load = function() {
				UserService.list().then(function(result) {
					vm.list = result.data;
				});
			}

			vm.newUser = function() {
				$location.path('useradd');
			}
			
			vm.editUser = function(id){
				$location.path('user/' + id);
			}
			
			vm.load();

		});
