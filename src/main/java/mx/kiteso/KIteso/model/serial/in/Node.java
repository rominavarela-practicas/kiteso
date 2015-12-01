package mx.kiteso.KIteso.model.serial.in;

public class Node {
	int id;
	int index;
	double[] coords;

	public Node(int id) {
		this.id = id;
	}

	//getters and setters
	public int getId(){
		return this.id;
	}
	public int getIndex(){
		return this.index;
	}
	public double[] getCoords(){
		return this.coords;
	}
	
	public void setId(int id){
		this.id= id;
	}
	public void setIndex(int index){
		this.index= index;
	}
	public void setCoords(double[] coords){
		this.coords= coords;
	}
}
