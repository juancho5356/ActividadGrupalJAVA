package Vista;

import java.awt.EventQueue;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Controlador.DAOFuncionalidad;
import Controlador.DAORol;
import Modelo.Funcionalidad;
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

public class FuncionalidadesJefe{

	JFrame frame;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JTable table;
	private JTextPane textCantidad;
	private JLabel lblCantidadDeFuncionalidades;
	private JTabbedPane tabbedPane;
	private JPanel panel_1;
	private final JLabel lblNombre = new JLabel("Nombre:");
	private JLabel lblNewLabel;
	private JButton btnAceptar;
	private JLabel lblIngreso;
	private JScrollPane scrollPane_1;
	private JTextArea textArea_Desc;
	private JScrollPane scrollPane_2;
	private JTextArea textArea_Nombre;
	private JLabel lblFuncionalidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FuncionalidadesJefe window = new FuncionalidadesJefe();
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
	public FuncionalidadesJefe() {
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
		scrollPane.setViewportView(table);
		
		lista();
		cuenta();
		
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
	
}
