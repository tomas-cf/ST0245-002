

package codigo.entrega03.v2;

import java.util.ArrayList;

/**
 *
 * @author NN
 */
public class Gini {
    
    
    public Gini(){
        
    }
    /**
        * Metodo que sirve para calcular el gini de un nodo
        * @param ArrayList<ArrayList<String>> que corresponde a los estudiantes que tiene cada nodo
        * @return el gini que tiene el nodo
    */
    public static double calculoGini(ArrayList<ArrayList<String>> rows){

        double gini = 0;
        double contExitoSi = 0;

        double contExitoNo = 0;

        
        for (int i = 0; i < rows.size(); i++) {
            if (rows.get(i).get(32).equals("1")) {
                contExitoSi++;
            }else{
                contExitoNo++;
            }
        }
        
        //Formula del gini 
        gini = (double)((double)(contExitoSi*contExitoSi)/(double)(rows.size()*rows.size()))+(double)((double)(contExitoNo*contExitoNo)/(double)(rows.size()*rows.size()));
        gini = 1 - gini;
        return gini;
    }
    
     /**
        * Metodo que sirve para calcular el gini ponderado de una division de un nodo
        * @param double giniDer que corresponde a el gini del nodo de los estudiantes a los cuales la pregunta es incorrecta
        * @param double contNo que corresponde a la contidad de estudiantes a los cuales la pregunta es incorrecta
        * @param double giniIz que corresponde a el gini del nodo de los estudianes a los cuales la pregunta es correcta
        * @param double contYes que corresponde a la contidad de estudiantes a los cuales la pregunta es correcta
        * @return el gini ponderado que tiene la división del nodo
    */
    public static double calculoGiniPond( double giniDer, double contNo, double giniIz, double contYes){
        double giniPond = 0;
        giniPond = (double)((double)(contNo*giniDer)+(double)(contYes*giniIz))/(double)(contYes+contNo);
        
        return giniPond;
    }
    

    
    
    
}
