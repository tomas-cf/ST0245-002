
package laboratorio04;

/**
 *
 * @author NN
 */
import java.util.ArrayList;

public class Point2
{
    public class Node {
        public Node left;
        public Node right;
        public int data;
        public Node (int data) {
            this.data=data;
        }
    }

    public Node root;

    public void buildingTree (int [] preOrder) {
        for (int i = 0; i < preOrder.length; i++) {
            insert(root, preOrder[i]);
        }
    }

    public void insert (Node node, int data) {
        if (root == null) {
            root = new Node(data);
            return;
        }
        if (node.data == data){
 
        }else if (data > node.data) {
            if (node.right == null) {
                node.right = new Node(data);
            }else {
                insert(node.right, data);
            }
        }else {
            if (node.left == null) {
                node.left = new Node(data);
            }else {
                insert(node.left, data);
            }
        }
    }

    public void preOrder(Node node) {
       if(node==null) return;
        else{
            System.out.println(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void posOrder(Node node) {
        if(node==null) return;
        else{
            posOrder(node.left);
            posOrder(node.right);
            System.out.println(node.data);
        }
    }

    public void exercise21 (int [] input) {
        buildingTree(input);
        System.out.println("PosOrder");
        posOrder(root);
        System.out.println();
        //System.out.println("PreOrder");
        //preOrder(root);
    }

    public static void main (String [] args) {
        int [] test = {50,30,24,5,28,45,98,52,60};
        Point2 testing = new Point2();
        testing.exercise21(test);
    }
}
