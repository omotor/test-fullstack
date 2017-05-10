'use strict';

var userdeletecontroller_callback = function($http, $stateParams) {
	$http.delete("/api/user/" + $stateParams.id);
};

angular.module('test').controller('userdeletecontroller', ['$http', '$stateParams', userdeletecontroller_callback]);
