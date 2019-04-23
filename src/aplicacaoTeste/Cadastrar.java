package aplicacaoTeste;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import fachada.Fachada;
import modelo.Pessoa;
import modelo.Telefone;


public class Cadastrar {

	public Cadastrar(){
		Fachada.inicializar();
		Pessoa p;
		Telefone t;
		try {
			System.out.println("cadastrando...");
			p=Fachada.cadastrarPessoa("joao");
			t=Fachada.adicionarTelefonePessoa("joao","88880000");
			t=Fachada.adicionarTelefonePessoa("joao","88881111");	

			p=Fachada.cadastrarPessoa("maria");
			t=Fachada.adicionarTelefonePessoa("maria","87882222");
			t=Fachada.adicionarTelefonePessoa("maria","88883333");

			p=Fachada.cadastrarPessoa("jose");
			t=Fachada.adicionarTelefonePessoa("jose","87884444");

			p=Fachada.cadastrarAluno("paulo", 9);
			p=Fachada.cadastrarProfessor("fausto", 1000.0);
		} catch (Exception e) {System.out.println(e.getMessage());}


		Fachada.finalizar();
		System.out.println("fim do programa");
	}


	public void cadastrar(){

	}	


	//=================================================
	public static void main(String[] args) {
		new Cadastrar();
	}
}


