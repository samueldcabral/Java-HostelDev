package modelo;

public class Hospede extends Pessoa{
	private String id;
	
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

	@Override
	public String toString() {
		return "Hospede [ id = " + id + ", nome = " + nome + ", telefone = " + telefone + " ]";
	}
}
