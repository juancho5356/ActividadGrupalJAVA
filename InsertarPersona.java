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

import javax.swing.JTextField;
import javax.swing.JButton;

public class InsertarPersona {

	private JFrame frame;
	private JTextField textFieldDocumento;
	private JTextField textFieldApellido1;
	private JTextField textFieldApellido2;
	private JTextField textFieldNombre1;
	private JTextField textFieldNombre2;

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
		frame.setBounds(100, 100, 682, 531);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		textFieldDocumento.setBounds(157, 90, 298, 34);
		frame.getContentPane().add(textFieldDocumento);
		textFieldDocumento.setColumns(10);
		
		textFieldApellido1 = new JTextField();
		textFieldApellido1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldApellido1.setColumns(10);
		textFieldApellido1.setBounds(157, 138, 298, 34);
		frame.getContentPane().add(textFieldApellido1);
		
		textFieldApellido2 = new JTextField();
		textFieldApellido2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldApellido2.setColumns(10);
		textFieldApellido2.setBounds(157, 189, 298, 34);
		frame.getContentPane().add(textFieldApellido2);
		
		textFieldNombre1 = new JTextField();
		textFieldNombre1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldNombre1.setColumns(10);
		textFieldNombre1.setBounds(157, 237, 298, 34);
		frame.getContentPane().add(textFieldNombre1);
		
		textFieldNombre2 = new JTextField();
		textFieldNombre2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldNombre2.setColumns(10);
		textFieldNombre2.setBounds(157, 286, 298, 34);
		frame.getContentPane().add(textFieldNombre2);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAceptar.setBounds(231, 367, 139, 40);
		frame.getContentPane().add(btnAceptar);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String documento = textFieldDocumento.getText();
				String apellido1 = textFieldApellido1.getText();
				String apellido2 = textFieldApellido2.getText();
				String nombre1 = textFieldNombre1.getText();
				String nombre2 = textFieldNombre2.getText();
				
				Persona p = new Persona();
				p.setDocumento(documento);
				p.setApellido1(apellido1);
				p.setApellido2(apellido2);
				p.setNombre1(nombre1);
				p.setNombre2(nombre2);
				
				if(DAOPersona.insert(p)) {
					JOptionPane.showMessageDialog(null, "Se ha insertado una persona en la base de datos");
					int contador = DAOPersona.cuentaPersonas();
					
					if(contador > 0) {
						System.out.println("En la tabla PERSONAS hay " + contador + " registros");
						LinkedList<String> personas = null;
						personas = DAOPersona.findAll();
						for(String s: personas)
							System.out.println(s);
					}
				}else {
					JOptionPane.showInputDialog(null, "No se ha insertado una persona en la base de datos");
				}
			}
	});
}
}