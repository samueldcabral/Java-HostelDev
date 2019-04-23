package modelo;

/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */
public class Funcionario extends Pessoa {
	private String matricula;
	private double salario;
	
	public Funcionario(String nome, String matricula, double salario) {
		super(nome);
		// TODO Auto-generated constructor stub
		
		this.matricula = matricula;
		this.salario = salario;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
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
		return "Funcionario [ matricula = " + matricula + ", salario = " + salario + ", nome = " + nome + " ]";
	}
	
	

}
