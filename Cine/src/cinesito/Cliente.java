package cinesito;

//Clase Cliente
public class Cliente extends Thread {
 private String nombre;
 private String apellidos;
 private String correo;
 private String cuentaBancaria;
 private int fondos;
 private GestorDeReservas gestorDeReservas;
 private int filaDeseada;
 private int columnaDeseada;

 // Constructor
 public Cliente(String nombre, String apellidos, String correo, String cuentaBancaria, int fondos, GestorDeReservas gestorDeReservas) {
     this.nombre = nombre;
     this.apellidos = apellidos;
     this.correo = correo;
     this.cuentaBancaria = cuentaBancaria;
     this.fondos = fondos;
     this.gestorDeReservas = gestorDeReservas;
 }

 // Run method
 @Override
 public void run() {
     while (true) { // Simulación continua de clientes
         // Genera datos aleatorios para la ubicación del asiento deseado
         filaDeseada = (int) (Math.random() * gestorDeReservas.getNumFilas()) + 1;
         columnaDeseada = (int) (Math.random() * gestorDeReservas.getNumColumnas()) + 1;

         // Intenta reservar un asiento
         gestorDeReservas.intentarReservar(this, filaDeseada, columnaDeseada);

         // Espera un tiempo antes de realizar otra reserva (simula la concurrencia)
         try {
             Thread.sleep((int) (Math.random() * 500) + 500);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     }
 }

 // Getters y setters
 public String getNombre() {
     return nombre;
 }

 public String getApellidos() {
     return apellidos;
 }

 public String getCorreo() {
     return correo;
 }

 public String getCuentaBancaria() {
     return cuentaBancaria;
 }

 public int getFondos() {
     return fondos;
 }

 public void setFondos(int fondos) {
     this.fondos = fondos;
 }

 public int getFilaDeseada() {
     return filaDeseada;
 }

 public int getColumnaDeseada() {
     return columnaDeseada;
 }

 // Otros métodos según sea necesario
}

