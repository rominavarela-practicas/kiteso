package mx.kiteso.KIteso.services;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.kiteso.KIteso.controller.SessionController;
import mx.kiteso.KIteso.model.Session;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("KItesoServices/demo")
public class BaseServices {
	
	@Autowired
	private ServletContext context;
	private static final Logger log = Logger.getLogger(BaseServices.class);
	
	@PostConstruct
	public void init() {
		log.info("init Demo Controller");
	}
	
	@RequestMapping(value="/hello", method=RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String hello( 
			@CookieValue(value = "session", defaultValue = "{}") String sessionCookie,
			HttpServletRequest req, HttpServletResponse res)
	{
		Session session = SessionController.readSession(sessionCookie);
		return "{ \"msg\": \"hello : "+session.getEmail()+" \" }";
	}
}
