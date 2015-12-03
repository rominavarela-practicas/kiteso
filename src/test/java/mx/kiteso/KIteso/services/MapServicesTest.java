package mx.kiteso.KIteso.services;

import static org.junit.Assert.*;

import java.sql.Connection;

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
		Connection connection= Mockito.mock(Connection.class);
		services.connection= connection;
		
	}
	
	@Test
	public void getMapTest(){
		String sessionCookie = "";
		HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
		HttpServletResponse res = Mockito.mock(HttpServletResponse.class);
		
		Map map = services.getMap(sessionCookie, req, res);
		
		assertTrue(map !=null);
	}
	
	@Test
	public void shortestRouteTest() {
		int sourceIndex = 0;
		int targetIndex = 1;
		String sessionCookie ="";
		HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
		HttpServletResponse res = Mockito.mock(HttpServletResponse.class);
		Map map = services.shortestRoute(sourceIndex, targetIndex, sessionCookie, req, res);
		
		assertTrue(map !=null);
	}
	
	
}
