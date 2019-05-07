/**IFPB - Curso SI - Disciplina de PERSISTENCIA DE OBJETOS
 * @author Prof Fausto Ayres
 */

package fachada;

import java.util.List;

import dao.DAO;
import dao.DAOAluno;
import dao.DAOCama;
import dao.DAOFuncionario;
import dao.DAOHospedagem;
import dao.DAOHospede;
import dao.DAOPessoa;
import dao.DAOProduto;
import dao.DAOQuarto;
import dao.DAOTelefone;
import modelo.Aluno;
import modelo.Cama;
import modelo.Funcionario;
import modelo.Hospedagem;
import modelo.Hospede;
import modelo.Pessoa;
import modelo.Produto;
import modelo.Professor;
import modelo.Quarto;
import modelo.Telefone;

public class Fachada {
	private static DAOPessoa daopessoa = new DAOPessoa();  
	private static DAOHospede daohospede = new DAOHospede();  
	private static DAOFuncionario daofuncionario = new DAOFuncionario();
	private static DAOCama daocama = new DAOCama();
	private static DAOHospedagem daohospedagem = new DAOHospedagem();
	private static DAOProduto daoproduto = new DAOProduto();
	private static DAOQuarto daoquarto = new DAOQuarto();

	public static void inicializar(){
		DAO.open();
	}
	public static void finalizar(){
		DAO.close();
	}

	// CADASTRAR
	
	public static Pessoa cadastrarPessoa(String nome, String telefone) throws  Exception{
		DAO.begin();	
		Pessoa p = daopessoa.read(nome);
		if(p != null)
			throw new Exception("cadastrar pessoa - pessoa ja cadastrada: " + nome);

		p = new Pessoa(nome, telefone);
		daopessoa.create(p);	
		DAO.commit();
		return p;
	}	

	public static Hospede cadastrarHospede(String id, String nome, String telefone) throws  Exception{
		DAO.begin();	
		Pessoa p = daopessoa.read(nome);
		if(p != null)
			throw new Exception("cadastrar hospede - pessoa ja cadastrado:" + nome);

		p = new Hospede(id, nome, telefone);
		daopessoa.create(p);	
		DAO.commit();
		return (Hospede) p;
	}

	public static Funcionario cadastrarFuncionario(String matricula, String nome, String telefone, double salario) throws  Exception{
		DAO.begin();	
		Pessoa p = daopessoa.read(nome);
		if(p != null)
			throw new Exception("cadastrar Funcionario - pessoa ja cadastrado:" + nome);

		p = new Funcionario(matricula, nome, telefone, salario);
		daopessoa.create(p);	
		DAO.commit();
		return (Funcionario) p;
	}
	
	public static Cama cadastrarCama(String id, String numero, String tipo) throws  Exception{
		DAO.begin();	
		Cama c = daocama.read(id);
		if(c != null)
			throw new Exception("cadastrar Cama - Cama ja cadastrado:" + c);

		c = new Cama(id, numero, tipo);
		daocama.create(c);	
		DAO.commit();
		return (Cama) c;
	}
	
	public static Quarto cadastrarQuarto(String id, String numero) throws  Exception{
		DAO.begin();	
		Quarto c = daoquarto.read(id);
		if(c != null)
			throw new Exception("cadastrar Quarto - Quarto ja cadastrado:" + c);

		c = new Quarto(id, numero);
		daoquarto.create(c);	
		DAO.commit();
		return (Quarto) c;
	}

	public static Produto cadastrarProduto(String id, String nome, String descricao, double valor) throws  Exception{
		DAO.begin();	
		Produto p = daoproduto.read(id);
		if(p != null)
			throw new Exception("cadastrar Produto - Produto ja cadastrado:" + c);

		p = new Produto(id, nome, descricao, valor);
		daoproduto.create(p);	
		DAO.commit();
		return (Produto) p;
	}
	
	public static Hospedagem cadastrarHospedagem(String id, Hospede hospede, Funcionario funcionario, Quarto quarto, Cama cama) throws  Exception{
		DAO.begin();	
		Hospedagem h = daohospedagem.read(id);
		if(h != null)
			throw new Exception("cadastrar Hospedagem - Hospedagem ja cadastrado:" + c);

		h = new Hospedagem(id, hospede, funcionario, quarto, cama);
		daohospedagem.create(h);	
		DAO.commit();
		return (Hospedagem) h;
	}
	
	//ADICIONAR TODO
	public static Telefone adicionarTelefonePessoa(String nome, String numero) 
			throws  Exception{
		DAO.begin();	
		Pessoa p = daopessoa.read(nome);
		if(p == null)
			throw new Exception("adicionar telefone - pessoa nao cadastrada:" + nome);

		Telefone t = daotelefone.read(numero);
		if(t != null)
			throw new Exception("adicionar telefone - telefone ja cadastrado:" + nome);

		t = new Telefone(numero);
		p.adicionar(t);
		daopessoa.update(p);	
		DAO.commit();
		return t;
	}

