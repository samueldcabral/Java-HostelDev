
package dao;

import java.util.List;

//import com.db4o.query.Candidate;
//import com.db4o.query.Evaluation;
import com.db4o.query.Query;

import modelo.Hospedagem;
import modelo.Hospede;
import modelo.Pessoa;
import modelo.Produto;

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
	
//	--------------------------------------
//	---- MINHAS CONSULTAS ---
	public List<Hospede> consultarHospedePorQuarto(Object chave) {
		//String nome = (String) chave;
		int id = (Integer) chave;
		Query q = manager.query();
		q.constrain(Hospede.class);
		q.descend("hospedagens").descend("quarto").descend("numero").constrain(id);
		List<Hospede> resultados = q.execute();
		
		if (resultados.size()>0)
			return resultados;
		else
			return null;
	}
	
	public List<Hospede> consultarHospedePorProduto(Object chave) {
		String nome = (String) chave;
		//int id = (Integer) chave;
		Query q = manager.query();
		q.constrain(Hospede.class);
		q.descend("hospedagens").descend("produtos").descend("nome").constrain(nome);
		List<Hospede> resultados = q.execute();
		
		if (resultados.size()>0)
			return resultados;
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

