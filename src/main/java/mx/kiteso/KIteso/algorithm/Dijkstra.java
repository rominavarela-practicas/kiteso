package mx.kiteso.KIteso.algorithm;

import java.util.List;

public interface Dijkstra {
	void init(int sourceIndex) throws Exception;
	public List<Integer> getShortestRoute(int targetIndex) throws Exception;
}
