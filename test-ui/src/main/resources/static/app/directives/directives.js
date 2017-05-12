
(function (window, angular, undefined) {
    'use strict';



    angular.module('test')

    .directive('alertMessage', function () {
        return {
            restrict: 'A',
            templateUrl: 'app/components/mensagem/layout-mensagem.html'
        }
    })
    
   .directive('phone', function () {
        return {
            require: 'ngModel',
            link: function (scope, element, attrs, modelCtrl) {
                modelCtrl.$parsers.push(function (inputValue) {
                    if (inputValue == undefined) return ''
                    var transformedInput = inputValue.replace(/[^0-9]/g, '');
                    if (transformedInput != inputValue) {
                        modelCtrl.$setViewValue(transformedInput);
                        modelCtrl.$render();
                    }

                    return transformedInput;
                });
            }
        };
    });
    
})(window, window.angular);
