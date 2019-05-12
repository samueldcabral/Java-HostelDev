package aplicacaoSwing;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import fachada.Fachada;

public class TelaPrincipal {

	private JFrame frmPrincipal;
	private JMenuItem mntmCadastrar;
	private JMenuItem mntmListar;
	private JMenuItem mntmAlterarDeletar;
	private JMenu mnConsulta;
	private JMenu mnFuncionario;
	private JMenu mnHospede;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frmPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			frmPrincipal = new JFrame() { 
			  private Image backgroundImage = ImageIO.read(new File("Resources/img/HostelDev.png"));
			  //private Image backgroundImage = ImageIO.read(getClass().getResource("Resources/img/HostelDev.png"));

			  public void paint( Graphics g ) { 
			    super.paint(g);
			    g.drawImage(backgroundImage, 0, 60, null);
			  }
			};
		} catch (HeadlessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		frmPrincipal.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				Fachada.inicializar();
				//JOptionPane.showMessageDialog(null, "sistema inicializado !");
			}
			@Override
			public void windowClosing(WindowEvent e) {
				Fachada.finalizar();
				//JOptionPane.showMessageDialog(null, "sistema finalizado !");
			}
		});
		frmPrincipal.setTitle("Agenda");
		frmPrincipal.setBounds(600, 30, 1077, 973);
		frmPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPrincipal.getContentPane().setLayout(null);

		
//		BufferedImage myPicture = null;
//		try {
//			myPicture = ImageIO.read(new File("img/HostelDev.png"));
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		frmPrincipal.setLayout(null);
//		
//		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
//		picLabel.setBounds(-154, -61, 1391, 1011);
//		frmPrincipal.add(picLabel);
		
		
		JMenuBar menuBar = new JMenuBar();
		frmPrincipal.setJMenuBar(menuBar);
		
		// HOSPEDE MENU BAR

		mnHospede = new JMenu("Hospede");
		menuBar.add(mnHospede);

		mntmCadastrar = new JMenuItem("Cadastrar");
		mntmCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastro j = new TelaCadastro("Hospede");
			}

		});
		mnHospede.add(mntmCadastrar);

		mntmListar = new JMenuItem("Listar");
		mntmListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListagem j = new TelaListagem("Hospede");
				j.setVisible(true);
			}
		});
		mnHospede.add(mntmListar);

		mntmAlterarDeletar = new JMenuItem("Alterar/Deletar");
		mntmAlterarDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAlteracao j = new TelaAlteracao("Hospede");
			}
		});
		mnHospede.add(mntmAlterarDeletar);

		// FUNCIONARIO MENU BAR
		mnFuncionario = new JMenu("Funcionario");
		menuBar.add(mnFuncionario);
		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		mntmCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastro j = new TelaCadastro("Funcionario");
			}
		});
		mnFuncionario.add(mntmCadastrar);

		JMenuItem mntmListar_1 = new JMenuItem("Listar");
		mntmListar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListagem j = new TelaListagem("Funcionario");
				j.setVisible(true);
			}
		});
		mnFuncionario.add(mntmListar_1);
		
		mntmAlterarDeletar = new JMenuItem("Alterar/Deleter");
		mntmAlterarDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAlteracao j = new TelaAlteracao("Funcionario");
			}
		});
		mnFuncionario.add(mntmAlterarDeletar);
		
		//HOSPEDAGENS MENU BAR
		JMenu mnHospededagem = new JMenu("Hospedagem");
		menuBar.add(mnHospededagem);

		JMenuItem mntmCadastrar_2 = new JMenuItem("Cadastrar");
		mntmCadastrar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastro j = new TelaCadastro("Hospedagem");
			}

		});
		mnHospededagem.add(mntmCadastrar_2);

		JMenuItem mntmListar_2 = new JMenuItem("Listar");
		mntmListar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListagem j = new TelaListagem("Hospedagem");
				j.setVisible(true);
			}
		});
		mnHospededagem.add(mntmListar_2);
		
		mntmAlterarDeletar = new JMenuItem("Alterar/Deleter");
		mntmAlterarDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAlteracao j = new TelaAlteracao("Hospedagem");
			}
		});
		mnHospededagem.add(mntmAlterarDeletar);
		
		//PRODUTO MENU BAR
		JMenu mnProduto = new JMenu("Produto");
		menuBar.add(mnProduto);

		JMenuItem mntmCadastrar_3 = new JMenuItem("Cadastrar");
		mntmCadastrar_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastro j = new TelaCadastro("Produto");
			}

		});
		mnProduto.add(mntmCadastrar_3);

		JMenuItem mntmListar_3 = new JMenuItem("Listar");
		mntmListar_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListagem j = new TelaListagem("Produto");
				j.setVisible(true);
			}
		});
		mnProduto.add(mntmListar_3);
		
		mntmAlterarDeletar = new JMenuItem("Alterar/Deleter");
		mntmAlterarDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAlteracao j = new TelaAlteracao("Produto");
			}
		});
		mnProduto.add(mntmAlterarDeletar);
		
		//QUARTO MENU BAR
		JMenu mnQuarto = new JMenu("Quarto");
		menuBar.add(mnQuarto);

		JMenuItem mntmCadastrar_4 = new JMenuItem("Cadastrar");
		mntmCadastrar_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastro j = new TelaCadastro("Quarto");
			}

		});
		mnQuarto.add(mntmCadastrar_4);

		JMenuItem mntmListar_4 = new JMenuItem("Listar");
		mntmListar_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListagem j = new TelaListagem("Quarto");
				j.setVisible(true);
			}
		});
		mnQuarto.add(mntmListar_4);
		
		mntmAlterarDeletar = new JMenuItem("Alterar/Deleter");
		mntmAlterarDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAlteracao j = new TelaAlteracao("Quarto");
			}
		});
		mnQuarto.add(mntmAlterarDeletar);
		
		//CAMA MENU BAR
		JMenu mnCama = new JMenu("Cama");
		menuBar.add(mnCama);

		JMenuItem mntmCadastrar_5 = new JMenuItem("Cadastrar");
		mntmCadastrar_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastro j = new TelaCadastro("Cama");
			}

		});
		mnCama.add(mntmCadastrar_5);

		JMenuItem mntmListar_5 = new JMenuItem("Listar");
		mntmListar_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListagem j = new TelaListagem("Cama");
				j.setVisible(true);
			}
		});
		mnCama.add(mntmListar_5);
		
		mntmAlterarDeletar = new JMenuItem("Alterar/Deleter");
		mntmAlterarDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAlteracao j = new TelaAlteracao("Cama");
			}
		});
		mnCama.add(mntmAlterarDeletar);
		
		//CONSULTAS MENU BAR
		mnConsulta = new JMenu("Consultas");
		mnConsulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				TelaConsulta j = new TelaConsulta();
				j.setVisible(true);

			
			}
		});
		menuBar.add(mnConsulta);
	
	

			
	
		}
	}

