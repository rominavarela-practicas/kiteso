package mx.kiteso.KIteso.algorithm.adapter;

import mx.kiteso.KIteso.model.adapter.Edge;
import mx.kiteso.KIteso.model.Node;

import java.util.*;

/**
 * Created by Arreola on 11/23/2015.
 */
public class Dijkstra {

    private ArrayList<Edge> edges;
    private Set<Node> settledNodes;
    private Set<Node> unSettledNodes;
    private Map<Node, Node> predecessors;
    private Map<Node, Double> distance;

    public void setEdges(ArrayList<Edge> edges) {
        this.edges = edges;
    }

    public ArrayList<Edge> getEdges() {
        return this.edges;
    }

    //Busca todos los caminos hacia el nodo source
    public void execute(Node source) {
        settledNodes = new HashSet<Node>();
        unSettledNodes = new HashSet<Node>();
        predecessors = new HashMap<Node, Node>();
        distance = new HashMap<Node, Double>();

        distance.put(source, 0.0);
        unSettledNodes.add(source);

        while(unSettledNodes.size() > 0) {
            Node node = getMinimum(unSettledNodes);
            settledNodes.add(node);
            unSettledNodes.remove(node);
            findMinimalDistances(node);
        }
    }

    private void findMinimalDistances(Node node) {
        List<Node> adjacentNodes = getNeighbors(node);
        for (Node target : adjacentNodes) {
            if (getShortestDistance(target) > getShortestDistance(node)
                    + getDistance(node, target)) {
                distance.put(target, getShortestDistance(node)
                        + getDistance(node, target));
                predecessors.put(target, node);
                unSettledNodes.add(target);
            }
        }
    }

    private List<Node> getNeighbors(Node node) {
        List<Node> neighbors = new ArrayList<Node>();
        for (Edge edge : edges) {
            if (edge.getOrigen().equals(node)
                    && !isSettled(edge.getDestino())) {
                neighbors.add(edge.getDestino());
            }
        }
        return neighbors;
    }

    private boolean isSettled(Node node) {
        return settledNodes.contains(node);
    }

    private Double getDistance(Node node, Node target) {
        for (Edge edge : edges) {
            if (edge.getOrigen().equals(node)
                    && edge.getDestino().equals(target)) {
                return edge.getPonderacion();
            }
        }
        throw new RuntimeException("Should not happen");
    }

    private Node getMinimum(Set<Node> vertexes) {
        Node minimum = null;
        for (Node vertex : vertexes) {
            if (minimum == null) {
                minimum = vertex;
            } else {
                if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
                    minimum = vertex;
                }
            }
        }
        return minimum;
    }

    private double getShortestDistance(Node destination) {
        Double d = distance.get(destination);
        if (d == null) {
            return Integer.MAX_VALUE;
        } else {
            return d;
        }
    }

    //Busca el camino hacia el nodo target
    public LinkedList<Node> getPath(Node target) {
        LinkedList<Node> path = new LinkedList<Node>();
        Node step = target;
        // Checar si el camino existe
        if (predecessors.get(step) == null) {

            System.out.println("Estoy entrando aqui...");

            return null;
        }
        path.add(step);
        while (predecessors.get(step) != null) {
            step = predecessors.get(step);
            path.add(step);
        }
        // Poner el camino en el correcto orden
        Collections.reverse(path);
        return path;
    }

}
