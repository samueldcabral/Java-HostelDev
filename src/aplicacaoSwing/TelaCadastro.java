package aplicacaoSwing;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import fachada.Fachada;

public class TelaCadastro {

	private JFrame frmCadastro;
	private JLabel label1;
	private JTextField textField;
	private JTextField textField_1;
	private JButton button1;
	private JList<String> list;
	private JScrollPane scrollPane;
	private JButton button2;
	private DefaultListModel<String> model;
	private JLabel label2;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaCadastro window = new TelaCadastro();
//					window.frmCadastro.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	
//	public TelaListagem() {
//		
//		
		private String cls;
	public TelaCadastro(String classe) {
		this.cls = classe;
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		if(this.cls.equals("Hospede")) {
			cadastrarHospede();
		}else {
			
		
		frmCadastro = new JFrame();
		frmCadastro.setTitle("Cadastro");
		frmCadastro.setBounds(100, 100, 225, 331);
		frmCadastro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCadastro.getContentPane().setLayout(null);
		
		label1 = new JLabel("nome:");
		label1.setBounds(25, 34, 46, 14);
		frmCadastro.getContentPane().add(label1);
		
		label2 = new JLabel("");
		label2.setBounds(10, 276, 189, 14);
		frmCadastro.getContentPane().add(label2);
		
		textField = new JTextField();
		textField.setBounds(62, 31, 86, 20);
		frmCadastro.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(53, 77, 78, 20);
		frmCadastro.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		button2 = new JButton("Cadastrar Pessoa");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String nome = textField.getText();
//					Fachada.cadastrarPessoa(nome);
					if(!model.isEmpty()) {
						for(int i=0; i<model.size(); i++) {
							String numero = (String) model.get(i);
//							Fachada.adicionarTelefonePessoa(nome,numero );
						}
					}
					model.clear();
					textField.setText("");
					label2.setText("cadastro concluido");
				}
				catch(Exception e) {
					
				}
			}
		});
		
		button1 = new JButton("inserir telefone");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String num = textField_1.getText();
				if(!model.contains(num))
					model.addElement(num);
				else
					label2.setText("numero ja incluido");
			}
		});
		button1.setBounds(28, 108, 120, 23);
		frmCadastro.getContentPane().add(button1);
		button2.setBounds(25, 242, 145, 23);
		frmCadastro.getContentPane().add(button2);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 142, 78, 80);
		frmCadastro.getContentPane().add(scrollPane);
		
		model = new DefaultListModel<String>() ;
		list = new JList<String>(model);
		scrollPane.setColumnHeaderView(list);
		
		//mostrar a janela
		frmCadastro.setVisible(true);
		}
	}
	
	/**
	 * @wbp.parser.entryPoint
	 */
	private void cadastrarHospede() {
		frmCadastro = new JFrame();
		frmCadastro.setTitle("Cadastro");
		frmCadastro.setBounds(100, 100, 225, 331);
		frmCadastro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCadastro.getContentPane().setLayout(null);
		
		label1 = new JLabel("Id:");
		label1.setBounds(25, 34, 46, 14);
		frmCadastro.getContentPane().add(label1);
		
		label2 = new JLabel("Nome:");
		label2.setBounds(10, 76, 189, 14);
		frmCadastro.getContentPane().add(label2);
		
		JLabel label3 = new JLabel("Telefone:");
		label3.setBounds(10, 116, 189, 14);
		frmCadastro.getContentPane().add(label3);
		
		final JLabel label4 = new JLabel("Resultado:");
		label4.setBounds(10, 156, 189, 14);
		frmCadastro.getContentPane().add(label4);
		
		textField = new JTextField();
		textField.setBounds(62, 31, 86, 20);
		frmCadastro.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(53, 77, 78, 20);
		frmCadastro.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		final JTextField textField_2 = new JTextField();
		textField_2.setBounds(53, 117, 78, 20);
		frmCadastro.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		button2 = new JButton("Cadastrar Pessoa");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String idHospede = textField.getText();
					String nomeHospede = textField_1.getText();
					String telefoneHospede = textField_2.getText();
					
					if(!idHospede.isEmpty() && !nomeHospede.isEmpty()) {
						Fachada.cadastrarHospede(idHospede, nomeHospede, telefoneHospede);
						label4.setText("Resultado: cadastro concluido");
					}else {
						label4.setText("Resultado: Erro! Cadastro nao realizado");
					}
	
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
				}
				catch(Exception e) {
					
				}
			}
		});
		
//		button1 = new JButton("inserir telefone");
//		button1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				String num = textField_1.getText();
//				if(!model.contains(num))
//					model.addElement(num);
//				else
//					label2.setText("numero ja incluido");
//			}
//		});
//		button1.setBounds(28, 108, 120, 23);
//		frmCadastro.getContentPane().add(button1);
		button2.setBounds(25, 242, 145, 23);
		frmCadastro.getContentPane().add(button2);
		
//		scrollPane = new JScrollPane();
//		scrollPane.setBounds(53, 142, 78, 80);
//		frmCadastro.getContentPane().add(scrollPane);
//		
//		model = new DefaultListModel<String>() ;
//		list = new JList<String>(model);
//		scrollPane.setColumnHeaderView(list);
		
		//mostrar a janela
		frmCadastro.setVisible(true);
	}
}
