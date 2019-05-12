package modelo;

public class Cama {
	private String id;
	private String numero;
	private String tipo;
	private Quarto quarto; 
	private String nomeQuarto;
	
	public Cama(String id, String numero, String tipo) {
		this.id = id;
		this.numero = numero;
		this.tipo = tipo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getNomeQuarto() {
		return nomeQuarto;
	}

	public void setNomeQuarto(String nomeQuarto) {
		this.nomeQuarto = nomeQuarto;
	}
	
	@Override
	public String toString() {
		return "Cama [id=" + id + ", numero=" + numero + ", tipo=" + tipo + ", Quarto=" + nomeQuarto + "]";
	}

}
