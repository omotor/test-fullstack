/**
 * Created by DEK on 25/04/2017.
 */

angular.module("test").directive("uiAlert", function () {
    return {
        templateUrl: "app/view/alert.html",
        replace: true,
        restrict: "AE",
        scope: {
            title: "@"
        },
        transclude: true
    };
});