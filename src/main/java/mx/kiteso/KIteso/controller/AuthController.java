package mx.kiteso.KIteso.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.kiteso.KIteso.constant.Status;
import mx.kiteso.KIteso.model.Auth;

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
@RequestMapping("KItesoServices/auth")
public class AuthController {
	
	@Autowired
	private ServletContext context;
	private static final Logger log = Logger.getLogger(AuthController.class);
	
	@PostConstruct
	public void init() {
		log.info("Auth Controller Initialized");
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Auth authService( @RequestParam String assertion,
						HttpServletRequest req, HttpServletResponse res)
	{
		Auth auth = new Auth();
		auth.setStatus(-1);
		
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
			auth.setStatus(response.getStatusLine().getStatusCode());
			
			if(auth.getStatus()!=Status.STATUS_OK)
				throw new java.lang.Exception("Verifier status is not OK");
			
			//ON SUCCESS
			//read auth data
			Gson gson = new Gson();
			String json = EntityUtils.toString(response.getEntity());
			PersonaAuth personaAuth = gson.fromJson(json, PersonaAuth.class);
		    
			//store session
			//TODO session model (user table?)
			Cookie cookie = new Cookie("session", personaAuth.email);
			res.addCookie(cookie);
			
			auth.setEmail(personaAuth.email);
		}
		catch(Exception ex)
		{
			//remove session
			Cookie cookie = new Cookie("session", "");
			res.addCookie(cookie);
			
			auth.setMsg(ex.getMessage());
			log.info(ex.getMessage());
		}
		
		return auth;
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Auth logoutService(HttpServletRequest req, HttpServletResponse res)
	{
		Auth auth = new Auth();
		
		//remove session
		Cookie cookie = new Cookie("session", "");
		res.addCookie(cookie);
		
		//response
		auth.setStatus(Status.STATUS_OK);
		return auth;
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
