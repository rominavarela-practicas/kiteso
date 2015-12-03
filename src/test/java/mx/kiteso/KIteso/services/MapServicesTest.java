package mx.kiteso.KIteso.services;

import static org.junit.Assert.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import mx.kiteso.KIteso.model.serial.out.Map;

public class MapServicesTest {
	MapServices services;
	
	@Before
	public void setup() throws Exception{
		Logger log= Mockito.mock(Logger.class);
		MapServices.log= log;
		
		services= new MapServices();
		services.init();
	}
	
	@After
	public void destroy() throws Exception{
		services.destroy();
	}
	
	@Test
	public void connectionTest() throws Exception{
		System.out.println("Map services loaded successfully");
	}
	
	@Test
	public void getMapTest(){
		String sessionCookie = "";
		HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
		HttpServletResponse res = Mockito.mock(HttpServletResponse.class);
		
		Map map = services.getMap(sessionCookie, req, res);
		
		assertTrue(map !=null);
	}
}
