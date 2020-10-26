package taller11;
import java.util.ArrayList;
import taller11.Digraph;

/**
 * Implementacion de un grafo dirigido usando matrices de adyacencia
 *
 * @author Mauricio Toro, Mateo Agudelo, <su nombre>
 */
public class DigraphAM extends Digraph {
	//static
        int[][] matriz ;

	/**
	* Constructor para el grafo dirigido
	* @param vertices el numero de vertices que tendra el grafo dirigido
	*
	*/
	public DigraphAM(int size) {
		super(size);
                matriz= new int[size][size];
	}

	/**
	* Metodo para añadir un arco nuevo, donde se representa cada nodo con un entero
	* y se le asigna un peso a la longitud entre un nodo fuente y uno destino	
	* @param source desde donde se hara el arco
	* @param destination hacia donde va el arco
	* @param weight el peso de la longitud entre source y destination
	*/
	public void addArc(int source, int destination, int weight) {
		matriz[source][destination]= weight;
                //En caso de que se pueda de ir del destino al origen siempre uwu
                //matriz[destination][source]= weight;
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
            for (int i = 0; i < matriz.length; i++) {
                if (matriz[vertex][i]!=0) {
                    vecis.add(i);
                }
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
		return matriz[source][destination];
	}
        
        //prueba manual "Recordar que se debe hacer static arregloDeListas"
        /*public static void main(String[] args){
            DigraphAM grafito = new DigraphAM(8);
            grafito.addArc(0, 1, 6);
            grafito.addArc(1, 2, 6);
            grafito.addArc(1, 6, 7);
            grafito.addArc(2, 4, 3);
            grafito.addArc(6, 5, 6);
            grafito.addArc(5, 7, 1);
            grafito.addArc(7, 3, 9);
            
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    System.out.print("["+matriz[i][j]+"] ");
                }
                System.out.println("");
            }
        }*/

}