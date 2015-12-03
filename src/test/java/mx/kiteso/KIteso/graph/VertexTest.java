package mx.kiteso.KIteso.graph;

import static org.junit.Assert.*;

import java.util.List;

import mx.kiteso.KIteso.model.serial.in.Node;

import org.junit.Before;
import org.junit.Test;

public class VertexTest {
	Vertex vertex;
	Node node = new Node();
	List<Edge> neihborns;

	
	@Before
	public void setUp(){
		vertex = new Vertex(node);
	}
	
	
	@Test
	public void getNodeTest(){
		vertex.setNode(node);
		assertEquals(vertex.getNode(),node);
	}
	
	@Test
	public void getNeighbordsTest(){
		vertex.setNeighborns(neihborns);
		assertEquals(vertex.getNeighborns(),neihborns);
	}
}
