package mx.kiteso.KIteso.model;

public class Link {
	Node source;
	Node target;
	double weight;
	
	//getters and setters
	public Node getSource(){
		return this.source;
	}
	public Node getTarget(){
		return this.target;
	}
	public double getWeight(){
		return this.weight;
	}
	
	public void setSource(Node source){
		this.source= source;
	}
	public void setTarget(Node target){
		this.target= target;
	}
	public void setWeight(double weight){
		this.weight= weight;
	}
}
