package mx.kiteso.KIteso.algorithm;

import java.util.List;

import mx.kiteso.KIteso.model.Node;
import mx.kiteso.KIteso.model.adapter.Edge;
import mx.kiteso.KIteso.model.adapter.Vertex;

public interface Dijkstra {
	void init(Vertex source, List<Vertex> vertices, List<Edge> edges);
	public List<Node> getShortestPath(Vertex target, List<Vertex> vertices);
}
