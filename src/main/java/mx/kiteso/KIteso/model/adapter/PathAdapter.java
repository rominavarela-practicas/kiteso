package mx.kiteso.KIteso.model.adapter;

import mx.kiteso.KIteso.graph.Edge;
import mx.kiteso.KIteso.graph.Vertex;
import mx.kiteso.KIteso.model.serial.out.Path;

public class PathAdapter extends Path{
	public PathAdapter(Edge e){
		this.setSource(e.getSource().getCoords());
		this.setTarget(e.getTarget().getCoords());
	}
	
	public PathAdapter(Vertex source, Vertex target){
		this.setSource(source.getNode().getCoords());
		this.setTarget(target.getNode().getCoords());
	}
}
