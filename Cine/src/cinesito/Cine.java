package cinesito;

import java.util.Iterator;

//Clase Cine
//Clase Cine
public class Cine {
 public static final int FILAS = 5; // Número de filas en el cine
 public static final int COLUMNAS = 8; // Número de columnas en el cine

 private Asiento[][] asientos;
 private int recaudacionTotal;
 private String cuentaCine;

 // Constructor
 public Cine() {
     this.asientos = new Asiento[FILAS][COLUMNAS];
     inicializarAsientos();
     this.recaudacionTotal = 0;
     this.cuentaCine = "cuentaCine123"; // Puedes establecer una cuenta bancaria válida
 }

 // Métodos
 private void inicializarAsientos() {
     for (int i = 0; i < FILAS; i++) {
         for (int j = 0; j < COLUMNAS; j++) {
             asientos[i][j] = new Asiento(i + 1, j + 1); // Filas y columnas comienzan desde 1
         }
     }
 }

 public boolean verificarDisponibilidad(int fila, int columna) {
     return !asientos[fila - 1][columna - 1].isOcupado();
 }

 public boolean reservarAsiento(int fila, int columna) {
     if (verificarDisponibilidad(fila, columna)) {
         asientos[fila - 1][columna - 1].setOcupado(true);
         return true;
     }
     return false;
 }

 public boolean estaLleno() {
     for (int i = 0; i < FILAS; i++) {
         for (int j = 0; j < COLUMNAS; j++) {
             if (!asientos[i][j].isOcupado()) {
                 return false; // Si hay al menos un asiento disponible, el cine no está lleno
             }
         }
     }
     return true;
 }

 public void agregarRecaudacion(int monto) {
     recaudacionTotal += monto;
 }

 public void reiniciarAsientos() {
     for (int i = 0; i < FILAS; i++) {
         for (int j = 0; j < COLUMNAS; j++) {
             asientos[i][j].setOcupado(false);
         }
     }
 }

 // Getters y Setters
 public int getRecaudacionTotal() {
     return recaudacionTotal;
 }

 public String getCuentaCine() {
     return cuentaCine;
 }
}
