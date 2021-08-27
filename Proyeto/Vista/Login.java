package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.SwingConstants;

import Controlador.DAOPersona;
import Modelo.Persona;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

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
		frmLogin.setBounds(100, 100, 781, 429);
		frmLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("LogIn");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Baskerville Old Face", Font.PLAIN, 60));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(274, 21, 205, 71);
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
		passwordField.setBounds(210, 195, 489, 37);
		frmLogin.getContentPane().add(passwordField);
		
		textFieldCorreo = new JTextField();
		textFieldCorreo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldCorreo.setBounds(210, 125, 489, 37);
		frmLogin.getContentPane().add(textFieldCorreo);
		textFieldCorreo.setColumns(10);
		
		JButton btnAdministrador = new JButton("Administrador");
		btnAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAdministrador.setBounds(49, 266, 166, 37);
		frmLogin.getContentPane().add(btnAdministrador);
		
		JButton btnJefe = new JButton("Jefe de seccion");
		btnJefe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnJefe.setBounds(258, 266, 190, 37);
		frmLogin.getContentPane().add(btnJefe);
		
		JButton btnOperador = new JButton("Operador de seccion");
		btnOperador.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnOperador.setBounds(498, 266, 228, 37);
		frmLogin.getContentPane().add(btnOperador);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/Vista/d.jpg")));
		lblNewLabel_2.setBounds(0, 0, 767, 392);
		frmLogin.getContentPane().add(lblNewLabel_2);
		
		btnAdministrador.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				LinkedList<Persona> administradores = new LinkedList<>();
				administradores = DAOPersona.findAdmin();
				
				LinkedList<String> correos = new LinkedList<>();
				for(Persona p: administradores) {
					correos.add(p.getMail());
				}
				
				LinkedList<String> claves = new LinkedList<>();
				for(Persona p: administradores) {
					claves.add(p.getClave());
				}
				
				if((correos.contains(textFieldCorreo.getText()) && (claves.contains(passwordField.getText())))) {
					System.out.println("Usuario aceptado");
					MenuAdmin.main(null);
					textFieldCorreo.setText("");
					passwordField.setText("");
				}
				else {
					JOptionPane.showMessageDialog(null, "Credenciales incorrectas");
				}
			}
		});
				
		
		btnJefe.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				LinkedList<Persona> jefes = new LinkedList<>();
				jefes = DAOPersona.findJefe();
				
				LinkedList<String> correosJ = new LinkedList<>();
				for(Persona s: jefes) {
					correosJ.add(s.getMail());
				}
				
				LinkedList<String> clavesJ = new LinkedList<>();
				for(Persona t: jefes) {
					clavesJ.add(t.getClave());
				}
				
				if((correosJ.contains(textFieldCorreo.getText()) && (clavesJ.contains(passwordField.getText())))) {
					System.out.println("Usuario aceptado");
					MenuJefe.main(null);
					textFieldCorreo.setText("");
					passwordField.setText("");
				}
				else {
					JOptionPane.showMessageDialog(null, "Credenciales incorrectas");
				}
			}
		});
				
				
		btnOperador.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				LinkedList<Persona> operadores = new LinkedList<>();
				operadores = DAOPersona.findOperador();
				
				LinkedList<String> correosO = new LinkedList<>();
				for(Persona x: operadores) {
					correosO.add(x.getMail());
				}
				
				LinkedList<String> clavesO = new LinkedList<>();
				for(Persona y: operadores) {
					clavesO.add(y.getClave());
				}
				
				if((correosO.contains(textFieldCorreo.getText()) && (clavesO.contains(passwordField.getText())))) {
					System.out.println("Usuario aceptado");
					MenuOperador.main(null);
					textFieldCorreo.setText("");
					passwordField.setText("");
				}
				else {
					JOptionPane.showMessageDialog(null, "Credenciales incorrectas");
				}
			}
		});
	}
}
