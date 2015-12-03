package mx.kiteso.KIteso.model.serial.in;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import mx.kiteso.KIteso.model.serial.in.Node;

public class NodeTest {

	Node node;
	
	@Before
	public void setUp() {
		node = new Node();
	}
	
	@Test
	public void coordsTest() {
		double[] array0 = {0,0};
		double[] array1 = {0,0};
		node.setCoords(array0);
		assertEquals(node.getCoords(), array1);
	}
	
	@Test
	public void indexTest() {
		node.setIndex(1);
		assertEquals(node.getIndex(), 1,0);
	}
	
}
