package mx.kiteso.KIteso.model.serial.in;

public class Node {
	int index;
	double[] coords;

	public Node() {
	}

	//getters and setters
	public int getIndex(){
		return this.index;
	}
	public double[] getCoords(){
		return this.coords;
	}
	
	public void setIndex(int i){
		this.index= i;
	}
	public void setCoords(double[] coords){
		this.coords= coords;
	}
}
