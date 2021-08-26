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

public class FuncionalidadesOperador{

	JFrame frame;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JTable table;
	private JTextPane textCantidad;
	private JLabel lblCantidadDeFuncionalidades;
	private JLabel lblFuncionalidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FuncionalidadesOperador window = new FuncionalidadesOperador();
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
	public FuncionalidadesOperador() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 572, 511);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBackground(new Color(176, 224, 230));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 64, 535, 369);
		panel.add(scrollPane);
		
		lblCantidadDeFuncionalidades = new JLabel("Cantidad de Funcionalidades:");
		lblCantidadDeFuncionalidades.setBounds(20, 443, 208, 21);
		panel.add(lblCantidadDeFuncionalidades);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		lista();
		cuenta();
		
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
		textCantidad.setBounds(198, 443, 46, 21);
		textCantidad.setEditable(false);
		textCantidad.setBackground(SystemColor.inactiveCaptionBorder);
		panel.add(textCantidad);
		
		int cuenta = DAOFuncionalidad.cuentaFuncionalidades();
		textCantidad.setText(""+ cuenta + "");
		
	}
	
}
