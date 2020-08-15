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
        //Archivo que se va leer
         File archivo = null;
        //Instanciación de FileReader para indicar que el archivo se va leer el archivo
         FileReader fr = null;
         //Instanciación de BufferedReader para leer el archivo
         BufferedReader br = null;
         //Matriz que guardará los datos extraidos del archivo.csv
         String[][] datos= new String[5000][76];
         //Contador que llevará la cantidad de filas 
         int cont=0;
         //Leer el archivo
        try {
            //Instanciar el archivo
            archivo= new File("./src/codigo/entrega01/0_test_balanced_5000.csv");
            //Instanciar el FileReader con el archivo
            fr= new FileReader(archivo);
            //Instanciar BufferedReader para leer el archivo
            br= new BufferedReader(fr);
            //Variable que guardará por fila(hasta que alla un \n) lo que tiene el string 
            String linea;
            //Leer el archivo
            while((linea=br.readLine())!=null){
                //Partir la linea cada que alla un ; , volverla un arreglo y guardarlo en la matriz[cont]
                datos[cont]= linea.split(";");
                //Aumentar fila+1
                cont++;
            }
            
        //Por si no se encuentra el archivo, imprimir error
        } catch (Exception e) {
            System.out.println("No se pudo leer el archivo");
        }finally{
            if(null!=br){
                //Cerrar archivo si quedó abierto
                br.close();
            }
        }
        
    }

}
