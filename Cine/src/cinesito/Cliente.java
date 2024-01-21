package cinesito;

public class Cliente extends Thread{
	//Atributos
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
	//Logica para reservar
	@Override
	public void run() {
		
		
	}
	public static void Cliente() {
		
	}
	
	//Getters y Setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getCuentaBancaria() {
		return cuentaBancaria;
	}
	public void setCuentaBancaria(String cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}
	public int getFondos() {
		return fondos;
	}
	public void setFondos(int fondos) {
		this.fondos = fondos;
	}
	public GestorDeReservas getGestorDeReservas() {
		return gestorDeReservas;
	}
	public void setGestorDeReservas(GestorDeReservas gestorDeReservas) {
		this.gestorDeReservas = gestorDeReservas;
	}
	public int getFilaDeseada() {
		return filaDeseada;
	}
	public void setFilaDeseada(int filaDeseada) {
		this.filaDeseada = filaDeseada;
	}
	public int getColumnaDeseada() {
		return columnaDeseada;
	}
	public void setColumnaDeseada(int columnaDeseada) {
		this.columnaDeseada = columnaDeseada;
	}
	
	
}
