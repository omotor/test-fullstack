'use strict';

angular.module('test').controller('newUserController', ['$scope', '$state','$location','UserService',
    function ($scope, $state,$location,UserService) {

        $scope.invalidEmail = false;

        $scope.saveUser = function (user) {
            UserService.saveUser(user).success(function (data) {
                $scope.message = "User Saved!";
                $location.path("/");
            }).error(function (data,status) {
                if(data.statusEnum == "INVALID_EMAIL"){
                    $scope.invalidEmail = true;
                }
                $scope.message = "Error occurred " + data;
            });
        }

    }

]);