

package dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;
//import com.db4o.cs.Db4oClientServer;
//import com.db4o.cs.config.ClientConfiguration;
import com.db4o.query.Query;

import modelo.Cama;
import modelo.Funcionario;
import modelo.Hospedagem;
import modelo.Hospede;
import modelo.Pessoa;
import modelo.Produto;
import modelo.Quarto;


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
		//Pessoa
		config.common().objectClass(Pessoa.class).cascadeOnUpdate(true);
		config.common().objectClass(Pessoa.class).cascadeOnDelete(true);
		config.common().objectClass(Pessoa.class).cascadeOnActivate(true);
		
		//Funcionario
		config.common().objectClass(Funcionario.class).cascadeOnUpdate(true);
		config.common().objectClass(Funcionario.class).cascadeOnDelete(true);
		config.common().objectClass(Funcionario.class).cascadeOnActivate(true);
		
		//Hospede
		config.common().objectClass(Hospede.class).cascadeOnUpdate(true);
		config.common().objectClass(Hospede.class).cascadeOnDelete(true);
		config.common().objectClass(Hospede.class).cascadeOnActivate(true);
		
		//Quarto
		config.common().objectClass(Quarto.class).cascadeOnUpdate(true);
		config.common().objectClass(Quarto.class).cascadeOnDelete(true);
		config.common().objectClass(Quarto.class).cascadeOnActivate(true);
		
		//Cama
		config.common().objectClass(Cama.class).cascadeOnUpdate(true);
		config.common().objectClass(Cama.class).cascadeOnDelete(true);
		config.common().objectClass(Cama.class).cascadeOnActivate(true);
		
		//Produto
		config.common().objectClass(Produto.class).cascadeOnUpdate(true);
		config.common().objectClass(Produto.class).cascadeOnDelete(true);
		config.common().objectClass(Produto.class).cascadeOnActivate(true);
		
		//Hospedagem
		config.common().objectClass(Hospedagem.class).cascadeOnUpdate(true);
		config.common().objectClass(Hospedagem.class).cascadeOnDelete(true);
		config.common().objectClass(Hospedagem.class).cascadeOnActivate(true);
		
		//indexacao de atributos
		config.common().objectClass(Pessoa.class).objectField("id").indexed(true);
		config.common().objectClass(Pessoa.class).objectField("nome").indexed(true);
		manager = 	Db4oEmbedded.openFile(config, "banco.db4o");
	}

//	public static void abrirBancoServidor(){
//		ClientConfiguration config = Db4oClientServer.newClientConfiguration( ) ;
//		config.common().messageLevel(0);   //0,1,2,3,4
//		config.common().objectClass(Pessoa.class).cascadeOnUpdate(true);
//		config.common().objectClass(Pessoa.class).cascadeOnDelete(true);
//		config.common().objectClass(Pessoa.class).cascadeOnActivate(true);
//		config.common().objectClass(Aluno.class).cascadeOnUpdate(true);
//		config.common().objectClass(Aluno.class).cascadeOnDelete(true);
//		config.common().objectClass(Aluno.class).cascadeOnActivate(true);
//		// 		indexacao de atributos
//		config.common().objectClass(Pessoa.class).objectField("id").indexed(true);
//		config.common().objectClass(Pessoa.class).objectField("nome").indexed(true);
//
//		manager = Db4oClientServer.openClient(config,"10.0.4.179",34000,"usuario1","senha1");	
//		//manager = Db4oClientServer.openClient(config,"localhost",34000,"usuario1","senha1");
//	}

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

	//--------transação---------------
	public static void begin(){	
	}		// tem que ser vazio

	public static void commit(){
		manager.commit();
	}
	public static void rollback(){
		manager.rollback();
	}



}

