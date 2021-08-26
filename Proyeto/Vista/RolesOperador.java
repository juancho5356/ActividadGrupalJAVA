package Vista;

import java.awt.EventQueue;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Controlador.DAORol;
import Modelo.Rol;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import java.awt.ComponentOrientation;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RolesOperador {

	
	/**
	 * 
	 */	
	JFrame frame;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JTable table;
	private JTextPane textCantidad;
	private JLabel lblCantidadDeRoles;
	private JLabel lblRol;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RolesOperador window = new RolesOperador();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * Create the application.
	 */
	public RolesOperador() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 573, 540);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBackground(new Color(173, 216, 230));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 62, 535, 402);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		lista();
		cuenta();
	
		lblCantidadDeRoles = new JLabel("Cantidad de Roles:");
		lblCantidadDeRoles.setBounds(10, 474, 220, 21);
		panel.add(lblCantidadDeRoles);
		
		lblRol = new JLabel("Roles");
		lblRol.setFont(new Font("Bookman Old Style", Font.BOLD, 40));
		lblRol.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblRol.setBounds(10, 10, 535, 42);
		panel.add(lblRol);
		
		
	}
	public void lista() {
		DefaultTableModel model = new DefaultTableModel();
		Object[] columns = {"Id Rol", "Nombre", "Descripción"};
		
		model.setColumnIdentifiers(columns);
		
		Object [] fila = new Object[columns.length]; 
		table.setModel(model);
		
		LinkedList<Rol> allRoles = DAORol.findAll();
		
		for (int i=0;i<allRoles.size();i++){
			
			int id=allRoles.get(i).getIdRol();
			String no = allRoles.get(i).getNombreRol();
			String de = allRoles.get(i).getDescripcionRol();
		
			
			fila[0] = id;
			fila[1] = no;
			fila[2] = de;
			
			model.addRow(fila); 
		}
	}
	public void cuenta() {
		
		textCantidad = new JTextPane();
		textCantidad.setEditable(false);
		textCantidad.setBackground(SystemColor.inactiveCaptionBorder);
		textCantidad.setBounds(147, 474, 46, 21);
		panel.add(textCantidad);
		
		int cuenta = DAORol.cuentaRoles();
		textCantidad.setText(""+ cuenta + "");
	}

}
