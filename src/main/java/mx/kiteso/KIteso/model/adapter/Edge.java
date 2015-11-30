package mx.kiteso.KIteso.model.adapter;

import mx.kiteso.KIteso.model.Node;

/**
 * Created by Arreola on 11/25/2015.
 */
public class Edge {

    private Node origen;
    private Node destino;
    private double ponderacion;
    
    public Edge(Node origen, Node destino, double ponderacion) {
        this.origen = origen;
        this.destino = destino;
        this.ponderacion = ponderacion;
    }

    public Node getOrigen() { return this.origen;}
    public Node getDestino() { return this.destino;}
    public double getPonderacion() { return this.ponderacion;}
}