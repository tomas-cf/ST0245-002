/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto1;

/**
 *
 * @author NN
 */

import java.util.ArrayList;
/**
 * Este clase abstracta representa un grafo.
 * Nota --> el código fue tomado del codigo_estudiante dado por el profesor.
 * @author Mauricio Toro
 * @version 1
 */
public abstract class Graph{
    protected int size;
    
    /**
     * Este constructor inicializa un grafo de acuerdo al número de sus vértices.
     */
    public Graph(int vertices) {
        size = vertices;
    }

    /**
     * Este método agrega un arco entre dos vértices.
     */
    public abstract void addArc(int source, int destination, int weight);

    /**
     * Este método retorna en un ArrayList todos los vertices que tengan una conexion con uno.
     */
    public abstract ArrayList<Integer> getSuccessors(int vertice);

    /**
     * Este método retorna el valor o peso de un arco entre dos vértices.
     */
    public abstract int getWeight(int source, int destination);

    /**
     * Este método retorna el tamaño del grafo.
     */
    public int size(){
        return size;
    }
}
