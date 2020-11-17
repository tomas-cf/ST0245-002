

package codigo.entrega03.v2;

import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 *
 * @author NN
 */
public class CodigoEntrega03V2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        

        
        /*
            Nombres de los dataset:
            
            lite.csv
            0_train_balanced_15000.csv
            4_test_balanced_45000.csv
            2_train_balanced_75000.csv
            3_train_balanced_105000.csv
            4_train_balanced_135000.csv
            0_test_balanced_5000.csv
            1_train_balanced_45000.csv
        */
       
        try {
            LeerDatos training_data = new LeerDatos();
            training_data.leer("0_test_balanced_5000.csv");

            
            Arbol arbolito = new Arbol();
            
            
            Nodo root = arbolito.build_tree(training_data.estudiantes);
            
            LeerDatos test_data = new LeerDatos();
            
            
            test_data .leer("4_test_balanced_45000.csv"); 
            
            int cont = 0;
            double contAciertos=0;
            double cont1=0;
            double cont1Esperados=0;
            for (ArrayList<String> stud : test_data.estudiantes) {
                String exito = (String)stud.get(stud.size()-1);
                double probExito = arbolito.classify(stud, root);
                String prediccion="0";
                if (probExito>50) {
                    prediccion="1";
                }
                if (prediccion.equals(exito)) {
                    //System.out.println("se parece");
                    contAciertos++;
                    if (prediccion.equals("1")) {
                        cont1++;
                    }
                }
                if (prediccion.equals("1")) {
                    cont1Esperados++;
                }
                //System.out.println("Exito del est "+cont+" : " +exito+ " Predicción : "+prediccion);
                cont++;
            }
            //arbolito.printTree(root);
            System.out.println("Exactitud : "+(contAciertos/test_data.estudiantes.size()));
            System.out.println("Presición : "+(cont1/contAciertos));
            System.out.println("Sensibilidad : "+(cont1/cont1Esperados));
            //double probExito = arbolito.classify(test_data.estudiantes.get(4999), root);
            //System.out.println(test_data.estudiantes.get(4999).get(33));
            //System.out.println(probExito);
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
}
