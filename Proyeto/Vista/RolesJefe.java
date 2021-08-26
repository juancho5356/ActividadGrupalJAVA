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

public class RolesJefe {

	
	/**
	 * 
	 */	
	JFrame frame;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JTable table;
	private JTextPane textCantidad;
	private JLabel lblCantidadDeRoles;
	private JTabbedPane tabbedPane;
	private JPanel panel_1;
	private JLabel lblIngreso;
	private JLabel lblNombre;
	private JLabel lblNewLabel;
	private JButton btnAceptar;
	private JScrollPane scrollPane_3;
	private JTextArea textArea_Nombre;
	private JScrollPane scrollPane_4;
	private JTextArea textArea_Desc;
	private JLabel lblRol;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RolesJefe window = new RolesJefe();
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
	public RolesJefe() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 811, 511);
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
		lblCantidadDeRoles.setBounds(555, 62, 220, 21);
		panel.add(lblCantidadDeRoles);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(555, 121, 232, 343);
		panel.add(tabbedPane);
		
		panel_1 = new JPanel();
		tabbedPane.addTab("Rol nuevo", null, panel_1, null);
		panel_1.setLayout(null);
		
		lblIngreso = new JLabel("Ingreso");
		lblIngreso.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblIngreso.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblIngreso.setBounds(10, 10, 111, 25);
		panel_1.add(lblIngreso);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 45, 126, 13);
		panel_1.add(lblNombre);
		
		lblNewLabel = new JLabel("Descripci\u00F3n:");
		lblNewLabel.setBounds(10, 122, 75, 13);
		panel_1.add(lblNewLabel);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBackground(SystemColor.menu);
		btnAceptar.setBounds(10, 284, 85, 21);
		panel_1.add(btnAceptar);
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(textArea_Nombre.getText().isEmpty() || textArea_Desc.getText().isEmpty())) {
					
					String n = textArea_Nombre.getText();
					String d = textArea_Desc.getText();
					
					Rol r = new Rol();
					r.setNombreRol(n);
					r.setDescripcionRol(d);
					
					DAORol.insert(r);
					
					JOptionPane.showMessageDialog(null, "Éxito");
					
					lista();
					cuenta();
					
					textArea_Nombre.setText("");
					textArea_Desc.setText("");
				}
				else {
					JOptionPane.showMessageDialog(null, "No es posible añadir el registro, campos sin rellenar");
				}
			}
		});
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 71, 207, 40);
		panel_1.add(scrollPane_3);
		
		textArea_Nombre = new JTextArea();
		textArea_Nombre.setLineWrap(true);
		scrollPane_3.setViewportView(textArea_Nombre);
		
		scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(10, 146, 207, 128);
		panel_1.add(scrollPane_4);
		
		textArea_Desc = new JTextArea();
		textArea_Desc.setLineWrap(true);
		scrollPane_4.setViewportView(textArea_Desc);
		
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
		textCantidad.setBounds(741, 62, 46, 21);
		panel.add(textCantidad);
		
		int cuenta = DAORol.cuentaRoles();
		textCantidad.setText(""+ cuenta + "");
	}

}
