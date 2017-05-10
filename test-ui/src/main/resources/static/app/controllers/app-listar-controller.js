angular.module('test').controller('ListarController', ['$scope', '$state', 'apiUser', ListarController]);

function ListarController($scope, $state, apiUser) {
    apiUser.list(function (data) {
        $scope.users = data;
    });
}