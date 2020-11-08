
package laboratorio05;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author NN
 */
public class Algorithm {


    
    public static boolean BFSColorFC(DigraphAM graph) {
        return BFSColorFCAux(graph.matriz, 0);
        
    }
    
    public static boolean DFSColorFC(DigraphAM graph) {
        //return DFSColorFCAux(tree.getFirst(), 1);
        int tamaño = graph.matriz.length;
        int colorArr[] = new int[tamaño];
        for (int i = 0; i < tamaño; i++) {
            colorArr[i]=-1;
        }
        colorArr[0]=1;
        return DFSColorFCAux(graph.matriz,0,colorArr);
    }

    private static boolean DFSColorFCAux(int[][] matriz, int father,int[] colorArr){
        if (matriz[father][father]==1) {
            return false;
        }
        
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[father][i]==1 && colorArr[i]==-1) {
                colorArr[i]= 1-colorArr[father];
                if (!DFSColorFCAux(matriz, i, colorArr)){
                    return false;
                }
                
            }else if(matriz[father][i]==1 && colorArr[father]==colorArr[i]){
                    return false;
            }
        }

        return true;
    }
    
    private static boolean BFSColorFCAux(int[][] matriz, int origin) {
        int tamaño = matriz.length;
        int colorArr[] = new int[tamaño];
        for (int i = 0; i < tamaño; i++) {
            colorArr[i]=-1;
        }
        colorArr[origin]=1;
        Queue<Integer> colita = new LinkedList<Integer>();
        colita.add(origin);
        while (!colita.isEmpty()) {            
            int auxU = colita.poll();
            if (matriz[auxU][auxU] == 1)
                return false;
            for (int  auxV= 0;  auxV< tamaño; auxV++) {
                if (matriz[auxU][auxV]==1 && colorArr[auxV]==-1) {
                    colorArr[auxV]= 1-colorArr[auxU];
                    colita.add(auxV);
                }else if(matriz[auxU][auxV]==1 && colorArr[auxU]==colorArr[auxV]){
                    return false;
                }
            }

        }
        return true;
    }
}
