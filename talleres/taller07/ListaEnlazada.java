
package taller07;

import java.lang.IndexOutOfBoundsException; // Usar esto cuando se salga el índice
// Una lista simplemente enlazada
public class ListaEnlazada {
private Node first;
private int size;
public ListaEnlazada()
{
	size = 0;
	first = null;	
}

	/**
	 * Returns the node at the specified position in this list.
	 * @param index - index of the node to return
	 * @return the node at the specified position in this list
	 * @throws IndexOutOfBoundsException
	 */
	private Node getNode(int index) throws IndexOutOfBoundsException { //O(n)
		if (index >= 0 && index < size) {
			Node temp = first;
			for (int i = 0; i < index; i++) {  //O(n)
				temp = temp.next;
			}
			return temp;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	/**
	 * Returns the element at the specified position in this list.
	 * @param index - index of the element to return
	 * @return the element at the specified position in this list
         * @throws IndexOutOfBoundsException
	 */
	public int get(int index) throws IndexOutOfBoundsException {  //O(n)
		Node temp = getNode(index);
		return temp.data;
	}

// Retorna el tamaño actual de la lista
public int size()
{
	return size;
}

// Inserta un dato en la posición index
public void insert(int data, int index)  //O(n)
{       

        if(index>0){
            Node nuevoNodo = new Node(data);
            Node temp = first;
            for (int i = 1; i <= index-1; i++) { //O(n)
                temp=temp.next;
            }   
            nuevoNodo.next= temp.next;
            temp.next= nuevoNodo;
            size++;
        }else if(index==0){
            first = new Node(data);
            size++;
        }

}

//Se agrega data en la ultima posición
public void insert(int data) //O(n)
{       
        if(size>0){
            Node nuevoNodo = new Node(data);
            Node temp = getNode(size-1);  //O(n)
            temp.next=nuevoNodo;
            size++;
        }
        if(size==0){
            first= new Node(data);
            size++;
        }
}

// Borra el dato en la posición index
public void remove(int index)   //O(n)
{
    if(index>0){      
        Node temp = first;
        for (int i = 1; i <= index-1; i++) { //O(n)
            temp = temp.next;
        }
        temp.next =  temp.next.next;
        size--;
    }else if(index==0){
        first= first.next;
        size--;
    }
    
}

// Verifica si está un dato en la lista
public boolean contains(int data)  //O(n)
{
	Node unNodo = first;
        while(unNodo != null){    //O(n)
            if(unNodo.data == data)
                return true;
            unNodo = unNodo.next;
        }
        return false;
}

public static void main(String[] args){
    ListaEnlazada lista = new ListaEnlazada();
    lista.insert(1,0);
    
    //lista.insert(3);
    
    lista.insert(2,1);
    
    //lista.remove(0);
    
    System.out.println(lista.get(0));
    
}


}




