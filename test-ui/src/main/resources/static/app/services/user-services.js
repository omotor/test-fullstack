angular.module('test').factory('UserService',

    function ($http) {

        var _getUsers = function () {
            return $http.get("/api/user");
        };

        var _saveUser = function (user) {
            return $http.post("/api/user",user);
        };

        return {
            getUsers:_getUsers,
            saveUser:_saveUser
        };
    }

)