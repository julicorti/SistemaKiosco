package tpmercado;

import java.util.HashMap;
import java.util.Map;

public class Stock {
    //En JAVA Map es una interfaz que representa una coleccion de pares CLAVE-VALOR, donde cada clave es unica y se mapea
    // a un unico valor. MAP proporciona diferentes formas de almacenar y manipular estos pares clave-valor. HASHMAP es una de 
    // esas implementaciones

    // Declaración de un map para almacenar los productos en stock
    public Map<String, Producto> stock; //Aca se declara una variable de instancia stock que es de tipo Map.
    //El map se declara con 2 tipos de datos , String para las claves y Producto para los valores, Esto significa que el MAP
    // tendra cadenas como claves y objetos Producto como valores. 

    // Constructor de la clase que inicializa el map y agrega productos predeterminados.
    // Este es el constructor de la clase Stock
    //Dentro del constructor, se inicializa el atributo stock utilizando la implementacion de HASHMAP
    //Se crea una nueva instancia de HASHMAP y se asigna a la variable stock.Esto crea un contenedor vacio que se utilizara 
    // para almacenar los productos en stock.
    public Stock() {
        this.stock = new HashMap<>();//Crea un nuevo objeto HashMap, esto es una clase en java que implementa la interfaz Map
        // y proporciona una estructura de datos basada en una tabla hash para almacenar pares clave-valor.

        //Una tabla hash o mapa hash o diccionario hash, es una estructura de datos que implementa una asociacion de claves y valores.
        // Es una forma eficiente de almacenar y recuperar informacion.
        // Agrego producto predeterminados al stock para que no aparezca todo vacio: 
        // Lo que pasa aca es lo siguiente: 
        //stock.put = Lo que hace esto es agregar un nuevo par clave-valor al map. Toma dos argumentos: La Clave y el Valor
        // Galletitas es la clave 
        // new Producto ("Galletitas", 10, 30) = Esto es el valor. Se crea un nuevo objeto Producto con el nombre Galletitas,
        //tiene la cantidad inicial de 10 unidades y el precio de $30
        // Lo mismo para los otros productos creados de manera predeterminada
        stock.put("Galletitas", new Producto("Galletitas", 10, 30 ));
        stock.put("Coca-Cola", new Producto("Coca-Cola", 10, 50));
        stock.put("Alfajor", new Producto("Alfajor", 10, 15));
        stock.put("Cafe", new Producto("Cafe", 10, 25));
        stock.put("Pan", new Producto("Pan", 10, 65));
        stock.put("Leche", new Producto("Leche", 10, 200));
        stock.put("Dulce de leche", new Producto("Dulce de leche", 10, 260));
        stock.put("Jamon", new Producto("Jamon", 10, 250));
        stock.put("Queso", new Producto("Queso", 10, 250));
    }

    public Map<String, Producto> getStock() {
        return stock;
    }

    public void setStock(Map<String, Producto> stock) {
        this.stock = stock;
    }

    // Metodo para agregar un producto al stock:
    public void agregarProducto(String nombreProducto, int cantidad, double precio) {
        // Agregar un nuevo producto al mapa
        stock.put(nombreProducto, new Producto(nombreProducto, cantidad, precio));
    }

    // Metodo para modificar un producto:
    public void modificarProducto(String nombreProducto, double precio, int cantidad) {
        if (stock.containsKey(nombreProducto)) {
            //Esta condicion verifica si el map stock contiene la clave nombreProducto. Si el nombre del producto 
            //esta presente como clave en el map,significa que el producto esta en stock y se puede modificar.

            Producto producto = stock.get(nombreProducto); // obtiene el producto del map stock utilizando el nombre del producto como clave.
            producto.setPrecio(precio); //Se actualiza el precio del producto
            producto.setCantidad(cantidad); //Se actualiza la cantidad de unidades del producto
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    // Metodo para eliminar un producto del stock:
    public void eliminarProducto(String nombreProducto) {
        //Verifico si el producto esta en el stock, 
        if (stock.containsKey(nombreProducto)) { //Verifica si el map contiene una clave,stock es el nombre del map, nombreProducto
            //es la clave que se busca. 

            // Si se encuentra la clave en la paso anterior , entonce se puede eliminar el producto
            stock.remove(nombreProducto);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    // Metodo para mostrar la lista de productos: 
    public void mostrarStockConPrecio() {
        System.out.println("----- Lista de Productos en Stock -----");
        // Iterar sobre el map y mostrar los detalles de cada producto:
        for (Map.Entry<String, Producto> entry : stock.entrySet()) {

            //Map.Entry<String, Producto> entry : stock.entrySet() = 
            //Cada elemento que vamos a obtener del map stock sera un par clave-valor, donde
            //la clave es un String y el valor es un objeto de tipo Producto. 
            //¿Que hace Entry? : Representa cada clave-valor dentro del map stock durante cada iteracion del bucle. 
            //Entry contiene una entrada especifica del map.
            //La variable entry esta declarada como tipo Map.Entry<String, Producto>, lo que significa que cada elemento que 
            //recorre el bucle es un objeto de tipo Map.Entry, que tiene 2 partes , la clave (String) y el valor (tipo Producto).
            //Esto permite acceder tanto a la clave como al valor de cada entrada del map durante la iteracion.
            // stock.entrySet() = Devuelve todos los elementos pares clave-valor del map stock
            String nombreProducto = entry.getKey();//entry.getKey me da el nombre del producto del map stock.Esto se 
            //se guarda en la variable nombreProducto que es de tipo String. Esta linea de codigo, me permite acceder 
            // al nombre del producto que esta en el map stock durante la iteracion del bucle. 

            Producto producto = entry.getValue(); //Aca obtengo el valor del objeto Producto asociado a la entrada del map 
            //stock  y asignandolo a la variable producto. Asignar entry.getValue() a producto , me permite acceder con el objeto
            // Producto durante la iteracion del bucle

            System.out.println("- Nombre: " + nombreProducto + ", Cantidad: " + producto.getCantidad() + ", Precio: $" + producto.getPrecio());
        }
    }
// Método para obtener la cantidad disponible de un producto específico
    public int getCantidadDisponible(String nombreProducto) {
        if (stock.containsKey(nombreProducto)) {
            Producto producto = stock.get(nombreProducto); // Obtener el producto del mapa
            return producto.getCantidad(); // Devolver la cantidad del producto
        } else {
            System.out.println("Producto no encontrado.");
            return 0; // Devolver 0 si el producto no se encuentra en el stock
        }
    }

}
