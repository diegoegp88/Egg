
package Entidades;


public class YateDeLujo extends BarcoAMotror{
    private Integer numeroDeCamarotes;

    public YateDeLujo() {
    }

    public YateDeLujo(Integer numeroDeCamarotes, double cvDeMotor, String matricula, double eslora, Integer fabricacion) {
        super(cvDeMotor, matricula, eslora, fabricacion);
        this.numeroDeCamarotes = numeroDeCamarotes;
    }

    public Integer getNumeroDeCamarotes() {
        return numeroDeCamarotes;
    }

    public void setNumeroDeCamarotes(Integer numeroDeCamarotes) {
        this.numeroDeCamarotes = numeroDeCamarotes;
    }

    @Override
    public void calcularModulo() {
        super.calcularModulo();
        this.modulo +=numeroDeCamarotes;
    }
    
    
}
