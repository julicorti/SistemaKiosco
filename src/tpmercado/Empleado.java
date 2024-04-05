
package tpmercado;
 
import java.time.LocalDateTime;

public class Empleado extends Usuario{
  
    private double efectivoDisponible;
    private Venta venta;
    public Empleado(String nombre, String puesto) {
        super(nombre);
         
        this.efectivoDisponible = 0.0;// Inicializamos el efectivo disponible en 0
    
    }
   
    public void aperturaCaja() {
        System.out.println("El empleado " + this.nombre + " está realizando la apertura de la caja.");
        // Simulamos algunas acciones durante la apertura de la caja
        this.efectivoDisponible = 1000.0; // Establecemos el efectivo inicial disponible
        System.out.println("Se ha establecido el efectivo inicial disponible en: $" + this.efectivoDisponible);
        System.out.println("La caja ha sido abierta a las " + LocalDateTime.now());
    }
    public void cerrarCaja(Venta venta) {
        System.out.println("El empleado " + getNombre() + " está cerrando la caja.");
        //total de ventas del turno
        double totalVentas = venta.calcularTotalVentas();
        System.out.println("El total de ventas del turno es: $" + totalVentas);
        System.out.println("La caja ha sido cerrada a las " + LocalDateTime.now());
    }

   

    public double getEfectivoDisponible() {
        return efectivoDisponible;
    }

    public void setEfectivoDisponible(double efectivoDisponible) {
        this.efectivoDisponible = efectivoDisponible;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
