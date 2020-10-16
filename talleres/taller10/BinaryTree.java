/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller10;
/**
 *
 * @author NN
 */
/**
* La clase BinaryTree intenta dar un conocimiento a los
* estudiantes acerca del manejo de un arbol binario de enteros.  
* Aquí se espera crear una estrcutura concreta del árbol binario,
* cabe aclarar que esta estrucutra ya esta implementada.
* @see <a href="https://docs.oracle.com/javase/9/docs/api/jdk/nashorn/api/tree/BinaryTree.html"> Árbol Binario</a>
* @author Mauricio Toro, Andres Paez
*
*/

public class BinaryTree {
	
	// Sirve como raíz del árbol
	public Node root;
    
   public BinaryTree(){
       root = null;
   }

	/**
	* @param n el dato del nodo que se busca buscar
	* Metodo auxiliar de insetarAux.
	*
	*/
    public void insertar(int n) {
        //root = new Node(n);
        insertarAux(this.root, n);
    }
    
    /**
	* @param node es la raíz del arbol
	* @param n el data del nodo que se busca insertar
	* nota: metodo recursivo.
	* Inserta un dato respetando claro las desigualdades en el árbol
	*/
    private void insertarAux(Node node, int n) {
        if (root == null) {
            root = new Node(n);
            return;
        }
        if (node.data == n){
 
        }else if (n > node.data) {
            if (node.right == null) {
                node.right = new Node(n);
            }else {
                insertarAux(node.right, n);
            }
        }else {
            if (node.left == null) {
                node.left = new Node(n);
            }else {
                insertarAux(node.left, n);
            }
        }
    }
    

    /**
	* @param n el dato del nodo que se busca.
	* Metodo auxiliar de buscarAux.
	* @return true si el metodo buscarAux es true
	*/
    public boolean buscar(int n) {
        return buscarAux(root, n);
    }
    
	/**
	* @param node es la raíz del arbol
	* @param n el data del nodo que se busca
	* nota: metodo recursivo.
	* Inserta un dato respetando claro las desigualdades en el árbol
	* @return true si se encuentra el elemento en el árbol, false de lo contrario
	*/ 

	private boolean buscarAux(Node node, int n) {
            if(node==null){
                return false;
                
            }
            if (node.data==n)
                return true;    
            else if (n<node.data)
                return buscarAux(node.left, n);
            else
                return buscarAux(node.right, n);
            
    }
	
    /**
	* @param n el dato del nodo que se busca borrar.
	* Metodo auxiliar de buscarAux.
	* 
	*/
    public void borrar(int n) {
        borrarAux(root, n);
    }
    
    /**
	* @param node es la raíz del arbol
	* @param n el data del nodo que se busca borrar
	* nota: metodo recursivo.
	* borra un dato respetando claro las desigualdades en el árbol
	*/ 
     private Node borrarAux(Node node, int n) {
         if (node==null) {
             //System.out.println("null");
             return null;
         }
         if (node.data==n) {
            if (node.right == null && node.left == null) {
                //System.out.println("ambos");
                return null;
            }
            if (node.right == null) {
                //System.out.println("right null");
                return node.left;
            }
            if (node.left == null) {
                //System.out.println("left null");
                return node.right;
            }else{
                //System.out.println("else xd "+ node.data);
                if (node.left.right==null) {
                    node.data = node.left.data;
                    node.left=null;
                }else
                node.data = elMayorDeLosMenores(node,node.left);
            }
         }else if (n<node.data){
             //System.out.println("n:"+n+" node.data:"+node.data);
             //System.out.println("menor");
             node.left=borrarAux(node.left, n);
         }else{
             node.right=borrarAux(node.right, n);
         }
            //System.out.println("mayor");
            return node;
         
         
    }
     
     //Busca el valor mayor de los menores del nodo que se va eliminar
    private int elMayorDeLosMenores(Node nodeAnte,Node node){
        if(node.right==null){
            int res = node.data;
            nodeAnte.right = null;
            return res;
        }else{
            return elMayorDeLosMenores(node,node.right);
        }
    }

    /*
	 
	 Los metodos posteriores son para imprimir el arbol de manera
	 que sirven para debuggeo
    */

	/**
	* @param node el nodo desde el cual se imprimirá
	* imprime el arbol desde el nodo node
	*/
	private void recursivePrintAUX(Node node)
	{
		if (node != null)
		{
			recursivePrintAUX(node.left);
			recursivePrintAUX(node.right);
			System.out.println(node.data);
		}
		
	}

	/**
	* Metodo auxiliar de recursivePrintAUX
	*
	*/
	public void recursivePrint()
	{
		recursivePrintAUX(root);
	}
		
        
        public static void array (int[] arr){
            int[] nuevo = {1100,2,3};
            
            arr[0]=1000;
            arr= nuevo;
        }
        
        
        
        
        public static void main (String [] args){
            BinaryTree arbolito = new BinaryTree();
            
            arbolito.insertar(8);
            arbolito.insertar(6);
            arbolito.insertar(9);
            arbolito.insertar(4);
            arbolito.insertar(7);
            arbolito.insertar(10);
            arbolito.borrar(6);
           
 
            arbolito.recursivePrint();
            System.out.println(arbolito.buscar(6));
            
            //System.out.println(arbolito.root.data);
        }

	
 
}


