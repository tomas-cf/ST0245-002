/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller04;

/**
 *
 * @author NN
 */
public class Taller04 {

    
    /**
	* @param array es un arreglo de numeros enteros
	* @param n la longitud del array anterior 
	*
	*en este método se busca el mayor de los numeros en un
	*arreglo de forma recursiva.
	*
	* @return el maximo
	*/
	public static int arrayMax(int[] array, int n) {
		if(n>array.length) return Integer.MIN_VALUE; //C1
                return Math.max(array[n],arrayMax(array,n+1));  //C2 +T(n-1)
                                                                // C2n + C1
        }
    
    /**
	* @param start es un contador, nos sirve para saber cuando debemos parar
	* @param array es un arreglo de numeros enteros, representan volumen
	* @param target es la meta, el numero que debe alacanzar la suma 
	*
	* en este método se busca hacer la suma de los volumnes posibles
	* de modo que se acomode de tal forma que se alcance el valor target
	* pista: la clave esta en el numero de elementos y que no siempre se toman
	* los elementos, en ocaciones pasan por ejemplo en un conjuntos [5,6,7,8] para un
	* target 12 se toman el 5 y el 7 pasando por 6 sin cogerlo.
	*
	*
	* @return verdadero si hay una combinación que suponga el valor target, falso de lo contrario
	*/
	public static boolean groupSum(int start, int[] nums, int target) {
            if(start>=nums.length) return target==0; //C1
            return groupSum(start+1,nums,target-nums[start]) || 
                   groupSum(start+1,nums,target);               //C2 + T(n-1)+ T(n-1)
        }                                                       // C2 + 2T(n-1)
	
	
	/**
	* @param n numero entero, hasta que numero se hace la serie
	*
	* el metodo se encarga de devolvernos el valor fibonacci en la enesima posicion
	* @see <a href="https://es.wikipedia.org/wiki/Sucesi%C3%B3n_de_Fibonacci"> fibonnaci <a/>
	* @return el valor encontrado en long dada la posible cantidad de bits
	*/
	public static long fibonacci(int n) { 
		if(n<=2) return n;              //C1
                return fibonacci(n-1)+fibonacci(n-2); //C2 + T(n-1) + T(n-2)
	}                                             // -C2+C1+Fn+C2Ln  
    
}
