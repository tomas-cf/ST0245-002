
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
    
    public Question(int column ,String value) {
        this.value = value;
        this.column = column;
    }
    
    public static String getValue(Question questions){
        return " valor : "+questions.value+" colum:"+questions.column;
    }
    
    public static int getColmn(Question question){
        return question.column;
    }
    
    public boolean isNumeric(String str){
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public boolean match(ArrayList<String> pTemp){
        
        String val = pTemp.get(this.column);
        //System.out.println("Dato : "+val);
        //System.out.println("Preguna : "+this.value);
        //System.out.println(isNumeric(val));
        if (isNumeric(val)) {
            //System.out.println("Dato : "+val);
            //System.out.println("Preguna : "+this.value);
            //System.out.println(Double.parseDouble(val) >= Double.parseDouble(this.value));
            return Double.parseDouble(val) >= Double.parseDouble(this.value);
        }else{
            return val.equals(this.value);
        }
    }
    
    
    //Falta el metodo para imprimir los training datos
    
}
