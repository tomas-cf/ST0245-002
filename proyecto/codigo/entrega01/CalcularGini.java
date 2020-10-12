/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo.entrega01;

/**
 *
 * @author NN
 */
public class CalcularGini {
   
    public double giniIz = 0;
    public double giniDe = 0;
    public int contExitoIzSi = 0;
    public int contExitoIzNo = 0;
    public int contExitoDeSi = 0;
    public int contExitoDeNo = 0;
    public int contYes = 0;
    public int contNo = 0;
    public double giniPond = 0;
    
    //17 Genero
    //32 Estrato
    public CalcularGini(){
        
    }
    
    public void calcular(int numPregun) throws Exception {
        try {
        LeerDatos datos = new LeerDatos();
        datos.leer();
         System.out.println(datos.datos.length);
        System.out.println(datos.datos[0][0]);
        for (int i = 1; i < datos.datos.length; i++) {
            System.out.println(datos.datos[i][numPregun]);
            //En el caso de comparar con genero == F
            //if (datos.datos[i][numPregun].equals("F")) {
            //En el caso de comparar con estrato == 4
            if (datos.datos[i][numPregun].equals("Estrato 4")) {
                contYes++;
                if (datos.datos[i][77].equals("1")){
                    contExitoDeSi++;
                }else{
                    contExitoDeNo++;
                }
            }else{
                contNo++;
                if (datos.datos[i][77].equals("1")){
                    contExitoIzSi++;
                }else{
                    contExitoIzNo++;
                }
            }
            
        }//*/
        
        giniIz = (double)((double)(contExitoIzSi*contExitoIzSi)/(double)(contNo*contNo))+(double)((double)(contExitoIzNo*contExitoIzNo)/(double)(contNo*contNo));
        giniIz = 1- giniIz;
        
        giniDe = (double)((double)(contExitoDeSi*contExitoDeSi)/(double)(contYes*contYes))+(double)((double)(contExitoDeNo*contExitoDeNo)/(double)(contYes*contYes));
        giniDe = 1 - giniDe;
        
        giniPond = (double)((double)(contYes*contYes)/(double)(5000*5000))+(double)((double)(contNo*contNo)/(double)(5000*5000));
        giniPond = 1- giniPond;
        
            System.out.println("Num Derecha(Si) = "+contYes);
            System.out.println("Exitoso = "+contExitoDeSi);
            System.out.println("No exitoso = "+contExitoDeNo);
            System.out.println("Gini De = "+ giniDe);
            System.out.println("---------------------------");
            System.out.println("Num Izquierda(No) = "+contNo);
            System.out.println("Exitoso = "+contExitoIzSi);
            System.out.println("No exitoso = "+contExitoIzNo);
            System.out.println("Gini iz = "+ giniIz);
            System.out.println("---------------------------");
            System.out.println("Gini pond = "+giniPond); 
        } catch (Exception e) {
        }
        
       
        
    }



    
    
}
