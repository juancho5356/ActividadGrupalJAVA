package vista;

import java.awt.EventQueue;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import conexionBD.DAOFuncionalidad;
import conexionBD.DAORol;
import modelo.Funcionalidad;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.awt.event.MouseEvent;

public class Funcionalidades implements MouseListener{

	JFrame frame;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JTable table;
	private JTextPane textCantidad;
	private JLabel lblCantidadDeFuncionalidades;
	private JLabel lblIngreseIdDe;
	private JTextField textEliminar;
	private JButton btnConfirmar;
	private JTabbedPane tabbedPane;
	private JPanel panel_1;
	private JPanel panel_2;
	private final JLabel lblNombre = new JLabel("Nombre:");
	private JLabel lblNewLabel;
	private JButton btnAceptar;
	private JLabel lblIngreso;
	private JLabel lblActualizar;
	private JScrollPane scrollPane_1;
	private JTextArea textArea_Desc;
	private JScrollPane scrollPane_2;
	private JTextArea textArea_Nombre;
	private JLabel lblNombre_1;
	private JLabel lblNewLabel_1;
	private JButton btnAceptar_2;
	private JLabel lblNewLabel_2;
	private JTextField textIdF;
	private JScrollPane scrollPane_3;
	private JTextArea textArea_Nombre_1;
	private JScrollPane scrollPane_4;
	private JTextArea textArea_Desc_1;
	private JLabel lblFuncionalidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Funcionalidades window = new Funcionalidades();
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
	public Funcionalidades() {
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
		panel.setBackground(new Color(176, 224, 230));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 64, 535, 369);
		panel.add(scrollPane);
		
		lblCantidadDeFuncionalidades = new JLabel("Cantidad de Funcionalidades:");
		lblCantidadDeFuncionalidades.setBounds(555, 62, 220, 21);
		panel.add(lblCantidadDeFuncionalidades);
		
		table = new JTable();
		table.addMouseListener(this);
		scrollPane.setViewportView(table);
		
		lista();
		cuenta();

		lblIngreseIdDe = new JLabel("Ingrese ID de Funcionalidad para eliminar:");
		lblIngreseIdDe.setBounds(10, 443, 243, 21);
		panel.add(lblIngreseIdDe);
		
		textEliminar = new JTextField();
		textEliminar.setBounds(263, 443, 58, 21);
		textEliminar.setColumns(10);
		textEliminar.setBackground(Color.WHITE);
		panel.add(textEliminar);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(338, 443, 97, 21);
		btnConfirmar.setBackground(SystemColor.menu);
		panel.add(btnConfirmar);
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				
				if(!(textEliminar.getText().isEmpty())) {
					String idX = textEliminar.getText();
					int idF = Integer.parseInt(idX);
					
					if (DAOFuncionalidad.delete(idF)) {
						
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
		tabbedPane.addTab("Funcionalidad nueva", null, panel_1, null);
		panel_1.setLayout(null);
		lblNombre.setBounds(10, 45, 126, 13);
		panel_1.add(lblNombre);
		
		lblNewLabel = new JLabel("Descripci\u00F3n:");
		lblNewLabel.setBounds(10, 122, 75, 13);
		panel_1.add(lblNewLabel);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBackground(SystemColor.control);
		btnAceptar.setBounds(10, 284, 85, 21);
		panel_1.add(btnAceptar);
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(textArea_Nombre.getText().isEmpty() || textArea_Desc.getText().isEmpty())) {
					
					String n = textArea_Nombre.getText();
					String d = textArea_Desc.getText();
					
					Funcionalidad f = new Funcionalidad();
					f.setNombreFuncion(n);
					f.setDescripcionFuncion(d);
					
					DAOFuncionalidad.insert(f);
					
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
		
		lblIngreso = new JLabel("Ingreso");
		lblIngreso.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblIngreso.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblIngreso.setBounds(10, 10, 111, 25);
		panel_1.add(lblIngreso);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 145, 207, 130);
		panel_1.add(scrollPane_1);
		
		textArea_Desc = new JTextArea();
		textArea_Desc.setLineWrap(true);
		scrollPane_1.setViewportView(textArea_Desc);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 69, 207, 43);
		panel_1.add(scrollPane_2);
		
		textArea_Nombre = new JTextArea();
		textArea_Nombre.setLineWrap(true);
		scrollPane_2.setViewportView(textArea_Nombre);
		
		panel_2 = new JPanel();
		tabbedPane.addTab("Modificar", null, panel_2, null);
		panel_2.setLayout(null);
		
