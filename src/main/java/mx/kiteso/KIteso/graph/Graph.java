package mx.kiteso.KIteso.graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import mx.kiteso.KIteso.model.serial.in.Link;
import mx.kiteso.KIteso.model.serial.in.Node;

public class Graph {
	List<Vertex> vertices;
	List<Edge> edges;
	
	Graph() throws FileNotFoundException {
		File jsonNodes = new File("public/data/nodes.json");
		this.vertices= this.readNodes(jsonNodes);
		
		File jsonLinks = new File("public/data/links.json");
		this.edges= this.readLinks(jsonLinks);
	}
	
	public List<Vertex> readNodes(File jsonNodes) throws FileNotFoundException {
		FileReader fileReader = new FileReader(jsonNodes);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		Gson gson = new Gson();
		Type tipoListaNodos = new TypeToken<List<Node>>(){}.getType();
		List<Node> nodos = gson.fromJson(bufferedReader, tipoListaNodos);
		
		List<Vertex> vertices= new ArrayList<Vertex>();
		int i=0;
		for(Node n: nodos)
		{
			n.setIndex(i);
			vertices.add(new Vertex(n));
			i++;
		}
		
		return vertices;
	}
	
	public List<Edge> readLinks(File jsonLinks) throws FileNotFoundException {
		FileReader fileReader = new FileReader(jsonLinks);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		Gson gson = new Gson();
		Type tipoListaLinks = new TypeToken<List<Link>>(){}.getType();
		List<Link> links = gson.fromJson(bufferedReader, tipoListaLinks);
		List<Edge> edges = new ArrayList<Edge>();
		
		for(Link l: links)
		{
			int idSource = l.getLink()[0];
			int idTarget = l.getLink()[1];
			
			Node source= this.getVertices().get(idSource-1).getNode();
			Node target= this.getVertices().get(idTarget-1).getNode();
			
			double weight = calculateWeight(source,target);
			
			edges.add(new Edge(source, target, weight));
			edges.add(new Edge(target, source, weight));
		}
		
		return edges;
	}
	
	public double calculateWeight(Node source, Node target) {		
		double a = Math.sqrt(
				(source.getCoords()[0]*source.getCoords()[0])+
				(target.getCoords()[0]*target.getCoords()[0]));
		double b = Math.sqrt(
				(source.getCoords()[1]*source.getCoords()[1])+
				(target.getCoords()[1]*target.getCoords()[1]));
		
		return Math.sqrt(a*a + b*b);
	}
	
	//getters and setters
	public List<Vertex> getVertices() {
		return this.vertices;
	}
	public List<Edge> getEdges() {
		return this.edges;
	}
	
	public void setVertices(List<Vertex> l) {
		this.vertices= l;
	}
	public void setEdges(List<Edge> l) {
		this.edges= l;
	}
	
	//Singleton
	private static Graph instance;
	public static synchronized Graph getInstance() throws FileNotFoundException{
		if(Graph.instance==null)
			Graph.instance= new Graph();
		return Graph.instance;
	}
}
