
package Entidades;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;


public class Alquiler {
    private String nombreCliente;
    private String documentoCliente;
    private LocalDateTime fechaDeIngreso;
    private LocalDateTime fechaDeSalida;
    private Embarcacion barco;

    public Alquiler(String nombreCliente, String documentoCliente, LocalDateTime fechaAlquiler, Embarcacion barco) {
        this.nombreCliente = nombreCliente;
        this.documentoCliente = documentoCliente;
        this.fechaDeIngreso = fechaAlquiler;
        this.barco = barco;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDocumentoCliente() {
        return documentoCliente;
    }

    public void setDocumentoCliente(String documentoCliente) {
        this.documentoCliente = documentoCliente;
    }

    public LocalDateTime getFechaAlquiler() {
        return fechaDeIngreso;
    }

    public void setFechaAlquiler(LocalDateTime fechaAlquiler) {
        this.fechaDeIngreso = fechaAlquiler;
    }

    public LocalDateTime getFechaDeSalida() {
        return fechaDeSalida;
    }

    public void setFechaDeSalida(LocalDateTime fechaDevolucion) {
        this.fechaDeSalida = fechaDevolucion;
    }

    public Embarcacion getBarco() {
        return barco;
    }

    public void setBarco(Embarcacion barco) {
        this.barco = barco;
    }
    
    public double calcularPrecioAlquiler() {
        long diasOcupacion = ChronoUnit.DAYS.between(fechaDeIngreso, fechaDeSalida);
        double modulo = this.barco.getModulo();
        
        if(diasOcupacion==0){//Si sale dentro del mismo dia se cobra el dia completo
            return (diasOcupacion + 1)* modulo;
        }else{
        return diasOcupacion * modulo;
        }
    }


}