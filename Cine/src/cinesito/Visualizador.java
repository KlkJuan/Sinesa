package cinesito;

//Clase Visualizador
public class Visualizador extends Thread {
 private Cine cine;

 // Constructor
 public Visualizador(Cine cine) {
     this.cine = cine;
 }

 // Método run para la lógica del hilo
 @Override
 public void run() {
     while (true) {
         try {
             // Espera a ser notificado antes de actualizar la visualización
             synchronized (this) {
                 wait();
             }
         } catch (InterruptedException e) {
             e.printStackTrace();
         }

         // Muestra el estado actual de los asientos en el cine
         mostrarEstadoAsientos();
     }
 }

 // Método para mostrar el estado actual de los asientos
 public void mostrarEstadoAsientos() {
     Asiento[][] asientos = cine.getAsientos();

     // Imprime el estado actual de todos los asientos en la consola
     for (int i = 0; i < asientos.length; i++) {
         for (int j = 0; j < asientos[0].length; j++) {
             if (asientos[i][j].isOcupado()) {
                 System.out.print("[X]"); // Asiento ocupado
             } else {
                 System.out.print("[O]"); // Asiento disponible
             }
         }
         System.out.println(); // Nueva línea para la siguiente fila
     }
     System.out.println("--------------------");
 }

 // Método para notificar un cambio y desencadenar la actualización
 public synchronized void notificarCambio() {
     notify();
 }
}
