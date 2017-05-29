(function () {

    'use strict';

    var app = angular.module('test');

    app.controller('UserFormController', UserFormController);

    UserFormController.$inject = ['$scope', '$state' ,'UserService', '$stateParams', 'growl'];

    function UserFormController($scope, $state, UserService, $stateParams, growl) {
        var vm = this;
        vm.saveOrUpdate = false;
        vm.user = {};

        vm.save = save;

        if($stateParams.id){
            var id = {id: $stateParams.id};
            UserService.get(id).$promise.then(function(data) {
                vm.user = data;
            }).catch(function(response){
                console.log(response);
            });
        }

        function save(){
            vm.saveOrUpdate = true;

            saveOrUpdate().then(function(data) {
                growl.success("User saved successfully.");
                $state.go('user-list');
                vm.saveOrUpdate = false;
            }).catch(function(response){
                if(response.data){
                    angular.forEach(response.data, function(error, key) {
                        growl.error(error.message);
                    });
                }
                vm.saveOrUpdate = false;
                console.log(response);
            });

        }

        function saveOrUpdate() {
            if (vm.user.id) {
                var id = {id:vm.user.id};
                return UserService.update(id, vm.user).$promise;
            } else {
                return UserService.save(vm.user).$promise;
            }
        }

    }

})();