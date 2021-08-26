package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.LinkedList;
import Modelo.Persona;
import Modelo.Rol;
import Controlador.DAOPersona;
import Controlador.DAORol;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.ComponentOrientation;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ListadoJefe {

	JFrame frame;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JTextPane textCantidad;
	private JLabel lblNewLabel;
	private JLabel lblListado;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListadoJefe window = new ListadoJefe();
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
	public ListadoJefe() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(175, 238, 238));
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 886, 427);
		panel.setLayout(null);
		panel.setBackground(SystemColor.activeCaption);
		frame.getContentPane().add(panel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 69, 860, 288);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		listaP();
		cuenta();
		
		lblNewLabel = new JLabel("Cantidad de personas registradas:");
		lblNewLabel.setBounds(602, 367, 220, 21);
		panel.add(lblNewLabel);
		
		LinkedList<Rol> allRoles = DAORol.findAll();
		
		for (int i=0;i<allRoles.size();i++){
			String rol = allRoles.get(i).getNombreRol();
		}
		
		lblListado = new JLabel("Listado Personas");
		lblListado.setFont(new Font("Bookman Old Style", Font.BOLD, 40));
		lblListado.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblListado.setBounds(10, 10, 535, 42);
		panel.add(lblListado);
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 900, 433);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
		}
	
	public void listaP() {
		DefaultTableModel model = new DefaultTableModel();
		Object[] columns = {"Id Persona","Documento", "Apellido1", "Apellido2", "Nombre1", "Nombre2", "Fecha Nacimiento", "Correo Electrónico"};
		
		model.setColumnIdentifiers(columns);
		
		Object [] fila = new Object[columns.length];
		table.setModel(model);
		
		LinkedList<Persona> allPersona = DAOPersona.findAll();
		
		for (int i=0;i<allPersona.size();i++){
			
			int id = allPersona.get(i).getIdPersona();
			String doc = allPersona.get(i).getDocumento();
			String a1 = allPersona.get(i).getApellido1();
			String a2 = allPersona.get(i).getApellido2();
			String n1 = allPersona.get(i).getNombre1();
			String n2 = allPersona.get(i).getNombre2();
			LocalDate fn = allPersona.get(i).getFechaNac();
			String c = allPersona.get(i).getMail();
			
			fila[0] = id;
			fila[1] = doc;
			fila[2] = a1;
			fila[3] = a2;
			fila[4] = n1;
			fila[5] = n2;
			fila[6] = fn;
			fila[7] = c;
			model.addRow(fila);
		}
		
	}
	public void cuenta() {
		textCantidad = new JTextPane();
		textCantidad.setEditable(false);
		textCantidad.setBackground(SystemColor.inactiveCaptionBorder);
		textCantidad.setBounds(812, 367, 58, 21);
		panel.add(textCantidad);
		
		int cuenta = DAOPersona.cuentaPersonas();
		textCantidad.setText(""+ cuenta +"");
		
	}
}
