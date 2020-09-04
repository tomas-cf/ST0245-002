
package taller06;

/**
 *
 * @author NN
 */
public class MiArrayList {
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private int elements[]; 
    
    /**
    * El metodo constructor se utiliza para incializar
    * variables a valores neutros como 0 o null.
    * El contructor no lleva parámetros en este caso.
    */
    public MiArrayList() {
        size=0;
        elements= new int [DEFAULT_CAPACITY];
    }     

    
    /**
    * Tiene la intención de retornar la longitud del objeto
    * @return longitud del objeto
    *
    * El size esta influenciado por las funciones add y del
    */
    public int size() { ///O(1)
        return size; //O(1)
    }   
    
    /** 
    * @param e el elemento a guardar
    * Agrega un elemento e a la última posición de la lista
    *
    */
    public void add(int e) { //O(n)
        if(size==elements.length){  
            int[] aux=new int [size*2];
            for (int i = 0; i < elements.length; i++) //O(n)                 
                aux[i]=elements[i];                         
            aux[elements.length]=e;                         
            size=elements.length+1;                         
            elements= aux;
        }else{
        elements[size]=e;
        size++;
        }
    }    
    
    
    /** 
    * @param i es un íncide donde se encuentra el elemento posicionado
    * Retorna el elemento que se encuentra en la posición i de la lista.
    *
    */
    public int get(int i) throws Exception{ //O(1)
        if(i>size) throw new Exception("Se salió del array papi");
        return elements[i]; //O(1)
    }
    
    
    /**
    * @param index es la posicion en la cual se va agregar el elemento
    * @param e el elemento a guardar
    * Agrega un elemento e en la posición index de la lista
    *
    */
    public void add(int index, int e) throws Exception{  //O(n)
        if(index <= size || index >= size) throw new Exception("Se salió del array papi");
        if(size==elements.length){
            int[] aux=new int [size*2];
            for (int i = 0; i < elements.length; i++)    //O(n)             
                aux[i]=elements[i];
            elements= aux;
        }
            int aux[] = new int[size+1];
            for (int i = 0; i < index; i++) { //O(n)
                aux[i]=elements[i];
            }
            aux[index]= e;
            for (int i = index+1; i <= size; i++) { //O(n)
                aux[i]= elements[i-1];
            }
            
        elements= aux;
        size++;
        
    } 

    /**
    * @param index es la posicion en la cual se va eliminar el elemento
    *
    * ELimina el elemento  en la posición index de la lista
    *
    */
    public void del(int index) throws Exception{ //O(n)
        if(index <= size || index >= size) throw new Exception("Se salió del array papi");
        int [] aux= new int[size];
        for (int i = 0; i < index; i++) {   //O(n)
            aux[i]=elements[i];
        }
        for (int i = index+1; i < size; i++) { //O(n)
            aux[i-1]= elements[i];
        }
        elements=aux;
        size--;
    }

    
}
