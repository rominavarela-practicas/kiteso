package mx.kiteso.KIteso.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class AuthServicesTest {

	AuthServices authServices;
	
	@Before
	public void setUp() {
		authServices = new AuthServices();
	}
	
	@Test
	public void authServicesTest() {
		String assertion= "";
		String sessionCookie= "";
		HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
		HttpServletResponse res = Mockito.mock(HttpServletResponse.class);
		authServices.authService(assertion, sessionCookie, req, res );
		
		authServices.logoutService(req, res);
	}
	
}
