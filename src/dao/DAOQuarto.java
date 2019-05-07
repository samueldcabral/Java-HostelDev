/**IFPB - Curso SI - Disciplina de POB
 * @author Prof Fausto Ayres
 */
package dao;

import java.util.List;

//import com.db4o.query.Candidate;
//import com.db4o.query.Evaluation;
import com.db4o.query.Query;

import modelo.Cama;
import modelo.Quarto;


public class DAOQuarto  extends DAO<Quarto>{

	//Leitura POR id 
	public Quarto read (Object chave) {
		String id = (String) chave;
		Query q = manager.query();
		q.constrain(Quarto.class);
		q.descend("id").constrain(id);
		List<Quarto> resultados = q.execute();
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
	public Quarto consultarQuartoPorNumero (Object chave) {
		String numero = (String) chave;
		Query q = manager.query();
		q.constrain(Quarto.class);
		q.descend("numero").constrain(numero);
		List<Quarto> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}
	
	public List<Cama> consultarCamasDoQuarto (Object numero) {
		String num = (String) numero;
		Query q = manager.query();
		q.constrain(Quarto.class);
		q.descend("numero").constrain(num);
		List<Quarto> resultados = q.execute();
		if (resultados.size()>0) {
			Quarto quarto = resultados.get(0);
			return quarto.getCamas();
		}
		else
			return null;
		
	}
//	public List<Pessoa>  consultarPessoasNTelefones(int n) {
//		Query q = manager.query();
//		q.constrain(Pessoa.class);
//		q.constrain(new Filtro(n));
//		List<Pessoa> result = q.execute(); 
//		return result;
//	}


	
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

