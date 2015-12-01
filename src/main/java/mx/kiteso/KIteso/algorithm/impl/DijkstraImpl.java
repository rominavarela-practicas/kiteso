package mx.kiteso.KIteso.algorithm.impl;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import mx.kiteso.KIteso.algorithm.Dijkstra;
import mx.kiteso.KIteso.graph.Edge;
import mx.kiteso.KIteso.graph.Graph;
import mx.kiteso.KIteso.graph.Vertex;

public class DijkstraImpl implements Dijkstra{
	
	ArrayList<Double> distanceMap;
	ArrayList<List<Integer>> routeMap;
	
	private DijkstraImpl(int sourceIndex) throws Exception
	{
		init(sourceIndex);
	}
	
	@Override
	public void init(int sourceIndex) throws Exception {
		Graph graph= Graph.getInstance();
		List<Vertex> vertices= graph.getVertices();
		
		//step 1: highest distances and empty paths
		this.distanceMap= new ArrayList<Double>();
		this.routeMap= new ArrayList<List<Integer>>();
		for(int i=0; i<graph.getEdges().size();i++)
		{
			this.distanceMap.add(Double.MAX_VALUE);
			this.routeMap.add(new ArrayList<Integer>());
		}
		
		//step 2: set origin distance=0 and iterate from it
		ArrayDeque<Integer> stack= new ArrayDeque<Integer>();
		this.distanceMap.set(sourceIndex, 0.0);
		stack.push(sourceIndex);
		
		while(!stack.isEmpty())
		{
			Vertex curr= vertices.get(stack.pop());
			double currDistance= distanceMap.get(curr.getNode().getIndex());
			List<Integer> currPath= routeMap.get(curr.getNode().getIndex());
			
			for(Edge nei: getNeighborns(curr))
			{
				double neiDistance= currDistance + nei.getWeight();
				int neiIndex= nei.getTarget().getIndex();
				
				//if better path, update
				if(neiDistance < distanceMap.get(neiIndex))
				{
					distanceMap.set(neiIndex, neiDistance);
					
					List<Integer> path= routeMap.get(neiIndex);
					path.clear();
					path.addAll(currPath);
					path.add(neiIndex);
					
					stack.push(nei.getTarget().getIndex());
				}
			}
		}
	}
	
	@Override
	public List<Integer> getShortestRoute(int targetIndex) {		
		return routeMap.get(targetIndex);
	}
	
	//sync methods
	public List<Edge> getNeighborns(Vertex v) throws Exception{
		Graph graph= Graph.getInstance();
		List<Edge> edges= graph.getEdges();
		
		List<Edge> neiList= v.getNeighborns();
		if(neiList==null)
		{
			neiList= new ArrayList<Edge>();
			for(Edge e: edges)
			{
				if(e.getSource().getIndex()==v.getNode().getIndex())
					neiList.add(e);
			}
			
			v.setNeighborns(neiList);
		}
		return neiList;
	}
	
	//singleton
	static private ArrayList<Dijkstra> instanceMap;
	public static synchronized Dijkstra getInstance(int sourceIndex) throws Exception{
		Graph graph= Graph.getInstance();
		
		if(instanceMap==null)
		{
			instanceMap= new ArrayList<Dijkstra>();
			for(int i=0;i<graph.getVertices().size();i++)
				instanceMap.add(null);
		}
		
		Dijkstra d= instanceMap.get(sourceIndex);
		if(d==null)
		{
			d= new DijkstraImpl(sourceIndex);
			instanceMap.set(sourceIndex, d);
		}
		
		return d;
	}
}
