

package codigo.entrega03.v2;

import java.util.ArrayList;

/**
 *
 * @author NN
 */
public class Gini {
    
    
    public Gini(){
        
    }
    
    public static double calculoGini(ArrayList<ArrayList<String>> rows){

        double gini = 0;
        double contExitoSi = 0;

        double contExitoNo = 0;

        
        for (int i = 0; i < rows.size(); i++) {
            if (rows.get(i).get(33).equals("1")) {
                contExitoSi++;
            }else{
                contExitoNo++;
            }
        }
        
        gini = (double)((double)(contExitoSi*contExitoSi)/(double)(rows.size()*rows.size()))+(double)((double)(contExitoNo*contExitoNo)/(double)(rows.size()*rows.size()));
        gini = 1 - gini;
        return gini;
    }
    
    public static double calculoGiniPond( double giniDer, double contNo, double giniIz, double contYes){
        double giniPond = 0;
        giniPond = (double)((double)(contNo*giniDer)+(double)(contYes*giniIz))/(double)(contYes+contNo);
        
        return giniPond;
    }
    

    
    
}
