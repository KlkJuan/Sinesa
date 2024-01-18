package cinesito;

import java.util.Random;

//Clase Main
public class Main {
 public static void main(String[] args) {
     // Inicialización de Componentes
     Cine cine = new Cine();
     ProcesadorDePagos procesadorPagos = new ProcesadorDePagos(cine);
     GestorDeReservas gestorReservas = new GestorDeReservas(cine, procesadorPagos);
     Visualizador visualizador = new Visualizador(cine);

     // Inicio del hilo de Visualizador
     visualizador.start();

     // Gestión de Hilos
     Thread visualizadorThread = new Thread(visualizador);

     // Inicia el hilo del Visualizador
     visualizadorThread.start();

     // Ciclo de Simulación
     while (true) {
         // Generación de Clientes
         generarCliente(gestorReservas);

         // Pequeña pausa para la simulación
         try {
             Thread.sleep(1000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     }
 }

 // Método para generar un cliente con datos aleatorios y realizar la reserva
 private static void generarCliente(GestorDeReservas gestorReservas) {
     Random rand = new Random();

     // Datos aleatorios para el cliente
     String nombre = "Cliente" + rand.nextInt(100);
     String apellidos = "Apellido" + rand.nextInt(100);
     String correo = "cliente" + rand.nextInt(100) + "@correo.com";
     String cuentaBancaria = "Cuenta" + rand.nextInt(100);
     int fondos = rand.nextInt(100) + 1; // Fondos entre 1 y 100
     int filaDeseada = rand.nextInt(Cine.FILAS);
     int columnaDeseada = rand.nextInt(Cine.COLUMNAS);

     // Crea e inicia el hilo del Cliente
     Cliente cliente = new Cliente(nombre, apellidos, correo, cuentaBancaria, fondos, gestorReservas,
             filaDeseada, columnaDeseada);
     Thread clienteThread = new Thread(cliente);
     clienteThread.start();
 }
}
