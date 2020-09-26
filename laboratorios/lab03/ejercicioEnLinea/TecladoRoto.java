/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio03;

/**
 *
 * @author NN
 */
import java.util.*;

public class TecladoRoto {

    //Punto 2.1

    public static void teclado(String a) {
        LinkedList<Character> texto = new LinkedList<>();
        for (char c : a.toCharArray()) {
            texto.add(c);
        }
        int tamaño = texto.size();
        LinkedList<String> salida = new LinkedList<>();

        while (texto.size() != 0) {
            String aux = "";
            if (texto.getFirst() == '[') {
                aux="";
                texto.removeFirst();
                while (texto.size() != 0 && texto.getFirst() != ']' && texto.getFirst() != '[') {
                    aux += texto.getFirst();
                    texto.removeFirst();
                }
                salida.addFirst(aux);
            } else if (texto.getFirst() == ']') {
                aux="";
                texto.removeFirst();
                while (texto.size() != 0 && texto.getFirst() != ']' && texto.getFirst() != '[') {
                    aux += texto.getFirst();
                    texto.removeFirst();
                }
                salida.add(aux);
            } else {
                salida.add(texto.getFirst() + "");
                texto.removeFirst();
            }

        }
        for (String s : salida) {
            System.out.print(s);
        }
        System.out.println("");
    }

    public static void main(String[] args) {

        teclado("This_is_a[Beiju]_Text");
        teclado("[[]][][]Happy_Birthday_to_Tsingua_University");
        teclado("asd[fgh[jkl");
        teclado("asd[fgh[jkl[");
        teclado("[[a[[d[f[g[g[h[h[dgd[fgsfa[f");
        teclado("asd[gfh[[dfh]hgh]fdfhd[dfg[d]g[d]dg");

    }
}
