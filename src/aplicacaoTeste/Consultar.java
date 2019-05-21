package aplicacaoTeste;

import com.db4o.query.Candidate;
import com.db4o.query.Evaluation;

import fachada.Fachada;
import modelo.Pessoa;

public class Consultar {

	public Consultar(){
		Fachada.inicializar();
		try {
//			System.out.println(Fachada.consultarPessoasPorParteNome("jo") );
//			System.out.println(Fachada.consultarPessoasNTelefones(2) );
//			System.out.println(Fachada.consultarPessoaPorNumero("88889999") );
//			System.out.println(Fachada.consultarTelefonesPorNome("joana") );
//			System.out.println(Fachada.consultarTelefonesPorPrefixo("87") );
			
//			System.out.println("\n\nconsultar Produtos de Todas Hospedagens do Hospede");
//			System.out.println(Fachada.consultarProdutosDeTodasHospedagensDoHospede("Alice Sara"));
//		
//			System.out.println("\n\nconsultar Valor Gasto Por Produtos");
//			System.out.println(Fachada.consultarValorGastoPorProdutosNaHospedagemHospede("Vicente Benício Santos"));
//
//			System.out.println("\n\nconsultar Funcionario Cadastrou Hospede");
//			System.out.println(Fachada.consultarFuncionarioCadastrouHospede("Vicente Benício Santos"));
//			
//			System.out.println("\n\nconsultar Pessoa por telefone");
//			System.out.println(Fachada.consultarPessoaPorNumero("89-99436-1257"));
//			
			System.out.println(Fachada.consultarHospedePorQuarto(202));
			System.out.println(Fachada.consultarHospedePorProduto("Heineken"));
			System.out.println(Fachada.consultarProdutosPorHospede("Julian Oliveira Almeida"));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Fachada.finalizar();
		System.out.println("fim do programa");
	}

	public static void main(String[] args) {
		new Consultar();
	}
}