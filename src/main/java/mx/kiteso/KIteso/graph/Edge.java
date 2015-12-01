package mx.kiteso.KIteso.graph;

import mx.kiteso.KIteso.model.serial.in.Node;

/**
 * Created by Arreola on 11/25/2015.
 */
public class Edge {

    private Node source;
    private Node target;
    private double weight;
    
    public Edge(Node source, Node target, double weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
    }
    
    //getters and setters
    public Node getSource() {
    	return this.source;
    }
    public Node getTarget() {
    	return this.target;
    }
    public double getWeight() {
    	return this.weight;
    }
    
    public void setSource(Node n) {
    	this.source= n;
    }
    public void setTarget(Node n) {
    	this.target= n;
    }
    public void setWeight(double d) {
    	this.weight= d;
    }
}