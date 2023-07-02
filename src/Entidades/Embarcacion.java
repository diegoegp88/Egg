
package Entidades;




public class Embarcacion {
    protected String matricula;
    protected double eslora;
    protected Integer fabricacion;
    protected double modulo;

    public Embarcacion() {
    }
    
    public Embarcacion(String matricula, double eslora, Integer fabricacion) {
        this.matricula = matricula;
        this.eslora = eslora;
        this.fabricacion = fabricacion;
        
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getEslora() {
        return eslora;
    }

    public void setEslora(double eslora) {
        this.eslora = eslora;
    }

    public Integer getFabricacion() {
        return fabricacion;
    }

    public void setFabricacion(Integer fabricacion) {
        this.fabricacion = fabricacion;
    }

    public double getModulo() {
        return modulo;
    }

    public void setModulo(double modulo) {
        this.modulo = modulo;
    }
    
    
    
   public void calcularModulo(){
       modulo= eslora*10;
   } 
}
