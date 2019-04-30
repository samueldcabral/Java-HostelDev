package modelo;

import java.util.ArrayList;

public class Quarto {
	private String id;
	private String numero;
	private ArrayList<Cama> camas = new ArrayList<Cama>();
	
	public Quarto(String id, String numero) {
		super();
		this.id = id;
		this.numero = numero;
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

	public ArrayList<Cama> getCamas() {
		return this.camas;
	}
	
	public void adicionarCama(Cama cama) {
		this.camas.add(cama);
	}

	@Override
	public String toString() {
		return "Quarto [ id=" + id + ", numero=" + numero + ", camas=" + camas + "]";
	}
	
	
}