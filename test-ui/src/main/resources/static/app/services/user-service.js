(function () {
    'use strict';

    var app = angular.module('test');
    app.factory('UserService', UserService);

    UserService.$inject = ['$resource', 'Global'];

    function UserService($resource, Global) {
        return $resource(Global.urlBase+"user/:id", {id:"@_id"}, {
            query:{isArray: true},
            update:{method:'PUT'}
        });
    }

})();