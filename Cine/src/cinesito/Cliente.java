package cinesito;

//Clase Cliente
//Clase Cliente
public class Cliente implements Runnable {
 private String nombre;
 private String apellidos;
 private String correo;
 private String cuentaBancaria;
 private int fondos;
 private GestorDeReservas gestorDeReservas;
 private int filaDeseada;
 private int columnaDeseada;

 // Constructor
 public Cliente(String nombre, String apellidos, String correo, String cuentaBancaria, int fondos,
                GestorDeReservas gestorDeReservas, int filaDeseada, int columnaDeseada) {
     this.nombre = nombre;
     this.apellidos = apellidos;
     this.correo = correo;
     this.cuentaBancaria = cuentaBancaria;
     this.fondos = fondos;
     this.gestorDeReservas = gestorDeReservas;
     this.filaDeseada = filaDeseada;
     this.columnaDeseada = columnaDeseada;
 }

 // Método run para la lógica del hilo del cliente
 @Override
 public void run() {
     // Lógica de reserva
     gestorDeReservas.intentarReservar(this, filaDeseada, columnaDeseada);
 }

 // Getters y Setters
 // (Opcional: puedes agregar más métodos según sea necesario)
}


