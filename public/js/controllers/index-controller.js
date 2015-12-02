/*baseServices = new BaseServices(servicesUrl);
helloButton = $("#helloButton");

helloButton.click(function(){
  baseServices.getHello(function(data){
                console.log("success");
                console.log(data);
            }, function(e){
                console.log("error");
                console.log(e);
            });
});*/

$("#nextButton").click(function(){
	if(!window.session)
		navigator.id.request();
	else if(!window.session.name)
		window.location.assign("register.html");
});
