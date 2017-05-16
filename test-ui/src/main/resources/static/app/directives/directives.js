'use strict';

angular.module('test').directive('testDataTable', function() {
	return {
		restrict : 'E',
		templateUrl : '/app/pages/templates/template-data-table.html' 
	};
});