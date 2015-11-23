package mx.kiteso.KIteso.model;

public class Node {
	int id;
	double[] coords;
	
	//getters and setters
	public int getId(){
		return this.id;
	}
	public double[] getCoords(){
		return this.coords;
	}
	
	public void setId(int id){
		this.id= id;
	}
	public void setCoords(double[] coords){
		this.coords= coords;
	}
}
