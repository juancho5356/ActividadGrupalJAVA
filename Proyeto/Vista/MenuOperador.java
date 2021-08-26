package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class MenuOperador {

	private JFrame frame;
	private JPanel panel;
	private JLabel lblBienvenida;
	private JLabel lblBienvenida_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuOperador window = new MenuOperador();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuOperador() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 846, 504);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 0, 0);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblBienvenida_1 = new JLabel("Welcome!");
		lblBienvenida_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenida_1.setForeground(Color.WHITE);
		lblBienvenida_1.setFont(new Font("Baskerville Old Face", Font.BOLD, 60));
		lblBienvenida_1.setBackground(new Color(0, 206, 209));
		lblBienvenida_1.setBounds(10, 10, 821, 152);
		frame.getContentPane().add(lblBienvenida_1);
		
		JButton btnRoles = new JButton("Roles");
		btnRoles.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		btnRoles.setBounds(286, 172, 265, 52);
		frame.getContentPane().add(btnRoles);
		btnRoles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RolesOperador window = new RolesOperador();
				window.frame.setVisible(true);
			}
		});
		
		JButton btnPersonas = new JButton("Personas");
		btnPersonas.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		btnPersonas.setBounds(286, 264, 265, 52);
		frame.getContentPane().add(btnPersonas);
		btnPersonas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoJefe window = new ListadoJefe();
				window.frame.setVisible(true);
			}
		});
		
		JButton btnFuncionalidades = new JButton("Funcionalidades");
		btnFuncionalidades.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		btnFuncionalidades.setBounds(286, 357, 265, 52);
		frame.getContentPane().add(btnFuncionalidades);
		btnFuncionalidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuncionalidadesOperador window = new FuncionalidadesOperador();
				window.frame.setVisible(true);
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MenuOperador.class.getResource("/Vista/d.jpg")));
		lblNewLabel.setBounds(0, 0, 841, 476);
		frame.getContentPane().add(lblNewLabel);
		
		
	}
}
