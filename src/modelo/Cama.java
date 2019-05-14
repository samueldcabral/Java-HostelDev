package modelo;

public class Cama {
	private int numero;
	private String tipo;
	private Quarto quarto; 
	private int numeroQuarto;
	
	public Cama(int numero, String tipo) {
		this.numero = numero;
		this.tipo = tipo;
	}

	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public int getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(int numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}
	
	@Override
	public String toString() {
		return "Cama [numero=" + numero + ", tipo=" + tipo + ", numeroQuarto=" + numeroQuarto + "]";
	}

}
