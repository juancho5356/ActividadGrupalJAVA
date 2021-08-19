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

import javax.swing.JTextField;
import javax.swing.JButton;

public class EliminarPersona {

	private JFrame frame;
	private JTextField textFieldIdPersona;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EliminarPersona window = new EliminarPersona();
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
	public EliminarPersona() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 323, 216);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Eliminar persona");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		lblNewLabel.setBounds(10, 10, 286, 34);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID persona:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(38, 74, 121, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		textFieldIdPersona = new JTextField();
		textFieldIdPersona.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldIdPersona.setBounds(169, 73, 70, 26);
		frame.getContentPane().add(textFieldIdPersona);
		textFieldIdPersona.setColumns(10);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEliminar.setBounds(93, 117, 110, 34);
		frame.getContentPane().add(btnEliminar);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idPersonaST = textFieldIdPersona.getText();
				int idPersona = Integer.parseInt(idPersonaST);
				
				DAOPersona.delete(idPersona);
				
				if(!DAOPersona.delete(idPersona)) {
					JOptionPane.showMessageDialog(null, "Se ha eliminado el registro correctamente");
				}
				else {
					JOptionPane.showMessageDialog(null, "No se ha podido eliminar el registro");
				}
	}

});
	}
}
