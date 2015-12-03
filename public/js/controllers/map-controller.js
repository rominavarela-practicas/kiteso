angular.module('KItesoApp',[]).controller('Controller', ['$scope', function($scope) {
    var _t= this;
    
    _t.locations= [];
    _t.sourceLocation = undefined;
    _t.targetLocation = undefined;
    
    _t.mapCenter=new google.maps.LatLng(20.608140,-103.414618);
    _t.map=new google.maps.Map(document.getElementById("googleMap"),
    {
        center:_t.mapCenter,
        zoom:18,
        mapTypeId:google.maps.MapTypeId.HYBRID
    });
    
    _t.flightPath= undefined;
    
    _t.marker=new google.maps.Marker({
        position:_t.mapCenter,
        animation:google.maps.Animation.BOUNCE
        });

    _t.marker.setMap(_t.map);

    //web service
    window.mapServices.getMap(function(data){
        _t.locations= data.locations;
        $scope.$apply();
        
        var arregloNodos=[];
        for(var i=0; i<data.paths.length; i++)
        {
        	var tempSource =new google.maps.LatLng( 
        			data.paths[i].source[0],
        			data.paths[i].source[1]);
        	
        	arregloNodos.push(tempSource);
        
        }
        
        var tempTarget =new google.maps.LatLng( 
        		data.paths[data.paths.length-1].target[0],
        		data.paths[data.paths.length-1].target[1]);
        arregloNodos.push(tempTarget);
        
        var flightPath = new google.maps.Polyline({
            path:arregloNodos,
            strokeColor:"#FFFFFF",
            strokeOpacity:0.8,
            strokeWeight:2
        });
        
        flightPath.setMap(_t.map);
        
    });
    
   _t.selectLocation= function(location){
	   location.selected= true;
	   
	   if(_t.selectionFlag)
	   {
		   if(_t.sourceLocation)
		   {
			   if(_t.sourceLocation.nodeIndex== location.nodeIndex
					   || (_t.targetLocation && _t.targetLocation.nodeIndex== location.nodeIndex))
				   return;
			   else
				   _t.sourceLocation.selected= false;
		   }
		   
		   _t.sourceLocation = location;
	   }
	   else
	   {
		   	if(_t.targetLocation)
			{
		   		if(_t.targetLocation.nodeIndex== location.nodeIndex
						   || (_t.sourceLocation && _t.sourceLocation.nodeIndex== location.nodeIndex))
					   return;
				   else
					   _t.targetLocation.selected= false;
			}
		   
		   _t.targetLocation = location;
	   }
	   
	   _t.selectionFlag= !_t.selectionFlag;
	   
	   if(_t.sourceLocation && _t.targetLocation)
	   {
		   window.mapServices.getShortestPath(
				    _t.sourceLocation.nodeIndex,
				    _t.targetLocation.nodeIndex,
					function(data){
				        console.log("success");
				        console.log(data);
				        console.log(_t.arregloNodos)
				        
				        if(_t.flightPath)
				        	_t.flightPath.setMap(null);
				        
				        var arregloNodos=[];
				        for(var i=0; i<data.paths.length; i++)
				        {
				        	var tempSource =new google.maps.LatLng( 
				        			data.paths[i].source[0],
				        			data.paths[i].source[1]);
				        	
				        	arregloNodos.push(tempSource);
				        
				        }
				        
				        var tempTarget =new google.maps.LatLng( 
				        		data.paths[data.paths.length-1].target[0],
				        		data.paths[data.paths.length-1].target[1]);
				        arregloNodos.push(tempTarget);
				        
				        _t.flightPath = new google.maps.Polyline({
				            path:arregloNodos,
				            strokeColor:"#0000FF",
				            strokeOpacity:0.8,
				            strokeWeight:2
				        });
				        
				        _t.flightPath.setMap(_t.map);
				    });
	   }
   }
   
   
   $("#nextButton").click(function(){
		window.location.assign("schedule.html");
	});
   
}]);