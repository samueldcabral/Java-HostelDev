package aplicacaoTeste;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import fachada.Fachada;


public class Atualizar {

	public Atualizar(){
		Fachada.inicializar();
		try {
			System.out.println("alterando...");
			Fachada.alterarPessoa("Allana Sueli da Paz", "Skywalker Sueli da Paz");

		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//erros
//		try {Fachada.excluirTelefonePessoa("joana", "88883333"); }//produz erro 
//		catch (Exception e) {System.out.println(e.getMessage());}
//		try {Fachada.alterarTelefone("88889999", "88883333"); }//produz erro 
//		catch (Exception e) {System.out.println(e.getMessage());}

		Fachada.finalizar();
		System.out.println("fim do programa");
	}




	//=================================================
	public static void main(String[] args) {
		new Atualizar();
	}
}

