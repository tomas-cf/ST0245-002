
package codigo.entrega03.v2;

import java.util.ArrayList;

/**
 *
 * @author NN
 */
public class Nodo {
        public Question question;
        public Nodo trueBranch;
        public Nodo falseBranch;
        //public String prediccion = null;
        public ArrayList<ArrayList<String>> rows;
        
        //public ArrayList<String> trueRows;
        //public ArrayList<String> falseRows;
        public Nodo (Question question, ArrayList<ArrayList<String>> rows){
		this.question = question;
                this.trueBranch = null;
                this.falseBranch = null;
                this.rows = rows;
                //this.prediccion = probabilidadExito();
        }
        
        
        public Nodo (Question question, Nodo trueBranch, Nodo falseBranch, ArrayList<ArrayList<String>>  rows){
		this.question = question;
                this.trueBranch = trueBranch;
                this.falseBranch = falseBranch;
                this.rows = rows;
	}
        
        public double probabilidadExito(){
            double total = 0;
            double yes = 0;
            for (ArrayList<String> row : rows) {
                if (row.get(33).equals("1")) {
                    yes++;
                }
                total++;
            }
            double probabilidad = (yes*100)/total;
            
            return probabilidad ;//+ "%";
        }
 
    
}
