package cinesito;

//Clase Asiento
//Clase Asiento
public class Asiento {
 private int fila;
 private int columna;
 private boolean ocupado;

 // Constructor
 public Asiento(int fila, int columna) {
     this.fila = fila;
     this.columna = columna;
     this.ocupado = false; // Al inicio, todos los asientos están disponibles
 }

 // Getters y Setters
 public int getFila() {
     return fila;
 }

 public int getColumna() {
     return columna;
 }

 public boolean isOcupado() {
     return ocupado;
 }

 public void setOcupado(boolean ocupado) {
     this.ocupado = ocupado;
 }

 // Método toString para representación en cadena del asiento
 @Override
 public String toString() {
     return "Asiento{" +
             "fila=" + fila +
             ", columna=" + columna +
             ", ocupado=" + ocupado +
             '}';
 }
}

