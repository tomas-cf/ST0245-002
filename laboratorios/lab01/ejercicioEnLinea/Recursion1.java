
package recursion;

/**
 *
 * @author NN
 */
public class Recursion1{

    public int triangle(int rows) {
        if (rows == 0) return 0; //C
        return rows + triangle(rows - 1); //C + T(n-1)
        //MODELO: T(n) =   |C, n=0
        //                 |C + T(n-1), n>0
        //ECUACION DE RECURRENCIA: 
        //          T(n) = C*n + C1
        //CÁLCULO DE COMPLEJIDAD:
        //          O(C*n + C1)
        //          O(C*n)      -> Por regla de la suma
        //          O(n)        -> Por regla de la multiplicación
    }
    
    public boolean nestParen(String str) {
        if(str.equals("")) return true; //C1
        if(str.length()<=1) return false; //C2
        if(str.length()==2) return str.charAt(0)=='(' && str.charAt(1)==')'; //C3

        return nestParen(str.charAt(0)+""+str.charAt(str.length()-1)) && 
                          nestParen(str.substring(1,str.length()-1));       //C4 + T(2) + T(n-2)
        /*C3 + T(2) + T(n-2)==C3+C2+T(n-2)
        ECUACION DE RECURRENCIA:
        ((-1/4)C1*C2)((-1)^2n-2n)+C2(-1)^n+c1
        CALCULO DE COMPLEJIDAD:
        
        */
    }   

    public int count11(String str) {
        if(str.length()<=1) return 0; //C1
        if(str.length()==2 ) {              //C2
            if(str.equals("11"))return 1;   //T(n)= C2+C3 
            else return 0;                  //T(n)= C2+C4    
        }
        if(count11(str.charAt(0)+""+str.charAt(1))==1) return 1+count11(str.substring(2)); //C5+T(n-2)
        return count11(str.charAt(0)+""+str.charAt(1)) + count11(str.substring(1));    //C6+ T(n-1)
        /*ECUACION DE RECURRENCIA: 
            C6n+C1
         CÁLCULO DE COMPLEJIDAD:
            O(C6n+C1) 
            O(C6n)     -> Por regla de la suma
            O(n)       -> Por regla de la multiplación
        */
    }
    
 
    
    public String endX(String str) {
        if(str.equals("") ) return str; //C1
        if(str.length()<=1) return str; //C2

        if(str.charAt(0)== 'x') return endX(str.substring(1))+"x"; //C3+T(n-1)

        return endX(str.substring(0,1))+endX(str.substring(1)); //C4+T(1))+T(n-1)
        /* C4+T(1)+T(n-1) == C4+C2+T(n-1)
          ECUACION DE RECURRENCIA:
            (C4+C2)n+C1
          CALCUCLO DE COMPLEJIDAD:
            O((C4+C2)n+C1) 
            O((C4+C2)n) -> Por regla de la suma
            O(n)        -> Por regla de la multiplicación
        
        */
        
    }

    
    public String pairStar(String str) {
        if(str.equals("")) return str; //C1

        if(str.length()==1) return str;  //C2
        if(str.charAt(0)==str.charAt(1)) return str.charAt(0)+"*"+pairStar(str.substring(1)); //C3+T(n-1)

        return pairStar(str.substring(0,1))+pairStar(str.substring(1)); //C4+T(1)+T(n-1)
        /* C4+T(1)+T(n-1) == C4+C2+T(n-1)
        ECUACION DE RECURRENCIA:
            (C4+C2)n+C1
        CALCULO DE COMPLEJIDAD:
            O((C4+C2)n+1) 
            O((C4+C2)n))    ->Por regla de la suma
            O(n)            ->Por regla de la multiplación
        */
    }
    
    public String changePi(String str) {
        if(str.length()>=2){ //C1
          if(str.charAt(0)== 'p' && str.charAt(1) == 'i') //C2
            return "3.14"+changePi(str.substring(2)); //C3+C2+T(n-2)
        }
        if(str.length()<=1) return str; //C4
        return changePi(str.substring(0,1))+changePi(str.substring(1)); //C5+T(1)+T(n-1)
        /*C5+T(1)+T(n-1)== C5+C4+T(n-1)
        ECUACION DE RECURRENCIA:
            (C5+C4)n+C1
        CALCULO DE LA COMPLEJIDAD
            O((C5+C4)n+C1)
            O((C5+C4)n) -> Por regla de la suma
            O(n)        -> Por regla de la multiplicación
        */
    }
    
}
