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

public class TelaAlteracao {

	private JFrame frmCadastro;
	private JLabel label1;
	private JTextField textField_1;
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
	private JButton btnExcluir;
	
	public TelaAlteracao(String classe) {
		this.cls = classe;
		initialize();
	}

	private void initialize() {
	
		frmCadastro = new JFrame();
		frmCadastro.setTitle("Alterar/Deletar " + cls);
		frmCadastro.setBounds(100, 100, 395, 438);
		frmCadastro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCadastro.getContentPane().setLayout(null);
		
		label1 = new JLabel("Id:");
		label1.setBounds(61, 34, 46, 14);
		frmCadastro.getContentPane().add(label1);
		
		label2 = new JLabel("Nome:");
		label2.setBounds(45, 76, 76, 14);
		frmCadastro.getContentPane().add(label2);
		
		JLabel label3 = new JLabel("Telefone:");
		label3.setBounds(21, 115, 86, 14);
		frmCadastro.getContentPane().add(label3);
		
		final JLabel label4 = new JLabel("Salario");
		label4.setBounds(21, 159, 86, 14);
		frmCadastro.getContentPane().add(label4);
		
		JLabel label5 = new JLabel("idCama");
		label5.setBounds(21, 198, 86, 14);
		frmCadastro.getContentPane().add(label5);
		
		final JLabel label6 = new JLabel("Resultado:");
		label6.setBounds(10, 237, 189, 14);
		frmCadastro.getContentPane().add(label6);
		
		textField_1 = new JTextField();
		textField_1.setBounds(150, 31, 95, 20);
		frmCadastro.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(140, 73, 105, 20);
		frmCadastro.getContentPane().add(textField_2);
		
		final JTextField textField_3 = new JTextField();
		textField_3.setBounds(150, 112, 95, 20);
		frmCadastro.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(140, 156, 105, 20);
		frmCadastro.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(141, 195, 105, 20);
		frmCadastro.getContentPane().add(textField_5);
		
		if(cls.equals("Hospede")) {
			label1.setText("Nome");
			label2.setText("Novo Nome");
			label3.setVisible(false);
			textField_3.setVisible(false);
			label4.setVisible(false);
			textField_4.setVisible(false);
			label5.setVisible(false);
			textField_5.setVisible(false);
			
		} else if(cls.equals("Funcionario")) {
			label1.setText("Nome");
			label2.setText("Novo Nome");
			label3.setText("Novo Salario");
			label4.setVisible(false);
			textField_4.setVisible(false);
			label5.setVisible(false);
			textField_5.setVisible(false);
			
		} else if(cls.equals("Hospedagem")) {
			label2.setText("Nome Hospede");
			label3.setText("Nome Funcionario");
			label4.setText("IdQuarto");
			
		} else if(cls.equals("Produto")) {
			label1.setText("Nome: ");
			label2.setText("Novo Nome:");
			label3.setText("Nova Descricao");
			label4.setText("Novo valor");
			label5.setVisible(false);
			textField_5.setVisible(false);
			
		} else if(cls.equals("Cama")) {
			label2.setText("Numero");
			label3.setText("Descricao");
			label4.setVisible(false);
			textField_4.setVisible(false);
			label5.setVisible(false);
			textField_5.setVisible(false);
			
		} else if(cls.equals("Quarto")) {
			label2.setText("Numero");
			label3.setVisible(false);
			textField_3.setVisible(false);
			label4.setVisible(false);
			textField_4.setVisible(false);
			label5.setVisible(false);
			textField_5.setVisible(false);
			
		}else {
			System.out.println("erro");
		}

		JButton btnNewButton = new JButton("Alterar " + cls);
		btnNewButton.setBounds(102, 304, 167, 25);
		frmCadastro.getContentPane().add(btnNewButton);
		
		btnExcluir = new JButton("Excluir " + cls);
		btnExcluir.setBounds(102, 353, 167, 25);
		frmCadastro.getContentPane().add(btnExcluir);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(cls.equals("Hospede")) {
						String nomeHospede = textField_1.getText();
						String novoNomeHospede = textField_2.getText();
						
						if(!nomeHospede.isEmpty() && !novoNomeHospede.isEmpty()) {
							Fachada.alterarPessoa(nomeHospede, novoNomeHospede);
							label6.setText("Resultado: Alteracao concluida");
						}else {
							label6.setText("Resultado: Erro! Alteracao nao realizada");
						}
		
						textField_1.setText("");
						textField_2.setText("");
						
					} else if(cls.equals("Funcionario")) {
						String nomeFuncionario = textField_1.getText();
						String novoFuncionario = textField_2.getText();
						String novoSalario = textField_3.getText();
						
						if(!nomeFuncionario.isEmpty() && !novoSalario.isEmpty() && !novoFuncionario.isEmpty()) {
							Fachada.alterarFuncionario(nomeFuncionario, Fachada.listarFuncionario(nomeFuncionario).getMatricula(), Double.parseDouble(novoSalario));
							Fachada.alterarPessoa(nomeFuncionario, novoFuncionario);
							label6.setText("Resultado: Alteracao concluida");
						}else if(!nomeFuncionario.isEmpty() && !novoFuncionario.isEmpty()){
							Fachada.alterarPessoa(nomeFuncionario, novoFuncionario);
							label6.setText("Resultado: Erro! Alteracao nao realizada");
						}else {
							label6.setText("Resultado: Erro! Alteracao nao realizada");
						}
		
						textField_1.setText("");
						textField_2.setText("");
						textField_3.setText("");
						
					} else if(cls.equals("Hospedagem")) {
//						String idHospedagem = textField_1.getText();
//						String nomeHospede = textField_2.getText();
//						String nomeFuncionario = textField_3.getText();
//						String idQuarto = textField_4.getText();
//						String idCama = textField_5.getText();
//						
//						if(!idHospedagem.isEmpty() && !nomeHospede.isEmpty() && !idQuarto.isEmpty() && !idCama.isEmpty()) {
//							Fachada.cadastrarHospedagem(idHospedagem, nomeHospede, nomeFuncionario, idQuarto, idCama);
//							label6.setText("Resultado: Alteracao concluido");
//						}else {
//							label6.setText("Resultado: Erro! Alteracao nao realizado");
//						}
//		
//						textField_1.setText("");
//						textField_2.setText("");
//						textField_3.setText("");
//						textField_4.setText("");
//						textField_5.setText("");
						
					} else if(cls.equals("Produto")) {
						String nomeProduto = textField_1.getText();
						String novoNomeProduto = textField_2.getText();
						String descricaoProduto = textField_3.getText();
						Double valorProduto = Double.parseDouble(textField_4.getText());
						
						if(!nomeProduto.isEmpty() && !novoNomeProduto.isEmpty()) {
							Fachada.alterarProduto(nomeProduto, novoNomeProduto, descricaoProduto, valorProduto);
							label6.setText("Resultado: Alteracao concluido");
						}else {
							label6.setText("Resultado: Erro! Alteracao nao realizado");
						}
		
						textField_1.setText("");
						textField_2.setText("");
						textField_3.setText("");
						textField_4.setText("");
						
					} else if(cls.equals("Cama")) {
						String idCama = textField_1.getText();
						String numeroCama = textField_2.getText();
						String descricaoCama = textField_3.getText();
						
						if(!idCama.isEmpty() && !numeroCama.isEmpty()) {
//							Fachada.cadastrarCama(idCama, numeroCama, descricaoCama);
							label6.setText("Resultado: Alteracao concluido");
						}else {
							label6.setText("Resultado: Erro! Alteracao nao realizado");
						}
		
						textField_1.setText("");
						textField_2.setText("");
						textField_3.setText("");
						
					} else if(cls.equals("Quarto")) {
						String idQuarto = textField_1.getText();
						String numeroQuarto = textField_2.getText();
						
						if(!idQuarto.isEmpty() && !numeroQuarto.isEmpty()) {
//							Fachada.cadastrarQuarto(idQuarto, numeroQuarto);
							label6.setText("Resultado: Alteracao concluido");
						}else {
							label6.setText("Resultado: Erro! Alteracao nao realizado");
						}
		
						textField_1.setText("");
						textField_2.setText("");
						
					}else {
						System.out.println("erro");
					}
				}
				catch(Exception e) {
				}
			}
		});
		
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(cls.equals("Hospede")) {
						String nomeHospede = textField_1.getText();
						String novoNomeHospede = textField_2.getText();
						
						if(!nomeHospede.isEmpty()) {
							Fachada.excluirHospede(nomeHospede);
							label6.setText("Resultado: Exclusao concluida");
						}else {
							label6.setText("Resultado: Erro! Exclusao nao realizada");
						}
		
						textField_1.setText("");
						textField_2.setText("");
						
					} else if(cls.equals("Funcionario")) {
						String nomeFuncionario = textField_1.getText();
						String novoFuncionario = textField_2.getText();
						
						if(!nomeFuncionario.isEmpty() && !novoFuncionario.isEmpty()) {
							Fachada.alterarPessoa(nomeFuncionario, novoFuncionario);
							label6.setText("Resultado: Exclusao concluida");
						}else {
							label6.setText("Resultado: Erro! Exclusao nao realizada");
						}
		
						textField_1.setText("");
						textField_2.setText("");
						
					} else if(cls.equals("Hospedagem")) {
						String idHospedagem = textField_1.getText();
						
						if(!idHospedagem.isEmpty()) {
							Fachada.excluirHospedagem(idHospedagem);
							label6.setText("Resultado: Exclusao concluido");
						}else {
							label6.setText("Resultado: Erro! Exclusao nao realizado");
						}
		
						textField_1.setText("");
						textField_2.setText("");
						textField_3.setText("");
						textField_4.setText("");
						textField_5.setText("");
						
					} else if(cls.equals("Produto")) {
						String idProduto = textField_1.getText();
						String nomeProduto = textField_2.getText();
						
						if(!nomeProduto.isEmpty()) {
							Fachada.excluirProduto(nomeProduto);
							label6.setText("Resultado: Exclusao concluido");
						}else {
							label6.setText("Resultado: Erro! Exclusao nao realizado");
						}
						
						textField_1.setText("");
						textField_2.setText("");
						textField_3.setText("");
						textField_4.setText("");
						
					} else if(cls.equals("Cama")) {
						String idCama = textField_1.getText();

						if(!idCama.isEmpty()) {
							Fachada.excluirCama(Integer.parseInt(idCama));
							label6.setText("Resultado: Exclusao concluido");
						}else {
							label6.setText("Resultado: Erro! Exclusao nao realizado");
						}
		
						textField_1.setText("");

						
					} else if(cls.equals("Quarto")) {
						String idQuarto = textField_1.getText();
						
						if(!idQuarto.isEmpty()) {
							Fachada.excluirQuarto(idQuarto);
							label6.setText("Resultado: Exclusao concluido");
						}else {
							label6.setText("Resultado: Erro! Exclusao nao realizado");
						}
		
						textField_1.setText("");
						textField_2.setText("");
						
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
