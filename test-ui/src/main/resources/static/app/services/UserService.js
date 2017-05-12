(function (window, angular, undefined) {
    'use strict';

    angular.module('test')
                .factory('UserService', ['$resource', UserService]);
    
	function UserService($resource){
		return $resource('/api/user/:id', null,
		{
			'update': {method: 'PUT'},
			'search': {method: 'GET', isArray: true}
         });
	}
    
})(window, window.angular);
