package mx.kiteso.KIteso.model.serial.out;

import java.util.List;

public class Route extends Status{
	public List<Integer> route;
	
	//getters and setters
	public List<Integer> getRoute(){
		return this.route;
	}
	
	public void setRoute(List<Integer> r){
		this.route= r;
	}
}
