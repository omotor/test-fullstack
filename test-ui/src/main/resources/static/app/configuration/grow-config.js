(function () {
    'use strict';

    var app = angular.module('test');

    app.config(['growlProvider', function(growlProvider) {
        growlProvider.globalDisableCloseButton(true);
        growlProvider.globalTimeToLive({success: 3000, error: 5000, warning: 5000, info: 6000});
    }]);


})();