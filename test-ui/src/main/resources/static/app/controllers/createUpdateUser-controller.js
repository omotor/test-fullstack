'use strict';

angular.module('test').controller('newUserController', ['$scope', '$state','$location','$stateParams','UserService',
    function ($scope, $state,$location,$stateParams,UserService) {

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

        var getUser = function () {
            UserService.getUser($stateParams.id).success(function (data) {
                $scope.user = data;
            }).error(function (data,status) {
                $scope.message = "Error occurred " + data;
            });
        }

        if($stateParams.newUser == true){
            $scope.newUser = true;
        }else {
            getUser();
        }

    }

]);