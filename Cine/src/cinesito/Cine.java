package cinesito;

import java.util.Iterator;

//Clase Cine
public class Cine {
 private Asiento[][] asientos;
 private int recaudacionTotal;
 private String cuentaCine;

 // Constructor
 public Cine(int filas, int columnas, String cuentaCine) {
     this.asientos = new Asiento[filas][columnas];
     this.recaudacionTotal = 0;
     this.cuentaCine = cuentaCine;
     inicializarAsientos(filas, columnas);
 }

 // Inicializa la matriz de asientos
 private void inicializarAsientos(int filas, int columnas) {
     for (int i = 0; i < filas; i++) {
         for (int j = 0; j < columnas; j++) {
             asientos[i][j] = new Asiento(i + 1, j + 1); // Fila y columna comienzan desde 1
         }
     }
 }

 // Métodos para verificar la disponibilidad de asientos
 public boolean verificarDisponibilidad(int fila, int columna) {
     return !asientos[fila - 1][columna - 1].isOcupado(); // Fila y columna comienzan desde 1
 }

 // Métodos para reservar asientos
 public boolean reservarAsiento(int fila, int columna) {
     if (verificarDisponibilidad(fila, columna)) {
         Asiento asiento = asientos[fila - 1][columna - 1];
         asiento.setOcupado(true);
         recaudacionTotal += calcularCostoReserva(); // Puedes implementar este método según tus necesidades
         return true;
     }
     return false;
 }

 // Método para comprobar si el cine está lleno
 public boolean estaLleno() {
     for (Asiento[] fila : asientos) {
         for (Asiento asiento : fila) {
             if (!asiento.isOcupado()) {
                 return false; // Si encuentra al menos un asiento disponible, el cine no está lleno
             }
         }
     }
     return true;
 }

 // Método para manejar la recaudación
 public void agregarRecaudacion(int monto) {
     recaudacionTotal += monto;
 }

 // Método para reiniciar los asientos
 public void reiniciarAsientos() {
     inicializarAsientos(asientos.length, asientos[0].length);
 }

 // Getters y setters
 public int getRecaudacionTotal() {
     return recaudacionTotal;
 }

 public String getCuentaCine() {
     return cuentaCine;
 }

 // Otros métodos según sea necesario

}