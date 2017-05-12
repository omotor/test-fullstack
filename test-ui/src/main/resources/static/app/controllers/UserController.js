(function (window, angular, undefined) {
	'use strict';

    angular.module('test')
    	.controller('UserNewController', ['UserService','$state','$scope','mensagem', UserNewController])
    	.controller('UserUpdateController', ['UserService','$stateParams','$state','mensagem', UserUpdateController])
    	.controller('UserListController', ['UserService','mensagem','$window', UserListController]);
	
	
	function UserListController(UserService,mensagem,$window) {
    	var self = this;

    	self.users = [];
    	
		self.search = function(){
			UserService.search(function(data){
				self.users = data;
			});
		}		
		
		self.search();
		
		self.remove = function(id){
			var confirmAction = $window.confirm("Tem certeza que deseja remover o registro?");
			if(confirmAction){
				UserService.remove({'id':id},function(data){
					mensagem.add("Cliente removido com sucesso",{type:"success"});
					self.search();
				});
			}
		}
		
		return self;
    }
	
	function UserNewController(UserService,$state,$scope,mensagem) {
		var self = this;
		
		self.user = {sex:"MASCULINO"};
		self.form = {submit:save}
		
		function save(){
			UserService.save(self.user,
				function(data){
					mensagem.add("Cliente criado com sucesso",{type:"success"});
					$state.go("users-list");
				},function(error){
					mensagem.add("Erro ao criar cliente",{type:"danger",detail:error});
				}
			)
		}
		
		return self;
	}
	
	function UserUpdateController(UserService,$stateParams,$state,mensagem) {
		var self = this;
		
		UserService.get({id:$stateParams.id},function(data){
			  self.user = data;
	    });
		
		self.form = {submit:update}
		
		function update(){
			UserService.update(self.user,function(data){
				mensagem.add("Cliente atualizado com sucesso",{type:"success"});
				$state.go("users-list");
			},function(error){
				mensagem.add("Erro ao criar cliente",{type:"danger",detail:error});
			})
		}
		
		return self;
	}

})(window, window.angular);