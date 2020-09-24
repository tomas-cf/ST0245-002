/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller08;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author NN
 */
public class Taller08 {

    
    /*
    * @param string es una cadena de texto que viene de este modo 3 4 5 * + o de esta manera 2 3 * 5 +
    * todo viene separado por espacios por lo que la función split. ("") vendría muy bien para separarlos
    * Se intenta hacer el calculo por medio del metodo polaco posfijo
    * @return un entero resultado de la operación
    */
    public  static  int  polaca   ( String  string ) { //O(n)
        Stack<Integer> stack = new Stack<Integer>();
        for (String s : string.split(" ")) { //O(n) n es la cantidad de caracteres diferentes a " "
            if(s.equals("+") || s.equals("-") ||
               s.equals("*") || s.equals("/")){
                int n1= stack.pop();
                int n2 = stack.pop();
                int resul=0;
                switch(s){
                    case"+": 
                        resul=n2+n1;
                        break;
                    case"-":
                        resul=n2-n1;
                        break;
                    case"*":
                        resul=n2*n1;
                        break;
                    default:
                        resul=n2/n1;
                        break;
                }
                stack.push(resul);
            }else{
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

    /**
    * @param neveras es una estructura de datos para representar el almacen con las neveras
    * @param solicitudes es una estructura de datos para representar las solicitudes
    */
    public  static  void  asignarSolicitudes   (LinkedList<Nevera> almacen , LinkedList<Solicitud> solicitudes ) { //O(m*n)
        String salida ="[";
        int sizeAux= almacen.size();
        for (int i =0; i <solicitudes.size(); i++) { // O(m*n)
            salida+= "('"+solicitudes.get(i).empresa+"',[";
            int neveras= solicitudes.get(i).cantidad;
            if (neveras>almacen.size()) {
                neveras=almacen.size();
            }
            for (int j = 0; j < neveras; j++) { //O(n)
                salida+= "("+almacen.getFirst().codigo+","+almacen.getFirst().marca+")";
                if (j>neveras-1) {
                    salida+=",";
                }
                almacen.removeFirst();
            }
            salida+="]),";
        }

        salida =salida.substring(0,salida.length()-1)+"]";
        System.out.println(salida);
    }
	
    /**
    * @param stack es una pila ya implementada que se crea en el test
    * Este método se encarga de poner la pila stack en orden inverso
    * Nota: recuerde que la funcion pop () no solo expulsa la última 
    * posición de una pila si no que tambien devuelve su valor.
    * @return una pila que haga el inverso de stack
    */
    public  static  Stack < Integer >  inversa ( Stack < Integer >  stack ) {
       
        return stack;
    }
    
    
    /**
    * @param queue es una cola ya implementada que se crea en el test
    * Este método se encarga de atender a personas.
    * Nota: Se debe imprimir en consola a quién atiende y sacarlo de la cola
    * existe una función "pull" que hace el trabajo más fácil
    * 
    */
    public static void cola (Queue<String> queue){
        //...
        return;
    }
    
   

    public static void main(String[] args) {
        //Prueba de pilas jeje
       /*Stack<Integer> pila = new Stack<Integer>();
       pila.push(1);
       pila.push(2);
       pila.push(3);
       //pila.pop();
       int a = pila.peek();
        for (int i = 0; i < pila.size(); i++) {
            System.out.println(pila.pop());
        }
        //*/
        
        // System.out.println(a);
        
       //Punto 1 (Calculadora Polaca)
       /*String calcul = "6 5 - 4 +";
        for (String c: calcul.split(" ")) {
          //  System.out.println(c);
        }
        
        //System.out.println(polaca(calcul));
        //*/
        
        //Punto 2 (Las neveras xd)
       
       /*LinkedList<Nevera> almacen = new LinkedList<Nevera>();
       LinkedList<Solicitud> solicitudes = new LinkedList<Solicitud>();
       //Neveras del alamacen
       almacen.add(new Nevera(9,"ibm"));
       almacen.add(new Nevera(8,"lg"));
       almacen.add(new Nevera(9,"ibm"));
       almacen.add(new Nevera(8,"lg"));
       almacen.add(new Nevera(7,"haceb"));
       almacen.add(new Nevera(6,"ibm"));
       almacen.add(new Nevera(5,"lg"));
       almacen.add(new Nevera(4,"haceb"));
       almacen.add(new Nevera(3,"ibm"));
       almacen.add(new Nevera(2,"lg"));
       almacen.add(new Nevera(1,"haceb"));
       //Solicitudes de neveras
       solicitudes.add(new Solicitud("exito",1));
       solicitudes.add(new Solicitud("olimpica",4));
       solicitudes.add(new Solicitud("la14",2));
       solicitudes.add(new Solicitud("eafit",10));

        System.out.println("----");
        
        asignarSolicitudes(almacen, solicitudes);
        //*/
    }
    
}
