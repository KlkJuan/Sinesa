package cinesito;

//Clase GestorReservas
//Clase GestorReservas
public class GestorDeReservas {
 private Cine cine;
 private ProcesadorDePagos procesadorDePagos;
 private Visualizador visualizador;

 // Constructor
 public GestorDeReservas(Cine cine, ProcesadorDePagos procesadorDePagos, Visualizador visualizador) {
     this.cine = cine;
     this.procesadorDePagos = procesadorDePagos;
     this.visualizador = visualizador;
 }

 // Método para intentar reservar un asiento
 public void intentarReservar(Cliente cliente, int filaDeseada, int columnaDeseada) {
     if (!cine.verificarDisponibilidad(filaDeseada, columnaDeseada)) {
         // El asiento deseado está ocupado, buscar asiento alternativo
         buscarAsientoAlternativo(cliente, filaDeseada, columnaDeseada);
     } else {
         // El asiento deseado está disponible, proceder con la reserva
         procesarReserva(cliente, filaDeseada, columnaDeseada);
     }
 }

 // Método para buscar un asiento alternativo
 private void buscarAsientoAlternativo(Cliente cliente, int filaDeseada, int columnaDeseada) {
     // Implementa la lógica para encontrar un asiento alternativo
     // Puedes priorizar los asientos más cercanos al originalmente seleccionado
     // (Por simplicidad, en este ejemplo, se reserva el primer asiento disponible)
     for (int i = 1; i <= Cine.FILAS; i++) {
         for (int j = 1; j <= Cine.COLUMNAS; j++) {
             if (cine.verificarDisponibilidad(i, j)) {
                 procesarReserva(cliente, i, j);
                 return;
             }
         }
     }

     // No hay asientos alternativos disponibles, manejar el caso según sea necesario
     // (En este ejemplo, simplemente notificamos al cliente)
     System.out.println("No hay asientos alternativos disponibles.");
 }

 // Método para procesar la reserva
 public void procesarReserva(Cliente cliente, int fila, int columna) {
     // Realizar el proceso de pago
     if (procesadorDePagos.procesarPago(cliente.getCuentaBancaria(), cliente.getFondos())) {
         // Pago exitoso, reservar el asiento
         cine.reservarAsiento(fila, columna);
         
         // Notificar al visualizador para actualizar la visualización
         visualizador.notificarCambio();

         // (Opcional: Puedes realizar otras acciones, como enviar un correo de confirmación al cliente)
     } else {
         // Fondos insuficientes, manejar el caso según sea necesario
         // (En este ejemplo, simplemente notificamos al cliente)
         System.out.println("Fondos insuficientes para reservar el asiento.");
     }
 }
}


