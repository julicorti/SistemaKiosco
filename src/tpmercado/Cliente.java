/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpmercado;



public class Cliente extends Usuario{
    public String nombre;
    public int cantidad;
    public Stock stock;
    public Producto producto;

    public Cliente(String nombre) {
        super(nombre);
    }

    
  

    
   // Método para que el cliente seleccione el método de pago
    public void seleccionarMetodoDePago(String metodoDePago) {
        System.out.println("Cliente " + nombre + " seleccionó el método de pago: " + metodoDePago);
    }
    public void comprar(String metodoDePago) {
    if (cantidad <= 0) {
        System.out.println("La cantidad deseada debe ser mayor que cero.");
        return;
    }

    if (stock.getCantidadDisponible(nombre)>= producto.getCantidad()) {
        this.seleccionarMetodoDePago(metodoDePago);
        producto.restarStock(cantidad);
        System.out.println("Compra realizada: " + cantidad + " unidades de " + nombre);
    } else {
        System.out.println("No hay suficiente stock de " + nombre + " para comprar " + cantidad + " unidades.");
    }
}
}
