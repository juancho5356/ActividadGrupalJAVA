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
import Modelo.Rol;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class InsertarPersona {

	private JFrame frame;
	private JTextField textFieldDocumento;
	private JTextField textFieldApellido1;
	private JTextField textFieldApellido2;
	private JTextField textFieldNombre1;
	private JTextField textFieldNombre2;
	private JTextField textFieldEmail;
	private JTextField textFieldContraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertarPersona window = new InsertarPersona();
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
	public InsertarPersona() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 682, 618);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ingresar persona");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		lblNewLabel.setBounds(157, 10, 349, 54);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Documento:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 90, 114, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Apellido1:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(10, 138, 114, 25);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Apellido2:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(10, 189, 114, 25);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Nombre1:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(10, 237, 114, 25);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Nombre2:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_4.setBounds(10, 286, 114, 25);
		frame.getContentPane().add(lblNewLabel_1_4);
		
		textFieldDocumento = new JTextField();
		textFieldDocumento.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldDocumento.setBounds(157, 90, 456, 34);
		frame.getContentPane().add(textFieldDocumento);
		textFieldDocumento.setColumns(10);
		
		textFieldApellido1 = new JTextField();
		textFieldApellido1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldApellido1.setColumns(10);
		textFieldApellido1.setBounds(157, 138, 456, 34);
		frame.getContentPane().add(textFieldApellido1);
		
		textFieldApellido2 = new JTextField();
		textFieldApellido2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldApellido2.setColumns(10);
		textFieldApellido2.setBounds(157, 189, 456, 34);
		frame.getContentPane().add(textFieldApellido2);
		
		textFieldNombre1 = new JTextField();
		textFieldNombre1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldNombre1.setColumns(10);
		textFieldNombre1.setBounds(157, 237, 456, 34);
		frame.getContentPane().add(textFieldNombre1);
		
		textFieldNombre2 = new JTextField();
		textFieldNombre2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldNombre2.setColumns(10);
		textFieldNombre2.setBounds(157, 286, 456, 34);
		frame.getContentPane().add(textFieldNombre2);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAceptar.setBounds(226, 531, 139, 40);
		frame.getContentPane().add(btnAceptar);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Email:");
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_4_1.setBounds(10, 337, 114, 25);
		frame.getContentPane().add(lblNewLabel_1_4_1);
		
		JLabel lblNewLabel_1_4_2 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_1_4_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_4_2.setBounds(10, 385, 114, 25);
		frame.getContentPane().add(lblNewLabel_1_4_2);
		
		JLabel lblNewLabel_1_4_3 = new JLabel("Rol:");
		lblNewLabel_1_4_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_4_3.setBounds(10, 430, 114, 25);
		frame.getContentPane().add(lblNewLabel_1_4_3);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(157, 333, 456, 34);
		frame.getContentPane().add(textFieldEmail);
		
		textFieldContraseña = new JTextField();
		textFieldContraseña.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldContraseña.setColumns(10);
		textFieldContraseña.setBounds(157, 381, 456, 34);
		frame.getContentPane().add(textFieldContraseña);
		
		JComboBox comboBoxRol = new JComboBox();
		comboBoxRol.setMaximumRowCount(3);
		comboBoxRol.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBoxRol.setBounds(157, 429, 456, 34);
		comboBoxRol.addItem("Administrador");
		comboBoxRol.addItem("Jefe de seccion");
		comboBoxRol.addItem("Operador de seccion");
		frame.getContentPane().add(comboBoxRol);
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String documento = textFieldDocumento.getText();
				String apellido1 = textFieldApellido1.getText();
				String apellido2 = textFieldApellido2.getText();
				String nombre1 = textFieldNombre1.getText();
				String nombre2 = textFieldNombre2.getText();
				String email = textFieldEmail.getText();
				String contraseña = textFieldContraseña.getText();
				String rol = comboBoxRol.getToolTipText();
				
				Persona p = new Persona();
				p.setDocumento(documento);
				p.setApellido1(apellido1);
				p.setApellido2(apellido2);
				p.setNombre1(nombre1);
				p.setNombre2(nombre2);
				p.setEmail(email);
				p.setClave(contraseña);
				//p.setRol();
				
				if(DAOPersona.insert(p)) {
					JOptionPane.showMessageDialog(null, "Se ha insertado una persona en la base de datos");
					int contador = DAOPersona.cuentaPersonas();
					
					if(contador > 0) {
						System.out.println("En la tabla PERSONAS hay " + contador + " registros");
						LinkedList<Persona> personas = null;
						personas = DAOPersona.findAll();
						for(Persona s: personas)
							System.out.println(s);
					}
				}else {
					JOptionPane.showMessageDialog(null, "No se ha insertado una persona en la base de datos");
				}
			}
	});
}
}