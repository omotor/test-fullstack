'use strict';
angular.module('test').controller('getUserController', function ($scope, $state, $http) {        
    $scope.getUser = [];
    $scope.getUsuario = function () {
        $http.get("/api/user?id="+ $state.params.id).then(function (response) {
            console.log(response);
            $scope.getUser.push(response.data);
        });
    };
    $scope.getUsuario();
    console.log($scope.getUser);
});