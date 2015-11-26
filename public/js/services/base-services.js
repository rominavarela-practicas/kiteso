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

/**
 * @method getGraph
 * @param success_callback function(data)
 * @param error_callback function(message)
 **/
BaseServices.prototype.getGraph = function (success_callback, error_callback)
{
  /*$.get( this.servicesUrl+"hello" ,
              success_callback , "json" )
              .error(error_callback);*/
  /*$.post( this.servicesUrl+"demo/hello" , {} ,
              success_callback , "json" )
              .fail(error_callback);*/
  var graph={
       markers:[
        {name:"A",coords:[20.608140,-103.414618]},
        {name:"B",coords:[20.607659,-103.414561]},
        {name:"C",coords:[20.607825,-103.414793]}
       ],
       paths:[
        {source:[20.608140,-103.414618],target:[20.607659,-103.414561]},
        {source:[20.607659,-103.414561],target:[20.607660,-103.414961]},
        {source:[20.607660,-103.414961],target:[20.607825,-103.414793]},
       ]
  };
  success_callback(graph);
}