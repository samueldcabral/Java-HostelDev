/**IFPB - Curso SI - Disciplina de POB
 * @author Prof Fausto Ayres
 */
package dao;

import java.util.List;

//import com.db4o.query.Candidate;
//import com.db4o.query.Evaluation;
import com.db4o.query.Query;

import modelo.Produto;


public class DAOProduto  extends DAO<Produto>{

	//Leitura POR nome 
	public Produto read (Object chave) {
		String nome = (String) chave;
		Query q = manager.query();
		q.constrain(Produto.class);
		q.descend("nome").constrain(nome);
		List<Produto> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}


	/**********************************************************
	 * 
	 * TODAS AS CONSULTAS DE PRODUTO
	 * 
	 **********************************************************/
//	public Produto consultarQuartoPorNumero (Object chave) {
//		String numero = (String) chave;
//		Query q = manager.query();
//		q.constrain(Produto.class);
//		q.descend("numero").constrain(numero);
//		List<Produto> resultados = q.execute();
//		if (resultados.size()>0)
//			return resultados.get(0);
//		else
//			return null;
//	}
//	
//	public List<Cama> consultarCamasDoQuarto (Object numero) {
//		String num = (String) numero;
//		Query q = manager.query();
//		q.constrain(Produto.class);
//		q.descend("numero").constrain(num);
//		List<Produto> resultados = q.execute();
//		if (resultados.size()>0) {
//			Produto quarto = resultados.get(0);
//			return quarto.getCamas();
//		}
//		else
//			return null;
//		
//	}
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

