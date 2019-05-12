
package dao;

import java.util.List;

//import com.db4o.query.Candidate;
//import com.db4o.query.Evaluation;
import com.db4o.query.Query;

import modelo.Funcionario;
import modelo.Hospede;
import modelo.Pessoa;

public class DAOFuncionario  extends DAO<Funcionario>{

	//Leitura POR nome 
	public Funcionario read (Object chave) {
		String nome = (String) chave;
		Query q = manager.query();
		q.constrain(Funcionario.class);
		q.descend("nome").constrain(nome);
		List<Funcionario> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}


	/**********************************************************
	 * 
	 * TODAS AS CONSULTAS DE PESSOA
	 * 
	 **********************************************************/
	public  List<Funcionario> consultarFuncionariosPorParteNome(String caracteres) {
		Query q = manager.query();
		q.constrain(Funcionario.class);
		q.descend("nome").constrain(caracteres).like();
		q.descend("dataCadastro").orderAscending();
		List<Funcionario> result = q.execute(); 
		return result;
	}

	public Funcionario consultarFuncionarioPorNumero(String n){
		Query q = manager.query();
		q.constrain(Pessoa.class);
		q.descend("telefone").constrain(n);
		List<Funcionario> resultados = q.execute();
		if(resultados.size()==0)
			return null;
		else
			return resultados.get(0);
	}
	
	public Funcionario consultarFuncionarioPorMatricula(String matricula) {
		Query q = manager.query();
		q.constrain(Hospede.class);
		q.descend("matricula").constrain(matricula);
		List<Funcionario> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}
}


/*-------------------------------------------------*/
//@SuppressWarnings("serial")
//class Filtro  implements Evaluation {
//	private int n;
//	public Filtro (int n) {this.n=n;}
//	public void evaluate(Candidate candidate) {
//		Pessoa p = (Pessoa) candidate.getObject();
//		candidate.include( p.getTelefones().size()==n);
//	}
//	private boolean compara(Pessoa p, int n) {
//		return p.getTelefones().size()==n;
//	}
//}

