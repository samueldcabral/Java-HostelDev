package modelo;

public class Funcionario extends Pessoa {
	private int matricula;
	private double salario;
	
	public Funcionario(String nome, String telefone, int matricula, double salario) {
		super(nome, telefone);
		
		this.matricula = matricula;
		this.salario = salario;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Funcionario [matricula = " + matricula + ", salario = " + salario + ", nome = " + nome + ", telefone = " + telefone + "]";
	}
	
}
