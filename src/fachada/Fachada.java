
package fachada;

import java.util.ArrayList;
import java.util.List;

import dao.DAO;
import dao.DAOCama;
import dao.DAOFuncionario;
import dao.DAOHospedagem;
import dao.DAOHospede;
import dao.DAOPessoa;
import dao.DAOProduto;
import dao.DAOQuarto;
import modelo.Cama;
import modelo.Funcionario;
import modelo.Hospedagem;
import modelo.Hospede;
import modelo.Pessoa;
import modelo.Produto;
import modelo.Quarto;

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
			throw new Exception("Cadastrar Pessoa - Pessoa ja cadastrada: " + nome);

		p = new Pessoa(nome, telefone);
		daopessoa.create(p);	
		DAO.commit();
		return p;
	}	

	public static Hospede cadastrarHospede(String nome, String telefone) throws  Exception{
		DAO.begin();	
		Pessoa p = daohospede.read(nome);
		if(p != null)
			throw new Exception("Cadastrar Hospede - Hospede ja cadastrado:" + nome);
		
		int idCadastro;
		List<Hospede> hospedes = daohospede.readAll();
		if(hospedes.size() > 0) {
			idCadastro = hospedes.get(hospedes.size() - 1 ).getId() + 1;
		}else {
			idCadastro = 1;
		}
		
		p = new Hospede(idCadastro, nome, telefone);
		daopessoa.create(p);	
		DAO.commit();
		return (Hospede) p;
	}

	public static Funcionario cadastrarFuncionario(String nome, String telefone, double salario) throws  Exception{
		DAO.begin();	
		Pessoa p = daofuncionario.read(nome);
		if(p != null)
			throw new Exception("Cadastrar Funcionario - Funcionario ja cadastrado:" + nome);
		
		int matCadastro;
		List<Funcionario> funcionarios = daofuncionario.readAll();
		if(funcionarios.size() > 0) {
			matCadastro = funcionarios.get(funcionarios.size() - 1 ).getMatricula() + 1;
		}else {
			matCadastro = 100;
		}
		
		p = new Funcionario(nome, telefone, matCadastro, salario);
		daopessoa.create(p);	
		DAO.commit();
		return (Funcionario) p;
	}
	
	public static Cama cadastrarCama(int numero, String tipo) throws  Exception{
		DAO.begin();	
		Cama c = daocama.read(numero);
		if(c != null)
			throw new Exception("Cadastrar Cama - Cama ja cadastrada: " + c);

		c = new Cama(numero, tipo);
		daocama.create(c);	
		DAO.commit();
		return (Cama) c;
	}
	
	public static Quarto cadastrarQuarto(int numero) throws  Exception{
		DAO.begin();	
		Quarto c = daoquarto.read(numero);
		if(c != null)
			throw new Exception("cadastrar Quarto - Quarto ja cadastrado:" + c);

		c = new Quarto(numero);
		daoquarto.create(c);	
		DAO.commit();
		return (Quarto) c;
	}

	public static Produto cadastrarProduto(String nome, String descricao, double valor) throws  Exception{
		DAO.begin();	
		Produto p = daoproduto.read(nome);
		if(p != null)
			throw new Exception("Cadastrar Produto - Produto ja cadastrado:" + p);

		int idCadastro;
		List<Produto> produtos = daoproduto.readAll();
		if(produtos.size() > 0) {
			idCadastro = produtos.get(produtos.size() - 1 ).getId() + 1;
		}else {
			idCadastro = 500;
		}
		
		p = new Produto(idCadastro, nome, descricao, valor);
		daoproduto.create(p);	
		DAO.commit();
		return (Produto) p;
	}
	
	public static Hospedagem cadastrarHospedagem(String hospede, String funcionario, int quarto, int cama) throws  Exception{		
		DAO.begin();	
		
		Hospede hos = daohospede.read(hospede);
		if(hos == null)
			throw new Exception("cadastrar hospedagem - Hospede nao cadastrado!: " + hos);
		
		ArrayList<Hospedagem> hospedagens = hos.getHospedagens();
		Boolean hospedagemAberta = false;
		for(Hospedagem h : hospedagens) {
			if(h.getStatusHospedagem() != hospedagemAberta) {
				hospedagemAberta = h.getStatusHospedagem();
			}
		}
		
		if(hospedagemAberta != false) 
			throw new Exception("cadastrar hospedagem - hospedagem aberta no sistema: " + hospedagemAberta);
		
		if(funcionario.equals("")) {
			funcionario = "Kamilly Antonia Aurora";
		}
		Funcionario f = daofuncionario.read(funcionario);
		if(f == null)
			throw new Exception("cadastrar hospedagem - Funcionario nao cadastrado!: " + funcionario);
		
		Quarto q = daoquarto.read(quarto);
		if(q == null)
			throw new Exception("cadastrar hospedagem - Quarto nao cadastrado!: " + q);
		
		Cama c = daocama.read(cama);
		if(c == null)
			throw new Exception("cadastrar hospedagem - Cama nao cadastrado!: " + c);

		int idCadastro;
		List<Hospedagem> hospedagensCadastradas = daohospedagem.readAll();
		if(hospedagensCadastradas.size() > 0) {
			idCadastro = hospedagensCadastradas.get(hospedagensCadastradas.size() - 1 ).getId() + 1;
		}else {
			idCadastro = 1000;
		}
		
		Hospedagem h = new Hospedagem(idCadastro, hos, f, q, c);
		hos.adicionarHospedagem(h);
		hos.setIdHospedagens(h.getId());

		daohospedagem.create(h);	
		DAO.commit();
		return (Hospedagem) h;
	}
	
	public static void fecharHospedagemDoHospede(String nomeHospede) throws Exception {
		DAO.begin();	
		Hospede hospede = daohospede.read(nomeHospede);
		
		if(hospede == null)
			throw new Exception("fecharHospedagemDoHospede - hospede nao existe: " + hospede);
	
		ArrayList<Hospedagem> hospedagens = hospede.getHospedagens();
		for(Hospedagem h : hospedagens) {
			if(h.getStatusHospedagem() == true) {
				h.setStatusHospedagem(false);
				daohospedagem.update(h);
				DAO.commit();
			}
		}
	}
	
	//ADICIONAR 
	
	public static Cama adicionarCamaQuarto(int numeroCama, int numeroQuarto) throws Exception {
		DAO.begin();
		Cama c = daocama.read(numeroCama);
		if(c == null)
			throw new Exception("adicionar cama - cama nao cadastrada: " + numeroCama);
		
		Quarto q = daoquarto.read(numeroQuarto);
		if(q == null)
			throw new Exception("adicionar quarto - quarto nao cadastrado: " + numeroQuarto);
		
		Quarto quartoAtual = c.getQuarto();
		if(quartoAtual != null)
			throw new Exception("adicionarCamaQuarto - Cama ja tem quarto!");
		
		q.adicionarCama(c);
		c.setQuarto(q);
		c.setNumeroQuarto(q.getNumero());
		daoquarto.update(q);
		daocama.update(c);
		DAO.commit();
		return c;
	}
	
	public static void excluirCamaQuarto(int numeroCama, int numeroQuarto) throws Exception {
		DAO.begin();
		Cama c = daocama.read(numeroCama);
		if(c == null)
			throw new Exception("excluir cama quarto- cama nao cadastrada: " + numeroCama);
		
		Quarto q = daoquarto.read(numeroQuarto);
		if(q == null)
			throw new Exception("excluir cama quarto - quarto nao cadastrado: " + numeroQuarto);
		
		c = q.localizarCama(c);
		
		if(c == null)
			throw new Exception("excluir cama quarto - quarto nao tem cama: " + q.getNumero());
		
		q.remover(c);
		c.setQuarto(null);
		daoquarto.update(q);
		DAO.commit();
	}
	
	public static Produto adicionarProdutoHospedagem(String nomeProduto, int idHospedagem) throws Exception {
		DAO.begin();
		Hospedagem h = daohospedagem.read(idHospedagem);
		if(h == null)
			throw new Exception("adicionarProdutoHospedagem - Hospedagem nao existe:" + idHospedagem);
		
		Produto p = daoproduto.read(nomeProduto);
		if(p == null)
			throw new Exception("adicionarProdutoHospedagem - Produto nao existe:" + nomeProduto);
		
		h.setProdutos(p);
		p.setHospedagens(h);
		p.setIdHospedagens(h.getId());
		daohospedagem.update(h);
		daoproduto.update(p);
		DAO.commit();
		return p;
	}
	
	public static Produto excluirProdutoHospedagem(String nomeProduto, int idHospedagem) throws Exception {
		DAO.begin();
		Hospedagem h = daohospedagem.read(idHospedagem);
		if(h == null)
			throw new Exception("removerProdutoHospedagem - Hospedagem nao existe:" + idHospedagem);
		
		Produto p = daoproduto.read(nomeProduto);
		if(p == null)
			throw new Exception("removerProdutoHospedagem - Produto nao existe:" + nomeProduto);
		
		h.removerProduto(p);
		daohospedagem.update(h);
		DAO.commit();
		return p;
	}

	// ALTERAR (TO DO)
	
	public static void alterarPessoa(String nome, String novonome) throws Exception{
		DAO.begin();		
		Pessoa p = daopessoa.read(nome);	
		if (p==null)
			throw new Exception("alterar pessoa - nome inexistente:" + nome);

		p.setNome(novonome); 			
		p=daopessoa.update(p);     	
		DAO.commit();	
	}
	
	public static void alterarProduto(String nome, String novoNome, String novaDescricao, Double novoValor) throws Exception {
		DAO.begin();
		Produto prod = daoproduto.read(nome);
		if(prod==null)
			throw new Exception("alterarProduto - inexistente: " + nome);
		
		prod.setNome(novoNome);
		prod.setDescricao(novaDescricao);
		
		if(prod.getValor() != novoValor) {
			prod.setValor(novoValor);
		}
		
		prod = daoproduto.update(prod);
		DAO.commit();
	}
	
	public static void alterarFuncionario(String nome, int novaMatricula, double novoSalario) throws Exception {
		DAO.begin();
		Funcionario funcionario = daofuncionario.read(nome);
		if(funcionario==null)
			throw new Exception("alterarFuncionario - inexistente: " + nome);
		
		if(novaMatricula != funcionario.getMatricula()) {
			funcionario.setMatricula(novaMatricula);
		}
		if(novoSalario != funcionario.getSalario()) {
			funcionario.setSalario(novoSalario);
		}
		
		funcionario = daofuncionario.update(funcionario);
		DAO.commit();
	}
	
	// EXCLUIR (TO DO) 
	
	public static void excluirHospede(String n) throws Exception {
		DAO.begin();
		Hospede hospede = daohospede.read(n);
		if(hospede == null)
			throw new Exception("excluir hospede - nome inexistente: " + n);
		removerHospedagemDoHospede(hospede);
		daohospede.delete(hospede);
		DAO.commit();
	}
	
	public static void removerHospedagemDoHospede(Hospede h) {
		for(Hospedagem hospedagem : h.getHospedagens()) {
			h.removerHospedagem(hospedagem);
			daohospedagem.delete(hospedagem);
			DAO.commit();
		}
	}
	
	public static void excluirFuncionario(String n) throws Exception {
		DAO.begin();
		Funcionario f = daofuncionario.read(n);
		if (f==null) 
			throw new Exception("excluirFuncionario - nome inexistente:" + n);

		daofuncionario.delete(f);
		DAO.commit();
	}
	
	public static void excluirCama(int id) throws Exception {
		DAO.begin();
		Cama c = daocama.read(id);
		if(c==null)
			throw new Exception("excluirCama - inexistente" + id);
		
		Quarto q = c.getQuarto();
		
		if(q != null)
			q.remover(c);
		daocama.delete(c);
		DAO.commit();
	}
	
	public static void excluirHospedagem(String id) throws Exception {
		DAO.begin();
		Hospedagem hospedagem = daohospedagem.read(id);
		if(hospedagem==null)
			throw new Exception("excluirHospedagem - inexistente: " + id);
		Hospede hospede = hospedagem.getHospede();
		hospede.removerHospedagem(hospedagem);
		daohospedagem.delete(hospedagem);
		DAO.commit();
	}
	
	public static void excluirProduto(String nomeProduto) throws Exception {
		DAO.begin();
		Produto p = daoproduto.read(nomeProduto);
		if(p==null)
			throw new Exception(" excluirProduto : " + nomeProduto);
		
		removerProdutoDaHospedagem(p);
		daoproduto.delete(p);
		DAO.commit();
	}
	
	public static void removerProdutoDaHospedagem(Produto p) {
		for(Hospedagem h : p.getHospedagens()) {
			h.removerProduto(p);
		}
	}
	
	public static void excluirQuarto(String id) throws Exception {
		DAO.begin();
		Quarto q = daoquarto.read(id);
		
		if(q==null)
			throw new Exception(" excluirQuarto : " + id);
		
		ArrayList<Cama> c = q.getCamas();
		
		if(c.size() > 0) {
			excluirCamasDoQuarto(q.getNumero());
		}
		daoquarto.delete(q);
		DAO.commit();
	}
	
	public static void excluirCamasDoQuarto(int idQuarto) {
		Quarto q = daoquarto.read(idQuarto);
		ArrayList<Cama> c = q.getCamas();
		
		for(Cama cama : c) {
			try {
				excluirCamaQuarto(cama.getNumero(), q.getNumero());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
//
//
//	public void excluirPessoaManualmente(String nome) throws Exception{
//		DAO.begin();
//		Pessoa p = daopessoa.read(nome);	
//		if(p==null)
//			throw new Exception("excluir pessoa - nome inexistente:" + nome);
//
//		//apagar todos telefones da pessoa
//		removerTelefonesDaPessoa(p);
//		//apagar a pessoa
//		daopessoa.delete(p);      
//		DAO.commit();
//	}
//	
//	public void removerTelefonesDaPessoa(Pessoa p) {
//		for(Telefone t : p.getTelefones()) {
//			p.remover(t);
//			daotelefone.delete(t);		//deletar telefone orfao do banco
//			DAO.commit();
//		}
//	}
	
	// LISTAR (TO DO)
	public static Hospedagem pegarHospedagemAbertaHospede(String nome) throws Exception {
		Hospede h = daohospede.read(nome);
		List<Hospedagem> hospedagens = h.getHospedagens();
		
		for(Hospedagem hos : hospedagens) {
			if(hos.getStatusHospedagem()) {
				return hos;
			}
		}
		return null;
	}
	
	public static String listarCamas(){
		List<Cama> camas = daocama.readAll();
		String texto="-----------listagem de Camas-----------\n";
		for (Cama c : camas) {
			texto += c +"\n\n";
		}
		return texto;
	}
	
	public static String listarFuncionarios(){
		List<Funcionario> funcs = daofuncionario.readAll();
		String texto="-----------listagem de Funcionarios-----------\n";
		for (Funcionario f : funcs) {
			texto += f +"\n\n";
		}
		return texto;
	}
	
	public static Funcionario listarFuncionario(String nome) throws Exception{
		Funcionario funcs = daofuncionario.read(nome);
		if(funcs == null)
			throw new Exception("Funcinario nao existe: " + nome);
		String texto="-----------Funcionarios-----------\n";
	
		return funcs;
	}
	
	public static String listarHospedagens(){
		List<Hospedagem> hosps = daohospedagem.readAll();
		String texto="-----------listagem de Hospedagens-----------\n";
		for (Hospedagem h : hosps) {
			texto += h +"\n\n";
		}
		return texto;
	}
	
	public static String listarHospedes(){
		List<Hospede> hos = daohospede.readAll();
		String texto="-----------listagem de Hospedes-----------\n";
		for (Hospede h : hos) {
			texto += h +"\n\n";
		}
		return texto;
	}
	
	public static String listarPessoas(){
		List<Pessoa> pessoas = daopessoa.readAll();
		String texto="-----------listagem de Pessoas-----------\n";
		for (Pessoa pe : pessoas) {
			texto += pe +"\n\n";
		}
		return texto;
	}
	
	public static String listarProdutos(){
		List<Produto> prods = daoproduto.readAll();
		String texto="-----------listagem de Produtos-----------\n";
		for (Produto pr : prods) {
			texto +=  pr +"\n\n";
		}
		return texto;
	}
	
	public static String listarQuartos(){
		List<Quarto> qts = daoquarto.readAll();
		String texto="-----------listagem de Quartos-----------\n";
		for (Quarto q : qts) {
			texto += q +"\n\n";
		}
		return texto;
	}


	/**********************************************************
	 * 
	 * CONSULTAS  (TO DO)
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

	public static String consultarPessoaPorNumero(String n) {
		Pessoa result = daopessoa.consultarPessoaPorNumero(n);
		if(result==null)
			return "\nConsultar pessoa do numero "+n+"  nao encontrado";
		else
			return "\nConsultar pessoa do numero "+n+" => " +result.getNome();
	}
	
	// CONSULTAS USANDO 3 CLASSES
	
	public static ArrayList<Produto> consultarProdutosDeTodasHospedagensDoHospede(String nomeHospede) throws Exception{
		Hospede hospede = daohospede.read(nomeHospede);
		if(hospede == null)
			throw new Exception("consultarProdutosDeTodasHospedagensDoHospede - hospede nao existe: " + nomeHospede);
		
		ArrayList<Hospedagem> hospedagens = hospede.getHospedagens();
		ArrayList<Produto> prods = new ArrayList<Produto>();
		
		for(Hospedagem hos : hospedagens) {
			for(Produto prod : hos.getProdutos()) {
				prods.add(prod);
			}
		}
		
		return prods;
	}
	
	public static ArrayList<String> consultarValorGastoPorProdutosNaHospedagemHospede(String nomeHospede) throws Exception {
		Hospede hospede = daohospede.read(nomeHospede);
		if(hospede == null)
			throw new Exception("consultarValorGastoPorProdutosNaHospedagemHospede - hospede nao existe: " + nomeHospede);
		
		ArrayList<Hospedagem> hospedagens = hospede.getHospedagens();
		ArrayList<String> valoresProdutos = new ArrayList<String>();
		
		for(Hospedagem hos : hospedagens) {
			double total = 0;
			for(Produto prod : hos.getProdutos()) {
				total += prod.getValor();
			}
			valoresProdutos.add("hospedagem " + hos.getId());
			valoresProdutos.add(total + "");
		}
		return valoresProdutos;
	}
	
	public static ArrayList<String> consultarFuncionarioCadastrouHospede(String nomeHospede) throws Exception {
		Hospede hospede = daohospede.read(nomeHospede);
		if(hospede == null)
			throw new Exception("consultarFuncionarioCadastrouHospede - hospede nao existe: " + nomeHospede);
		
		System.out.println("hospede eh => " + hospede.getNome());
		ArrayList<Hospedagem> hospedagens = hospede.getHospedagens();
		ArrayList<String> nomesFuncionarios = new ArrayList<String>();
		
		for(Hospedagem hos : hospedagens) {
			nomesFuncionarios.add("Hospedagem: " + hos.getId() + " ");
			nomesFuncionarios.add(hos.getFuncionario().getNome());
		}
		return nomesFuncionarios;
	}
	
	public static List<Hospede> consultarHospedePorQuarto(int numeroQuarto) throws Exception{
		Quarto q = daoquarto.read(numeroQuarto);
		if(q==null) throw new Exception("Quarto não existe: " + numeroQuarto);
		
		List<Hospede> h = daohospede.consultarHospedePorQuarto(q.getNumero());
		return h;
	}
	
	public static List<Hospede> consultarHospedePorProduto(String produto) throws Exception {
		Produto p = daoproduto.read(produto);
		if(p==null) throw new Exception("Produto não existe: " + produto);
		
		List<Hospede> h = daohospede.consultarHospedePorProduto(produto);
		return h;
	}
	
	public static List<Produto> consultarProdutosPorHospede(String hospede) {
		List<Produto> h = daoproduto.consultarProdutosPorHospede(hospede);
		return h;
	}
}
