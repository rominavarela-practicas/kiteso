baseServices = new BaseServices(servicesUrl);
helloButton = $("#helloButton");

helloButton.click(function(){
  baseServices.getHello(function(data){
                console.log("success");
                console.log(data);
            }, function(e){
                console.log("error");
                console.log(e);
            });
});
