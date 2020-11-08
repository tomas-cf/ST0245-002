
package laboratorio05;

/**
 *
 * @author NN
 */
import javax.tools.Diagnostic;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Scan {

    public Scan() {
    }

    public void readBicolor() throws FileNotFoundException {
        
        File archivo = new File("Entrada.txt");
        Scanner read = new Scanner(archivo);
        String line = read.nextLine();
        Scanner scanLine = new Scanner(line);
        DigraphAM am = null;
        //Tree t = new Tree();
        int nodos = scanLine.nextInt();
        while (nodos != 0) {
            am = new DigraphAM(nodos);
            line = read.nextLine();
            scanLine = new Scanner(line);
            int aris = scanLine.nextInt();
            for (int i = 0; i < aris; i++) {
                line = read.nextLine();
                scanLine = new Scanner(line);
                am.addArc(scanLine.nextInt(), scanLine.nextInt(), 1);
            }
            line = read.nextLine();
            scanLine = new Scanner(line);
            
            //t.genTree(am);
            am.imprimir();
            
            System.out.println("BFS");
            if (Algorithm.BFSColorFC(am)){
                System.out.println("BICOLORABLE");
            }else{
                System.out.println("NO BICOLORABLE");
            }
            System.out.println("DFS");
            if (Algorithm.DFSColorFC(am)){
                System.out.println("BICOLORABLE");
            }else{
                System.out.println("NO BICOLORABLE");
            }
            //*/
             System.out.println("---------------------------");
            nodos = scanLine.nextInt();
        }
    }
    
}