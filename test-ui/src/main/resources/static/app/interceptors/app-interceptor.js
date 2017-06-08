(function () {
	angular.module('test').config(['$httpProvider', function($httpProvider){
		console.log("Adding interceptor");
	    $httpProvider.interceptors.push(function(){
	    	return {
	            request: function(config) {
	                config.headers = config.headers || {};
	                config.headers['Cache-Control'] = 'no-cache';
	                config.headers['Pragma'] = 'no-cache';//disabled because of crossdomain tests
	                config.headers['If-Modified-Since'] ='Mon, 26 Jul 1997 05:00:00 GMT';
	                
	                //enable to overcome cross domain origin problems
	                /*
	                config.headers['Access-Control-Allow-Headers'] = 'Origin, X-Requested-With, Content-Type, Accept';
	                config.headers['Access-Control-Allow-Origin'] = '*';
	                config.headers['Access-Control-Allow-Methods'] = 'POST, GET, GET, DELETE, OPTIONS';
	                config.headers['Accept'] = 'application/json;odata=verbose';
					*/
	                return config;
	            }
	        };
	    });
	
	}]);
	
})();