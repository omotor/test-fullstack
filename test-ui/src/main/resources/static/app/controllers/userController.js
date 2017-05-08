'use strict';
angular.module('test').controller('userController', function ($scope, $state, $http) {
    $scope.user = [];
    $scope.listarUsuarios = function () {
        $http.get("/api/user").then(function (response) {
            console.log(response);
            $scope.user.push(response.data);
        });        
    };
    $scope.listarUsuarios();
    console.log($scope.user);
});