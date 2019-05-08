package modelo;

import java.util.ArrayList;

public class Hospede extends Pessoa{
	private String id;
	private ArrayList<Hospedagem> hospedagens = new ArrayList<Hospedagem>();
	
	public Hospede(String nome, String telefone, String id) {
		super(nome, telefone);
		// TODO Auto-generated constructor stub
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public void adicionarHospedagem(Hospedagem h) {
		this.hospedagens.add(h);
	}
	
	public void removerHospedagem(Hospedagem h) {
		this.hospedagens.remove(h);
	}
	
	@Override
	public String toString() {
		return "Hospede [ id = " + id + ", nome = " + nome + ", telefone = " + telefone + " ]";
	}
}
