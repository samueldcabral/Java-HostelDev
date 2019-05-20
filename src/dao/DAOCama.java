
package dao;

import java.util.List;

//import com.db4o.query.Candidate;
//import com.db4o.query.Evaluation;
import com.db4o.query.Query;

import modelo.Cama;


public class DAOCama  extends DAO<Cama>{

	//Leitura POR id 
	public Cama read (Object chave) {
		int id = (Integer) chave;
		Query q = manager.query();
		q.constrain(Cama.class);
		q.descend("numero").constrain(id);
		List<Cama> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}
	
	

}