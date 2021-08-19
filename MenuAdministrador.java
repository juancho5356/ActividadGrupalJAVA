package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MenuAdministrador {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuAdministrador window = new MenuAdministrador();
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
	public MenuAdministrador() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 910, 478);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Menu administrador");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		lblNewLabel.setBounds(320, 10, 279, 43);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnInsertarPersona = new JButton("Insertar persona");
		btnInsertarPersona.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnInsertarPersona.setBounds(44, 129, 183, 33);
		frame.getContentPane().add(btnInsertarPersona);
		btnInsertarPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertarPersona.main(null);
			}
		});
		
		JButton btnListarPersonas = new JButton("Listar personas");
		btnListarPersonas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnListarPersonas.setBounds(49, 319, 179, 33);
		frame.getContentPane().add(btnListarPersonas);
		btnListarPersonas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarPersonas.main(null);
			}
		});
		
		JButton btnInsertarPersona_1 = new JButton("Eliminar persona");
		btnInsertarPersona_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnInsertarPersona_1.setBounds(44, 257, 188, 33);
		frame.getContentPane().add(btnInsertarPersona_1);
		btnInsertarPersona_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarPersona.main(null);
			}
		});
		
		JButton btnEditarPersona = new JButton("Editar persona");
		btnEditarPersona.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEditarPersona.setBounds(49, 193, 179, 33);
		frame.getContentPane().add(btnEditarPersona);
		btnEditarPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditarPersona.main(null);
			}
		});
		
		JButton btnBuscarPersonas = new JButton("Buscar personas");
		btnBuscarPersonas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBuscarPersonas.setBounds(49, 384, 179, 33);
		frame.getContentPane().add(btnBuscarPersonas);
		btnBuscarPersonas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuscarPersonas.main(null);
			}
		});
		
		JButton btnInsertarRol = new JButton("Insertar rol");
		btnInsertarRol.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnInsertarRol.setBounds(345, 129, 179, 33);
		frame.getContentPane().add(btnInsertarRol);
		
		JButton btnEditarRol = new JButton("Editar rol");
		btnEditarRol.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEditarRol.setBounds(345, 193, 179, 33);
		frame.getContentPane().add(btnEditarRol);
		
		JButton btnEliminarRol = new JButton("Eliminar rol");
		btnEliminarRol.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEliminarRol.setBounds(345, 257, 179, 33);
		frame.getContentPane().add(btnEliminarRol);
		
		JButton btnInsertarFuncionalidad = new JButton("Insertar funcionalidad");
		btnInsertarFuncionalidad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnInsertarFuncionalidad.setBounds(624, 129, 238, 33);
		frame.getContentPane().add(btnInsertarFuncionalidad);
		
		JButton btnEditarFuncionalidad = new JButton("Editar funcionalidad");
		btnEditarFuncionalidad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEditarFuncionalidad.setBounds(635, 193, 215, 33);
		frame.getContentPane().add(btnEditarFuncionalidad);
		
		JButton btnEliminarFuncionalidad = new JButton("Eliminar funcionalidad");
		btnEliminarFuncionalidad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEliminarFuncionalidad.setBounds(621, 257, 241, 33);
		frame.getContentPane().add(btnEliminarFuncionalidad);
	}

}
