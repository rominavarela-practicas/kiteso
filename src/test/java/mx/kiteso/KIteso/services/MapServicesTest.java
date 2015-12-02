package mx.kiteso.KIteso.services;

import org.apache.log4j.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.mockito.Mockito;

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
}
