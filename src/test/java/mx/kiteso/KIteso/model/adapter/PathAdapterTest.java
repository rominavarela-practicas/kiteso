package mx.kiteso.KIteso.model.adapter;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import mx.kiteso.KIteso.graph.Edge;
import mx.kiteso.KIteso.graph.Vertex;
import mx.kiteso.KIteso.model.serial.in.Node;

public class PathAdapterTest {
	
	Edge edge;
	Node nodeSource = new Node();
	Node nodeTarget = new Node();
	Node node = new Node();
	
	Vertex vertex1;
	Vertex vertex2;
	
	
	PathAdapter pathadapter1;
	PathAdapter pathadapter2;
	
	@Before
	public void setUp(){
		edge = new Edge(nodeSource,nodeTarget,1);
		vertex1 = new Vertex(nodeSource);
		vertex2 = new Vertex(nodeTarget);

	}
	
	@Test
	public void PathAdapterTest(){
		pathadapter1 = new PathAdapter(edge);
		pathadapter2 = new PathAdapter(vertex1,vertex2);
		
	}
	

}
