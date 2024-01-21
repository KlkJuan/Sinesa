package cinesito;

public class ProcesadorDePagos {
	//Atributo
	private Cine cine;
	private int entrada=10;
	//Constructor
	public ProcesadorDePagos(Cine cine) {
		
		this.cine = cine;
	}
	
	public static void ProcesadorDePagos() {
	}
	
	//Metodos
	public boolean procesarPago(String cuentaCliente,int fondosCliente) {
		if(fondosCliente>=entrada) {
			this.cine.agregarRecaudacion(entrada);
			System.out.println("Se ha realizado el pago correctamente");
		}
		System.out.println("Fallo en el pago");
		return false;
	}
	
	//Getters y Setters
	public Cine getCine() {
		return cine;
	}

	public void setCine(Cine cine) {
		this.cine = cine;
	}

	public int getEntrada() {
		return entrada;
	}

	public void setEntrada(int entrada) {
		this.entrada = entrada;
	}
	
	
}	


