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
	private JButton button1;
	private JList<String> list;
	private JScrollPane scrollPane;
	private JButton button2;
	private DefaultListModel<String> model;
	private JLabel label2;

	private String cls;
	private JTextField textField_2;
	private JTextField textField_4;
	private JLabel lblIdcama;
	private JTextField textField_5;
	private JLabel label6;
	private JTextField textField_6;
	private JButton btnAdicionar;
	
	public TelaCadastro(String classe) {
		this.cls = classe;
		initialize();
	}


	private void initialize() {
	
		frmCadastro = new JFrame();
		frmCadastro.setTitle("Cadastrar " + cls);
		frmCadastro.setBounds(100, 100, 395, 438);
		frmCadastro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCadastro.getContentPane().setLayout(null);
		
		label2 = new JLabel("Nome:");
		label2.setBounds(42, 33, 76, 14);
		frmCadastro.getContentPane().add(label2);
		
		JLabel label3 = new JLabel("Telefone:");
		label3.setBounds(32, 77, 86, 14);
		frmCadastro.getContentPane().add(label3);
		
		final JLabel label4 = new JLabel("Salario");
		label4.setBounds(42, 121, 86, 14);
		frmCadastro.getContentPane().add(label4);
		
		JLabel label5 = new JLabel("idCama");
		label5.setBounds(42, 157, 86, 14);
		frmCadastro.getContentPane().add(label5);
		
		label6 = new JLabel("idProduto");
		label6.setBounds(32, 193, 86, 14);
		frmCadastro.getContentPane().add(label6);
		
		final JLabel label7 = new JLabel("Resultado:");
		label7.setBounds(10, 246, 189, 14);
		frmCadastro.getContentPane().add(label7);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(140, 30, 105, 20);
		frmCadastro.getContentPane().add(textField_2);
		
		final JTextField textField_3 = new JTextField();
		textField_3.setBounds(150, 74, 95, 20);
		frmCadastro.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(140, 118, 105, 20);
		frmCadastro.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(140, 154, 105, 20);
		frmCadastro.getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(140, 193, 105, 20);
		frmCadastro.getContentPane().add(textField_6);
		
		btnAdicionar = new JButton("Adicionar: " + cls);
		btnAdicionar.setBounds(100, 354, 167, 25);
		frmCadastro.getContentPane().add(btnAdicionar);
		
		if(cls.equals("Hospede")) {
			label4.setVisible(false);
			textField_4.setVisible(false);
			label5.setVisible(false);
			textField_5.setVisible(false);
			label6.setVisible(false);
			textField_6.setVisible(false);
			textField_6.setVisible(false);
			btnAdicionar.setVisible(false);
			
		} else if(cls.equals("Funcionario")) {
			label5.setVisible(false);
			label6.setVisible(false);
			textField_5.setVisible(false);
			textField_6.setVisible(false);
			textField_6.setVisible(false);
			btnAdicionar.setVisible(false);
			
		} else if(cls.equals("Hospedagem")) {
			label2.setText("Nome Hospede");
			label3.setText("Nome Funcionario");
			label4.setText("IdQuarto");
			
			
		} else if(cls.equals("Produto")) {
			label3.setText("Descricao");
			label4.setText("valor");
			label5.setVisible(false);
			label6.setVisible(false);
			textField_5.setVisible(false);
			textField_6.setVisible(false);
			textField_6.setVisible(false);
			btnAdicionar.setVisible(false);
			
		} else if(cls.equals("Cama")) {
			label2.setText("Numero");
			label3.setText("Descricao");
			label4.setVisible(false);
			textField_4.setVisible(false);
			label5.setVisible(false);
			label6.setVisible(false);
			textField_5.setVisible(false);
			textField_6.setVisible(false);
			textField_6.setVisible(false);
			btnAdicionar.setVisible(false);
			
		} else if(cls.equals("Quarto")) {
			label2.setText("Numero");
			label3.setVisible(false);
			textField_3.setVisible(false);
			label6.setVisible(false);
			label4.setVisible(false);
			textField_4.setVisible(false);
			label5.setVisible(false);
			label6.setVisible(false);
			textField_5.setVisible(false);
			textField_6.setVisible(false);
			btnAdicionar.setVisible(false);
			 
			
		}else {
			System.out.println("erro");
		}

		JButton btnNewButton = new JButton("Cadastrar " + cls);
		btnNewButton.setBounds(100, 316, 167, 25);
		frmCadastro.getContentPane().add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(cls.equals("Hospede")) {
						String nomeHospede = textField_2.getText();
						String telefoneHospede = textField_3.getText();
						
						if(!nomeHospede.isEmpty()) {
							Fachada.cadastrarHospede(nomeHospede, telefoneHospede);
							label7.setText("Resultado: cadastro concluido");
						}else {
							label7.setText("Resultado: Erro! Cadastro nao realizado");
						}
		
						textField_2.setText("");
						textField_3.setText("");
						
					} else if(cls.equals("Funcionario")) {
						String nomeFuncionario = textField_2.getText();
						String telefoneFuncionario = textField_3.getText();
						Double salarioFuncionario = Double.parseDouble(textField_4.getText());
						
						if(!nomeFuncionario.isEmpty()) {
							Fachada.cadastrarFuncionario(nomeFuncionario, telefoneFuncionario, salarioFuncionario);
							label7.setText("Resultado: cadastro concluido");
						}else {
							label7.setText("Resultado: Erro! Cadastro nao realizado");
						}
		
						textField_2.setText("");
						textField_3.setText("");
						textField_4.setText("");
						
					} else if(cls.equals("Hospedagem")) {
						String nomeHospede = textField_2.getText();
						String nomeFuncionario = textField_3.getText();
						String idQuarto = textField_4.getText();
						String idCama = textField_5.getText();
						
						if(!nomeHospede.isEmpty() && !idQuarto.isEmpty() && !idCama.isEmpty()) {
							Fachada.cadastrarHospedagem(nomeHospede, nomeFuncionario, Integer.parseInt(idQuarto), Integer.parseInt(idCama));
							label7.setText("Resultado: cadastro concluido");
						}else {
							label7.setText("Resultado: Erro! Cadastro nao realizado");
						}
		
						textField_2.setText("");
						textField_3.setText("");
						textField_4.setText("");
						textField_5.setText("");
						
					} else if(cls.equals("Produto")) {
						String nomeProduto = textField_2.getText();
						String descricaoProduto = textField_3.getText();
						Double valorProduto = Double.parseDouble(textField_4.getText());
						
						if(!nomeProduto.isEmpty()) {
							Fachada.cadastrarProduto(nomeProduto, descricaoProduto, valorProduto);
							label7.setText("Resultado: cadastro concluido");
						}else {
							label7.setText("Resultado: Erro! Cadastro nao realizado");
						}
		
						textField_2.setText("");
						textField_3.setText("");
						textField_4.setText("");
						
					} else if(cls.equals("Cama")) {
						String numeroCama = textField_2.getText();
						String descricaoCama = textField_3.getText();
						
						if(!numeroCama.isEmpty()) {
							Fachada.cadastrarCama(Integer.parseInt(numeroCama), descricaoCama);
							label7.setText("Resultado: cadastro concluido");
						}else {
							label7.setText("Resultado: Erro! Cadastro nao realizado");
						}
		
						textField_2.setText("");
						textField_3.setText("");
						
					} else if(cls.equals("Quarto")) {
						String numeroQuarto = textField_2.getText();
						
						if(!numeroQuarto.isEmpty()) {
							Fachada.cadastrarQuarto(Integer.parseInt(numeroQuarto));
							label7.setText("Resultado: cadastro concluido");
						}else {
							label7.setText("Resultado: Erro! Cadastro nao realizado");
						}
		
						textField_2.setText("");
						
					}else {
						System.out.println("erro");
					}
				}
				catch(Exception e) {
				}
			}
		});
		
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(cls.equals("Hospedagem")) {
						int idHospedagem = Fachada.pegarHospedagemAbertaHospede(textField_2.getText()).getId();
						String nomeProduto = textField_6.getText();
						
						if(!nomeProduto.isEmpty()) {
							Fachada.adicionarProdutoHospedagem(nomeProduto, idHospedagem);
							label7.setText("Resultado: Adicionar concluido");
						}else {
							label7.setText("Resultado: Erro! Adicionar nao realizado");
						}
		
						textField_6.setText("");
						
					} else if(cls.equals("Quarto")) {
						String numeroQuarto = textField_2.getText();
						String numeroCama = textField_3.getText();
						
						if(!numeroQuarto.isEmpty() && !numeroCama.isEmpty()) {
							Fachada.adicionarCamaQuarto(Integer.parseInt(numeroCama), Integer.parseInt(numeroQuarto));
							label7.setText("Resultado: cadastro concluido");
						}else {
							label7.setText("Resultado: Erro! Cadastro nao realizado");
						}
		
						textField_3.setText("");
						
					}else {
						System.out.println("erro");
					}
				}
				catch(Exception e) {
				}
			}
		});
		frmCadastro.setVisible(true);
		}
	}