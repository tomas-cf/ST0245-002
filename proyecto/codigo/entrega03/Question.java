
package codigo.entrega03.v2;

import java.util.ArrayList;
import jdk.nashorn.internal.runtime.JSType;

/**
 *
 * @author NN
 */
public class Question {
    
    
    public int column;
    public String value;
    
    /**
     * Metodo para crear una nueva posible pregunta
     * @param column que corresponde a la columna que le corresponde la pregunta
     * @param  value que corresponde a la pregunta con que se va comparar
     */
    public Question(int column ,String value) {
        this.value = value;
        this.column = column;
    }
    
    /**
     * Metodo que sirve para retornar el valor con que compara la pregunta
     * @param questions que corresponde a la pregunta a la cual se le quiere saber el value
     * @return valor con que compara la pregunta
     */
    public static String getValue(Question questions){
        return " valor : "+questions.value;
    }
    
    /**
     * Metodo que sirve para retornar el la columna a la que corresponde la pregunta
     * @param question que corresponde a la pregunta a la cual se le quiere saber su correspondiente columna
     * @return la columna a la que corresponde la pregunta
     */
    public static int getColmn(Question question){
        return question.column;
    }
    
    /**
     * Metodo que sirve para verificar si un String es numerico o no
     * @param str que corersponde a el String que se quiere saber si es numerico o no
     * @return si es numerico o no (boolean)
     */
    public boolean isNumeric(String str){
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    /**
     * Metodo que sirve para comparar la pregunta guardada con el valor correspondiente a la columna del estudiante que le llega 
     * @param pTemp que corresponde a el estudiante con que se quiere validar
     * @return un booleano con su respectivo valor según el estudiante
     */
    public boolean match(ArrayList<String> pTemp){
        
        //Se saca el valor de la columna del estudiante
        String val = pTemp.get(this.column);
        
        //System.out.println("Dato : "+val);
        //System.out.println("Preguna : "+this.value);
        //System.out.println(isNumeric(val));
        
        //Si es numerico se compara con >=
        if (isNumeric(val)) {
            //System.out.println("Dato : "+val);
            //System.out.println("Preguna : "+this.value);
            //System.out.println(Double.parseDouble(val) >= Double.parseDouble(this.value));
            
            return Double.parseDouble(val) >= Double.parseDouble(this.value);
        //Si son string se comprar con equals
        }else{
            return val.equals(this.value);
        }
    }
    
    
    //Falta el metodo para imprimir los training datos
    
}
