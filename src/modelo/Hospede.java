package modelo;

public class Hospede extends Pessoa{
	private String id;
	
	public Hospede(String nome, String id) {
		super(nome);
		// TODO Auto-generated constructor stub
		this.id = id;
	}

	@Override
	public String toString() {
		return "Hospede [ id = " + id + ", nome = " + nome + " ]";
	}
	
}
