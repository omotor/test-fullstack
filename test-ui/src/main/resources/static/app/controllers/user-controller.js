(function () {

    'use strict';

    var app = angular.module('test');

    app.controller('UserController', UserController);

    UserController.$inject = ['$scope', 'UserService', 'growl'];

    function UserController($scope, UserService, growl) {
        var vm = this;
        vm.userList = [];

        vm.remove = remove;

        UserService.query().$promise.then(function(data) {
            vm.userList = data;
        }).catch(function(response){
            console.log(response);
        });

        function remove(user, index){
            var id = {id:user.id};
            UserService.delete(id).$promise.then(function(data) {
                growl.success("User has been successfully removed.");
                vm.userList.splice(index,1);
            });
        }
    }

})();