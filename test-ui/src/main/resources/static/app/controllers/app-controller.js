'use strict';

angular.module('test').controller('AppController', ['$scope', '$state','$location','UserService',
	function ($scope, $state,$location,UserService) {

		var loadUsers = function () {
            UserService.getUsers().success(function (data) {
				$scope.users = data;
            }).error(function (data,status) {
				$scope.message = "Error occurred " + data;
            });
        }
        loadUsers();

        $scope.deleteUser = function (id) {
            UserService.deleteUser(id).success(function (data) {
                console.log("User deleted")
                loadUsers();
            }).error(function (data,status) {
                $scope.message = "Error occurred " + data;
            });
        }

        $scope.updateUser = function (id) {
            $location.path("/user/"+id);
        }

	}

]);