package mx.kiteso.KIteso.adapter;

import mx.kiteso.KIteso.algorithm.Dijkstra;
import mx.kiteso.KIteso.model.Link;
import mx.kiteso.KIteso.model.Node;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Arreola on 11/25/2015.
 */
public class DijkstraAdapter {
    private Dijkstra dijkstra;
    private ArrayList<Node> nodes;

    public DijkstraAdapter() {
        dijkstra = new Dijkstra();
    }

    //Metodo que convierte una lista de Links en una lista de Edges para facilitar el uso en el algoritmo de Dijkstra
    public void sendLinks(List<Link> links) {
        ArrayList<Edge> edges = new ArrayList<>();
        Node tempNodeOr;
        Node tempNodeDe;
        double tempWeight;
        Edge tempEdge;

        for(int i = 0; i < links.size() ; i++) {
            tempNodeOr = nodes.get(links.get(i).getLink()[0]);
            tempNodeDe = nodes.get(links.get(i).getLink()[1]);
            tempWeight = links.get(i).getWeight();
            tempEdge = new Edge(tempNodeOr, tempNodeDe, tempWeight);
            edges.add(tempEdge);
        }
        dijkstra.setEdges(edges);
    }

    public void setNodes(ArrayList<Node> nodes) {
        this.nodes = nodes;
    }

    //Checar
    public LinkedList<Node> getPath(int source, int target) {
        Node sourceNode = searchNode(source);
        Node targetNode = searchNode(target);
        dijkstra.execute(sourceNode);

        return dijkstra.getPath(targetNode);
    }

    public Node searchNode(int nodeId) {
        ArrayList<Edge> edges = dijkstra.getEdges();
        for(Edge target: edges) {
            if(target.getOrigen().getId() == nodeId)
                return target.getOrigen();
            if(target.getDestino().getId() == nodeId)
                return target.getDestino();
        }
        return null;
    }


}
