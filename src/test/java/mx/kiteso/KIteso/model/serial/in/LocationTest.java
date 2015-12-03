package mx.kiteso.KIteso.model.serial.in;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import mx.kiteso.KIteso.model.serial.in.Location;

public class LocationTest {
	
	Location location;
	
	@Before
	public void setUp(){
		location = new Location();
	}
	
	@Test
	public void nameTest(){
		location.setName("Taco");
		assertEquals(location.getName(),"Taco");
	}
	
	@Test
	public void nodeTest(){
		location.setNodeIndex(8);
		assertEquals(location.getNodeIndex(),8,0);
	}
	
	
	
	
	
}
