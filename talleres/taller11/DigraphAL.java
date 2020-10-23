package taller11;

import java.util.ArrayList;
import java.util.LinkedList;
import taller11.Digraph;
import taller11.Pair;

/**
 * Implementacion de un grafo dirigido usando listas de adyacencia
 *
 * @author Mauricio Toro, Mateo Agudelo, <su nombre>
 */
public class DigraphAL extends Digraph {
	//static
         ArrayList<LinkedList< Pair<Integer, Integer> >> arregloDeListas;

	/**
	* Constructor para el grafo dirigido
	* @param vertices el numero de vertices que tendra el grafo dirigido
	*
	*/
	public DigraphAL(int size) {
            super(size);
            arregloDeListas= new ArrayList<LinkedList< Pair<Integer, Integer> >>();
            for (int i = 0; i < size; i++) {
                arregloDeListas.add(new LinkedList< Pair<Integer, Integer>>());
            }
	}

	/**
	* Metodo para añadir un arco nuevo, donde se representa cada nodo con un entero
	* y se le asigna un peso a la longitud entre un nodo fuente y uno destino	
	* @param source desde donde se hara el arco
	* @param destination hacia donde va el arco
	* @param weight el peso de la longitud entre source y destination
	*/
	public void addArc(int source, int destination, int weight) {
		arregloDeListas.get(source).add(new Pair(destination,weight));
                
                //En caso de que siempre se pueda de ir del destino al origen
                //arregloDeListas.get(destination).add(new Pair(source,weight));
	}

	/**
	* Metodo para obtener una lista de hijos desde un nodo, es decir todos los nodos
	* asociados al nodo pasado como argumento
	* @param vertex nodo al cual se le busca los asociados o hijos
	* @return todos los asociados o hijos del nodo vertex, listados en una ArrayList
	* Para más información de las clases:
 	* @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html"> Ver documentacion ArrayList </a>
	*/
	public ArrayList<Integer> getSuccessors(int vertex) {
            ArrayList<Integer> vecis = new ArrayList<Integer>();
            for(Pair p : arregloDeListas.get(vertex)){
                vecis.add((int)p.first);
            }
            
            return vecis;
	}

	/**
	* Metodo para obtener el peso o longitud entre dos nodos
	* 
	* @param source desde donde inicia el arco
	* @param destination  donde termina el arco
	* @return un entero con dicho peso
	*/	
	public int getWeight(int source, int destination) {
		return arregloDeListas.get(source).get(destination).second;
	}
        
        
        //prueba manual "Recordar que se debe hacer static arregloDeListas"
        /*public static void main(String[] args){
            DigraphAL grafito = new DigraphAL(8);
            grafito.addArc(0, 3, 6);
            grafito.addArc(2, 4, 6);
            grafito.addArc(0, 2, 3);
            grafito.addArc(2, 5, 1);
            grafito.addArc(5, 7, 3);
            grafito.addArc(5, 6, 4);
            grafito.addArc(6, 7, 1);
            
            
            for (int i = 0; i < arregloDeListas.size() ; i++) {
                if (arregloDeListas.get(i).size()==0) {
                    System.out.print("null");
                }else{
                    for(Pair p : arregloDeListas.get(i)){
                    System.out.print("("+p.first+","+p.second+")" );
                }
                }
                System.out.println("");
            }
        }*/
}
