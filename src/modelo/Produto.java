package modelo;

import java.util.ArrayList;

public class Produto {
	private String id;
	private String nome;
	private String descricao;
	private double valor;
	private ArrayList<Hospedagem> hospedagens;
	


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

	public void setHospedagem(Hospedagem hospedagens) {
		this.hospedagens.add(hospedagens);
	}
	
	public void removerHospedagem(Hospedagem hospedagem) {
		this.hospedagens.remove(hospedagem);
	}
	@Override
	public String toString() {
		return "Produto [ id = " + id + ", nome = " + nome + ", descricao = " + descricao + ", valor = " + valor + " ]";
	}	
}
