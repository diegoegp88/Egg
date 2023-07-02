
package Entidades;


public class BarcoAMotror extends Embarcacion{
    protected double cvDeMotor;

    public BarcoAMotror() {
    }

    public BarcoAMotror(double cvDeMotor, String matricula, double eslora, Integer fabricacion) {
        super(matricula, eslora, fabricacion);
        this.cvDeMotor = cvDeMotor;
    }

    public double getCvDeMotor() {
        return cvDeMotor;
    }

    public void setCvDeMotor(double cvDeMotor) {
        this.cvDeMotor = cvDeMotor;
    }

    @Override
    public void calcularModulo() {
        super.calcularModulo();
        this.modulo+= cvDeMotor;
    }
    
    
}
