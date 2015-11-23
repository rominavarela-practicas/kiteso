package mx.kiteso.KIteso.model;

public class Link {
	int[] link;
	double weight;

	//getters and setters
	public int[] getLink(){
		return this.link;
	}
	public double getWeight(){
		return this.weight;
	}
	
	public void setLink(int[] link){
		this.link= link;
	}
	public void setWeight(double weight){
		this.weight= weight;
	}
}
