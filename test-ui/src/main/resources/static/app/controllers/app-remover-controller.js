angular.module('test').controller('RemoverController', ['$scope', 'apiUser', RemoverController]);

function RemoverController($scope, apiUser) {
    $scope.deletar = function (user, e) {
        apiUser.delete({id: user.id}, function () {
            $scope.users.splice($scope.users.indexOf(user), 1);
        });
    };
}