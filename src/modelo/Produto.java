package modelo;

import java.util.ArrayList;

public class Produto {
	private String id;
	private String nome;
	private String descricao;
	private double valor;
	private ArrayList<Hospedagem> hospedagens = new ArrayList<Hospedagem>();
	private ArrayList<String> idHospedagens = new ArrayList<String>();
	
	public Produto(String id, String nome, String descricao, double valor) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public ArrayList<Hospedagem> getHospedagens() {
		return hospedagens;
	}

	public void setHospedagens(Hospedagem h) {
		this.hospedagens.add(h);
	}
	
	public void removerHospedagens(Hospedagem h) {
		this.hospedagens.remove(h);
	}
	
//	public ArrayList<Hospedagem> getHospedagens() {
//		return hospedagens;
//	}

//	public void setHospedagem(Hospedagem hosps) {
//		System.out.println("cabral");
//		this.hospedagens.remove(hosps);
//		System.out.println("samuel");
//	}
	

	public ArrayList<String> getIdHospedagens() {
		return idHospedagens;
	}

	public void setIdHospedagens(String idHospedagens) {
		this.idHospedagens.add(idHospedagens);
	}

	public void setHospedagens(ArrayList<Hospedagem> hospedagens) {
		this.hospedagens = hospedagens;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", valor=" + valor
				+ ", idHospedagens=" + idHospedagens + "]";
	}	
}
