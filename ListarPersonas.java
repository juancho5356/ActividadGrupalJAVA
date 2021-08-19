package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Controlador.ConexionBD;
import Controlador.DAOPersona;
import Modelo.Persona;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class ListarPersonas {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		Connection connection = ConexionBD.getConnection();
		
		int contador = DAOPersona.cuentaPersonas();
		
		if(contador > 0) {
			System.out.println("En la tabla PERSONAS hay " + contador + " registros");
			LinkedList<Persona> personas = null;
			personas = DAOPersona.findAll();
			for(Persona p: personas)
				System.out.println(p);
		
		}else {
			System.out.println("La tabla PERSONAS  no contiene registros");
			
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarPersonas window = new ListarPersonas();
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
	public ListarPersonas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 927, 647);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textArea.setBounds(10, 161, 893, 449);
		frame.getContentPane().add(textArea);
		
		JButton btnNewButton = new JButton("Listar personas");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(10, 114, 172, 37);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int contador = DAOPersona.cuentaPersonas();
				if(contador > 0) {
				textArea.setText("");
				LinkedList<Persona> personas = null;
				personas = DAOPersona.findAll();
				for(Persona p: personas)
					textArea.append(p + "\n");
				}
			}
		});
					
		
		JButton btnBorrarResultados = new JButton("Borrar resultados");
		btnBorrarResultados.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBorrarResultados.setBounds(711, 114, 192, 37);
		frame.getContentPane().add(btnBorrarResultados);
		btnBorrarResultados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
			}
		});
		
		JLabel lblNewLabel = new JLabel("Listado personas");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		lblNewLabel.setBounds(296, 10, 297, 45);
		frame.getContentPane().add(lblNewLabel);
	}
}
