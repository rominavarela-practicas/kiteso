angular.module('KItesoApp',[]).controller('Controller',function(){
	$("#nextButton").click(function(){
		window.location.assign("teacher.html");
	});
	
	$("#backButton").click(function(){
		window.location.assign("map.html");
	});
});
