/**
 * @class BaseServices
 * @param servicesUrl
 **/
function BaseServices(servicesUrl) {
    this.servicesUrl = servicesUrl;
}

/**
 * @method hello
 * @param success_callback function(data)
 * @param error_callback function(message)
 **/
BaseServices.prototype.getHello = function (success_callback, error_callback)
{
  /*$.get( this.servicesUrl+"hello" ,
              success_callback , "json" )
              .error(error_callback);*/
  $.post( this.servicesUrl+"demo/hello" , {} ,
              success_callback , "json" )
              .fail(error_callback);
}
