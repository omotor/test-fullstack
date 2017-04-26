'use strict';

angular.module('test').controller('newUserController', ['$scope', '$state','UserService',
    function ($scope, $state,UserService) {

        $scope.saveUser = function (user) {
            UserService.saveUser(user).success(function (data) {
                $scope.message = "User Saved!";
            }).error(function (data,status) {
                $scope.message = "Error occurred " + data;
            });
        }

    }

]);