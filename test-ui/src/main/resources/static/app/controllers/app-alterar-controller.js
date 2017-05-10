angular.module('test').controller('AlterarController', ['$scope', '$stateParams', 'apiUser', AlterarController]);

function AlterarController($scope, $stateParams, apiUser) {
    apiUser.get({id:$stateParams.id},function(data){
        $scope.user = data;
    });
    
    $scope.alterar = function(){
        apiUser.update({id:$stateParams.id},$scope.user, function (data) {
            location.href = "#/user/";
        });
    }
}