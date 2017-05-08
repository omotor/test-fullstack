'use strict';
angular.module('test').controller('userAddController', function ($scope, $state, $http) {
    $scope.userAdd = [];    
    $scope.adcionarUsuarios = function () {
        $http.post("/api/user", $state.params.usuario).then(function (response) {
            console.log(response);
            $scope.userAdd.push(response.data);
        });
    };

    $scope.adcionarUsuarios();
    console.log($scope.userAdd);
});