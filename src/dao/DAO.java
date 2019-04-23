/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Persistencia de Objetos
 * Prof. Fausto Maranh�o Ayres
 **********************************/

package dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.cs.Db4oClientServer;
import com.db4o.cs.config.ClientConfiguration;
import com.db4o.query.Query;

import modelo.Aluno;
import modelo.Pessoa;


public abstract class DAO<T> implements DAOInterface<T> {
	protected static ObjectContainer manager;

	public static void open(){	
		if(manager==null){		
			abrirBancoLocal();
			//abrirBancoServidor();
		}
	}
	public static void abrirBancoLocal(){		
		//Backup.criar("banco.db4o");		//criar uma copia do banco
		//new File("banco.db4o").delete();  //apagar o banco
		EmbeddedConfiguration config =  Db4oEmbedded.newConfiguration(); 
		config.common().messageLevel(0);  // 0,1,2,3...
		config.common().objectClass(Pessoa.class).cascadeOnUpdate(true);
		config.common().objectClass(Pessoa.class).cascadeOnDelete(true);
		config.common().objectClass(Pessoa.class).cascadeOnActivate(true);
		config.common().objectClass(Aluno.class).cascadeOnUpdate(true);
		config.common().objectClass(Aluno.class).cascadeOnDelete(true);
		config.common().objectClass(Aluno.class).cascadeOnActivate(true);
		// 		indexacao de atributos
		config.common().objectClass(Pessoa.class).objectField("id").indexed(true);
		config.common().objectClass(Pessoa.class).objectField("nome").indexed(true);
		manager = 	Db4oEmbedded.openFile(config, "banco.db4o");
	}

	public static void abrirBancoServidor(){
		ClientConfiguration config = Db4oClientServer.newClientConfiguration( ) ;
		config.common().messageLevel(0);   //0,1,2,3,4
		config.common().objectClass(Pessoa.class).cascadeOnUpdate(true);
		config.common().objectClass(Pessoa.class).cascadeOnDelete(true);
		config.common().objectClass(Pessoa.class).cascadeOnActivate(true);
		config.common().objectClass(Aluno.class).cascadeOnUpdate(true);
		config.common().objectClass(Aluno.class).cascadeOnDelete(true);
		config.common().objectClass(Aluno.class).cascadeOnActivate(true);
		// 		indexacao de atributos
		config.common().objectClass(Pessoa.class).objectField("id").indexed(true);
		config.common().objectClass(Pessoa.class).objectField("nome").indexed(true);

		manager = Db4oClientServer.openClient(config,"10.0.4.179",34000,"usuario1","senha1");	
		//manager = Db4oClientServer.openClient(config,"localhost",34000,"usuario1","senha1");
	}

	public static void close(){
		if(manager!=null) {
			manager.close();
			manager=null;
		}
	}

	//----------CRUD-----------------------

	public void create(T obj){
		manager.store( obj );
	}

	public abstract T read(Object chave);

	public T update(T obj){
		manager.store(obj);
		return obj;
	}

	public void delete(T obj) {
		manager.delete(obj);
	}

	public void refresh(T obj){
		manager.ext().refresh(obj, Integer.MAX_VALUE);
	}

	@SuppressWarnings("unchecked")
	public List<T> readAll(){
		Class<T> type = (Class<T>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		Query q = manager.query();
		q.constrain(type);
		return (List<T>) q.execute();
	}

	//--------transa��o---------------
	public static void begin(){	
	}		// tem que ser vazio

	public static void commit(){
		manager.commit();
	}
	public static void rollback(){
		manager.rollback();
	}



}

