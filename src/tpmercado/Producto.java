package tpmercado;

import java.util.Map;

public class Producto {

    private String nombre;
    private int cantidad;
    private double precio;
    private Stock stock;
    // Constructor 
    public Producto(String nombre, int cantidad, double precio) {

        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
       
    }

    // Metodo para obtener el nombre del producto:
    public String getNombre() {
        return nombre;
    }

    public void restarStock(int cantidad) {
        if (cantidad > 0 && cantidad <= this.cantidad) {
            this.cantidad -= cantidad;
            System.out.println("Se han vendido " + cantidad + " unidades de " + nombre + ".");
        } else {
            System.out.println("No hay suficiente stock de " + nombre + " para vender.");
        }
    }

    // Metodo para obtener la cantidad del producto:
    public int getCantidad() {
        return cantidad;
    }

    // Metodo para establecer la cantidad del producto:
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    // Metodo para obtener el precio del producto:
    public double getPrecio() {
        return precio;
    }

    // Metodo para establecer el precio del producto:
    public void setPrecio(double precio) {
        this.precio = precio;
    }

   
}
