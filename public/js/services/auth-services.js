/**
 * @class AuthServices
 * @param servicesUrl
 **/
function AuthServices(servicesUrl) {
    this.servicesUrl = servicesUrl;
}

/**
 * @method login
 * @param assertion
 * @param success_callback function(data)
 * @param error_callback function()
 **/
AuthServices.prototype.login = function (assertion, success_callback, error_callback)
{
    $.post( this.servicesUrl+"auth/login" , {assertion:assertion} ,
                success_callback , "json" )
                .fail(error_callback);
}

/**
 * @method logout
 * @param success_callback function(data)
 * @param error_callback function()
 **/
AuthServices.prototype.logout = function (success_callback, error_callback)
{
    $.post( this.servicesUrl+"auth/logout" , {} ,
                success_callback , "json" )
                .fail(error_callback);
}
