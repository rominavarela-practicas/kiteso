package mx.kiteso.KIteso.model.serial.out;

public class Path {
	double[] source;
	double[] target;
	
	//getters and setters
	public double[] getSource(){
		return this.source;
	}
	public double[] getTarget(){
		return this.target;
	}
	
	public void setSource(double[] d){
		this.source= d;
	}
	public void setTarget(double[] d){
		this.target= d;
	}
}
