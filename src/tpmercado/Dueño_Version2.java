package tpmercado;

import java.util.Scanner;

public class Dueño_Version2 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        int opcion;

        // Bucle principal
        while (true) { //Este bucle es infinito, el codigo dentro del bucle se ejecutara siempre, ya que la condicion true siempre
            //sera verdadera , continuara ejecutandose hasta que el usuario elige salir del sistema , utilizando la instruccion break
            // Menu : 
            System.out.println("----- Bienvenido al sistema -----");
            System.out.println("1. Ingresar como Admin");
            System.out.println("2. Ingresar como cliente");
            System.out.println("3. Salir");
            System.out.print("Ingrese una opcion: ");
            opcion = entrada.nextInt();

            if (opcion == 1) { //Opcion para entrar como Dueño 

                System.out.print("Ingrese su nombre de usuario: ");
                String nombreDueño = entrada.next();
                System.out.print("Ingrese su contraseña: ");
                String contraseñaDueño = entrada.next();

                // Validacion de los datos que ingresa el Usuario, para que pueda ingresar como Dueño.
                if (nombreDueño.equals("Juan") && contraseñaDueño.equals("12345")) {
                    //Si los datos que puso son correctos , aparece esto: 
                    System.out.println("----- Bienvenido, Dueño -----");
                    // Crear un objeto Stock
                    Stock stock = new Stock();
                    // Crear un objeto Dueño con el nombre de usuario y el stock creado
                    Dueño dueño = new Dueño(nombreDueño, stock);
                    // Muestro el menú del dueño
                    dueño.menuDueño();
                } else {
                    // Mensaje de error si los datos son incorrectas
                    System.out.println("Nombre de usuario o contraseña incorrectos.");
                }

            } else if (opcion == 2) {
                System.out.print("Ingrese el nombre del cliente: ");
                String nombreCliente = entrada.next();
               Cliente cliente = new Cliente(nombreCliente);

                // Menú para el cliente
                while (true) { //La idea aca es que con este menu hagan los if y dentro llamen a los metodos
                    System.out.println("----- Menú Cliente -----");
                    System.out.println("1. Ver productos disponibles");
                    System.out.println("2. Comprar producto");
                    System.out.println("3. Salir");
                    System.out.print("Ingrese una opción: ");
                    int opcionCliente = entrada.nextInt();
                }
        }
        else if (opcion == 3) {
                //  si el usuario elige salir
                System.out.println("* Salio del sistema *");
                // Salir del bucle
                break;
            } else {
                // Mensaje de error si la opción ingresada no es válida
                System.out.println("Opción no válida.");
            }
    }
}
}
