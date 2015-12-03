package mx.kiteso.KIteso.controller;

import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import mx.kiteso.KIteso.model.serial.out.Session;

public class SessionControllerTest {
	SessionController sessionController;
	
	
	
	
	
	@Before
	public void setUp(){
		sessionController = new SessionController();
	}
	
	@Test
	public void writeSessionTest() {
		Session session = new Session();
		session.setEmail("taco");
		HttpServletResponse res = Mockito.mock(HttpServletResponse.class);
		sessionController.writeSession(session, res );
		
		String sessionCookie = " ";
		sessionController.readSession(sessionCookie );
	}

}
