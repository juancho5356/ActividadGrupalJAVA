package Vista;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;

import javax.swing.SwingConstants;

import Modelo.Funcionalidad;
import Modelo.Rol;

import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuAdmin {

	JFrame frame;
	private JPanel panel;
	private JLabel lblBienvenida;
	private JButton btnRoles;
	private JButton btnPersonas;
	private JButton btnFuncionalidades;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuAdmin window = new MenuAdmin();
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
	public MenuAdmin() {
		initialize();
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 845, 504);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		lblBienvenida = new JLabel("Welcome!");
		lblBienvenida.setForeground(new Color(255, 255, 255));
		lblBienvenida.setBackground(new Color(0, 206, 209));
		lblBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenida.setFont(new Font("Baskerville Old Face", Font.BOLD, 60));
		lblBienvenida.setBounds(10, 10, 821, 152);
		panel.add(lblBienvenida);
		
		
		btnRoles = new JButton("Roles");
		btnRoles.setBackground(new Color(245, 245, 245));
		btnRoles.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		btnRoles.setBounds(286, 172, 265, 52);
		panel.add(btnRoles);
		btnRoles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				Roles window = new Roles();
				window.frame.setVisible(true);
			}
		});
		
		btnPersonas = new JButton("Personas");
		btnPersonas.setBackground(new Color(245, 245, 245));
		btnPersonas.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		btnPersonas.setBounds(286, 264, 265, 52);
		panel.add(btnPersonas);
		btnPersonas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registro window = new Registro();
				window.frame.setVisible(true);
			}
		});
		
		btnFuncionalidades = new JButton("Funcionalidades");
		btnFuncionalidades.setBackground(new Color(245, 245, 245));
		btnFuncionalidades.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		btnFuncionalidades.setBounds(286, 357, 265, 52);
		panel.add(btnFuncionalidades);
		btnFuncionalidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funcionalidades window = new Funcionalidades();
				window.frame.setVisible(true);
			}
		});
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MenuAdmin.class.getResource("/Vista/d.jpg")));
		lblNewLabel.setBounds(0, 0, 841, 476);
		panel.add(lblNewLabel);
		
	
	}
}
