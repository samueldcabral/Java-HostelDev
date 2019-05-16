package aplicacaoTeste;

import fachada.Fachada;


public class Atualizar {

	public Atualizar(){
		Fachada.inicializar();
		try {
			System.out.println("alterando pessoa: nome...");
			Fachada.alterarPessoa("Barbara Lucia", "Lucia Barbara");
			Fachada.alterarPessoa("Leila Ribeiro Almeida", "Thalia R. Almeida");
			
			System.out.println("alterando funcionario: salario e matricula...");
			Fachada.alterarFuncionario("Joao Giovanni Tomas da Mota", 111, 3000);
			Fachada.alterarFuncionario("Julia Marli Marcia", 222, 3300);
			
			System.out.println("alterando produto: nome, desc e valor...");
			Fachada.alterarProduto("Cha", "Cha Camomila", "Bebida Quente", 2.2);
			Fachada.alterarProduto("Itaipava", "Itaipava premium", "Cerveja Nacional", 5.0);
			Fachada.alterarProduto("Salgadinhos Diversos", "Tapioquinha frita", "Salgados", 4.1);
			Fachada.alterarProduto("Lasanha Frango", "Lasanha lombo", "Lasanha", 10.0);
			
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

