import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @author NN
*/

public class Main
{
    public static void main() {
        dataReader d = new dataReader();
        HashMap<Long, Node> nodes = d.readNodes();
        System.out.println(nodes.size());
        ArrayList<Triplet<Long, Long, Double>> edges = d.readEdges();
        System.out.println(edges.size());
        DataStructure e = new DataStructure(nodes, edges);
        System.out.println(e.adjGraph.size());
        System.out.println(nodes.get(new Long(287291920)).id);

        Long l = new Long(287291920);
        Long l2 = new Long(1397149003);

        ArrayList<Long> test1 = e.getSuccessors(l);
        System.out.println(test1.size());

        for(Long i : test1) {
            System.out.println(i);
        }
        System.out.println("Distance: " + e.getWeight(l, l2));
    }
}