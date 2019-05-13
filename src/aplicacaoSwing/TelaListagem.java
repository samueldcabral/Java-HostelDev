package aplicacaoSwing;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import java.awt.Font;

public class TelaListagem extends JFrame {
	private JPanel contentPane;
	private JTextArea textArea;
	private JButton btnCriar;

	private String cls;
	public TelaListagem(String classe) {
		this.cls = classe;
		setTitle("Listar");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(700, 150, 899, 573);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		btnCriar = new JButton("Listar " + classe);
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(cls.equals("Hospede")) {
						textArea.setText(Fachada.listarHospedes());
					}else if(cls.equals("Funcionario")){
						textArea.setText(Fachada.listarFuncionarios());
					}else if(cls.equals("Hospedagem")) {
						textArea.setText(Fachada.listarHospedagens());
					}else if(cls.equals("Produto")) {
						textArea.setText(Fachada.listarProdutos());
					}else if(cls.equals("Quarto")) {
						textArea.setText(Fachada.listarQuartos());
					}else if(cls.equals("Cama")) {
						textArea.setText(Fachada.listarCamas());
					}else {
						textArea.setText("Seleçao Invalida");
					}
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(null,erro.getMessage());
				}
			}
		});
		btnCriar.setBounds(339, 457, 175, 56);
		contentPane.add(btnCriar);

		textArea = new JTextArea();
		textArea.setFont(new Font("Bahnschrift", Font.PLAIN, 19));
		textArea.setLineWrap(true);
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setBounds(12, 29, 857, 422);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(scroll);
	}
}
