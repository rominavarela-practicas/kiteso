package mx.kiteso.KIteso.model.serial.out;

import java.util.List;

import mx.kiteso.KIteso.model.serial.in.Location;

public class Map extends Status{
	public List<Location> locations;
	public List<Path> paths;
	
	//getters and setters
	public List<Location> getLocations() {
		return this.locations;
	}
	public List<Path> getPaths(){
		return this.paths;
	}
	
	public void setLocations(List<Location> l) {
		this.locations= l;
	}
	public void setPaths(List<Path> paths){
		this.paths= paths;
	}
}
