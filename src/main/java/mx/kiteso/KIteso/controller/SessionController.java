package mx.kiteso.KIteso.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import mx.kiteso.KIteso.model.Session;

import com.google.gson.Gson;

public class SessionController {
	public static void clearSession(HttpServletResponse res) {
		res.addCookie( new Cookie("session", "") );
	}
	
	public static void writeSession(Session session, HttpServletResponse res) {
		Gson gson = new Gson();
		Session cipheredSession = session.clone();
		//TODO cipher content
		//https://github.com/pcompton/cookie-sample/blob/master/src/main/java/com/issgovernance/cookiesample/domain/CookieEncryption.java
		Cookie cookie = new Cookie("session", gson.toJson(cipheredSession));
		res.addCookie(cookie);
	}
	
	public static Session readSession(String sessionCookie){
		Gson gson = new Gson();
		Session cipheredSession = gson.fromJson(sessionCookie, Session.class);
		Session session = cipheredSession.clone();
		//TODO decipher content
		return session;
	}
}
