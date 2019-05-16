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
			
			System.out.println("\nHospede \n");
			h=Fachada.cadastrarHospede("Vicente Benício Santos", "68-92595-2244");
			h=Fachada.cadastrarHospede("Alice Sara", "61-99218-2429");
			h=Fachada.cadastrarHospede("Diego Gael Santos", "89-99436-1257");
			h=Fachada.cadastrarHospede("Ryan Ian da Paz", "69-3561-1726");
			h=Fachada.cadastrarHospede("Eloa Luana Corte Real", "89-3922-5863");
			h=Fachada.cadastrarHospede("Allana Sueli da Paz", "69-98931-2339");
			h=Fachada.cadastrarHospede("Barbara Lucia", "69-98931-1439");
			h=Fachada.cadastrarHospede("Thaís Silva Dias", "(19) 7399-9779");
			h=Fachada.cadastrarHospede("Mariana Azevedo Ribeiro", "(14) 4041-4623");
			h=Fachada.cadastrarHospede("Guilherme Ferreira Pinto", "(61) 9552-7572");
			h=Fachada.cadastrarHospede("Julian Oliveira Almeida", "(84) 5921-8489");
			h=Fachada.cadastrarHospede("Tiago Melo Dias", "(61) 9142-5326");
			h=Fachada.cadastrarHospede("Lavinia Martins Almeida", "(12) 6017-4793");
			 
			System.out.println("\nFuncinario \n");
			f=Fachada.cadastrarFuncionario("Joao Giovanni Tomas da Mota", "82-98827-0734", 2000);
			f=Fachada.cadastrarFuncionario("Julia Marli Marcia", "82-2597-9440", 2200);
			f=Fachada.cadastrarFuncionario("Victor Hugo da Mota", "65-99721-3571", 2500);
			f=Fachada.cadastrarFuncionario("Luiz Theo Aragao", "65-2874-1654", 2100);
			f=Fachada.cadastrarFuncionario("Kamilly Antonia Aurora", "15-9974-1854", 2200);
			f=Fachada.cadastrarFuncionario("Francisco Manoel", "55-99875-6454", 2000);
			f=Fachada.cadastrarFuncionario("Murilo Correia Pinto", "(71) 6434-4023", 2000);
			f=Fachada.cadastrarFuncionario("Vitor Pereira Fernandes", "(85) 4247-2722", 2300);
			f=Fachada.cadastrarFuncionario("Igor Goncalves Cavalcanti", "(35) 7691-5614", 3000);
			f=Fachada.cadastrarFuncionario("Camila Azevedo Rocha", "(27) 2182-7330", 3320);
			f=Fachada.cadastrarFuncionario("Livia Cunha Cavalcanti", "(55) 8825-9049", 1220);
			f=Fachada.cadastrarFuncionario("Leila Ribeiro Almeida", "(11) 7823-9959", 2300);
			f=Fachada.cadastrarFuncionario("Bruno Cunha Cavalcanti", "(71) 6595-4686", 3200);
		
			System.out.println("\nProduto \n");
			prod=Fachada.cadastrarProduto("Coca-Cola", "Refrigerante", 5.5);
			prod=Fachada.cadastrarProduto("Fanta", "Refrigerante", 4.5);
			prod=Fachada.cadastrarProduto("Sprite", "Refrigerante", 4.5);
			prod=Fachada.cadastrarProduto("Cafe", "Bebida quente", 3);
			prod=Fachada.cadastrarProduto("Cha", "Bebida quente", 2);
			prod=Fachada.cadastrarProduto("Heineken", "Cerveja importada", 7);
			prod=Fachada.cadastrarProduto("Petra", "Cerveja Nacional", 6);
			prod=Fachada.cadastrarProduto("Budweiser", "Cerveja Nacional", 6.5);
			prod=Fachada.cadastrarProduto("Itaipava", "Cerveja Nacional", 5.5);
			prod=Fachada.cadastrarProduto("Pastel frito", "Salgados", 5);
			prod=Fachada.cadastrarProduto("Salgadinhos Diversos", "Salgados", 4);
			prod=Fachada.cadastrarProduto("Pastel de forno", "Salgados", 5);
			prod=Fachada.cadastrarProduto("Empada", "Salgados", 4.5);
			prod=Fachada.cadastrarProduto("Pizza Mussarela", "Pizzas", 12);
			prod=Fachada.cadastrarProduto("Pizza Calabresa", "Pizzas", 15.5);
			prod=Fachada.cadastrarProduto("Pizza Quatro Queijos", "Pizzas", 15.5);
			prod=Fachada.cadastrarProduto("Lasanha Bolonhesa", "Lasanha", 10);
			prod=Fachada.cadastrarProduto("Lasanha Frango", "Lasanha", 10);
			prod=Fachada.cadastrarProduto("Escondidiho de Charque", "Escondidinho", 9.5);
			
			System.out.println("\nCama \n");
			c=Fachada.cadastrarCama(10, "beliche inferior");
			c=Fachada.cadastrarCama(20, "beliche inferior");
			c=Fachada.cadastrarCama(30, "beliche inferior");
			c=Fachada.cadastrarCama(40, "beliche inferior");
			c=Fachada.cadastrarCama(50, "beliche inferior");
			c=Fachada.cadastrarCama(60, "beliche Superior");
			c=Fachada.cadastrarCama(70, "beliche Superior");
			c=Fachada.cadastrarCama(80, "beliche Superior");
			c=Fachada.cadastrarCama(90, "beliche Superior");
			c=Fachada.cadastrarCama(100, "beliche Superior");
			
			System.out.println("\nQuarto \n");
			q=Fachada.cadastrarQuarto(101);
			q=Fachada.cadastrarQuarto(102);
			q=Fachada.cadastrarQuarto(103);
			q=Fachada.cadastrarQuarto(104);
			q=Fachada.cadastrarQuarto(201);
			q=Fachada.cadastrarQuarto(202);
			q=Fachada.cadastrarQuarto(203);
			q=Fachada.cadastrarQuarto(204);
			
			System.out.println("\nHospedagem \n");
			hos=Fachada.cadastrarHospedagem("Vicente Benício Santos", "Joao Giovanni Tomas da Mota", 101, 10);
			Fachada.fecharHospedagemDoHospede("Vicente Benício Santos");
			hos=Fachada.cadastrarHospedagem("Vicente Benício Santos", "Joao Giovanni Tomas da Mota", 102, 20);
			hos=Fachada.cadastrarHospedagem("Alice Sara", "Julia Marli Marcia", 103, 30);
			hos=Fachada.cadastrarHospedagem("Lavinia Martins Almeida", "Julia Marli Marcia", 104, 40);
			hos=Fachada.cadastrarHospedagem("Tiago Melo Dias", "Julia Marli Marcia", 201, 50);
			hos=Fachada.cadastrarHospedagem("Julian Oliveira Almeida", "Joao Giovanni Tomas da Mota", 202, 60);
			System.out.println("\nFim Hospedagem \n");

			System.out.println("adicionarCamaQuarto");
			c=Fachada.adicionarCamaQuarto(10, 101);
			c=Fachada.adicionarCamaQuarto(20, 102);
			c=Fachada.adicionarCamaQuarto(30, 103);
			c=Fachada.adicionarCamaQuarto(40, 104);
			c=Fachada.adicionarCamaQuarto(50, 201);
			c=Fachada.adicionarCamaQuarto(60, 202);
			c=Fachada.adicionarCamaQuarto(70, 203);
			c=Fachada.adicionarCamaQuarto(80, 204);
			
			System.out.println("adicionarProdutoHospedagem");
			prod=Fachada.adicionarProdutoHospedagem("Coca-Cola", 1001);
			prod=Fachada.adicionarProdutoHospedagem("Pizza Mussarela", 1001);
			prod=Fachada.adicionarProdutoHospedagem("Sprite", 1001);
			prod=Fachada.adicionarProdutoHospedagem("Empada", 1001);
			prod=Fachada.adicionarProdutoHospedagem("Pizza Calabresa", 1002);
			prod=Fachada.adicionarProdutoHospedagem("Cafe", 1002);
			prod=Fachada.adicionarProdutoHospedagem("Sprite", 1002);
			prod=Fachada.adicionarProdutoHospedagem("Heineken", 1003);
			prod=Fachada.adicionarProdutoHospedagem("Pastel de forno", 1003);
			prod=Fachada.adicionarProdutoHospedagem("Lasanha Bolonhesa", 1003);
			prod=Fachada.adicionarProdutoHospedagem("Pizza Calabresa", 1004);
			prod=Fachada.adicionarProdutoHospedagem("Heineken", 1004);
			prod=Fachada.adicionarProdutoHospedagem("Itaipava", 1005);
			prod=Fachada.adicionarProdutoHospedagem("Pizza Quatro Queijos", 1005);
					
			System.out.println("Itens Cadastrados com sucesso \n");
			
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