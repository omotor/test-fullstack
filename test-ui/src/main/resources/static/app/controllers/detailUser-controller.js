/**
 * Created by DEK on 25/04/2017.
 */

'use strict';

angular.module('test').controller('detailUserController', ['$scope', '$state','$stateParams','UserService',
    function ($scope, $state,$stateParams ,UserService) {

        var getUser = function () {
            UserService.getUser($stateParams.id).success(function (data) {
                $scope.user = data;
            }).error(function (data,status) {
                $scope.message = "Error occurred " + data;
            });
        }
        getUser();
    }

]);