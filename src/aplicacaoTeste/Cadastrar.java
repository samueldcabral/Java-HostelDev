package aplicacaoTeste;


import fachada.Fachada;
import modelo.Cama;
import modelo.Funcionario;
import modelo.Hospedagem;
import modelo.Hospede;
import modelo.Produto;
import modelo.Quarto;


public class Cadastrar {

	public Cadastrar(){
		Fachada.inicializar();
		Hospede h;
		Funcionario f;
		Produto prod;
		Cama c;
		Quarto q;
		Hospedagem hos;
		
		try {
			System.out.println("cadastrando...");
			
//			System.out.println("\nHospede \n");
//			h=Fachada.cadastrarHospede("Vicente Benício Santos", "68-92595-2244");
//			h=Fachada.cadastrarHospede("Alice Sara", "61-99218-2429");
//			h=Fachada.cadastrarHospede("Diego Gael Santos", "89-99436-1257");
//			h=Fachada.cadastrarHospede("Ryan Ian da Paz", "69-3561-1726");
//			h=Fachada.cadastrarHospede("Eloa Luana Corte Real", "89-3922-5863");
//			h=Fachada.cadastrarHospede("Allana Sueli da Paz", "69-98931-2339");
//			h=Fachada.cadastrarHospede("Barbara Lucia", "69-98931-1439");
//		
//			System.out.println("\nFuncinario \n");
//			f=Fachada.cadastrarFuncionario("Joao Giovanni Tomas da Mota", "82-98827-0734", 2000);
//			f=Fachada.cadastrarFuncionario("Julia Marli Marcia", "82-2597-9440", 2200);
//			f=Fachada.cadastrarFuncionario("Victor Hugo da Mota", "65-99721-3571", 2500);
//			f=Fachada.cadastrarFuncionario("Luiz Theo Aragao", "65-2874-1654", 2100);
//			f=Fachada.cadastrarFuncionario("Kamilly Antonia Aurora", "15-9974-1854", 2200);
//			f=Fachada.cadastrarFuncionario("Francisco Manoel", "55-99875-6454", 2000);
//	
//			System.out.println("\nProduto \n");
//			prod=Fachada.cadastrarProduto("Coca-Cola", "Refrigerante", 5.5);
//			prod=Fachada.cadastrarProduto("Fanta", "Refrigerante", 4.5);
//			prod=Fachada.cadastrarProduto("Sprite", "Refrigerante", 4.5);
//			prod=Fachada.cadastrarProduto("Cafe", "Bebida quente", 3);
//			prod=Fachada.cadastrarProduto("Cha", "Bebida quente", 2);
//			prod=Fachada.cadastrarProduto("Heineken", "Cerveja importada", 7);
//			prod=Fachada.cadastrarProduto("Petra", "Cerveja Nacional", 6);
//			prod=Fachada.cadastrarProduto("Salgadinhos Diversos", "Salgados", 4);
//			prod=Fachada.cadastrarProduto("Pastel de forno", "Salgados", 5);
//			prod=Fachada.cadastrarProduto("Empada", "Salgados", 4.5);
//			prod=Fachada.cadastrarProduto("Pizza Mussarela", "Pizzas", 12);
//			prod=Fachada.cadastrarProduto("Pizza Calabresa", "Pizzas", 15.5);
//			
//			System.out.println("\nCama \n");
//			c=Fachada.cadastrarCama(10, "beliche inferior");
//			c=Fachada.cadastrarCama(20, "beliche inferior");
//			c=Fachada.cadastrarCama(30, "beliche inferior");
//			c=Fachada.cadastrarCama(40, "beliche inferior");
//			c=Fachada.cadastrarCama(50, "beliche inferior");
//			c=Fachada.cadastrarCama(60, "beliche Superior");
//			c=Fachada.cadastrarCama(70, "beliche Superior");
//			c=Fachada.cadastrarCama(80, "beliche Superior");
//			c=Fachada.cadastrarCama(90, "beliche Superior");
//			c=Fachada.cadastrarCama(100, "beliche Superior");
//			
//			System.out.println("\nQuarto \n");
//			q=Fachada.cadastrarQuarto(101);
//			q=Fachada.cadastrarQuarto(102);
//			q=Fachada.cadastrarQuarto(103);
//			q=Fachada.cadastrarQuarto(104);
//			q=Fachada.cadastrarQuarto(201);
//			q=Fachada.cadastrarQuarto(202);
//			q=Fachada.cadastrarQuarto(203);
//			q=Fachada.cadastrarQuarto(204);
//			
//			System.out.println("\nHospedagem \n");
//			hos=Fachada.cadastrarHospedagem("Vicente Benício Santos", "Joao Giovanni Tomas da Mota", 101, 10);
//			Fachada.fecharHospedagemDoHospede("Vicente Benício Santos");
//			hos=Fachada.cadastrarHospedagem("Vicente Benício Santos", "Joao Giovanni Tomas da Mota", 102, 20);
//			hos=Fachada.cadastrarHospedagem("Alice Sara", "Julia Marli Marcia", 103, 30);
//			System.out.println("\nFim Hospedagem \n");

//			System.out.println("adicionarCamaQuarto");
//			c=Fachada.adicionarCamaQuarto(10, 101);
//			c=Fachada.adicionarCamaQuarto(20, 101);
//			c=Fachada.adicionarCamaQuarto(30, 102);
//			c=Fachada.adicionarCamaQuarto(40, 102);
//			c=Fachada.adicionarCamaQuarto(50, 103);
//			
			System.out.println("adicionarProdutoHospedagem");
			prod=Fachada.adicionarProdutoHospedagem("Coca-Cola", 1001);
			prod=Fachada.adicionarProdutoHospedagem("Pizza Mussarela", 1001);
			prod=Fachada.adicionarProdutoHospedagem("Sprite", 1001);
			prod=Fachada.adicionarProdutoHospedagem("Empada", 1001);
			prod=Fachada.adicionarProdutoHospedagem("Pizza Calabresa", 1002);
			prod=Fachada.adicionarProdutoHospedagem("Pizza Calabresa", 1002);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		Fachada.finalizar();
		System.out.println("fim do programa");
	}

	public void cadastrar(){

	}	

	public static void main(String[] args) {
		new Cadastrar();
	}
}