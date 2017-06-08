(function () {
	angular.module('test').controller('UserFormController', ['UserService','$scope','$state','$stateParams',function(UserService,$scope, $state, $stateParams){
		console.log("userFormController ...");
		var vm = this;
		vm.saveOrUpdate = false;
		vm.user = {};
	
	
		if($stateParams.id){
			var id = $stateParams.id;
			UserService.getUser(id).then(function(response) {
				vm.user = response.data;
			},function(error){
				console.log(error);
				$scope.errorMessage = error;
			}).catch(function(response){
				$scope.errorMessage = "Error at trying to get user"
				console.log(response);
			});
		}
		
		vm.saveUser = function(){
			vm.saveOrUpdate = true;
	
			saveOrUpdateUser().then(function(data) {
				$scope.message = "User saved with success.";
				$state.go('user-list');
				vm.saveOrUpdate = false;
			},function(error){
				console.log(error);
				$scope.errorMessage = error;
			}).catch(function(response){
				if(response.data){
					$scope.errorMessage = '';
					angular.forEach(response.data, function(error, key) {
						$scope.errorMessage += error.message;
					});
				}
				vm.saveOrUpdate = false;
				console.log(response);
			});
		};
	
		function saveOrUpdateUser() {
			if (vm.user.id) {
				return UserService.updateUser(vm.user.id, vm.user);
			} else {
				console.log("user: "+ vm.user+", vm.user.name: "+vm.user.name)
				return UserService.createUser(vm.user);
			}
		}
		
	}]);

})();	