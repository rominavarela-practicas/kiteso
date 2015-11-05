package mx.kiteso.KIteso.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.kiteso.KIteso.controller.SessionController;
import mx.kiteso.KIteso.model.Status;
import mx.kiteso.KIteso.model.Session;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
@RequestMapping("KItesoServices")
public class AuthServices {
	
	@Autowired
	private ServletContext context;
	private static final Logger log = Logger.getLogger(AuthServices.class);
	
	@PostConstruct
	public void init() {
		log.info("Auth Controller Initialized");
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Status authService( @RequestParam String assertion,
						HttpServletRequest req, HttpServletResponse res)
	{
		Status status = new Status();
		status.setStatus(-1);
		
		try
		{
			//post assertion
			@SuppressWarnings({ "deprecation", "resource" })
			HttpClient client = new org.apache.http.impl.client.DefaultHttpClient();
			HttpPost post = new HttpPost("https://verifier.login.persona.org/verify");
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("assertion", assertion));
			params.add(new BasicNameValuePair("audience", req.getScheme() + "://" + req.getServerName() + ":" + (req.getServerPort() == 80 ? "" : req.getServerPort())));
			post.setEntity(new UrlEncodedFormEntity(params));
			
			HttpResponse response = client.execute((HttpUriRequest)post);
			status.setStatus(response.getStatusLine().getStatusCode());
			
			if(status.getStatus()!=Status.STATUS_OK)
				throw new java.lang.Exception("Verifier status is not OK");
			
			//ON SUCCESS
			//read auth data
			Gson gson = new Gson();
			String json = EntityUtils.toString(response.getEntity());
			PersonaAuth personaAuth = gson.fromJson(json, PersonaAuth.class);
		    
			//session
			Session session = new Session();
			session.setEmail(personaAuth.email);
			SessionController.writeSession(session, res);
			status.setEmail(personaAuth.email);
			
			//TODO user exists?
			status.setRedir("/register");
		}
		catch(Exception ex)
		{
			SessionController.clearSession(res);
			status.setMsg(ex.getMessage());
			log.info(ex.getMessage());
		}
		
		return status;
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Status logoutService(HttpServletRequest req, HttpServletResponse res)
	{
		Status status = new Status();
		SessionController.clearSession(res);
		status.setStatus(Status.STATUS_OK);
		status.setRedir("/");
		return status;
	}
	
	@SuppressWarnings("unused")
	private class PersonaAuth
	{
		public String audience;
		public Long expires;
		public String issuer;
		public String email;
		public String status;
	}
	
}
