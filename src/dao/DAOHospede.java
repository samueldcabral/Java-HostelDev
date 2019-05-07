/**IFPB - Curso SI - Disciplina de POB
 * @author Prof Fausto Ayres
 */
package dao;

import java.util.List;

//import com.db4o.query.Candidate;
//import com.db4o.query.Evaluation;
import com.db4o.query.Query;

import modelo.Hospede;
import modelo.Pessoa;

public class DAOHospede  extends DAO<Hospede>{

	//Leitura POR nome 
	public Hospede read (Object chave) {
		String nome = (String) chave;
		Query q = manager.query();
		q.constrain(Hospede.class);
		q.descend("nome").constrain(nome);
		List<Hospede> resultados = q.execute();
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
	public  List<Hospede> consultarHospedesPorParteNome(String caracteres) {
		Query q = manager.query();
		q.constrain(Hospede.class);
		q.descend("nome").constrain(caracteres).like();
		q.descend("dataCadastro").orderAscending();
		List<Hospede> result = q.execute(); 
		return result;
	}

//	public List<Pessoa>  consultarPessoasNTelefones(int n) {
//		Query q = manager.query();
//		q.constrain(Pessoa.class);
//		q.constrain(new Filtro(n));
//		List<Pessoa> result = q.execute(); 
//		return result;
//	}

	public Hospede consultarPessoaPorNumero(String n){
		Query q = manager.query();
		q.constrain(Pessoa.class);
		q.descend("telefone").constrain(n);
		List<Hospede> resultados = q.execute();
		if(resultados.size()==0)
			return null;
		else
			return resultados.get(0);
	}
	
	public Hospede consultarHospedePorId(String id) {
		Query q = manager.query();
		q.constrain(Hospede.class);
		q.descend("id").constrain(id);
		List<Hospede> resultados = q.execute();
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

