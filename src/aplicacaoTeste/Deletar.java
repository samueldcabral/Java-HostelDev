package aplicacaoTeste;

import fachada.Fachada;

public class Deletar {
	public Deletar(){
		Fachada.inicializar();
		try {
			System.out.println("deletando...");
			
			Fachada.excluirHospede("Guilherme Ferreira Pinto");
			Fachada.excluirFuncionario("Murilo Correia Pinto");
			Fachada.excluirProdutoHospedagem("Coca-Cola", 1001);
			Fachada.excluirCama(100);
			Fachada.excluirCamasDoQuarto(103);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		Fachada.finalizar();
		System.out.println("fim do programa");
	}

	public static void main(String[] args) {
		new Deletar();
	}
}

