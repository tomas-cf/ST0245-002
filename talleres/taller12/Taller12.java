/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller12;

/**
 *
 * @author NN
 */
public class Taller12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*//En el caso de ser con Matriz de adyacencia se usa este
        DigraphAM graph = new DigraphAM(8);
        //*/
        //En el caso de ser con Lista de adyacencia se usa este
        DigraphAL graph = new DigraphAL(8);
        //*/
        graph.addArc(0, 2, 1);
        graph.addArc(2, 0, 1);
        graph.addArc(2, 6, 1);
        graph.addArc(6, 2, 1);
        graph.addArc(6, 4, 1);
        graph.addArc(4, 7, 1);
        graph.addArc(1, 5, 1);
        graph.addArc(5, 7, 1);
        graph.addArc(5, 3, 1);
        graph.addArc(3, 5, 1);
        graph.addArc(3, 7, 1);
        
        
        /* //En el caso de buscar con Matriz de adyacencia se usan estos
            System.out.println(DigraphAM.hayCaminoDFS(graph, 1, 4));
            //System.out.println(DigraphAM.hayCaminoBFS(graph, 0, 1));
        //*/
        // En el caso de buscar con Lista de adyacencia se usan estos
            System.out.println(DigraphAL.hayCaminoDFS(graph, 1, 4));
            System.out.println(DigraphAL.hayCaminoBFS(graph, 0, 7));
        //*/
    }
    
}
