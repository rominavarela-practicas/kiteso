package mx.kiteso.KIteso.model.serial.out;

import java.util.List;

public class Map extends Status{
	public List<Path> paths;
	
	//getters and setters
	public List<Path> getPaths(){
		return this.paths;
	}
	
	public void setPaths(List<Path> paths){
		this.paths= paths;
	}
}
