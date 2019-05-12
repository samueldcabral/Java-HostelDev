
package dao;

import java.util.List;

//import com.db4o.query.Candidate;
//import com.db4o.query.Evaluation;
import com.db4o.query.Query;

import modelo.Cama;


public class DAOCama  extends DAO<Cama>{

	//Leitura POR id 
	public Cama read (Object chave) {
		String id = (String) chave;
		Query q = manager.query();
		q.constrain(Cama.class);
		q.descend("id").constrain(id);
		List<Cama> resultados = q.execute();
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
	public Cama consultarCamaPorNumero (Object chave) {
		String numero = (String) chave;
		Query q = manager.query();
		q.constrain(Cama.class);
		q.descend("numero").constrain(numero);
		List<Cama> resultados = q.execute();
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

