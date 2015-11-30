package mx.kiteso.KIteso.model.adapter;

import java.util.List;

import mx.kiteso.KIteso.model.Node;

public class Vertex {
	Node node;
	List<Edge> neihborns;
	
	public Vertex(Node n){
		this.node= n;
	}
	
	//getters and setters
	public Node getNode(){
		return this.node;
	}
	public List<Edge> getNeighborns(){
		return this.neihborns;
	}
	
	public void setNode(Node n){
		this.node= n;
	}
	public void setNeighborns(List<Edge> nei){
		this.neihborns= nei;
	}
}
