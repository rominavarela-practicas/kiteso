package mx.kiteso.KIteso.graph;

import java.io.File;
import java.util.ArrayList;

import mx.kiteso.KIteso.model.Link;
import mx.kiteso.KIteso.model.Node;

public class Graph {
	/**
	 * Instance data
	 */
	public ArrayList<Link> itesoGraph= null;
	
	/**
	 * Singleton instance
	 */
	private static Graph instance;
	public static synchronized Graph getInstance(){
		if(Graph.instance==null)
			Graph.instance= new Graph();
		return Graph.instance;
	}
	
	/**
	 * Constructor loads itesoGraph from JSON File
	 */
	private Graph() {
		File jsonFile = new File("kiteso-graph.json");
		if(!jsonFile.exists())
			throw new java.lang.ExceptionInInitializerError("File not found");
		
		itesoGraph= new ArrayList<Link>();
		//TODO
		//read json to fill itesoGraph
		Node source= new Node();
		source.setLatitude(1);
		source.setLongitude(1);
		Node target= new Node();
		target.setLatitude(2);
		target.setLongitude(2);
		Link link = new Link();
		link.setSource(source);
		link.setTarget(target);
		link.setWeight(calculateWeight(source, target));
		itesoGraph.add(link);
		//... this has to be removed once json can be readen
		
	}
	
	private double calculateWeight(Node a, Node b){
		//TODO
		return 1;
	}
	
	/**
	 * @return a list of links to walk through from source to target
	 */
	public ArrayList<Link> getShortestPath(Node source, Node target){
		ArrayList<Link> shortestPath = new ArrayList<Link>();
		//TODO
		return shortestPath;
	}
}
