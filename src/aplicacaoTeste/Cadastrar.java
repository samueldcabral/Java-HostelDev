package aplicacaoTeste;


import fachada.Fachada;
//import modelo.Cama;
//import modelo.Funcionario;
//import modelo.Hospedagem;
//import modelo.Hospede;
//import modelo.Produto;
//import modelo.Quarto;


public class Cadastrar {

	public Cadastrar(){
		Fachada.inicializar();
//		Hospede h;
//		Funcionario f;
//		Produto prod;
//		Cama c;
//		Quarto q;
//		Hospedagem hos;
		
		try {
			System.out.println("cadastrando...");
//			System.out.println("\nHospede \n");
//			h=Fachada.cadastrarHospede("1", "Vicente Benício Santos", "68-92595-2244");
//			h=Fachada.cadastrarHospede("2", "Alice Sara", "61-99218-2429");
//			h=Fachada.cadastrarHospede("3", "Diego Gael Santos", "89-99436-1257");
//			h=Fachada.cadastrarHospede("4", "Ryan Ian da Paz", "69-3561-1726");
//			h=Fachada.cadastrarHospede("5", "Eloa Luana Corte Real", "89-3922-5863");
//			h=Fachada.cadastrarHospede("6", "Allana Sueli da Paz", "69-98931-2339");
//			h=Fachada.cadastrarHospede("7", "Barbara Lucia", "69-98931-1439");
//		
//			System.out.println("\nFuncinario \n");
//			f=Fachada.cadastrarFuncionario("111-110", "Joao Giovanni Tomas da Mota", "82-98827-0734", 2000);
//			f=Fachada.cadastrarFuncionario("222-220", "Julia Marli Marcia", "82-2597-9440", 2200);
//			f=Fachada.cadastrarFuncionario("333-330", "Victor Hugo da Mota", "65-99721-3571", 2500);
//			f=Fachada.cadastrarFuncionario("444-440", "Luiz Theo Aragao", "65-2874-1654", 2100);
//			f=Fachada.cadastrarFuncionario("555-550", "Kamilly Antonia Aurora", "15-9974-1854", 2200);
//			f=Fachada.cadastrarFuncionario("666-660", "Francisco Manoel", "55-99875-6454", 2000);
//	
//			System.out.println("\nProduto \n");
//			prod=Fachada.cadastrarProduto("11", "Coca-Cola", "Refrigerante", 5.5);
//			prod=Fachada.cadastrarProduto("22", "Fanta", "Refrigerante", 4.5);
//			prod=Fachada.cadastrarProduto("33", "Sprite", "Refrigerante", 4.5);
//			prod=Fachada.cadastrarProduto("44", "Cafe", "Bebida quente", 3);
//			prod=Fachada.cadastrarProduto("55", "Cha", "Bebida quente", 2);
//			prod=Fachada.cadastrarProduto("66", "Heineken", "Cerveja importada", 7);
//			prod=Fachada.cadastrarProduto("77", "Petra", "Cerveja Nacional", 6);
//			prod=Fachada.cadastrarProduto("88", "Salgadinhos Diversos", "Salgados", 4);
//			prod=Fachada.cadastrarProduto("99", "Pastel de forno", "Salgados", 5);
//			prod=Fachada.cadastrarProduto("111", "Empada", "Salgados", 4.5);
//			prod=Fachada.cadastrarProduto("222", "Pizza Mussarela", "Pizzas", 12);
//			prod=Fachada.cadastrarProduto("333", "Pizza Calabresa", "Pizzas", 15.5);
//			
//			System.out.println("\nCama \n");
//			c=Fachada.cadastrarCama("1", "10", "beliche inferior");
//			c=Fachada.cadastrarCama("2", "20", "beliche inferior");
//			c=Fachada.cadastrarCama("3", "30", "beliche inferior");
//			c=Fachada.cadastrarCama("4", "40", "beliche inferior");
//			c=Fachada.cadastrarCama("5", "50", "beliche inferior");
//			c=Fachada.cadastrarCama("6", "60", "beliche Superior");
//			c=Fachada.cadastrarCama("7", "70", "beliche Superior");
//			c=Fachada.cadastrarCama("8", "80", "beliche Superior");
//			c=Fachada.cadastrarCama("9", "90", "beliche Superior");
//			c=Fachada.cadastrarCama("10", "100", "beliche Superior");
//			
//			System.out.println("\nQuarto \n");
//			q=Fachada.cadastrarQuarto("1", "101");
//			q=Fachada.cadastrarQuarto("2", "102");
//			q=Fachada.cadastrarQuarto("3", "201");
//			q=Fachada.cadastrarQuarto("4", "202");
			
//			System.out.println("\nHospedagem \n");
//			System.out.println("1");
//			hos=Fachada.cadastrarHospedagem("1", "Vicente Benício Santos", "Joao Giovanni Tomas da Mota", "1", "1");
//			System.out.println("2");
//			hos=Fachada.cadastrarHospedagem("2", "Vicente Benício Santos", "Joao Giovanni Tomas da Mota", "2", "6");
//			System.out.println("3");
//			hos=Fachada.cadastrarHospedagem("3", "Alice Sara", "Julia Marli Marcia", "1", "2");

//			System.out.println("adicionarCamaQuarto");
//			c=Fachada.adicionarCamaQuarto("1", "1");
//			c=Fachada.adicionarCamaQuarto("2", "1");
//			c=Fachada.adicionarCamaQuarto("3", "1");
//			c=Fachada.adicionarCamaQuarto("4", "2");
//			c=Fachada.adicionarCamaQuarto("5", "1");
			
			System.out.println("adicionarProdutoHospedagem");
//			prod=Fachada.adicionarProdutoHospedagem("Coca-Cola", "1");
//			prod=Fachada.adicionarProdutoHospedagem("Pizza Mussarela", "1");
//			prod=Fachada.adicionarProdutoHospedagem("Sprite", "2");
//			prod=Fachada.adicionarProdutoHospedagem("Empada", "2");
//			prod=Fachada.adicionarProdutoHospedagem("Pizza Calabresa", "2");

			
			
//			p=Fachada.cadastrarPessoa("maria");
//			t=Fachada.adicionarTelefonePessoa("maria","87882222");
//			t=Fachada.adicionarTelefonePessoa("maria","88883333");
//
//			p=Fachada.cadastrarPessoa("jose");
//			t=Fachada.adicionarTelefonePessoa("jose","87884444");
//
//			p=Fachada.cadastrarAluno("paulo", 9);
//			p=Fachada.cadastrarProfessor("fausto", 1000.0);
			
			
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


