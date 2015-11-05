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
var session = {};

$("#loginButton").click(function(){
  navigator.id.request();
});

$("#logoutButton").click(function(){
  navigator.id.logout();
});

var displaySession = function() {
    if(session.email)
    {
        $("#loginButton").hide();
        $("#logoutButton").show();
    }
    else
    {
        $("#loginButton").show();
        $("#logoutButton").hide();
    }
}

displaySession();

navigator.id.watch({
    onlogin: function(assertion)
    {
    	authServices.login(assertion, function(data){
            console.log("auth success");
            console.log(data);
            
            //on change
            if(session.email != data.email)
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
    	authServices.logout( function(data){
            console.log("logout success");
            console.log(data);
            
            //on change
            if(session.email != data.email)
        	{
                session = {}
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
