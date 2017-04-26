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

        var saveUser = function (user) {
            UserService.saveUser(user).success(function (data) {
                $scope.message = "User Saved!";
            }).error(function (data,status) {
                $scope.message = "Error occurred " + data;
            });
        }

	}

]);