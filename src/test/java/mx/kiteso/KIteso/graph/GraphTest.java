package mx.kiteso.KIteso.graph;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import mx.kiteso.KIteso.model.Node;
import mx.kiteso.KIteso.model.adapter.Vertex;

public class GraphTest {
	
	@Test
	public void TestGetInstance() throws InterruptedException {
		ArrayList<TestGetInstanceRunnable> runnables= new ArrayList<TestGetInstanceRunnable>();
		ArrayList<Thread> threads= new ArrayList<Thread>();
		
		for(int i=0; i<5; i++) 
		{
			TestGetInstanceRunnable runnable = new TestGetInstanceRunnable();
			runnables.add(runnable);
			threads.add( new Thread(runnable));
		}
		
		for(Thread t: threads)
			t.run();
		
		for(Thread t: threads)
			t.join();
		
		for(TestGetInstanceRunnable r: runnables)
			Assert.assertTrue(r.graph!=null);
	}
	class TestGetInstanceRunnable implements Runnable{
		public Graph graph;
		
		public void run() {
	        try
	        {
				this.graph= Graph.getInstance();
			} 
	        catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void TestGetShortestPath() throws Exception {
		Graph graph= Graph.getInstance();
		Vertex source = graph.vertices.get(0);
		Vertex target = graph.vertices.get(10);
		
		List<Node> path= graph.getShortestPath(source, target);
		
		//
		ArrayList<TestGetShortestPathRunnable> runnables= new ArrayList<TestGetShortestPathRunnable>();
		ArrayList<Thread> threads= new ArrayList<Thread>();
		
		for(int i=0; i<5; i++) 
		{
			TestGetShortestPathRunnable runnable = new TestGetShortestPathRunnable();
			runnables.add(runnable);
			threads.add( new Thread(runnable));
		}
		
		for(Thread t: threads)
			t.run();
		
		for(Thread t: threads)
			t.join();

		//assert same path
		for(TestGetShortestPathRunnable r: runnables)
		{
			Assert.assertEquals(path.size(), r.path.size());
			for(int i=0; i<path.size(); i++)
				Assert.assertEquals(path.get(i), r.path.get(i));
		}
	}
	class TestGetShortestPathRunnable implements Runnable{
		public Graph graph;
		public Vertex source;
		public Vertex target;
		public List<Node> path;
		
		public void run() {
	        try
	        {
				this.graph= Graph.getInstance();
				this.source= this.graph.vertices.get(0);
				this.target= this.graph.vertices.get(10);
				this.path= this.graph.getShortestPath(source, target);
			} 
	        catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
}
