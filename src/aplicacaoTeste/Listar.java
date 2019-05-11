package aplicacaoTeste;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import fachada.Fachada;


public class Listar {

	public Listar(){
		Fachada.inicializar();
		try {
//			System.out.println(Fachada.listarPessoas());
			System.out.println(Fachada.listarCamas());
			System.out.println("\n----------------------------------------------------------------------\n");
			System.out.println(Fachada.listarFuncionarios());
			System.out.println("\n----------------------------------------------------------------------\n");
			System.out.println(Fachada.listarHospedagens());
			System.out.println("\n----------------------------------------------------------------------\n");
			System.out.println(Fachada.listarHospedes());
			System.out.println("\n----------------------------------------------------------------------\n");
			System.out.println(Fachada.listarQuartos());
			System.out.println("\n----------------------------------------------------------------------\n");
			System.out.println(Fachada.listarProdutos());
			System.out.println("\n----------------------------------------------------------------------\n");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Fachada.finalizar();
		System.out.println("fim do programa");
	}


	//=================================================
	public static void main(String[] args) {
		new Listar();
	}
}

