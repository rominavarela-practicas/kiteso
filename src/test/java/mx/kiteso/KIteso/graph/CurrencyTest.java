package mx.kiteso.KIteso.graph;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import mx.kiteso.KIteso.algorithm.Dijkstra;
import mx.kiteso.KIteso.algorithm.impl.DijkstraImpl;
import mx.kiteso.KIteso.graph.Graph;
import mx.kiteso.KIteso.model.serial.in.Node;

public class CurrencyTest {
	
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
	public void shortestRoute() throws Exception {
		Dijkstra d= DijkstraImpl.getInstance(0);
		List<Node> path= d.getShortestRoute(10);
				
		//
		ArrayList<ShortestRouteRunnable> runnables= new ArrayList<ShortestRouteRunnable>();
		ArrayList<Thread> threads= new ArrayList<Thread>();
		
		for(int i=0; i<5; i++) 
		{
			ShortestRouteRunnable runnable = new ShortestRouteRunnable();
			runnables.add(runnable);
			threads.add( new Thread(runnable));
		}
		
		for(Thread t: threads)
			t.run();
		
		for(Thread t: threads)
			t.join();

		//assert same path
		for(ShortestRouteRunnable r: runnables)
		{
			Assert.assertEquals(path.size(), r.path.size());
			for(int i=0; i<path.size(); i++)
				Assert.assertEquals(path.get(i), r.path.get(i));
		}
	}
	class ShortestRouteRunnable implements Runnable{
		public List<Node> path;
		
		public void run() {
	        try
	        {
	        	Dijkstra d= DijkstraImpl.getInstance(0);
	    		this.path= d.getShortestRoute(10);
			} 
	        catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
