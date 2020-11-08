
package laboratorio05;

/**
 *
 * @author NN
 */
public class Main {

    public static void main(String[] args) {
        
        Scan s = new Scan();
        try {
            s.readBicolor();
        } catch (Exception e) {
            System.out.println("error");
        }
        
    }
    
}
