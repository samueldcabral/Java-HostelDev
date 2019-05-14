
package dao;

import java.util.List;

//import com.db4o.query.Candidate;
//import com.db4o.query.Evaluation;
import com.db4o.query.Query;

import modelo.Cama;
import modelo.Funcionario;
import modelo.Hospedagem;
import modelo.Hospede;
import modelo.Produto;
import modelo.Quarto;

public class DAOHospedagem  extends DAO<Hospedagem>{

	//Leitura POR id 
	public Hospedagem read (Object chave) {
		int id = (Integer) chave;
		Query q = manager.query();
		q.constrain(Hospedagem.class);
		q.descend("id").constrain(id);
		List<Hospedagem> resultados = q.execute();
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
	public  List<Produto> consultarProdutosDaHospedagem(Object chave) {
		String id = (String) chave;
		Query q = manager.query();
		q.constrain(Hospedagem.class);
		q.descend("id").constrain(id);
		List<Hospedagem> resultados = q.execute();
		if (resultados.size()>0) {
			Hospedagem hospedagem = resultados.get(0);
			return hospedagem.getProdutos();
		}
		else
			return null;
	}
	
	public Quarto consultarQuartoDaHospedagem(Object chave) {
		String id = (String) chave;
		Query q = manager.query();
		q.constrain(Hospedagem.class);
		q.descend("id").constrain(id);
		List<Hospedagem> resultados = q.execute();
		if (resultados.size()>0) {
			Hospedagem hospedagem = resultados.get(0);
			return hospedagem.getQuarto();
		}
		else
			return null;
	}
	
	public Cama consultarCamaDaHospedagem(Object chave) {
		String id = (String) chave;
		Query q = manager.query();
		q.constrain(Hospedagem.class);
		q.descend("id").constrain(id);
		List<Hospedagem> resultados = q.execute();
		if (resultados.size()>0) {
			Hospedagem hospedagem = resultados.get(0);
			return hospedagem.getCama();
		}
		else
			return null;
	}
	
	public Funcionario consultarFuncionarioDaHospedagem(Object chave) {
		String id = (String) chave;
		Query q = manager.query();
		q.constrain(Hospedagem.class);
		q.descend("id").constrain(id);
		List<Hospedagem> resultados = q.execute();
		if (resultados.size()>0) {
			Hospedagem hospedagem = resultados.get(0);
			return hospedagem.getFuncionario();
		}
		else
			return null;
	}
	
	public Hospede consultarHospedeDaHospedagem(Object chave) {
		String id = (String) chave;
		Query q = manager.query();
		q.constrain(Hospedagem.class);
		q.descend("id").constrain(id);
		List<Hospedagem> resultados = q.execute();
		if (resultados.size()>0) {
			Hospedagem hospedagem = resultados.get(0);
			return hospedagem.getHospede();
		}
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

