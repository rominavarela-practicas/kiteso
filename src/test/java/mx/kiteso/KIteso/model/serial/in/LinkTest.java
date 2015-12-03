package mx.kiteso.KIteso.model.serial.in;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import mx.kiteso.KIteso.model.serial.in.Link;

public class LinkTest {

	Link link;
	
	@Before
	public void setUp(){
		link = new Link();
	}
	
	@Test
	public void testLink() {
		int[] array0 = {0,0};
		int[] array1 = {0,0};
		link.setLink(array0);
		assertEquals(link.getLink(), array1);
	}
	
	@Test
	public void testWeigh() {
		link.setWeight(10);
		assertEquals(link.getWeight(), 10, 0);
	}
	
}
