(function () {
    'use strict';
    angular.module('test')
            .directive('formUser', [formUser]);

    function formUser() {
        var ddo = {};

        ddo.restrict = "AE";
        
        ddo.scope = {
            submit: '@',
            user: '=',
        };

        ddo.templateUrl = 'app/directives/form-user.html';
        return ddo;
    }

})(); 