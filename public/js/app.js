var servicesUrl = "KItesoServices/";

//service configuration
$.ajaxSetup({
    xhrFields: {
       withCredentials: true
    },
    crossDomain: true
});

//session control
window.baseServices = new BaseServices(servicesUrl);
window.authServices = new AuthServices(servicesUrl);
window.mapServices = new MapServices(servicesUrl);
window.session = {};

$("#loginButton").click(function(){
  navigator.id.request();
});

$("#logoutButton").click(function(){
  navigator.id.logout();
});

var displaySession = function() {
    if(window.session.email)
    {    	
    	$("#userName").text(window.session.email)
    	
        $("#loginButton").hide();
        $("#userButton").show();
    }
    else
    {    	
        $("#loginButton").show();
        $("#userButton").hide();
    }
}

displaySession();

navigator.id.watch({
    onlogin: function(assertion)
    {
    	window.authServices.login(assertion, function(data){
            console.log("auth success");
            console.log(data);
            
            //on change
            if(window.session.email != data.email)
        	{
            	session = data;
                displaySession();
                if(data.redir && data.redir!==window.location.pathname)
                	window.location.assign(data.redir);
        	}
                        
        }, function(e){
            console.log("Error in auth service");
            console.log(e);
            session = {}
            displaySession();
        });
    },

    onlogout: function()
    {
    	window.authServices.logout( function(data){
            console.log("logout success");
            console.log(data);
            
            //on change
            if(window.session.email != data.email)
        	{
            	window.session = {}
            	displaySession();
                if(data.redir && data.redir!==window.location.pathname)
                	window.location.assign(data.redir);
        	}
                
        }, function(e){
            console.log("Error in logout service");
            console.log(e);
            
            session = {}
            displaySession();
        });
    }
});
