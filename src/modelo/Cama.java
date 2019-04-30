package modelo;

public class Cama {
	private String id;
	private String numero;
	private String tipo;
	
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

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Cama [ id =  " + id + ", numero = " + numero + ", tipo = " + tipo + " ]";
	}
	
	
}
