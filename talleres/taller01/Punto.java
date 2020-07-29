
public class Punto
{
   private double x, y;

    
  public Punto(double x, double y) {
	this.x = x;
        this.y = y;
    } 
  public double x() {
	return this.x;
    }
  public double y() {
	return this.y;
    }  
  public double radioPolar() {
	return Math.sqrt(x * x + y * y);
    }
  public double anguloPolar() {
	return Math.atan(y / x);
    }
  public double distanciaEuclidiana(Punto segundo) {
        double dx = this.x - segundo.x();
        double dy = this.y - segundo.y();
        return Math.sqrt(dx * dx + dy * dy);
    }
}
