package vista;

import java.awt.EventQueue;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import conexionBD.DAORol;
import modelo.Rol;
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
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class Roles implements MouseListener {

	
	/**
	 * 
	 */	
	JFrame frame;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JTable table;
	private JTextPane textCantidad;
	private JLabel lblCantidadDeRoles;
	private JLabel lblIngreseIdDe;
	private JTextField textEliminar;
	private JButton btnConfirmar;
	private JTabbedPane tabbedPane;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblIngreso;
	private JLabel lblNombre;
	private JLabel lblNewLabel;
	private JButton btnAceptar;
	private JLabel lblActualizar;
	private JLabel lblNewLabel_1;
	private JTextField textId;
	private JLabel lblNombre_1;
	private JLabel lblNewLabel_2;
	private JButton btnAceptar_1;
	private JScrollPane scrollPane_1;
	private JTextArea textArea_Nombre_1;
	private JScrollPane scrollPane_2;
	private JTextArea textArea_Desc_1;
	private JScrollPane scrollPane_3;
	private JTextArea textArea_Nombre;
	private JScrollPane scrollPane_4;
	private JTextArea textArea_Desc;
	private JLabel lblRol;
	private JLabel lblSelect;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Roles window = new Roles();
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
	public Roles() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 811, 511);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBackground(new Color(173, 216, 230));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 62, 535, 371);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(this);
		scrollPane.setViewportView(table);
		
		lista();
		cuenta();
	
		lblCantidadDeRoles = new JLabel("Cantidad de Roles:");
		lblCantidadDeRoles.setBounds(555, 62, 220, 21);
		panel.add(lblCantidadDeRoles);
		
		lblIngreseIdDe = new JLabel("Ingrese ID de Rol para eliminar:");
		lblIngreseIdDe.setBounds(10, 443, 191, 21);
		panel.add(lblIngreseIdDe);
		
		textEliminar = new JTextField();
		textEliminar.setColumns(10);
		textEliminar.setBackground(Color.WHITE);
		textEliminar.setBounds(263, 443, 58, 21);
		panel.add(textEliminar);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBackground(SystemColor.menu);
		btnConfirmar.setBounds(338, 443, 97, 21);
		panel.add(btnConfirmar);
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				
				if(!(textEliminar.getText().isEmpty())) {
					String idX = textEliminar.getText();
					int idRol = Integer.parseInt(idX);
					
					if (DAORol.delete(idRol)) {
						
						JOptionPane.showMessageDialog(null, "Éxito");
						
						textEliminar.setText("");
						lista();
						cuenta();
					}
					else {
						JOptionPane.showMessageDialog(null, "El registro que acaba de ingresar, no se encuentra en el sistema");
						textEliminar.setText("");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Por favor ingrese un id");
				}
				
			}
		});
		
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
		
		panel_2 = new JPanel();
		tabbedPane.addTab("Modificar", null, panel_2, null);
		panel_2.setLayout(null);
		
		lblActualizar = new JLabel("Actualizaci\u00F3n");
		lblActualizar.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblActualizar.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblActualizar.setBounds(11, 10, 207, 25);
		panel_2.add(lblActualizar);
		
		lblNewLabel_1 = new JLabel("ID Rol");
		lblNewLabel_1.setBounds(11, 45, 190, 21);
		panel_2.add(lblNewLabel_1);
		
		textId = new JTextField();
		textId.setColumns(10);
		textId.setBackground(Color.WHITE);
		textId.setBounds(159, 45, 58, 21);
		panel_2.add(textId);
		
		lblNombre_1 = new JLabel("Nombre:");
		lblNombre_1.setBounds(11, 83, 126, 13);
		panel_2.add(lblNombre_1);
		
		lblNewLabel_2 = new JLabel("Descripci\u00F3n:");
		lblNewLabel_2.setBounds(11, 157, 75, 13);
		panel_2.add(lblNewLabel_2);
		
		btnAceptar_1 = new JButton("Aceptar");
		btnAceptar_1.setBackground(SystemColor.menu);
		btnAceptar_1.setBounds(133, 285, 85, 21);
		panel_2.add(btnAceptar_1);
		btnAceptar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!(textId.getText().isEmpty() || textArea_Nombre_1.getText().isEmpty() || textArea_Desc_1.getText().isEmpty())) {
					
					String id = textId.getText();
					int idR = Integer.parseInt(id);
					String n = textArea_Nombre_1.getText();
					String d = textArea_Desc_1.getText();
					
					try {
						Rol r = new Rol();
						r.setIdRol(idR);
						r.setNombreRol(n);
						r.setDescripcionRol(d);
					
						if(DAORol.edit(r)){
							JOptionPane.showMessageDialog(null, "Éxito");
							lista();
							cuenta();
						}
						else {
							JOptionPane.showMessageDialog(null, "El registro que acaba de ingresar, no se encuentra en el sistema");
						}
						
						
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, "No es posible actualizar el registro");
					}
					lista();
					cuenta();
					
					textId.setText("");
					textArea_Nombre_1.setText("");
					textArea_Desc_1.setText("");
				}
				else {
					JOptionPane.showMessageDialog(null, "No es posible actualizar el registro, campos sin rellenar");
				}
			}
		});
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(11, 106, 206, 39);
		panel_2.add(scrollPane_1);
		
		textArea_Nombre_1 = new JTextArea();
		textArea_Nombre_1.setLineWrap(true);
		scrollPane_1.setViewportView(textArea_Nombre_1);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(11, 180, 206, 93);
		panel_2.add(scrollPane_2);
		
		textArea_Desc_1 = new JTextArea();
		textArea_Desc_1.setLineWrap(true);
		scrollPane_2.setViewportView(textArea_Desc_1);
		
		lblRol = new JLabel("Roles");
		lblRol.setFont(new Font("Bookman Old Style", Font.BOLD, 40));
		lblRol.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblRol.setBounds(10, 10, 535, 42);
		panel.add(lblRol);
		
		lblSelect = new JLabel("Seleccione un registro para realizar alguna modificaci\u00F3n");
		lblSelect.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSelect.setForeground(Color.DARK_GRAY);
		lblSelect.setBounds(390, 10, 397, 19);
		panel.add(lblSelect);
		
		
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

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == table) {
			mouseClickedTable(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	public void mouseClickedTable(MouseEvent e) {
		int filaSeleccionada;
		try {
			filaSeleccionada = table.getSelectedRow();
			if(filaSeleccionada == -1) {

			}else {
			
				textId.setText(table.getValueAt(filaSeleccionada, 0 ).toString());
				textArea_Nombre_1.setText(table.getValueAt(filaSeleccionada, 1 ).toString());
				textArea_Desc_1.setText(table.getValueAt(filaSeleccionada, 2 ).toString());
				
			}
		}catch(Exception ex) {
			 JOptionPane.showMessageDialog(null, " .::Error En la Operacion::.");
		}
	}
}
