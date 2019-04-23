/**IFPB - Curso SI - Disciplina de POB
 * @author Prof Fausto Ayres
 */
package dao;


import java.util.List;

import com.db4o.query.Query;

import modelo.Telefone;

public class DAOTelefone  extends DAO<Telefone>{
	//Leitura POR numero 
	public Telefone read (Object chave) {
		String num = (String) chave;
		Query q = manager.query();
		q.constrain(Telefone.class);
		q.descend("numero").constrain(num);
		List<Telefone> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}
	
	
	/**********************************************************
	 * 
	 * TODAS AS CONSULTAS DE TELEFONE
	 * 
	 **********************************************************/
	public List<Telefone> consultarTelefonesPorPrefixo(String prefixo) {
		Query q = manager.query();
		q.constrain(Telefone.class);
		q.descend("numero").constrain(prefixo).startsWith(true);
		//q.descend("pessoa").descend("nome").orderDescending();
		List<Telefone> result = q.execute(); 
		return result;
	}

	public List<Telefone> consultarTelefonesPorNome(String nome) {
		Query q = manager.query();
		q.constrain(Telefone.class);
		q.descend("pessoa").descend("nome").constrain(nome);
		List<Telefone> result = q.execute(); 
		return result;
	}


}
