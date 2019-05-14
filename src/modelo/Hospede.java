package modelo;

import java.util.ArrayList;

public class Hospede extends Pessoa{
	private int id;
	private ArrayList<Hospedagem> hospedagens = new ArrayList<Hospedagem>();
	private ArrayList<Integer> idHospedagens = new ArrayList<Integer>();
	
	public Hospede(int id, String nome, String telefone) {
		super(nome, telefone);
		// TODO Auto-generated constructor stub
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void adicionarHospedagem(Hospedagem h) {
		this.hospedagens.add(h);
	}
	
	public ArrayList<Hospedagem> getHospedagens() {
		return hospedagens;
	}

	public void setHospedagens(ArrayList<Hospedagem> hospedagens) {
		this.hospedagens = hospedagens;
	}

	public void removerHospedagem(Hospedagem h) {
		this.hospedagens.remove(h);
	}
	
	public ArrayList<Integer> getIdHospedagens() {
		return idHospedagens;
	}

	public void setIdHospedagens(int idHospedagens) {
		this.idHospedagens.add(idHospedagens);
	}
	
	@Override
	public String toString() {
		return "Hospede [id=" + id + ", idHospedagens=" + idHospedagens + ", nome=" + nome + ", telefone=" + telefone
				+ "]";
	}
}
