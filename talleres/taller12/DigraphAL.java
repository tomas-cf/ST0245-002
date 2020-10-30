package taller12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import taller12.Graph;
import taller12.Pair;

/**
 * Implementacion de un grafo dirigido usando listas de adyacencia
 *
 * @author Mauricio Toro, Mateo Agudelo, <su nombre>
 */
public class DigraphAL extends Graph {
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
        
        public static boolean hayCaminoDFS(DigraphAL g, int o, int d) {
            boolean[] v = new boolean[g.size()];
        
            return hayCaminoDFSAux(g, o, d, v);
        }
        
        private static boolean hayCaminoDFSAux(DigraphAL g, int o, int d, boolean[] v) {
            v[o] = true;
            if (o == d) return true;
            for(Integer s : g.getSuccessors(o))
                if (!v[s])
                    if (hayCaminoDFSAux(g, s, d, v))
                        return true;
            return false;
        }
    
        public static boolean hayCaminoBFS(DigraphAL g, int o, int d) {
            Queue<Integer> nextToVisit = new LinkedList<Integer>();
            boolean[] v = new boolean[g.size()];
            nextToVisit.add(o);
            v[o]= true;
            while (!nextToVisit.isEmpty()) {            
                int aux = nextToVisit.remove();
                if (aux == d)
                    return true;
                v[aux]=true;
                for (Integer child : g.getSuccessors(aux)) 
                    if (!v[child])
                        nextToVisit.add(child);
            }
            return false;
        }
}
