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

public class MenuJefe {

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
					MenuJefe window = new MenuJefe();
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
	public MenuJefe() {
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
				RolesJefe window = new RolesJefe();
				window.frame.setVisible(true);
			}
		});
		
		JButton btnPersonas = new JButton("Personas");
		btnPersonas.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		btnPersonas.setBounds(286, 264, 265, 52);
		frame.getContentPane().add(btnPersonas);
		btnPersonas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroJefe window = new RegistroJefe();
				window.frame.setVisible(true);
			}
		});
		
		JButton btnFuncionalidades = new JButton("Funcionalidades");
		btnFuncionalidades.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		btnFuncionalidades.setBounds(286, 357, 265, 52);
		frame.getContentPane().add(btnFuncionalidades);
		
		JLabel lblNewLabel = new JLabel("Ha iniciado sesion como Jefe de seccion");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(573, 10, 258, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnCerrar = new JButton("Cerrar sesion");
		btnCerrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCerrar.setBounds(693, 35, 115, 21);
		frame.getContentPane().add(btnCerrar);
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(MenuJefe.class.getResource("/Vista/d.jpg")));
		lblNewLabel_1.setBounds(0, 0, 831, 467);
		frame.getContentPane().add(lblNewLabel_1);
		btnFuncionalidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuncionalidadesJefe window = new FuncionalidadesJefe();
				window.frame.setVisible(true);
			}
		});
		
		
	}
}
