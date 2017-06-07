'use strict';

angular.module('test').service('UserService', function ($http) {
	var baseUrl = "http://localhost:5000/api/user/";
	console.log("userService ...");
	this.getUsers = function () {
		return $http.get(baseUrl);
	}
	
	this.getUser = function (userId) {
		return $http.get(baseUrl + userId);
	}
	
	this.createUser = function (user) {
		console.log("Creating user: " + user);
		return $http.post(baseUrl,{
			name: user.name,
			email: user.email,
			telephone: user.telephone,
			sex: user.sex
		});
	}
	
	this.updateUser = function (userId, user) {
		return $http.put(baseUrl + userId,{
			name: user.name,
			email: user.email,
			telephone: user.telephone,
			sex: user.sex
		});
	}
	
	this.deleteUser = function (userId) {
		return $http.delete(baseUrl + userId);
	}
});
