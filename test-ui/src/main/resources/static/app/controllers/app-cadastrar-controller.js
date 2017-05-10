angular.module('test').controller('CadastrarController', ['$scope', 'apiUser', CadastrarController]);

function CadastrarController($scope, apiUser) {

    $scope.cadastrar = function () {
        apiUser.save($scope.user, function (data) {
            location.href = "#/user/";
        });

    }
}