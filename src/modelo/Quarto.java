package modelo;

import java.util.ArrayList;

public class Quarto {
	private int numero;
	private ArrayList<Cama> camas = new ArrayList<Cama>();
	
	public Quarto(int numero) {
		super();
		this.numero = numero;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public ArrayList<Cama> getCamas() {
		return this.camas;
	}
	
	public void removerCama(Cama cama) {
		this.camas.add(cama);
	}
	
	public void adicionarCama(Cama cama) {
		this.camas.add(cama);
	}
	
	public Cama localizarCama(Cama cama) {
		for(Cama c : this.camas) {
			if(cama == c) {
				return c;
			}
		}
		return null;
	}
	
	public void remover(Cama c) {
		this.camas.remove(c);
	}
	
	@Override
	public String toString() {
		return "Quarto [ numero=" + numero + ", camas=" + camas + "]";
	}
}