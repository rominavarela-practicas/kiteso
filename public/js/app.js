var servicesUrl = "KItesoServices/";

//service configuration
$.ajaxSetup({
    xhrFields: {
       withCredentials: true
    },
    crossDomain: true
});

//session control
var baseServices = new BaseServices(servicesUrl);
var authServices = new AuthServices(servicesUrl);

$("#loginButton").click(function(){
  navigator.id.request();
});

$("#logoutButton").click(function(){
  navigator.id.logout();
});

navigator.id.watch({
    onlogin: function(assertion)
    {
    	authServices.login(assertion, function(data){

            console.log("auth success");
            console.log(data);


        }, function(e){
            console.log("Error in auth service");
            console.log(e);
        });
    },

    onlogout: function()
    {
    	authServices.logout( function(data){
          console.log("logout success");
          console.log(data);
            if(data.redir)
                window.location.assign(data.redir);
        }, function(e){
            console.log("Error in logout service");
            console.log(e);
        });
    }
});
