package mx.kiteso.KIteso.algorithm;

import java.util.List;

import mx.kiteso.KIteso.model.serial.in.Node;

public interface Dijkstra {
	void init(int sourceIndex) throws Exception;
	public List<Node> getShortestRoute(int targetIndex) throws Exception;
}
