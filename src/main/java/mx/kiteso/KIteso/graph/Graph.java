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

import mx.kiteso.KIteso.model.Link;
import mx.kiteso.KIteso.model.Node;

public class Graph {
	List<Node> nodes;
	List<Link> links;
	
	Graph() throws FileNotFoundException {
		File jsonNodes = new File("public/data/nodes.json");
		this.nodes= this.readNodes(jsonNodes);
		
		File jsonLinks = new File("public/data/links.json");
		this.links= this.readLinks(jsonLinks);
	}
	
	public List<Node> readNodes(File jsonNodes) throws FileNotFoundException {
		FileReader fileReader = new FileReader(jsonNodes);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		Gson gson = new Gson();
		Type tipoListaNodos = new TypeToken<List<Node>>(){}.getType();
		List<Node> nodos = gson.fromJson(bufferedReader, tipoListaNodos);

		return nodos;
	}
	
	public List<Link> readLinks(File jsonLinks) throws FileNotFoundException {
		FileReader fileReader = new FileReader(jsonLinks);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		Gson gson = new Gson();
		Type tipoListaLinks = new TypeToken<List<Link>>(){}.getType();
		List<Link> links = gson.fromJson(bufferedReader, tipoListaLinks);

		return links;
	}
	
	public ArrayList<Link> getShortestPath(Node source, Node target){
		ArrayList<Link> shortestPath = new ArrayList<Link>();
		
		//TODO

		return shortestPath;
	}
	
	//getters and setters
	public List<Node> getNodes() {
		return this.nodes;
	}
	public List<Link> getLinks() {
		return this.links;
	}
	
	public void setNodes(List<Node> l) {
		this.nodes= l;
	}
	public void setLinks(List<Link> l) {
		this.links= l;
	}
	
	//Singleton
	private static Graph instance;
	public static synchronized Graph getInstance() throws FileNotFoundException{
		if(Graph.instance==null)
			Graph.instance= new Graph();
		return Graph.instance;
	}
}
