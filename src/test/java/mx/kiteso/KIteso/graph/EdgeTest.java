package mx.kiteso.KIteso.graph;

import static org.junit.Assert.*;
import mx.kiteso.KIteso.model.serial.in.Node;

import org.junit.Before;
import org.junit.Test;

public class EdgeTest {
	
	Edge edge;
	Node nodeSource = new Node();
	Node nodeTarget = new Node();
	@Before
	public void setUp(){
		edge = new Edge(nodeSource,nodeTarget,1);
	}
	
	@Test
	public void getTest(){
		edge.setSource(nodeSource);
		edge.setTarget(nodeTarget);
		edge.setWeight(2);
		
		assertEquals(edge.getSource(),nodeSource);
		assertEquals(edge.getTarget(),nodeTarget);
		assertEquals(edge.getWeight(),2.0f,0);
		
	}

}
