package EjemploJTable;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Ventana {

	private JFrame frame;
	private JTextField textCedula;
	private JTextField textApellido;
	private JTextField textNombre;
	private JButton btnEliminar;
	private JButton btnBuscar;
	private JButton btnModificar;
	private JButton btnMostrarTodo;
	private JTextField textCedulaX;
	private JLabel lblEliminar;
	private JLabel lblTitulo;

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
		frame.setBounds(100, 100, 505, 313);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textCedula = new JTextField();
		textCedula.setBounds(94, 55, 86, 20);
		frame.getContentPane().add(textCedula);
		textCedula.setColumns(10);
		
		textApellido = new JTextField();
		textApellido.setBounds(94, 120, 86, 20);
		frame.getContentPane().add(textApellido);
		textApellido.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setBounds(94, 88, 86, 20);
		frame.getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		JButton btnAlta = new JButton("Alta");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

				if (!(textCedula.getText().isEmpty() || textNombre.getText().isEmpty() || textApellido.getText().isEmpty())) {

					String ci = textCedula.getText();
					String nombre=textNombre.getText();
					String apellido=textApellido.getText();
					
					Empleado e = new Empleado(ci,nombre,apellido);
					DAOEmpleados.insert(e);
					
					JOptionPane.showMessageDialog(null, "Éxito");
				}
				else {
					JOptionPane.showMessageDialog(null, "No es posible añadir el registro, campos sin completar");
				}
				
				textCedula.setText("");
				textNombre.setText("");
				textApellido.setText("");
			}
		});
		btnAlta.setBounds(226, 53, 89, 23);
		frame.getContentPane().add(btnAlta);
	
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if (!(textCedulaX.getText().isEmpty())) {
					
					String ci=textCedulaX.getText();
					
					if (DAOEmpleados.delete(ci)) {
						JOptionPane.showMessageDialog(null, "Éxito");
					}
					else {
						JOptionPane.showMessageDialog(null, "La cédula que acaba de ingresar, no se encuentra en el sistema");
					}					
					
					textCedulaX.setText("");
				}
				else {
					JOptionPane.showMessageDialog(null, "No es posible eliminar el registro, campo sin completar");
				}
			}
		});
		btnEliminar.setBounds(338, 243, 114, 23);
		frame.getContentPane().add(btnEliminar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(textCedula.getText().isEmpty())) {
					String ci=textCedula.getText();
			
					try {
						Empleado re=DAOEmpleados.find(ci);
				
						textNombre.setText(re.getNombre());
						textApellido.setText(re.getApellido());
				
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, "No existe registro");
					}
				}else {
					JOptionPane.showMessageDialog(null, "Faltan completar campo de Cedula para realizar busqueda");
				}
				
				
				
				
			}
		});
		btnBuscar.setBounds(226, 118, 89, 23);
		frame.getContentPane().add(btnBuscar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(textCedula.getText().isEmpty() || textNombre.getText().isEmpty() || textApellido.getText().isEmpty())) {
					
					String ci=textCedula.getText();
					String nombre=textNombre.getText();
					String apellido=textApellido.getText();
				
					Empleado e1 = new Empleado(ci,nombre,apellido);
					
					if(DAOEmpleados.update(e1)) {
						JOptionPane.showMessageDialog(null, "Éxito");
						
					}
					else {
						JOptionPane.showMessageDialog(null, "No existe empleado con la Cédula indicada");
					}
					textCedula.setText("");
					textNombre.setText("");
					textApellido.setText("");
				}else {
					JOptionPane.showMessageDialog(null, "Faltan completar campos para realizar modificación");
				}
				
				
				
			}			
		});
		btnModificar.setBounds(226, 86, 89, 23);
		frame.getContentPane().add(btnModificar);
		
		btnMostrarTodo = new JButton("Mostrar Todo");
		btnMostrarTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				MostrarTodo mt=new MostrarTodo();
				mt.mostrar();
			}
		});
		btnMostrarTodo.setBounds(10, 168, 170, 23);
		frame.getContentPane().add(btnMostrarTodo);
		
		JLabel lblCedula = new JLabel("C\u00E9dula");
		lblCedula.setBounds(10, 57, 46, 14);
		frame.getContentPane().add(lblCedula);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 90, 46, 14);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(10, 122, 46, 14);
		frame.getContentPane().add(lblApellido);
		
		textCedulaX = new JTextField();
		textCedulaX.setBounds(338, 214, 114, 19);
		frame.getContentPane().add(textCedulaX);
		textCedulaX.setColumns(10);
		
		lblEliminar = new JLabel("Eliminar empleado por CI");
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setBounds(318, 191, 163, 13);
		frame.getContentPane().add(lblEliminar);
		
		lblTitulo = new JLabel("Ingreso de Empleado");
		lblTitulo.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		lblTitulo.setBounds(10, 10, 192, 35);
		frame.getContentPane().add(lblTitulo);
	}
}
