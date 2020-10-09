
package taller09;

import java.util.HashMap;
/**
 *
 * @author NN
 */
public class Taller09 {
	
    /** 
    * pedrito 2
    * @param empresas es el hashmap ya creado donde se guardaran los valores 
    * @param key es la llave en el conjunto
    * @param value es el valor asociado a la llave key
    * El metodo agregara un nuevo valor a empresas con los atributos key y value.
    */
    public static void agregar(HashMap empresas,String key, String value){
        empresas.put(key, value);
    }
    
    /** 
    * pedrito 3
    * @param empresas es el hashmap ya creado donde se guardaran los valores 
    * @param key es la llave en el conjunto
    * 
    * El metodo buscara el valor asociado a la llave key
    * @return true, si lo encuentra, false de lo contrario.
    */
    public static boolean buscar(HashMap empresas,String key){
        System.out.println(empresas.get(key));
        return empresas.containsKey(key);
    }

    /** 
    * pedrito 4
    * @param empresas es el hashmap ya creado donde se guardaran los valores 
    * @param value es el valor asociado a la llave key
    * El metodo nos dira si hay una llave asociado al valor value.
    * @return true, si lo encuentra, false de lo contrario.
    */
    public static boolean contieneValue(HashMap empresas,String value){
        return empresas.containsValue(value);
    } 
    
    public static void main(String[] args){
        HashMap empresas = new HashMap();
        agregar(empresas, "Google", "Estados Unidos");
        agregar(empresas, "Nokia", "Finlandia");
        agregar(empresas, "La locura", "Colombia");
        agregar(empresas, "Sony", "Japon");
        
        System.out.println(buscar(empresas, "Sony"));
        
        System.out.println(contieneValue(empresas,"Finlandia"));
        
    }
}
