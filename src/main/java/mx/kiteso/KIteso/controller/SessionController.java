package mx.kiteso.KIteso.controller;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.cryptonode.jncryptor.AES256JNCryptor;

import mx.kiteso.KIteso.model.Session;

import com.google.gson.Gson;

@SuppressWarnings("unused")
public class SessionController{
	
	private static final byte[] keyValue =
		      new byte[] {'O', 'p', 'e', 'n', 'S', 'a', 'y', 's', 'M', 'e', '1', '2', '3', '4', '5', '6'};
	
	private static final Base64 base64 = new Base64();
	
	public static void clearSession(HttpServletResponse res) {
		res.addCookie( new Cookie("session", "") );
	}
	
	public static void writeSession(Session session, HttpServletResponse res) {
		Gson gson = new Gson();
		String json = gson.toJson(session);
		String cipheredSession = "";
		
		try
		{
			Key key = new SecretKeySpec(SessionController.keyValue, "AES");
			Cipher c = Cipher.getInstance("AES");
		    c.init(Cipher.ENCRYPT_MODE, key);
		    byte[] ciphertext = c.doFinal(json.getBytes());
		    cipheredSession = new String(base64.encode(ciphertext));
		} 
		catch (Exception ex)
		{
			System.out.println(ex);
		}
		
		Cookie cookie = new Cookie("session", cipheredSession);
		res.addCookie(cookie);
	}
	
	public static Session readSession(String sessionCookie){
		Session session = new Session();
		
		if(!sessionCookie.isEmpty())
			try
			{
				Key key = new SecretKeySpec(SessionController.keyValue, "AES");
			    Cipher c = Cipher.getInstance("AES");
			    c.init(Cipher.DECRYPT_MODE, key);
			    
			    byte[] decodedValue = base64.decode(sessionCookie);
			    byte[] decValue = c.doFinal(decodedValue);
			    String decryptedValue = new String(decValue);
			    
			    Gson gson = new Gson();
			    session = gson.fromJson(decryptedValue, Session.class);
			}
			catch(Exception ex)
			{
				System.out.println(ex);
			}
		
		return session;
	}
}
