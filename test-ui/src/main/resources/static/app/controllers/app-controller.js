'use strict';

angular.module('test').controller('AppController', ['$scope', '$state','UserService',
	function ($scope, $state,UserService) {

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

	}

]);