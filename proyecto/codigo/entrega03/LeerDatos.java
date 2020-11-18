package codigo.entrega03.v2;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author NN
 */

public class LeerDatos {
    
    //Matriz(ArrayList<ArrayList<String>>) que guardará los datos extraidos del archivo.csv
    public ArrayList<ArrayList<String>> estudiantes = new ArrayList<ArrayList<String>>(); //String[5000][77];
    
    
    public LeerDatos(){
        
    }
    
    /**
     * Metodo para obtener el dataset .csv tanto el train como el test
     * Los datos los guarda en el atributo de clase "estudiantes"
     * @param nombreArchivo con el nombre del archivo del dataset
     * @throws IOException error si no se encuentra el archivo
     */
    public void leer(String nombreArchivo) throws IOException, Exception {
        //Archivo que se va leer
         File archivo = null;
        //Instanciación de FileReader para indicar que el archivo se va leer el archivo
         FileReader fr = null;
         //Instanciación de BufferedReader para leer el archivo
         BufferedReader br = null;
         //Contador que llevará la cantidad de filas 
         int cont=0;
         //Leer el archivo
        try {
            //Instanciar el archivo
            archivo= new File(nombreArchivo);
            //Instanciar el FileReader con el archivo
            fr= new FileReader(archivo);
            //Instanciar BufferedReader para leer el archivo
            br= new BufferedReader(fr);
            //Variable que guardará por fila(hasta que alla un \n) lo que tiene el string 
            String linea;
            //Leer el archivo
            while((linea=br.readLine())!=null ){
                //Partir la linea cada que alla un ; , volverla un arreglo y guardarlo en la matriz[cont]
                //La primera linea no se tiene en cuenta porque solo lleva el nombre de cada columna
                if (cont!=0) {
                    //Este arraylist guardara el dato de columna de cada estudiante
                    ArrayList<String> aux = new ArrayList<String>();
                    //Este contador verificara en que columna va, puesto que hay unas columnas que no se van 
                    //a tener en cuenta
                    int col=0;
                    //Partir la linea cada que alla un ; , por cada string que haya, se agrega a aux.add
                    for (String s : linea.split(";")) {
                        //Aquí están las columnas que no se tienen en cuenta
                        if (col!=0 && col!=1 && col!=2 && col!=3 && col!=4 && col!=5 &&
                            col!=6 && col!=7 && col!=8 && col!=9 && col!=10 && col!=14 &&
                            col!=15 && col!=16 && col!=18 && col!=19 && col!=20 && col!=17 && //(Corresponde a el genero por si quiero tenerlo en cuenta)
                            col!=21 && col!=23 && col!=25 && col!=27 && 
                            col!=34  && col!=36 && col!=37 && col!=38 && col!=39 && 
                            col!=40 && col!=41 && col!=42 && col!=43 && 
                            col!=46 && col!= 47 && col!=48 && col!=49 && col!=51 && col != 53 && col!=55 &&
                            col!=56 && col!=57 && col!= 62 && col!= 64 && col!= 74 && col!=75 && col!=76 && col!=76 &&
                            col!=78) {
                            aux.add(s);
                        }
                        col++;
                    }
                    //Finalmente se agrega el estudiante a el array de estudiantes
                    estudiantes.add(aux); // = linea.split(";");
                }
                
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
