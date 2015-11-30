package mx.kiteso.KIteso.algorithm.impl;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import mx.kiteso.KIteso.algorithm.Dijkstra;
import mx.kiteso.KIteso.model.Node;
import mx.kiteso.KIteso.model.adapter.Edge;
import mx.kiteso.KIteso.model.adapter.Vertex;

public class DijkstraA implements Dijkstra{
	
	static List<Edge> edges;
	ArrayList<Double> distanceMap;
	ArrayList<List<Integer>> pathMap;
	
	private DijkstraA(Vertex source, List<Vertex> vertices, List<Edge> edges)
	{
		init(source, vertices, edges);
	}
	
	@Override
	public synchronized void init(Vertex source, List<Vertex> vertices, List<Edge> edges) {
		if(DijkstraA.edges==null)
			DijkstraA.edges= edges;
		
		distanceMap= new ArrayList<Double>();
		pathMap= new ArrayList<List<Integer>>();
		for(int i=0; i<edges.size();i++)
		{
			distanceMap.add(Double.MAX_VALUE);
			pathMap.add(new ArrayList<Integer>());
		}
		distanceMap.set(0, 0.0);
		
		//iterate
		ArrayDeque<Integer> stack= new ArrayDeque<Integer>();
		stack.push(source.getNode().getIndex());
		
		while(!stack.isEmpty())
		{
			Vertex curr= vertices.get(stack.pop());
			double currDistance= distanceMap.get(curr.getNode().getIndex());
			List<Integer> currPath= pathMap.get(curr.getNode().getIndex());
			
			for(Edge nei: getNeighborns(curr))
			{
				double neiDistance= currDistance + nei.getPonderacion();
				int neiIndex= nei.getDestino().getIndex();
				
				//if better path, update
				if(neiDistance < distanceMap.get(neiIndex))
				{
					distanceMap.set(neiIndex, neiDistance);
					
					List<Integer> path= pathMap.get(neiIndex);
					path.clear();
					path.addAll(currPath);
					path.add(neiIndex);
					
					stack.push(nei.getDestino().getIndex());
				}
			}
		}
	}
	
	@Override
	public List<Node> getShortestPath(Vertex target, List<Vertex> vertices) {
		int targetIndex= target.getNode().getIndex();
		List<Node> path= new ArrayList<Node>();
		for(int i: pathMap.get(targetIndex))
			path.add(vertices.get(i).getNode());
		
		return path;
	}
	
	//sync methods
	public List<Edge> getNeighborns(Vertex v){
		List<Edge> neiList= v.getNeighborns();
		if(neiList==null)
		{
			neiList= new ArrayList<Edge>();
			for(Edge e: DijkstraA.edges)
			{
				if(e.getOrigen().getId()==v.getNode().getId())
					neiList.add(e);
			}
			
			v.setNeighborns(neiList);
		}
		return neiList;
	}
	
	//singleton
	static private ArrayList<Dijkstra> instanceMap;
	public static synchronized Dijkstra getInstance(Vertex source, List<Vertex> vertices, List<Edge> edges){
		if(instanceMap==null)
		{
			instanceMap= new ArrayList<Dijkstra>();
			for(int i=0;i<vertices.size();i++)
				instanceMap.add(null);
		}
		
		int sourceIndex= source.getNode().getIndex();
		Dijkstra d= instanceMap.get(sourceIndex);
		if(d==null)
		{
			d= new DijkstraA(source, vertices, edges);
			instanceMap.set(sourceIndex, d);
		}
		
		return d;
	}
}
