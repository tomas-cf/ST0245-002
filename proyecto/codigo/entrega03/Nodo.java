
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
        
        /**
        * Metodo que sirve para crear un nodo sin hijos y sin pregunta
        * @param Question question que corresponde a la pregunta que le corresponde al nodo (Puede ser nula)
        * @param  ArrayList<ArrayList<String>> que corresponde a los estudiantes del dataset train que quedaron allí
        */
        public Nodo (Question question, ArrayList<ArrayList<String>> rows){
		this.question = question;
                this.trueBranch = null;
                this.falseBranch = null;
                this.rows = rows;
                //this.prediccion = probabilidadExito();
        }
        
        /**
        * Metodo que sirve para crear un nodo con hijos y con pregunta
        * @param Question question que corresponde a la pregunta que le corresponde al nodo (Puede ser nula)
        * @param  Nodo trueBranch que corresponde a los estudiantes a los cuales la pregunta es correcta
        * @param  Nodo falseBranch que corresponde a los estudiantes a los cuales la pregunta es incorrecta
        * @param  ArrayList<ArrayList<String>> que corresponde a las columnas del dataset train que quedaron allí
        */
        public Nodo (Question question, Nodo trueBranch, Nodo falseBranch, ArrayList<ArrayList<String>>  rows){
		this.question = question;
                this.trueBranch = trueBranch;
                this.falseBranch = falseBranch;
                this.rows = rows;
	}
        
        /**
        * Metodo que sirve para decir la probabilidad de exito de un nodo
        * @return la probabilidad(porcentaje) de exito que se tiene en el nodo
        */
        public double probabilidadExito(){
            double total = 0;
            double yes = 0;
            for (ArrayList<String> row : rows) {
                if (row.get(32).equals("1")) {
                    yes++;
                }
                total++;
            }
            double probabilidad = (yes*100)/total;
            
            return probabilidad ;//+ "%";
        }
 
    
}
