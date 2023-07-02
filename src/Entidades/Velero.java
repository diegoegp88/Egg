package Entidades;

public class Velero extends Embarcacion {

    private Integer numerosDeMastil;

    public Velero() {
    }

    public Velero(Integer numerosDeMastil, String matricula, double eslora, Integer fabricacion) {
        super(matricula, eslora, fabricacion);
        this.numerosDeMastil = numerosDeMastil;
    }

    public Integer getNumerosDeMastil() {
        return numerosDeMastil;
    }

    public void setNumerosDeMastil(Integer numerosDeMastil) {
        this.numerosDeMastil = numerosDeMastil;
    }

    @Override
    public void calcularModulo() {
        super.calcularModulo();
        this.modulo+= numerosDeMastil;
    }
    
    
}
