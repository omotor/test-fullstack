'use strict';

angular.module('test').service('UserService', function($http) {

	var save = function(data) {

		var req = {
			method : 'POST',
			url : 'http://localhost:5000/api/user',
			headers : {
				'Content-Type' : 'application/json'
			},
			data : JSON.stringify(data)
		};

		return $http(req).then(function(response) {
			alert("gravado com sucesso!");
			return response;
		}, function(response) {
			alert(response.statusText);
			return null;
		});
	};
	
	var update = function(data) {

		var req = {
			method : 'PUT',
			url : 'http://localhost:5000/api/user',
			headers : {
				'Content-Type' : 'application/json'
			},
			data : JSON.stringify(data)
		};

		return $http(req).then(function(response) {
			alert("gravado com sucesso!");
			return response;
		}, function(response) {
			alert(response.statusText);
			return null;
		});
	};
	
	var deleteUser = function(id) {

		var req = {
			method : 'DELETE',
			url : 'http://localhost:5000/api/user/'+id,
			headers : {
				'Content-Type' : 'application/json'
			}
		};

		return $http(req).then(function(response) {
			alert("EXCLUIDO COM SUCESSO!");
			return response;
		}, function(response) {
			alert(response.statusText);
			return null;
		});
	};

	var list = function() {

		var req = {
			method : 'GET',
			url : 'http://localhost:5000/api/user',
			headers : {
				'Content-Type' : 'application/json'
			}
		};

		return $http(req).then(function(response) {
			return response;
		}, function(response) {
			return null;
		});
	};
	
	var get = function(id) {

		var req = {
			method : 'GET',
			url : 'http://localhost:5000/api/user/'+id,
			headers : {
				'Content-Type' : 'application/json'
			}
		};

		return $http(req).then(function(response) {
			return response;
		}, function(response) {
			return null;
		});
	};

	return {
		save : save,
		list : list, 
		get : get, 
		update : update,
		deleteUser : deleteUser
	}

});
