/**
 * Created by DEK on 25/04/2017.
 */

angular.module("test").directive('formatPhone', [
    function() {
        return {
            require: 'ngModel',
            restrict: 'A',
            link: function(scope, elem, attrs, ctrl, ngModel) {
                elem.add(phonenumber).on('keyup', function() {
                    var origVal = elem.val().replace(/[^\w\s]/gi, '');
                    if(origVal.length > 4) {
                        var str = origVal.replace(/(.{5})/g,"$1-");
                        var phone = str;
                        jQuery("#phonenumber").val(phone);
                    }

                });
            }
        };
    }
]);