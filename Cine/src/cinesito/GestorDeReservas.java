package cinesito;


public class GestorDeReservas {
	private Cine cine;
	private ProcesadorDePagos procesadorDepagos;
	
	public GestorDeReservas(Cine cine, ProcesadorDePagos procesadorDepagos) {
		this.cine = cine;
		this.procesadorDepagos = procesadorDepagos;
	}
	
	public static void GestorDeReservas() {
	}

	public void intentarReserva(Cliente cliente, int filaDeseada, int columnaDeseada) {
		if(cine.reservarAsiento(filaDeseada, columnaDeseada)==false) {
			
		}
	}
	
	public void buscarAsientoAlternativo(int filaDeseada, int columnaDeseada) {
		
	}
	
	public void procesarReserva(Cliente cliente, int fila, int columna) {
		
	}
	//Getters y Setters
	public Cine getCine() {
		return cine;
	}

	public void setCine(Cine cine) {
		this.cine = cine;
	}

	public ProcesadorDePagos getProcesadorDepagos() {
		return procesadorDepagos;
	}

	public void setProcesadorDepagos(ProcesadorDePagos procesadorDepagos) {
		this.procesadorDepagos = procesadorDepagos;
	}
	
	
	
}


