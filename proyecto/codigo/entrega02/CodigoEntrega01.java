package codigo.entrega01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author NN
 */

public class CodigoEntrega01 {


    public static void main(String[] args) throws IOException {

        
        
        CalcularGini giniCalc = new CalcularGini();
        try {
            //17 Genero
            //giniCalc.calcular(17);
            //32 Estrato
            giniCalc.calcular(32);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
        
        //System.out.println(datos.datos[1][17]);
        //System.out.println(datos.datos[1][32]);
    }

}
