package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.LinkedList;

import javax.swing.SwingConstants;

import Controlador.DAOPersona;
import Modelo.Funcionalidad;
import Modelo.Persona;
import Modelo.Principal;
import Modelo.Rol;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;

public class Login {

	private JFrame frmLogin;
	private JPasswordField passwordField;
	private JTextField textFieldCorreo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("LogIn");
		frmLogin.getContentPane().setBackground(Color.GRAY);
		frmLogin.getContentPane().setForeground(Color.WHITE);
		frmLogin.setBounds(100, 100, 584, 429);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("LogIn");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(188, 21, 195, 64);
		frmLogin.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Correo electrónico");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 118, 190, 43);
		frmLogin.getContentPane().add(lblNewLabel);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblContrasea.setBounds(10, 188, 190, 43);
		frmLogin.getContentPane().add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordField.setBounds(210, 195, 271, 37);
		frmLogin.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(237, 250, 104, 32);
		frmLogin.getContentPane().add(btnNewButton);
		
		textFieldCorreo = new JTextField();
		textFieldCorreo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldCorreo.setBounds(210, 125, 271, 37);
		frmLogin.getContentPane().add(textFieldCorreo);
		textFieldCorreo.setColumns(10);
		
		String correoAdmin = "admin@correo.com";
		String contraseñaAdmin = "admin";
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LinkedList<Persona> administradores = new LinkedList<>();
				administradores = DAOPersona.findAdmin();
				
				LinkedList<String> correos = new LinkedList<>();
				for(Persona p: administradores) {
					correos.add(p.getEmail());
				}
				
				LinkedList<String> claves = new LinkedList<>();
				for(Persona s: administradores) {
					claves.add(s.getClave());
				}
				
				if((correos.contains(textFieldCorreo.getText()) && (claves.contains(passwordField.getText())))) {
				JOptionPane.showMessageDialog(null, "Usuario aceptado");
				System.out.println("Usuario aceptado");
				for(Persona p: administradores) {
					System.out.println(p);
				}
				MenuAdministrador.main(null);
				
				}
				else {
					JOptionPane.showMessageDialog(null, "Credenciales incorrectas");
				}
		
			}
	});	
}
}