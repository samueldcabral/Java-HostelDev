package modelo;

import java.time.LocalDate;

public class Pessoa{
	protected String nome;
	private LocalDate dataCadastro;
	protected String telefone;
	


	public Pessoa(String nome, String telefone) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.dataCadastro = LocalDate.now();
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", dataCadastro=" + dataCadastro + ", telefone=" + telefone + "]";
	}
}
