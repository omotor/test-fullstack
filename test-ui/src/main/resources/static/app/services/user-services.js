angular.module('test').factory('UserService',

    function ($http) {

        var _users = [];

        var _getUsers = function () {
            return $http.get("/api/user");

        };

        var _setUsers = function (users) {
            _users = users;
        };

        var _getUser = function (id) {
            return $http.get("/api/user/"+id);
        };

        var _saveUser = function (user) {
            return $http.post("/api/user",user);
        };

        return {
            getUsers:_getUsers,
            saveUser:_saveUser,
            setUsers:_setUsers,
            getUser:_getUser
        };
    }

)