angular.module('siscc.directive', [])

    .directive('alertMessage', function () {
        return {
            restrict: 'A',
            templateUrl: 'app/components/mensagem/layout-mensagem.html'
        }
    })