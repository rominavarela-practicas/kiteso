/**
 * @class MapServices
 * @param servicesUrl
 **/
function MapServices(servicesUrl) {
    this.servicesUrl = servicesUrl;
}

/**
 * @method getMap
 * @param success_callback function(data)
 * @param error_callback function(message)
 **/
MapServices.prototype.getMap = function (success_callback, error_callback)
{
  $.get( this.servicesUrl+"map" ,
              success_callback , "json" )
              .error(error_callback);
}

/**
 * @method getShortestPath
 * @param success_callback function(data)
 * @param error_callback function(message)
 **/
MapServices.prototype.getShortestPath = function (sourceId, targetId, success_callback, error_callback)
{
  $.get( this.servicesUrl+"map/shortest/path/"+sourceId+"/"+targetId ,
              success_callback , "json" )
              .error(error_callback);
}