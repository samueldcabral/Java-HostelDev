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

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaListagem window = new TelaListagem();
//					window.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	private String cls;
	public TelaListagem(String classe) {
		this.cls = classe;
		setTitle("Listar");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(700, 150, 869, 403);
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
		btnCriar.setBounds(24, 270, 175, 56);
		contentPane.add(btnCriar);

		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
		textArea.setLineWrap(true);
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setBounds(24, 29, 793, 210);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(scroll);
//
//		btnListarTelefones = new JButton("Listar Telefones");
//		btnListarTelefones.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				try{
//
//					textArea.setText(Fachada.listarTelefones());
//				}
//				catch(Exception erro){
//					JOptionPane.showMessageDialog(null,erro.getMessage());
//				}
//			}
//		});
//		btnListarTelefones.setBounds(306, 149, 115, 23);
//		contentPane.add(btnListarTelefones);
	}
}
