package modelo;

import java.time.LocalDate;

public class Pessoa{
	protected String nome;
	private LocalDate dataCadastro = LocalDate.now();
	protected String telefone;

	public Pessoa(String nome, String telefone) {
		super();
		this.nome = nome;
		this.telefone = telefone;
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

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", dataCadastro=" + dataCadastro + ", telefone=" + telefone + "]";
	}


}
