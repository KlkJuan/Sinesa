package cinesito;

import java.util.Random;

//Clase Main
//Clase Main
public class Main {
 public static void main(String[] args) {
     // Crear instancias de Cine, ProcesadorPagos, GestorReservas y Visualizador
     Cine cine = new Cine();
     ProcesadorDePagos procesadorDePagos = new ProcesadorDePagos(cine);
     Visualizador visualizador = new Visualizador(cine);
     GestorDeReservas gestorReservas = new GestorDeReservas(cine, procesadorDePagos, visualizador);

     // Iniciar el hilo del visualizador
     Thread hiloVisualizador = new Thread(visualizador);
     hiloVisualizador.start();

     // Simulación continua
     while (true) {
         // Generar clientes con datos aleatorios (puedes personalizar esta lógica)
         Cliente cliente = new Cliente(
                 "NombreCliente",
                 "ApellidoCliente",
                 "correo@cliente.com",
                 null, (int) (Math.random() * 100), // Fondos aleatorios entre 0 y 100
                 gestorReservas,
                 (int) (Math.random() * Cine.FILAS) + 1, // Fila aleatoria entre 1 y FILAS
                 (int) (Math.random() * Cine.COLUMNAS) + 1 // Columna aleatoria entre 1 y COLUMNAS
         );

         // Iniciar un hilo para el cliente y procesar su reserva
         Thread hiloCliente = new Thread(cliente);
         hiloCliente.start();

         // Puedes ajustar el intervalo entre la generación de clientes según sea necesario
         try {
             Thread.sleep(2000); // Esperar 2000 milisegundos (2 segundos) antes de generar otro cliente
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     }
 }
}

