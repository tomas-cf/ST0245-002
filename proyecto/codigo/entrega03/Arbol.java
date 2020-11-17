

package codigo.entrega03.v2;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author NN
 */
public class Arbol {
    
    public HashMap<Integer,Integer> colsVisitada = new HashMap<Integer,Integer>();
    
    /**
        * Metodo que sirve para construir el árbol de desición
        * @param ArrayList<ArrayList<String>> que corresponde a los estudiantes del dataset de test
        * @return el nodo raiz del árbol
    */
    public Nodo build_tree(ArrayList<ArrayList<String>> rows){
        ArrayList giniQuestion = find_best_split(rows);
        
        if (giniQuestion.get(1)==null) {
            return new Nodo(null,rows);
        }
        
        //System.out.println("Gini : "+giniQuestion.get(0));
        //System.out.println("Question : "+Question.getValue((Question)giniQuestion.get(1)));
        //System.out.println("Column question : "+Question.getColmn((Question)giniQuestion.get(1)));
        
        colsVisitada.put(Question.getColmn((Question)giniQuestion.get(1)), 1);
        ArrayList<ArrayList<ArrayList<String>>> trueAndFalseRows = partition(rows,(Question) giniQuestion.get(1));
        
        //ArrayList<ArrayList<String>> trueBranch = trueAndFalseRows.get(1);
       
        //ArrayList<ArrayList<String>> falseBranch = trueAndFalseRows.get(0);
       
         if  (rows.size()<=300 || (double)giniQuestion.get(0) == 0){
            Nodo hoja = new Nodo((Question)giniQuestion.get(1),new Nodo(null,trueAndFalseRows.get(1)), new Nodo(null,trueAndFalseRows.get(0)),rows);
            return hoja;
        }
        
        //System.out.println(trueAndFalseRows.size());
        Nodo trueBranch= build_tree(trueAndFalseRows.get(1));
        Nodo falseBranch= build_tree(trueAndFalseRows.get(0));
        
        
        
        return new Nodo((Question)giniQuestion.get(1),trueBranch,falseBranch,rows);
        
    }
    
    /**
        * Metodo que sirve para partir un nodo en dos (trueBranch y falseBranch), clasifica cada estudiante
        * segun la pregunta que le llegue
        * @param ArrayList<ArrayList<String>> rows que corresponde a los estudiantes que tiene el nodo
        * @param Questions question que corresponde a la pregunta con la cual se va dividir el nodo
        * @return ArrayList que guarda los estudiantes segun la clasificación tanto verdadera como la clasificiación falsa
    */
    public ArrayList<ArrayList<ArrayList<String>>> partition(ArrayList<ArrayList<String>> rows, Question question){
        
        ArrayList<ArrayList<ArrayList<String>>> salida = new ArrayList<ArrayList<ArrayList<String>>>(2);

        ArrayList<ArrayList<String>> true_rows = new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>> false_rows = new ArrayList<ArrayList<String>>();
        
        //System.out.print(question.value+ " ");
        //System.out.println(question.column);
        
        for(ArrayList<String> row : rows){
          if (question.match(row)){
            true_rows.add(row);
          }else{
            false_rows.add(row);
          }
        }
        salida.add(false_rows);
        salida.add(true_rows);
        return salida;
    }
    
    /**
        * Metodo que sirve para encontrar la mejor particion de un nodo
        * @param ArrayList<ArrayList<String>> que corresponde a los estudiantes del dataset de test
        * @return ArrayList donde en la posición 1 está le mejor pregunta (puede ser nula) y en 
        * la posición 2 está el gini correspondiente de la pregunta
    */
    public ArrayList find_best_split(ArrayList<ArrayList<String>> rows){
        double best_gini = 2; 
        Question best_question = null;  
        double current_uncertainty = Gini.calculoGini(rows);
        ArrayList bestSplit = new ArrayList(2);
        int n_features = rows.get(0).size(); //- 1  //# number of columns
        for(int col = 0; col<n_features-1; col++){
            HashMap <String,Integer> values = new HashMap<String,Integer>();
            //ArrayList<String> values = new ArrayList<String>();
            
            if (colsVisitada.containsKey(col)) {
                continue;
            }
            
            for (ArrayList<String> row : rows) {  
                //System.out.println(row);
                if (!values.containsKey(row.get(col))) {
                    values.put((String)row.get(col),1);
                }
            }
            
            //for (String value : values) {
                //System.out.println(values);
            //}
          
          for(String val : values.keySet()){
              
           //System.out.println(val+ " col: "+col);
              
            if (val==null) {
                continue;
            }
              
            Question question = new Question(col, val);
            
            ArrayList<ArrayList<ArrayList<String>>> trueAndFalseRows = partition(rows, question);
                                      
            
            if(trueAndFalseRows.get(1).size()==0 || trueAndFalseRows.get(0).size()==0)
                continue;
                                    
             //Calcular gini

            double giniIz=0,giniDe=0;
            giniIz = Gini.calculoGini(trueAndFalseRows.get(1));
            giniDe = Gini.calculoGini(trueAndFalseRows.get(0));
                                        
             
              
            //System.out.println("Question "+question.value);
            
            double gini = Gini.calculoGiniPond(giniDe,trueAndFalseRows.get(0).size(),giniIz,trueAndFalseRows.get(1).size());
            
            //double gini = Gini.infoGini(trueAndFalseRows.get(1), trueAndFalseRows.get(0), current_uncertainty);
            //System.out.println("Gini iz: "+giniIz+" Gini de: "+giniDe+" Gini Pon: "+ gini);  
             
            if (gini <= best_gini) {
                 best_gini = gini;
                 best_question = question; 
             }

        }
      }
        
        
      bestSplit.add(best_gini);
      bestSplit.add(best_question);
      
      return bestSplit;  
    }
    
    /**
        * Metodo que sirve para imprimir el árbol
        * @param Nodo root que corresponde a raiz del árbol
    */
    private void recursivePrintAUX(Nodo node)
	{
            if (node != null)
            {   
                    if (node.question !=null) {
                        System.out.println(Question.getValue(node.question));

                    }else{
                        System.out.println("Hoja");
                    }

                    for (ArrayList<String> col : node.rows) {
                        //System.out.println(col.get(35));
                    }
                    
                    //System.out.println(node.rows);
                    
                    System.out.println("---------");
                    recursivePrintAUX(node.trueBranch);
                    recursivePrintAUX(node.falseBranch);
                    
                    
            }
		
    }
    
    /**
        * Metodo auxiliar para imprimir el árbol
        * @param Nodo root que corresponde a raiz del árbol
    */
    public void printTree(Nodo root){
        recursivePrintAUX(root);
    }
    
    /**
        * Metodo auxiliar para imprimir el árbol
        * @param Nodo root que corresponde a raiz del árbol
        * @return el porcentaje de exito que hay en el nodo que corresponde el porcenaje de exito del estudiante
    */
    public double classify(ArrayList<String> row, Nodo node){
        if (node.question==null) {
            //System.out.println("Llegue pa clasificar owo");
            return node.probabilidadExito();
        }
        
        //System.out.println("Pregunta "+Question.getValue(node.question));
        //System.out.println("Dato : "+ node.question.match(row));
        //System.out.println(node.question.match(row));
        
        if (node.question.match(row)) {
            return classify(row, node.trueBranch);
        }else{
            return classify(row, node.falseBranch);
        }
    }
}
