package cinesito;

import java.util.Iterator;

//Clase Cine
//Clase Cine
public class Cine {
	 private int filas = 10; // Número de filas en el cine
	 private int columnas= 10; // Número de columnas en el cine

	 private Asiento[][] asientos;
	 private int recaudacionTotal;
	 private String CuentaCine;
	
	 // Constructor
	 public Cine(int recaudacionTotal,String cuentaCine) {
	     this.asientos = new Asiento[filas][columnas];
	     inicializarAsientos();
	     this.recaudacionTotal = 0;
	     this.CuentaCine=cuentaCine; // Puedes establecer una cuenta bancaria válida
	 }

	 // Métodos
	 private void inicializarAsientos() {
	     for (int i = 0; i < filas; i++) {
	         for (int j = 0; j < columnas; j++) {
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
	     for (int i = 0; i < filas; i++) {
	         for (int j = 0; j < columnas; j++) {
	             if (!asientos[i][j].isOcupado()) {
	                 return false; // si hay algun asiento libre, no esta lleno el cine 
	             }
	         }
	     }
	     return true;
	 }
	
	 public void agregarRecaudacion(int monto) {
	     recaudacionTotal += monto;
	 }
	
	 public void reiniciarAsientos() {
	     for (int i = 0; i < filas; i++) {
	         for (int j = 0; j < columnas; j++) {
	             asientos[i][j].setOcupado(false);
	         }
	     }
	 }
	 //Getters y Setters
	public int getFilas() {
		return filas;
	}
	
	public void setFilas(int filas) {
		this.filas = filas;
	}

	public int getColumnas() {
		return columnas;
	}
	
	public void setColumnas(int columnas) {
		this.columnas = columnas;
	}
	
	public Asiento[][] getAsientos() {
		return asientos;
	}

	public void setAsientos(Asiento[][] asientos) {
		this.asientos = asientos;
	}
	
	public int getRecaudacionTotal() {
		return recaudacionTotal;
	}
	
	public void setRecaudacionTotal(int recaudacionTotal) {
		this.recaudacionTotal = recaudacionTotal;
	}
	
	public String getCuentaCine() {
		return CuentaCine;
	}
	
	public void setCuentaCine(String cuentaCine) {
		CuentaCine = cuentaCine;
	}

}
