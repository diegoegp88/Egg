
package Service;

import Entidades.Alquiler;
import Entidades.BarcoAMotror;
import Entidades.Embarcacion;
import Entidades.Velero;
import Entidades.YateDeLujo;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;


public class AlquilerService {
    private Scanner leer = new Scanner(System.in);
    ArrayList<Alquiler> listaDeAlquileres = new ArrayList();
    
    public void inicio(){
        System.out.println("Biembenidos al programa para administrar alquileres para barcos");
        System.out.println();
        menuPrincipal();
    }
    
    public void menuPrincipal(){
        System.out.println("1 - Abrir alquiler");
        System.out.println("2 - cerrar alquiler");
        System.out.println("3 - ver alquileres");
        System.out.println("4 - salir del programa");
        System.out.println();
        int opcion=leer.nextInt();
        leer.nextLine();
        opcionesPrincipal(opcion);
    }
    
    public void opcionesPrincipal(int opcion){
        switch(opcion){
            case 1:
                menuAlquiler();
                break;
            case 2:
                System.out.println("Ingrese la matricula del barco que quiere cerrar el alquiler");
                cerrarAlquiler(leer.nextLine());
                menuPrincipal();
                break;
            case 3:
                mostrarAlquileresAbiertos();
                menuPrincipal();
                break;
            case 4:
                System.out.println();
                System.out.println("El programa terminara");
        }
    }
    
    public void menuAlquiler(){
        System.out.println("Seleccione una de las siguientes opciones");
        System.out.println();
        System.out.println("1 - Alquilar un espacio para un barco");
        System.out.println("2 - Alquilar un espacio para un velero");
        System.out.println("3 - Alquilar un espacio para un baco a motor");
        System.out.println("4 - Alquilar un espacio para un yate de lujo");
        System.out.println("5 - Volver al menu principal");
        System.out.println();
        
        int opcion=leer.nextInt();
        leer.nextLine();
       opcionesAlquiler(opcion);
    }
    
    public void opcionesAlquiler(int opcion){
        switch(opcion){
            case 1:
                listaDeAlquileres.add(alquilerDeEspacio(1));
                menuAlquiler();
                break;
            case 2:
                listaDeAlquileres.add(alquilerDeEspacio(2));
                menuAlquiler();
                break;
            case 3:
                listaDeAlquileres.add(alquilerDeEspacio(3));
                menuAlquiler();
                break;
            case 4:
                listaDeAlquileres.add(alquilerDeEspacio(4));
                menuAlquiler();
                break;
            case 5:
                inicio();
            default:
                System.out.println("Ingrese una opcion correcta");
                menuAlquiler();
        }
    }
    
    public Alquiler alquilerDeEspacio(int tipo){
        System.out.println("Ingrese el nombre del dueño de la embarcacion");
        String nombreCliente=leer.nextLine();
        System.out.println("Ingrese el DNI de "+ nombreCliente);
        String documentoCliente=leer.nextLine();
        LocalDateTime fechaDeEntrada=LocalDateTime.now();
        Embarcacion barco = crearEmbarcacion(tipo);
        barco.calcularModulo();
        return new Alquiler(nombreCliente,documentoCliente,fechaDeEntrada, barco);
             
    }
    
    public Embarcacion crearEmbarcacion(int tipo){
        System.out.println("Ingresar los siguientes datos de la embarcacion");
        System.out.println();
        System.out.println("Ingrese el numero de matricula");
        String matricula = leer.nextLine();
        System.out.println("Ingrese los metros de eslora");
        double eslora=leer.nextDouble();
        System.out.println("Ingrese el año de fabricacion");
        Integer fabricacion=leer.nextInt();
        
        switch(tipo){
            case 1:
                return new Embarcacion(matricula, eslora, fabricacion);
            case 2:
                System.out.println("Ingrese la cantidad de mastiles");
                Integer numerosDeMastil=leer.nextInt();
                return new Velero(numerosDeMastil, matricula, eslora, fabricacion);
            case 3:
                System.out.println("Ingrse la potencia en Cv de su embarcacion");
                double cvDeMotor=leer.nextDouble();
                return new BarcoAMotror(cvDeMotor,matricula, eslora, fabricacion);
            case 4:
                System.out.println("Ingrse el numero de camarotes de su embarcacion");
                Integer numeroDeCamarotes=leer.nextInt();
                System.out.println("Ingrse la potencia en Cv de su embarcacion");
                double cvDeMotorY=leer.nextDouble();
                return new YateDeLujo(numeroDeCamarotes,cvDeMotorY,matricula, eslora, fabricacion);
            default:
            System.out.println("Tipo de embarcacion no valido. Por favor, ingrese un tipo valido.");
            return null;
        }
        
    }
    
    public void cerrarAlquiler(String matricula) {
        double precioFinal;
        Alquiler aux=null;
        for (Alquiler alquileres : listaDeAlquileres) {//Busca la matricula
            if (alquileres.getBarco().getMatricula().equals(matricula)) {
                aux=alquileres;
                alquileres.setFechaDeSalida(LocalDateTime.now());
                precioFinal = alquileres.calcularPrecioAlquiler();
                System.out.println("El monto a cobrar por el alquiler del espacio es : $" + precioFinal + " pesos");
            }
        }
        listaDeAlquileres.remove(aux);//Remoeve el barco que sale del alquiler
        if (aux == null) {
            System.out.println("La Matricula ingresada no es correcta o no existe");
            System.out.println();
            menuPrincipal();
        }
    }
    
    public void mostrarAlquileresAbiertos() {

        if (!listaDeAlquileres.isEmpty()) {
            for (Alquiler alquileres : listaDeAlquileres) {

                System.out.println("El barco matricula: " + alquileres.getBarco().getMatricula() + " ingreso : " + alquileres.getFechaAlquiler());
                System.out.println();
            }
        } else {
            System.out.println("Los alquileres estan vacios");
            System.out.println();
        }
    }
    
    
}
