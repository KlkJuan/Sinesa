package cinesito;

//Clase GestorReservas
public class GestorDeReservas {
 private Cine cine;
 private ProcesadorDePagos procesadorPagos;
 private Visualizador visualizador;

 // Constructor
 public GestorDeReservas(Cine cine, ProcesadorDePagos procesadorPagos, Visualizador visualizador) {
     this.cine = cine;
     this.procesadorPagos = procesadorPagos;
     this.visualizador = visualizador;
 }

 // Método para intentar reservar un asiento
 public void intentarReservar(Cliente cliente, int filaDeseada, int columnaDeseada) {
     if (cine.verificarDisponibilidad(filaDeseada, columnaDeseada)) {
         procesarReserva(cliente, filaDeseada, columnaDeseada);
     } else {
         // Si el asiento deseado está ocupado, buscar un asiento alternativo
         buscarAsientoAlternativo(filaDeseada, columnaDeseada);
     }
 }

 // Método para buscar un asiento alternativo
 private void buscarAsientoAlternativo(int filaDeseada, int columnaDeseada) {
     // Implementar lógica para encontrar un asiento alternativo
     // Puedes adaptar esta lógica según tus requisitos específicos

     // Aquí hay un ejemplo básico de cómo podrías buscar un asiento alternativo cercano:
     for (int i = filaDeseada - 1; i <= filaDeseada + 1; i++) {
         for (int j = columnaDeseada - 1; j <= columnaDeseada + 1; j++) {
             if (cine.verificarDisponibilidad(i, j)) {
                 // Asiento alternativo encontrado, reserva
                 procesarReserva(new Cliente(), i, j); // Aquí se crea un cliente ficticio para la reserva
                 return;
             }
         }
     }

     // No se encontraron asientos alternativos
     System.out.println("No hay asientos disponibles cercanos. La reserva no se puede completar.");
 }

 // Método para procesar una reserva
 private void procesarReserva(Cliente cliente, int fila, int columna) {
     // Procesar el pago
     boolean pagoExitoso = procesadorPagos.procesarPago(cliente.getCuentaBancaria(), cliente.getFondos());

     // Si el pago es exitoso, confirmar la reserva
     if (pagoExitoso) {
         cine.reservarAsiento(fila, columna);
         visualizador.notificarCambio();
         System.out.println("Reserva exitosa para el cliente " + cliente.getNombre());
     } else {
         System.out.println("La reserva no pudo ser completada para el cliente " + cliente.getNombre());
     }
 }
}

