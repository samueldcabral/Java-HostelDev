package aplicacaoSwing;

import java.awt.EventQueue;
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
		frmPrincipal = new JFrame();


		frmPrincipal.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				Fachada.inicializar();
				JOptionPane.showMessageDialog(null, "sistema inicializado !");
			}
			@Override
			public void windowClosing(WindowEvent e) {
				Fachada.finalizar();
				JOptionPane.showMessageDialog(null, "sistema finalizado !");
			}
		});
		frmPrincipal.setTitle("Agenda");
		frmPrincipal.setBounds(1200, 300, 624, 306);
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
				TelaCadastro j = new TelaCadastro();
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


		// FUNCIONARIO MENU BAR
		mnFuncionario = new JMenu("Funcionario");
		menuBar.add(mnFuncionario);
		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		mntmCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		
		//HOSPEDAGENS MENU BAR
		JMenu mnHospededagem = new JMenu("Hospedagem");
		menuBar.add(mnHospededagem);

		JMenuItem mntmCadastrar_2 = new JMenuItem("Cadastrar");
		mntmCadastrar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastro j = new TelaCadastro();
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
