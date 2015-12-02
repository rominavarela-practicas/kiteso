package mx.kiteso.KIteso.services;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.kiteso.KIteso.controller.SessionController;
import mx.kiteso.KIteso.model.serial.out.Session;
import mx.kiteso.KIteso.model.serial.out.Status;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("KItesoServices/demo")
public class BaseServices {
	public static Logger log = Logger.getLogger(BaseServices.class);
	
	public Connection connection;
	
	@PostConstruct
	public void init() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost/Diseno_Software", "root", "toor");
		
		log.info("init Demo Controller");
	}
	
	@PreDestroy
	public void destroy() throws Exception {
		if(connection != null){
			connection.close();
		}
		
		log.info("Database connection closed");
	}
	
	@RequestMapping(value="/hello", method=RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Status hello( 
			@CookieValue(value = "session", defaultValue = "{}") String sessionCookie,
			HttpServletRequest req, HttpServletResponse res)
	{
	    Status status = new Status();
	    status.setStatus(Status.STATUS_OK);
	    
	    try
	    {
	    	Session session = SessionController.readSession(sessionCookie);
	    	status.setMsg("hello "+session.getEmail());
	    }
	    catch(Exception ex)
	    {
	    	status.setMsg("hello visitor");
	    }
		
		return status;
	}
}
