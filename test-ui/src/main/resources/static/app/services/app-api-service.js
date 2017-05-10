(function () {
    'use strict';

    angular.module('test')
            .factory('apiUser', ['$resource', apiUser]);


    function apiUser($resource) {
        return $resource('/api/user/:id', null,
                {
                    'update': {method: 'PUT'},
                    'list': {method: 'GET', cache: false, isArray: true}
                });
    }


})();
