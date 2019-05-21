package aplicacaoSwing;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import modelo.Hospede;
import modelo.Produto;
import java.awt.Font;

public class TelaConsulta extends JFrame {
	private JPanel contentPane;
	private JTextArea textArea;
	private JButton btnCriar;
	private JButton btnHospedeQuarto;
	private JButton btnHospedePorProdutos;


	public TelaConsulta() {
		setTitle("Consultar");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(600, 100, 968, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnCriar = new JButton("Pessoas por parte do nome");
		btnCriar.setFont(new Font("Tahoma", Font.PLAIN, 15));
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
		btnCriar.setBounds(648, 25, 272, 32);
		contentPane.add(btnCriar);

		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setBounds(20, 11, 616, 356);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(scroll);
		
		btnHospedeQuarto = new JButton("Consultar Hospedes por Quarto");
		btnHospedeQuarto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnHospedeQuarto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String numero = JOptionPane.showInputDialog("Digite o numero do quarto: ");
					List<Hospede> hospedes = Fachada.consultarHospedePorQuarto(Integer.parseInt(numero));
					String textoFinal = "";
					
					for(Hospede h : hospedes) {
						textoFinal += h.getNome() + " com telefone " + h.getTelefone() + " ficou no quarto " + numero + "\n\n";
					}
					
					if(!textoFinal.equals("")) {
						textArea.setText(textoFinal);
					}else {
						textArea.setText("Consulta vazia");
					}
					
					
				}catch (Exception erro){
					JOptionPane.showMessageDialog(null,erro.getMessage());
				}
			}
		});
		
		btnHospedeQuarto.setBounds(648, 93, 272, 32);
		contentPane.add(btnHospedeQuarto);
		
		btnHospedePorProdutos = new JButton("Consultar Hospedes por produtos");
		btnHospedePorProdutos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnHospedePorProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nomeProduto = JOptionPane.showInputDialog("Digite o nome do Produto: ");
					List<Hospede> hospedes = Fachada.consultarHospedePorProduto(nomeProduto);
					String textoFinal = "";
					
					for(Hospede h : hospedes) {
						textoFinal += h.getNome() + " com telefone " + h.getTelefone() + " consumiu " + nomeProduto + "\n\n";
					}
					
					if(!textoFinal.equals("")) {
						textArea.setText(textoFinal);
					}else {
						textArea.setText("Consulta vazia");
					}
					
					
					
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}
			}
		});
		btnHospedePorProdutos.setBounds(648, 171, 272, 32);
		contentPane.add(btnHospedePorProdutos);
		
		JButton btnProdutosPorHospede = new JButton("Consultar produto por hospede");
		btnProdutosPorHospede.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnProdutosPorHospede.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nomeHospede = JOptionPane.showInputDialog("Digite o nome do Hospede: ");
					List<Produto> produtos = Fachada.consultarProdutosPorHospede(nomeHospede);
					String textoFinal = "";
					
					for(Produto p : produtos) {
						textoFinal += p.getNome() + " com valor " + p.getValor() + " foi consumido por " + nomeHospede + "\n\n";
					}
					
					if(!textoFinal.equals("")) {
						textArea.setText(textoFinal);
					}else {
						textArea.setText("Consulta vazia");
					}
					

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}
			}
		});
		btnProdutosPorHospede.setBounds(648, 259, 272, 32);
		contentPane.add(btnProdutosPorHospede);
		
		
	}
}
