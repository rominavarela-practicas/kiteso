package mx.kiteso.KIteso.model.serial.out;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import mx.kiteso.KIteso.model.serial.in.Location;

public class MapTest {
	Map map;
	
	@Before
	public void setUp(){
		map = new Map ();
	}
	
	@Test
	public void allTest(){
		List<Location> locations = new ArrayList();
		List<Path> path = new ArrayList();
		
		map.setEmail("email");
		assertEquals(map.getEmail(), "email");
		
		map.setLocations(locations);
		assertEquals(map.getLocations(), locations);
		
		map.setMsg("msj");
		assertEquals(map.getMsg(),"msj");
		
		map.setPaths(path);
		assertEquals(map.getPaths(), path);
		
		map.setRedir("redir");
		assertEquals(map.getRedir(), "redir");
		
		map.setStatus(1);
		assertEquals(map.getStatus(), 1);
	}
	
	
	

}
