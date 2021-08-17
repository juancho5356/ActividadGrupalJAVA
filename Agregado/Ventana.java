package EjemploJTable;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Ventana {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
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
	public Ventana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextField textCedula = new JTextField();
		textCedula.setBounds(132, 36, 86, 20);
		frame.getContentPane().add(textCedula);
		textCedula.setColumns(10);
		
		JTextField textApellido = new JTextField();
		textApellido.setBounds(132, 114, 86, 20);
		frame.getContentPane().add(textApellido);
		textApellido.setColumns(10);
		
		JTextField textNombre = new JTextField();
		textNombre.setBounds(132, 69, 86, 20);
		frame.getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		JButton btnAlta = new JButton("Alta");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!(textCedula.getText().isEmpty() || textNombre.getText().isEmpty() || textApellido.getText().isEmpty())) {
					String ci=textCedula.getText();
					String nombre=textNombre.getText();
					String apellido=textApellido.getText();
				Empleado e = new Empleado(ci,nombre,apellido);
					DAOEmpleados.insert(e);
					JOptionPane.showMessageDialog(null, "Exito","Exito", JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					JOptionPane.showMessageDialog(null, "No se ha podido insertar los datos");
					}
				textCedula.setText("");
				textNombre.setText("");
				textApellido.setText("");
			}
		});
		btnAlta.setBounds(254, 35, 89, 23);
		frame.getContentPane().add(btnAlta);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ci=textCedula.getText();
				String nombre=textNombre.getText();
				String apellido=textApellido.getText();
				Empleado e1 = new Empleado(ci,nombre,apellido);
				DAOEmpleados.delete(e1);
				if(DAOEmpleados.delete(e1)) {
					JOptionPane.showMessageDialog(null, "Se ha eliminado el registro");
				}
				else {
					JOptionPane.showMessageDialog(null, "No se ha podido eliminar el registro");
				}
			}
		});
		btnEliminar.setBounds(254, 83, 89, 23);
		frame.getContentPane().add(btnEliminar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ci = textCedula.getText();
				
				try{
					Empleado re=DAOEmpleados.find(ci);
					textNombre.setText(re.getNombre());
					textApellido.setText(re.getApellido());
				
				}catch(Exception x){
					JOptionPane.showMessageDialog(null, "No existe registro compatible con la búsqueda");
				}
					
				}
		});
		btnBuscar.setBounds(254, 128, 89, 23);
		frame.getContentPane().add(btnBuscar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(textCedula.getText().isEmpty() || textNombre.getText().isEmpty() || textApellido.getText().isEmpty())) {
				String ci=textCedula.getText();
				String nombre=textNombre.getText();
				String apellido=textApellido.getText();
				Empleado e1 = new Empleado(ci,nombre,apellido);
				DAOEmpleados.update(e1);
				JOptionPane.showMessageDialog(null, "Datos modificados con éxito");
				}
				else {
					JOptionPane.showMessageDialog(null, "No se ha podido modificar");
				}
			}			
		});
		btnModificar.setBounds(254, 176, 89, 23);
		frame.getContentPane().add(btnModificar);
		
		JButton btnMostrarTodo = new JButton("Mostrar Todo");
		btnMostrarTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				MostrarTodo mt=new MostrarTodo();
				mt.mostrar();
			}
		});
		btnMostrarTodo.setBounds(61, 176, 157, 23);
		frame.getContentPane().add(btnMostrarTodo);
		
		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setBounds(48, 39, 46, 14);
		frame.getContentPane().add(lblCedula);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(48, 72, 46, 14);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(48, 117, 46, 14);
		frame.getContentPane().add(lblApellido);
	}

}