	public static Telefone excluirTelefonePessoa(String nome, String numero) 
			throws  Exception{
		DAO.begin();	
		Pessoa p = daopessoa.read(nome);
		if(p == null)
			throw new Exception("excluir telefone - pessoa nao cadastrada:" + nome);

		Telefone t = daotelefone.read(numero);
		if(t == null)
			throw new Exception("excluir telefone - telefone nao cadastrado:" + nome);

		t = p.localizar(numero);
		if(t == null)
			throw new Exception("excluir telefone - pessoa nao possui este telefone:" + nome);

		p.remover(t);
		daopessoa.update(p);	
		daotelefone.delete(t);	//excluir orfao
		DAO.commit();
		return t;
	}

	public static void alterarPessoa(String nome, String novonome) throws Exception{
		DAO.begin();		
		Pessoa p = daopessoa.read(nome);	
		if (p==null)
			throw new Exception("alterar pessoa - nome inexistente:" + nome);

		p.setNome(novonome); 			
		p=daopessoa.update(p);     	
		DAO.commit();	
	}

	public static void alterarTelefone(String numero, String novonumero) throws Exception{
		DAO.begin();		
		Telefone t = daotelefone.read(numero);	
		if (t==null) 
			throw new Exception("alterar telefone - numero inexistente:" + numero);

		Telefone t2 = daotelefone.read(novonumero);	
		if (t2!=null) 
			throw new Exception("alterar telefone - numero ja existe:" + novonumero);

		t.setNumero(novonumero); 			
		t=daotelefone.update(t);     	
		DAO.commit();	
	}


	public static void excluirPessoa(String n) throws Exception {
		DAO.begin();
		Pessoa p = daopessoa.read(n);
		if (p==null) 
			throw new Exception("excluir pessoa - nome inexistente:" + n);

		daopessoa.delete(p);
		DAO.commit();
	}


	public void excluirPessoaManualmente(String nome) throws Exception{
		DAO.begin();
		Pessoa p = daopessoa.read(nome);	
		if(p==null)
			throw new Exception("excluir pessoa - nome inexistente:" + nome);

		//apagar todos telefones da pessoa
		removerTelefonesDaPessoa(p);
		//apagar a pessoa
		daopessoa.delete(p);      
		DAO.commit();
	}
	
	public void removerTelefonesDaPessoa(Pessoa p) {
		for(Telefone t : p.getTelefones()) {
			p.remover(t);
			daotelefone.delete(t);		//deletar telefone orfao do banco
			DAO.commit();
		}
	}
	public static String listarPessoas(){
		List<Pessoa> pessoas = daopessoa.readAll();
		String texto="-----------listagem de Pessoas-----------\n";
		for (Pessoa pe : pessoas) {
			texto += pe +"\n";
		}
		return texto;
	}
	public static String listarAlunos(){
		List<Aluno> pessoas = daoaluno.readAll();
		String texto="-----------listagem de Alunos-----------\n";
		for (Aluno a : pessoas) {
			texto += a +"\n";
		}
		return texto;
	}

	public static String listarTelefones() { 	
		List<Telefone> aux = daotelefone.readAll();
		String texto="-----------listagem de Telefones---------\n";
		for(Telefone t: aux) {
			texto += "\n" + t; 
		}
		return texto;
	}

	/**********************************************************
	 * 
	 * CONSULTAS 
	 * 
	 **********************************************************/
	public static String consultarPessoasPorParteNome(String caracteres) {
		List<Pessoa> result = daopessoa.consultarPessoasPorParteNome(caracteres);

		String texto = "\nConsultar pessoas por parte do nome:"+caracteres;
		if (result.isEmpty())  
			texto += "consulta vazia";
		else 
			for(Pessoa p: result)texto += "\n" + p;
		return texto;
	}


	public static String consultarPessoasNTelefones(int n) {
		List<Pessoa> result = daopessoa.consultarPessoasNTelefones(n);

		String texto = "\nConsultar pessoas com "+n+" telefones:";
		if (result.isEmpty())  
			texto += "consulta vazia";
		else 
			for(Pessoa p: result)texto += "\n" + p;
		return texto;
	}

	public static String consultarPessoaPorNumero(String n) {
		Pessoa result = daopessoa.consultarPessoaPorNumero(n);
		if(result==null)
			return "\nConsultar pessoa do numero "+n+"  nao encontrado";
		else
			return "\nConsultar pessoa do numero "+n+" => " +result.getNome();

	}

	public static String consultarTelefonesPorNome(String n) {
		List<Telefone> result = daotelefone.consultarTelefonesPorNome(n);
		String texto = "\nConsultar telefones de " + n;
		if (result.isEmpty())  
			texto += "consulta vazia";
		else 
			for(Telefone t: result)texto += "\n" + t;
		return texto;
	}

	public static String consultarTelefonesPorPrefixo(String prefixo) {
		List<Telefone> result = daotelefone.consultarTelefonesPorPrefixo(prefixo);
		String texto = "\nConsultar telefones do prefixo " + prefixo;
		if (result.isEmpty())  
			texto += "consulta vazia";
		else 
			for(Telefone t: result)texto += "\n" + t;
		return texto;
	}



}
