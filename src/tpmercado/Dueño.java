 
package tpmercado;

import java.util.Scanner;

public class Dueño extends Usuario {

    // Atributo privado de tipo Stock, solo es accesible dentro de la clase Dueño, Esto ayuda a mantener el estado 
    // interno del objeto seguro y controlado. 
    private Stock stock;

    // Constructor de la clase con parametros nombre y stock
    public Dueño(String nombre, Stock stock) { //El parametro de Stock stock, permite una asociacion entre los objetos Dueño y 
        // Stock. 
        // Llamada al constructor de la clase padre Usuario.
        super(nombre);
        // Inicializacion del stock
        this.stock = stock;
    }

    // Metodo que muestra el menu de opciones para el dueño
    public void menuDueño() {
        Scanner entrada = new Scanner(System.in);
        int opcion;

        // Bucle principal que muestra el menu del dueño: 
        while (true) {
            // Menu del dueño
            System.out.println("----- Menu del Dueño -----");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Modificar Producto");
            System.out.println("3. Eliminar Producto");
            System.out.println("4. Ver Lista de Productos");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opcion: ");
            opcion = entrada.nextInt();

            if (opcion == 1) {
                // Llamo al metodo agregarProducto:
                agregarProducto();
            } else if (opcion == 2) {
                // Llamo al metodo modificarProducto:
                modificarProducto();
            } else if (opcion == 3) {
                // Llamo al metodo eliminarProducto:
                eliminarProducto();
            } else if (opcion == 4) {
                // Llamo al metodo mostrarProductos:
                mostrarProductos();
            } else if (opcion == 5) {
                //Si el usuario elige salir:
                System.out.println("* Saliendo del sistema *");
                // Salir del bucle
                break;
            } else {
                //Mensaje de error si la opcion ingresada no es valida:
                System.out.println("Opcion no valida.");
            }
        }
    }

    // Metodo para agregar un nuevo producto al stock: 
    public void agregarProducto() {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Ingrese el nombre del nuevo producto: ");
        String nombre = entrada.next();
        System.out.print("Ingrese la cantidad de unidades del nuevo producto: ");
        int cantidad = entrada.nextInt();
        System.out.print("Ingrese el precio del nuevo producto: ");
        double precio = entrada.nextDouble();
        
        // Llamar al metodo agregarProducto de la clase Stock: 
        stock.agregarProducto(nombre, cantidad, precio);
        System.out.println("***Producto agregado correctamente***");
    }

    // Metodo para modificar un producto: 
    public void modificarProducto() {
        // Llamo al metodo mostrarStockConPrecio de la clase Stock: Esto te muestra todos los productos
        stock.mostrarStockConPrecio();
        Scanner entrada = new Scanner(System.in);
        System.out.print("Ingrese el nombre del producto a modificar: ");
        String nombre = entrada.next();
        System.out.print("Ingrese el nuevo precio del producto: ");
        double precio = entrada.nextDouble();
        System.out.print("Ingrese la nueva cantidad de unidades del producto: ");
        int cantidad = entrada.nextInt();
        
        // Llamo al metodo modificarProducto de la clase Stock
        stock.modificarProducto(nombre, precio, cantidad);
        System.out.println("Producto modificado correctamente.");
    }

    // Metodo para eliminar un producto del stock: 
    public void eliminarProducto() {
        // Llamo al metodo mostrarStockConPrecio de la clase Stock: Esto te muestra todos los productos
        stock.mostrarStockConPrecio();
        Scanner entrada = new Scanner(System.in);
        System.out.print("Ingrese el nombre del producto a eliminar: ");
        String nombre = entrada.next();
        
        // Llamo al metodo eliminarProducto de la clase Stock
        stock.eliminarProducto(nombre);
        System.out.println("Producto eliminado correctamente.");
    }

    // Metodo para mostrar la lista de productos en el stock:
    public void mostrarProductos() {
        // Llamo al metodo mostrarStockConPrecio de la clase Stock:
        stock.mostrarStockConPrecio();
    }
}
