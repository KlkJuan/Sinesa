package cinesito;

//Clase ProcesadorPagos
//Clase ProcesadorPagos
public class ProcesadorDePagos {
 private Cine cine;

 // Constructor
 public ProcesadorDePagos(Cine cine) {
     this.cine = cine;
 }

 // Método para procesar el pago
 public boolean procesarPago(String cuentaCliente, int fondosCliente) {
     if (fondosCliente >= calcularCostoAsiento()) {
         // Simulación de transferencia de fondos
         // (En una implementación real, aquí se realizaría la transferencia bancaria)
         
         // Actualizar la recaudación total del cine
         cine.agregarRecaudacion(calcularCostoAsiento());
         return true; // Pago exitoso
     } else {
         return false; // Fondos insuficientes
     }
 }

 // Método para calcular el costo de un asiento (puedes ajustar esta lógica según sea necesario)
 private int calcularCostoAsiento() {
     // Puedes implementar una lógica más sofisticada para calcular el costo de los asientos
     return 10; // Costo fijo por asiento
 }
}


