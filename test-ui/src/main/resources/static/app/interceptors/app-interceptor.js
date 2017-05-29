(function() {
    'use strict';

    var app = angular.module('test');

    app.config(config);
    config.$inject = ['$httpProvider'];
    function config($httpProvider) {

        $httpProvider.interceptors.push(['$injector', function($injector){
            var growl = $injector.get('growl');
            var $q = $injector.get('$q');
            return {
                request: function(config) {
                    config.headers = config.headers || {};
                    config.headers['Cache-Control'] = 'no-cache';
                    config.headers['Pragma'] = 'no-cache';
                    config.headers['If-Modified-Since'] ='Mon, 26 Jul 1997 05:00:00 GMT';
                    return config;
                },
                'responseError': function (response) {
                    var status = response.status;
                    if (status == -1) {
                        growl.error("Server offline.", {title: 'Error'});
                        return;
                    }

                    if (status == 500) {
                        growl.error("Server error.", {title: 'Error'});
                        return;
                    }
                    return $q.reject(response);
                }
            };
        }]);
    }
})();