package mx.kiteso.KIteso.algorithm;

import java.util.List;

import mx.kiteso.KIteso.model.serial.in.Node;

public interface Dijkstra {
	void init(int sourceIndex) throws Exception;
	public List<Integer> getShortestRoute(int targetIndex) throws Exception;
}
