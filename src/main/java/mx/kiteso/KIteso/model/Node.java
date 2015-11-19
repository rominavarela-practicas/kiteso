package mx.kiteso.KIteso.model;

public class Node {
	int id;
	double latitude;
	double longitude;
	
	//getters and setters
	public int getId(){
		return this.id;
	}
	public double getLatitude(){
		return this.latitude;
	}
	public double getLongitude(){
		return this.longitude;
	}
	
	public void setId(int id){
		this.id= id;
	}
	public void setLatitude(double latitude){
		this.latitude= latitude;
	}
	public void setLongitude(double longitude){
		this.longitude= longitude;
	}
}
