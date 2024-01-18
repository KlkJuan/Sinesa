package cinesito;

//Clase ProcesadorPagos
public class ProcesadorDePagos {
 private Cine cine;

 // Constructor
 public ProcesadorDePagos(Cine cine) {
     this.cine = cine;
 }

 // Método para procesar el pago
 public boolean procesarPago(String cuentaCliente, int fondosCliente) {
     int costoAsiento = cine.getCostoAsiento(); // Obtener el costo del asiento del cine

     if (fondosCliente >= costoAsiento) {
         // Suficientes fondos, procesar el pago
         int nuevaRecaudacion = cine.getRecaudacionTotal() + costoAsiento;
         cine.setRecaudacionTotal(nuevaRecaudacion);

         // Actualizar la cuenta del cliente
         // (Este es un lugar ficticio, en una aplicación real se usarían servicios bancarios)
         System.out.println("Pago exitoso de " + costoAsiento + " desde la cuenta " + cuentaCliente);

         return true; // Pago exitoso
     } else {
         // Fondos insuficientes
         System.out.println("Fondos insuficientes en la cuenta " + cuentaCliente);

         return false; // Fondos insuficientes
     }
 }
}