		lblActualizar = new JLabel("Actualizaci\u00F3n");
		lblActualizar.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblActualizar.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblActualizar.setBounds(11, 10, 207, 25);
		panel_2.add(lblActualizar);
		
		lblNombre_1 = new JLabel("Nombre:");
		lblNombre_1.setBounds(11, 83, 126, 13);
		panel_2.add(lblNombre_1);
		
		lblNewLabel_1 = new JLabel("Descripci\u00F3n:");
		lblNewLabel_1.setBounds(11, 157, 75, 13);
		panel_2.add(lblNewLabel_1);
		
		btnAceptar_2 = new JButton("Aceptar");
		btnAceptar_2.setBackground(SystemColor.menu);
		btnAceptar_2.setBounds(133, 285, 85, 21);
		panel_2.add(btnAceptar_2);
		btnAceptar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!(textIdF.getText().isEmpty() || textArea_Nombre_1.getText().isEmpty() || textArea_Desc_1.getText().isEmpty())) {
					
					String id = textIdF.getText();
					int idF = Integer.parseInt(id);
					String n = textArea_Nombre_1.getText();
					String d = textArea_Desc_1.getText();
					
					try {
						Funcionalidad f = new Funcionalidad();
						f.setIdFuncionalidad(idF);
						f.setNombreFuncion(n);
						f.setDescripcionFuncion(d);
						
					
						if(DAOFuncionalidad.edit(f)){
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
					
					textIdF.setText("");
					textArea_Nombre_1.setText("");
					textArea_Desc_1.setText("");
				}
				else {
					JOptionPane.showMessageDialog(null, "No es posible actualizar el registro, campos sin rellenar");
				}
			}
		});
		lblNewLabel_2 = new JLabel("ID Funcionalidad");
		lblNewLabel_2.setBounds(11, 45, 190, 21);
		panel_2.add(lblNewLabel_2);
		
		textIdF = new JTextField();
		textIdF.setColumns(10);
		textIdF.setBackground(Color.WHITE);
		textIdF.setBounds(159, 45, 58, 21);
		panel_2.add(textIdF);
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(11, 106, 206, 41);
		panel_2.add(scrollPane_3);
		
		textArea_Nombre_1 = new JTextArea();
		textArea_Nombre_1.setLineWrap(true);
		scrollPane_3.setViewportView(textArea_Nombre_1);
		
		scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(11, 180, 206, 95);
		panel_2.add(scrollPane_4);
		
		textArea_Desc_1 = new JTextArea();
		textArea_Desc_1.setLineWrap(true);
		scrollPane_4.setViewportView(textArea_Desc_1);
		
		lblFuncionalidad = new JLabel("Funcionalidades");
		lblFuncionalidad.setFont(new Font("Bookman Old Style", Font.BOLD, 40));
		lblFuncionalidad.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblFuncionalidad.setBounds(10, 12, 535, 42);
		panel.add(lblFuncionalidad);
	}
	
	public void lista() {
		
		DefaultTableModel model = new DefaultTableModel();
		Object[] columns = {"Id Funcionalidad", "Nombre", "Descripción"};
		
		model.setColumnIdentifiers(columns);
		
		Object [] fila = new Object[columns.length]; 
		table.setModel(model);
		
		LinkedList<Funcionalidad> allFuncionalidades = DAOFuncionalidad.findAll();
		
		for (int i=0;i<allFuncionalidades.size();i++){
			
			int id=allFuncionalidades.get(i).getIdFuncionalidad();
			String no = allFuncionalidades.get(i).getNombreFuncion();
			String de = allFuncionalidades.get(i).getDescripcionFuncion();
		
			
			fila[0] = id;
			fila[1] = no;
			fila[2] = de;
			
			model.addRow(fila); 
		}
	}
	public void cuenta() {

		textCantidad = new JTextPane();
		textCantidad.setBounds(741, 62, 46, 21);
		textCantidad.setEditable(false);
		textCantidad.setBackground(SystemColor.inactiveCaptionBorder);
		panel.add(textCantidad);
		
		int cuenta = DAOFuncionalidad.cuentaFuncionalidades();
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
			
				textIdF.setText(table.getValueAt(filaSeleccionada, 0 ).toString());
				textArea_Nombre_1.setText(table.getValueAt(filaSeleccionada, 1 ).toString());
				textArea_Desc_1.setText(table.getValueAt(filaSeleccionada, 2 ).toString());
				
			}
		}catch(Exception ex) {
			 JOptionPane.showMessageDialog(null, " .::Error En la Operacion::.");
		}
	}
}
