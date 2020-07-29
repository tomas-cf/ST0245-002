public class Fecha {
    

    private final int dia;
    private final int mes;
    private final int anyo;


    public Fecha(int dia, int mes, int anyo) {
        this.dia=dia;
        this.mes=mes;
        this.anyo=anyo;

    public int dia() {
        return this.dia;

    public int mes() {
        return this.mes;
    }


    public int anio() {
        return this.anyo;
    }

    public int comparar(Fecha otra) {
        if (this.anyo < otra.anio())
            return -1;
        if (this.anyo > otra.anio())
            return 1;

        if (this.mes < otra.mes())
            return -1;
        if (this.mes > otra.mes())
            return 1;

        if (this.dia < otra.dia())
            return -1;
        if (this.dia > otra.dia())
            return 1;
        
        return 0;
    }

    public String toString() {
        return Integer.toString(this.dia)+"/"+Integer.toString(this.mes)+"/"+Integer.toString(this.anyo);
    }
}
