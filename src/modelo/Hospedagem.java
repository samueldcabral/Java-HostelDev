package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Hospedagem {
	private LocalDate dataCriacao = LocalDate.now();
	private String id;
	private Hospede hospede;
	private ArrayList<Produto> produtos = new ArrayList<Produto>();
	private Funcionario funcionario;
	private Quarto quarto;
	private Cama cama;
	
	public Hospedagem(String id, Hospede hospede, Funcionario funcionario, Quarto quarto, Cama cama) {
		super();
		this.id = id;
		this.hospede = hospede;
		this.funcionario = funcionario;
		this.quarto = quarto;
		this.cama = cama;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Hospede getHospede() {
		return hospede;
	}

	public void setHospede(Hospede hospede) {
		this.hospede = hospede;
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Produto produto) {
		this.produtos.add(produto);
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	public Cama getCama() {
		return cama;
	}

	public void setCama(Cama cama) {
		this.cama = cama;
	}

	@Override
	public String toString() {
		return "Hospedagem [dataCriacao=" + dataCriacao + ", id=" + id + ", hospede=" + hospede + ", produtos="
				+ produtos + ", funcionario=" + funcionario + ", quarto=" + quarto + ", cama=" + cama + "]";
	}
	
}
