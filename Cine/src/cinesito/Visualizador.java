package cinesito;

//Clase Visualizador
//Clase Visualizador
public class Visualizador implements Runnable {
 private Cine cine;

 // Constructor
 public Visualizador(Cine cine) {
     this.cine = cine;
 }

 // Método run para la lógica del hilo del visualizador
 @Override
 public void run() {
     while (true) {
         mostrarEstadoAsientos();
         esperarActualizacion();
     }
 }

 // Método para mostrar el estado actual de los asientos
 public void mostrarEstadoAsientos() {
     System.out.println("Estado actual de los asientos:");
     for (int i = 0; i < Cine.FILAS; i++) {
         for (int j = 0; j < Cine.COLUMNAS; j++) {
             if (cine.verificarDisponibilidad(i + 1, j + 1)) {
                 System.out.print("[O] "); // Asiento disponible
             } else {
                 System.out.print("[X] "); // Asiento ocupado
             }
         }
         System.out.println(); // Nueva línea para cada fila
     }
     System.out.println();
 }

 // Método para esperar actualización
 private void esperarActualizacion() {
     try {
         // Puedes ajustar la duración del intervalo de actualización según sea necesario
         Thread.sleep(500); // Esperar 500 milisegundos (0.5 segundos)
     } catch (InterruptedException e) {
         e.printStackTrace();
     }
 }

 // Método para notificar un cambio y desencadenar una actualización
 public void notificarCambio() {
     // Puedes agregar lógica adicional según sea necesario
 }
}

