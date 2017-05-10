var userlistcontroller_callback = function($scope, $window, User) {

	$scope.users = User.query();
	
    $scope.deleteUser = function(user) {
    	if (confirm('Tem certeza de que deseja excluir o usuário "' + user.nome + '"?')) {
    		var user_deleted_callback = function() {
		        $window.location.href = '/#/user';
    		};

    		user.$delete(user_deleted_callback);
		}
    };
};

angular.module('test').controller('userlistcontroller', ['$scope', '$window', 'User', userlistcontroller_callback]);
