
package taller12;

/**
 *
 * @author NN
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DigraphAM extends Graph
{
    //Grafo con matriz
    int[][] mat;
    public DigraphAM(int size){
        super(size);
        mat = new int[size][size];
   
    }
    
     public void addArc(int source, int destination, int weight){
      mat[source][destination] = weight;
   }
    
    
    public int getWeight(int source, int destination){
       return mat[source][destination];
    }

     public ArrayList<Integer> getSuccessors(int vertex)
    {
        ArrayList<Integer> vecis = new ArrayList<Integer>();
            for (int i = 0; i < mat.length; i++) {
                if (mat[vertex][i]!=0) {
                    vecis.add(i);
                }
            }
        return vecis;
    }
     
    public static boolean hayCaminoDFS(DigraphAM g, int o, int d) {
        boolean[] v = new boolean[g.size()];
        
        return hayCaminoDFSAux(g, o, d, v);
    }
     
    private static boolean hayCaminoDFSAux(DigraphAM g, int o, int d, boolean[] v) {
        v[o] = true;
        if (o == d) return true;
        for(Integer s : g.getSuccessors(o))
            if (!v[s])
                if (hayCaminoDFSAux(g, s, d, v))
                    return true;
        return false;
    }
    
    public static boolean hayCaminoBFS(DigraphAM g, int o, int d) {
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