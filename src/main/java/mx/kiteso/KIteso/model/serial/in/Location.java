package mx.kiteso.KIteso.model.serial.in;

public class Location {
	String name;
	int nodeIndex;
	
	//getters and setters
	public String getName(){
		return this.name;
	}
	public int getNodeIndex(){
		return this.nodeIndex;
	}
	
	public void setName(String s){
		this.name= s;
	}
	public void setNodeIndex(int i){
		this.nodeIndex= i;
	}
}
