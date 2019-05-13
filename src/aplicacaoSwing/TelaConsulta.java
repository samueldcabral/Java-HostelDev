package aplicacaoSwing;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import modelo.Produto;

public class TelaConsulta extends JFrame {
	private JPanel contentPane;
	private JTextArea textArea;
	private JButton btnCriar;
	private JButton btnProdHospede;
	private JButton btnValorTotalemProdutos;


	public TelaConsulta() {
		setTitle("Consultar");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 790, 302);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnCriar = new JButton("Pessoas por parte do nome");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String nom = JOptionPane.showInputDialog("digite parte do nome");
					textArea.setText(Fachada.consultarPessoasPorParteNome(nom));
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(null,erro.getMessage());
				}
			}
		});
		btnCriar.setBounds(488, 13, 272, 23);
		contentPane.add(btnCriar);

		textArea = new JTextArea();
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setBounds(20, 11, 454, 231);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(scroll);
		
		btnProdHospede = new JButton("Listar todos produtos do hospede");
		btnProdHospede.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nomeHospede = JOptionPane.showInputDialog("Digite o nome do Hospede: ");
					ArrayList<Produto> prods = Fachada.consultarProdutosDeTodasHospedagensDoHospede(nomeHospede);
					String textoFinal = "";
					
					for(Produto p : prods) {
						textoFinal += p.getNome() + " : " + p.getDescricao() + " : " + p.getValor() + "\n\n";
					}
					
					if(textoFinal.equals("")) {
						textArea.setText(textoFinal);
					}else {
						textArea.setText("Consulta vazia");
					}
					
					
				}catch (Exception erro){
					JOptionPane.showMessageDialog(null,erro.getMessage());
				}
			}
		});
		
		btnProdHospede.setBounds(488, 57, 272, 23);
		contentPane.add(btnProdHospede);
		
		btnValorTotalemProdutos = new JButton("Valor total em produtos por hospede");
		btnValorTotalemProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeHospede = JOptionPane.showInputDialog("Digite o nome do Hospede: ");
				try {
					textArea.setText(Fachada.consultarValorGastoPorProdutosNaHospedagemHospede(nomeHospede) + "");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}
			}
		});
		btnValorTotalemProdutos.setBounds(488, 102, 272, 23);
		contentPane.add(btnValorTotalemProdutos);
		
		JButton btnFuncCadastrouHosp = new JButton("Funcionario Cadastrou o hospede");
		btnFuncCadastrouHosp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeHospede = JOptionPane.showInputDialog("Digite o nome do Hospede: ");
				try {
					ArrayList<String> funcs = Fachada.consultarFuncionarioCadastrouHospede(nomeHospede);
					String textoFinal = "";
					
					for(String str : funcs) {
						textoFinal += str;
					}
					textArea.setText(textoFinal);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}
			}
		});
		btnFuncCadastrouHosp.setBounds(488, 142, 272, 23);
		contentPane.add(btnFuncCadastrouHosp);
		
		
	}
}
