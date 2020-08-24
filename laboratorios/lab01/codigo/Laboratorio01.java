
package laboratorio01;

/**
 *
 * @author NN
 */
public class Laboratorio01 {

    /**
     * This method calculates the longest common sequence between two strings
     * @param string1 First string
     * @param string2 Second string
     * @return length of the largest common sequence between cadena
     */
    public static int lcsDNA(String string1, String string2){
        return lcsDNAAux(string1,string2,string1.length(),string2.length());
    }
    /**
     * This method is an auxiliar for lcsDNA
     * @param string1 first characters string
     * @param string2 second characters string
     * @param m length of cadena1
     * @param n length of cadena 2
     * @return length of the largest common sequence between two strings
     */
   private static int lcsDNAAux(String string1, String string2, int m, int n) {
        
       if(m<=0 || n<=0) return 0; //C1
       if(string1.charAt(m-1)==string2.charAt(n-1)){ //C2
           return 1+Math.max(lcsDNAAux(string1.substring(0,m-1),string2,m-2,n) , 
                            lcsDNAAux(string1,string2.substring(0,n-1),m,n-2)); // T(m,n)= C2+C3+T(m-2,n)+T(m,n-2)
       }
       
        return Math.max(lcsDNAAux(string1.substring(0,m-1),string2,m-1,n) , 
                            lcsDNAAux(string1,string2.substring(0,n-1),m,n-1)); //T(m,n)= C4+T(m-1,n)+ T(m,n-1)
         /*
         ECUACION DE RECURRENCIA:
            
         CALCULO DE COMPLEJIDAD:
                O(2^n+m)
         */ 
   }
    
    /**
     * This method calculates how many ways there are for organizing rectangles
     * of 1x2 in a rectangle of 2xn
     * @param n side n of the rectangle 2xn
     * @return number of ways that rectangles of 1x2 can be organized 
     * in a rectangle of 2xn
     */
    public static int ways(int n){
        if(n<=2) return n;          //C1
        return ways(n-1)+ways(n-2); //C2+T(n-1)+T(n-2)
        /*
        ECUACION DE RECURRENCIA:
            -C2+C1*Fn+C2*Ln
        CALCULO DE COMPLEJIDAD:
            O(2^n)
        */
    }
    
}
