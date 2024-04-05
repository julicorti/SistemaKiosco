package tpmercado;

import java.time.LocalDate;
import java.util.ArrayList;

public class Venta {

    public Empleado empleado;
    public double importeTotal;
    private static ArrayList<Producto> productos = new ArrayList<>();
    LocalDate fecha = LocalDate.now();
    private ArrayList<Venta> ventasRealizadas;

    public Venta(ArrayList<Producto> productos) {
        this.productos = productos;
        this.fecha = LocalDate.now(); // Asigna la fecha actual al atributo fecha
        this.importeTotal = calcularTotal();
        this.ventasRealizadas = new ArrayList<>();
    }
    // Método para calcular el importe total de la venta

    public void vender(ArrayList<Producto> productos) {
        System.out.println("El empleado " + empleado.getNombre() + " está realizando una venta.");
        // Crear un objeto Venta con la información de la venta actual y agregarlo a la lista de ventas realizadas
        Venta venta = new Venta(productos);
        ventasRealizadas.add(venta);
    }

    public double calcularTotalVentas() {
        double total = 0.0;
        for (Venta venta : ventasRealizadas) {
            total += venta.getImporteTotal(); // Sumar el importe total de cada venta realizada
        }
        return total;
    }

    public double calcularTotal() {
        double total = 0.0;
        for (Producto producto : productos) {
            total += producto.getPrecio(); // Suma el precio de cada producto
        }
        return total;
    }

    public double calcularVuelto(double montoPagado) {
        double importeTotal = this.calcularTotal();
        return montoPagado - importeTotal;
    }

    public void emitirTicket() {
        System.out.println("--------- Ticket de Venta ---------");
        System.out.println("Fecha: " + this.fecha);
        System.out.println("Productos:");
        for (Producto producto : productos) {
            System.out.println("- " + producto.getNombre() + ": $" + producto.getPrecio());
        }
        System.out.println("Importe Total: $" + this.importeTotal);
        System.out.println("-----------------------------------");
    }

    public double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public ArrayList<Venta> getVentasRealizadas() {
        return ventasRealizadas;
    }

    public void setVentasRealizadas(ArrayList<Venta> ventasRealizadas) {
        this.ventasRealizadas = ventasRealizadas;
    }

    public static ArrayList<Producto> getProductos() {
        return productos;
    }

    public static void setProductos(ArrayList<Producto> productos) {
        Venta.productos = productos;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

}
