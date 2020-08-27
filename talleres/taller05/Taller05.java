/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller5;

/**
 *
 * @author NN
 */
public class Taller05 {

    
    /**
    * @param array es una arreglo de numeros enteros.
    * El método suma tiene la intención de hacer el proceso de suma
    * mediante una funcion cíclica (while/for/...)
    * @return la suma de todos los numeros sumados.
    */
    public static int suma (int[]array){
        int suma=0;                            //C1
        for (int i = 0; i < array.length; i++) //C2+C3*n 
            suma+=array[i];         
        return suma;                           //C4
                                               //T(n)=   C1+C4(C2+C3)*n
                                               //T(n)=   n
    }
    
    
    /**
    * @param num es el numero el cual se utiliza para ser multiplicado.
    * El método mul tiene la intención de hacer la multiplicación
    * de 1 a n por el numero mul
    * mediante una funcion cíclica (while/for/...)
    * 
    */
    public static void mul (int num){
        for (int i = 1; i <= num; i++) {                    //C1+C2n
            for (int j = 1; j <= num; j++) {                //(C3+C4n)*n
                System.out.println(i+"x"+j+" = "+(i*j) );   //C5+n*n
            }                                               //n^2
        }                                                   
    }
    
    
    /**
    * @param array es un arreglo de números desordenados
    * El método insertionSort tiene la intención ordenar los números
    * del arreglo array por el método insertion:
    * @see <a href="https://www.youtube.com/watch?v=OGzPmgsI-pQ"> Insertion Sort <a/>
    * mediante la anidación de funciones cíclicas (while/for/...)
    * 
    */
    public static int[] insertionSort (int[] array){
        for (int i = 0; i < array.length; i++) {            //C1+C2n
            for (int j = 0; j < array.length-1; j++) {      //(C3+C4n)*n
                if(array[j]>array[j+1]){                    //C5+n^2
                    int aux = array[j];                     //C6+n^2
                    array[j] = array[j+1];                  //C7+n^2
                    array[j+1] =aux;                        //C8+n^2
                }
            }
        }
        return array;                                       //C9+n^2
    }                                                       // n^2
}
    

