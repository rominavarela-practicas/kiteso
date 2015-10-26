package mx.kiteso.KIteso.controller;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("KItesoServices")
public class BaseController {
	
	@Autowired
	private ServletContext context;
	private static final Logger log = Logger.getLogger(BaseController.class);
	
	@PostConstruct
	public void init() {
		log.info("init Demo Controller");
	}
	
	@RequestMapping(value="/hello", method=RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String hello( HttpServletRequest req, HttpServletResponse res)
	{
		return "{ \"msg\": \"hello \" }";
	}
}
