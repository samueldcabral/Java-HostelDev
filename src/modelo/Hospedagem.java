package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Hospedagem {
	private LocalDate dataCriacao = LocalDate.now();
	private int id;
	private Hospede hospede;
	private ArrayList<Produto> produtos = new ArrayList<Produto>();
	private Funcionario funcionario;
	private Quarto quarto;
	private Cama cama;
	private Boolean statusHospedagem = true;
	
	public Hospedagem(int id, Hospede hospede, Funcionario funcionario, Quarto quarto, Cama cama) {
		super();
		this.id = id;
		this.hospede = hospede;
		this.funcionario = funcionario;
		this.quarto = quarto;
		this.cama = cama;
	}

	public Boolean getStatusHospedagem() {
		return statusHospedagem;
	}

	public void setStatusHospedagem(Boolean statusHospedagem) {
		this.statusHospedagem = statusHospedagem;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
	
	public void removerProduto(Produto p) {
		this.produtos.remove(p);
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
