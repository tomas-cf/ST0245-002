

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
        

        
        //Arbol prueba = new Arbol();
        

       
        try {
            LeerDatos training_data = new LeerDatos();
            //datos.leer("lite.csv" );
            training_data.leer("0_train_balanced_15000.csv");
            for (int i = 0; i < training_data.estudiantes.get(0).size(); i++) {
              //  System.out.println(LeerDatos.estudiantes.get(0).get(i));
            }
            //System.out.println(LeerDatos.estudiantes.get(5).size());
            //System.out.println(LeerDatos.estudiantes.get(4).get(35));
            
            //Nodo root = new Nodo(datos.getStudiantes())
            Arbol arbolito = new Arbol();
            //ArrayList ensayo = arbolito.find_best_split(LeerDatos.estudiantes);
            //System.out.println("Gini : "+ensayo.get(0));
            //System.out.println("Pregunta: "+Question.getValue((Question)ensayo.get(1)));
            
            Nodo root = arbolito.build_tree(training_data.estudiantes);
            
            LeerDatos test_data = new LeerDatos();
            test_data .leer("0_train_balanced_15000.csv"); //"4_test_balanced_45000.csv" || 0_train_balanced_15000.csv
            //ArrayList ensayo = new ArrayList();
            //ArrayList ensayo2 = new ArrayList();
            int cont = 0;
            double contAciertos=0;
            double cont1=0;
            double cont1Esperados=0;
            for (ArrayList<String> train : test_data.estudiantes) {
                String exito = (String)train.get(train.size()-1);
                double probExito = arbolito.classify(train, root);
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
