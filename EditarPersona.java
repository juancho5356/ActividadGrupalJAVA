package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import Controlador.DAOPersona;
import Modelo.Persona;

import javax.swing.JTextField;
import javax.swing.JButton;

public class EditarPersona {

	private JFrame frame;
	private JTextField textFieldIdPersona;
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
					EditarPersona window = new EditarPersona();
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
	public EditarPersona() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 514, 502);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Editar persona");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		lblNewLabel.setBounds(103, 10, 236, 43);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Documento:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 134, 122, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Apellido1:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(10, 183, 122, 25);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Apellido2:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(10, 231, 122, 25);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Nombre1:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(10, 280, 122, 25);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Nombre2:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_4.setBounds(10, 329, 122, 25);
		frame.getContentPane().add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("ID persona:");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_5.setBounds(10, 88, 122, 25);
		frame.getContentPane().add(lblNewLabel_1_5);
		
		textFieldIdPersona = new JTextField();
		textFieldIdPersona.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldIdPersona.setBounds(142, 85, 309, 31);
		frame.getContentPane().add(textFieldIdPersona);
		textFieldIdPersona.setColumns(10);
		
		textFieldDocumento = new JTextField();
		textFieldDocumento.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldDocumento.setColumns(10);
		textFieldDocumento.setBounds(142, 131, 309, 31);
		frame.getContentPane().add(textFieldDocumento);
		
		textFieldApellido1 = new JTextField();
		textFieldApellido1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldApellido1.setColumns(10);
		textFieldApellido1.setBounds(142, 180, 309, 31);
		frame.getContentPane().add(textFieldApellido1);
		
		textFieldApellido2 = new JTextField();
		textFieldApellido2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldApellido2.setColumns(10);
		textFieldApellido2.setBounds(142, 228, 309, 31);
		frame.getContentPane().add(textFieldApellido2);
		
		textFieldNombre1 = new JTextField();
		textFieldNombre1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldNombre1.setColumns(10);
		textFieldNombre1.setBounds(142, 277, 309, 31);
		frame.getContentPane().add(textFieldNombre1);
		
		textFieldNombre2 = new JTextField();
		textFieldNombre2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldNombre2.setColumns(10);
		textFieldNombre2.setBounds(142, 326, 309, 31);
		frame.getContentPane().add(textFieldNombre2);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAceptar.setBounds(224, 391, 144, 43);
		frame.getContentPane().add(btnAceptar);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Persona p = new Persona();
				p.setDocumento(textFieldDocumento.getText());
				p.setApellido1(textFieldApellido1.getText());
				p.setApellido2(textFieldApellido2.getText());
				p.setNombre1(textFieldNombre1.getText());
				p.setNombre2(textFieldNombre2.getText());
				
				DAOPersona.edit(p, textFieldIdPersona.getText());
				
				if(DAOPersona.edit(p, textFieldIdPersona.getText())) {
					JOptionPane.showMessageDialog(null, "Los datos se han actualizado con éxito");
				}
				else {
					JOptionPane.showMessageDialog(null, "No se ha podido actualizar los datos");
				}
	}

});
	}
}
