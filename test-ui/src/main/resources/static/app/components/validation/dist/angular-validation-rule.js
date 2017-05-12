/**
 * Created by indra on 14/01/15.
 */

angular.module('validation.rule', ['validation'])

    .config(['$validationProvider', function ($validationProvider) {
        var expression = {
            range: function (value, scope, element, attrs) {
                if (value >= parseInt(attrs.min) && value <= parseInt(attrs.max)) {
                    return value;
                }
            },
            length: function (value, scope, element, attrs) {
                if (value.length >= parseInt(attrs.minlength || 0) && value.length <= parseInt(attrs.maxlength)) {
                    return value;
                }
            },
            lengthNumber: function (value, scope, element, attrs) {
                if (value.length >= parseInt(attrs.minlength) && value.length <= parseInt(attrs.maxlength)) {
                    return value;
                } 
            },
            required: function (value) {
                return !!value;
            },
            requiredList: function (value) {
            	return !(angular.isUndefined(value) || value === null || value.length == 0);
            },
            url: /((([A-Za-z]{3,9}:(?:\/\/)?)(?:[-;:&=\+\$,\w]+@)?[A-Za-z0-9.-]+|(?:www.|[-;:&=\+\$,\w]+@)[A-Za-z0-9.-]+)((?:\/[\+~%\/.\w-_]*)?\??(?:[-\+=&;%@.\w_]*)#?(?:[\w]*))?)/,
			email : /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/,
			number: /^\d+$/,
            numberUntil1999:function (value) {
                return value >= 1 && value <= 999;
            },
            none: function (value) {
            	return true;
            }
        };
        
        var maxlength = {
        	ml:	function (value, scope, element, attrs) {
              return attrs.maxlength;    
        	},
        };
        
       var defaultMsg = {
            required: {error: 'Campo obrigatório', success: ''},
            requiredList: {error: 'Campo obrigatório', success: ''},
            url: {error: 'Url inválida', success: ''},
            email: {error: 'Email inválido', success: ''},
            number: {error: 'Informe um número', success: ''},
            range: {error: 'Number should between 5 ~ 10', success: 'good'},
            length: {error: 'Verifique a quantidade de caracteres informados', success: ''},
            none: {error: '', success: ''},
            numberUntil999: {error: 'O valor deve estar entre 0 e 999', success: ''},
            numberValidUntil999: {error: 'O valor deve estar entre 1 e 999', success: ''}
        };

        $validationProvider.setExpression(expression).setDefaultMsg(defaultMsg);
        $validationProvider.showSuccessMessage = false;
    }
    ])

;

