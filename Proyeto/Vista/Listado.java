package vista;

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
import modelo.Persona;
import modelo.Rol;
import conexionBD.DAOPersona;
import conexionBD.DAORol;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.ComponentOrientation;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;

public class Listado implements MouseListener {

	JFrame frame;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JTextPane textCantidad;
	private JLabel lblNewLabel;
	private JTextField textEliminar;
	private JLabel lblEliminar;
	private JButton btnConfirmar;
	private JPanel panel_1;
	private JLabel lblDocumento;
	private JTextField textDocumento;
	private JLabel lblApellido1;
	private JTextField textApellido1;
	private JTextField textApellido2;
	private JLabel lblApellido2;
	private JLabel lblNombre1;
	private JLabel lblNombre2;
	private JLabel lblFechaNacimiento;
	private JLabel lblRol;
	private JComboBox<Object> comboRol;
	private JLabel lblDia;
	private JTextField textDia;
	private JTextField textMes;
	private JLabel lblNewLabel_1;
	private JTextField textAnio;
	private JLabel lblNewLabel_2;
	private JTextField textNombre2;
	private JTextField textNombre1;
	private JLabel lblListado;
	private JLabel lblModificacionDeUsuarios;
	private JLabel lblId;
	private JTextField textId;
	private JButton btnAceptar;
	private JTable table;
	private JLabel lblCamposObligatorios;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JButton btnLimpiar;
	private JLabel lblCorreo;
	private JTextField textCorreo;
	private JPasswordField password;
	private JLabel lblClave;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblSelect;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Listado window = new Listado();
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
	public Listado() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(175, 238, 238));
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 1431, 506);
		panel.setLayout(null);
		panel.setBackground(SystemColor.activeCaption);
		frame.getContentPane().add(panel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 69, 1053, 389);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setSurrendersFocusOnKeystroke(true);
		table.addMouseListener(this);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		listaP();
		cuenta();
		
		lblNewLabel = new JLabel("Cantidad de personas registradas:");
		lblNewLabel.setBounds(602, 468, 220, 21);
		panel.add(lblNewLabel);
		
		textEliminar = new JTextField();
		textEliminar.setColumns(10);
		textEliminar.setBackground(Color.WHITE);
		textEliminar.setBounds(220, 468, 58, 21);
		panel.add(textEliminar);
		
		lblEliminar = new JLabel("Ingrese ID de persona para eliminar:");
		lblEliminar.setBounds(10, 468, 211, 21);
		panel.add(lblEliminar);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBackground(SystemColor.menu);
		btnConfirmar.setBounds(295, 468, 97, 21);
		panel.add(btnConfirmar);
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(textEliminar.getText().isEmpty())) {
					String idX = textEliminar.getText();
					int idRol = Integer.parseInt(idX);
					
					if (DAOPersona.delete(idRol)) {
						
						JOptionPane.showMessageDialog(null, "Éxito");
						
						textEliminar.setText("");
						listaP();
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
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 245, 245));
		panel_1.setLayout(null);
		panel_1.setBounds(1073, 0, 359, 496);
		panel.add(panel_1);
		
		lblDocumento = new JLabel("Documento");
		lblDocumento.setBounds(24, 107, 67, 13);
		panel_1.add(lblDocumento);
		
		textDocumento = new JTextField();
		textDocumento.setForeground(Color.BLACK);
		textDocumento.setColumns(10);
		textDocumento.setBackground(Color.WHITE);
		textDocumento.setBounds(139, 104, 203, 19);
		panel_1.add(textDocumento);
		
		lblApellido1 = new JLabel("Apellido 1");
		lblApellido1.setBounds(24, 145, 67, 13);
		panel_1.add(lblApellido1);
		
		textApellido1 = new JTextField();
		textApellido1.setForeground(Color.BLACK);
		textApellido1.setColumns(10);
		textApellido1.setBackground(Color.WHITE);
		textApellido1.setBounds(139, 142, 203, 19);
		panel_1.add(textApellido1);
		
		textApellido2 = new JTextField();
		textApellido2.setForeground(Color.BLACK);
		textApellido2.setColumns(10);
		textApellido2.setBackground(Color.WHITE);
		textApellido2.setBounds(139, 179, 203, 19);
		panel_1.add(textApellido2);
		
		lblApellido2 = new JLabel("Apellido 2");
		lblApellido2.setBounds(24, 182, 93, 13);
		panel_1.add(lblApellido2);
		
		lblNombre1 = new JLabel("Nombre 1");
		lblNombre1.setBounds(24, 222, 93, 13);
		panel_1.add(lblNombre1);
		
		lblNombre2 = new JLabel("Nombre 2");
		lblNombre2.setBounds(24, 260, 93, 13);
		panel_1.add(lblNombre2);
		
		lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		lblFechaNacimiento.setBounds(24, 303, 105, 13);
		panel_1.add(lblFechaNacimiento);
		
		lblRol = new JLabel("Rol");
		lblRol.setBounds(24, 426, 67, 13);
		panel_1.add(lblRol);
		
		comboRol = new JComboBox<Object>();
		comboRol.setBounds(139, 422, 203, 21);
		panel_1.add(comboRol);
		
		LinkedList<Rol> allRoles = DAORol.findAll();
		
		for (int i=0;i<allRoles.size();i++){
			String rol = allRoles.get(i).getNombreRol();
			comboRol.addItem(rol);
		} 
		
		lblDia = new JLabel("d\u00EDa");
		lblDia.setBounds(139, 320, 45, 13);
		panel_1.add(lblDia);
		
		textDia = new JTextField();
		textDia.setForeground(Color.BLACK);
		textDia.setColumns(10);
		textDia.setBackground(Color.WHITE);
		textDia.setBounds(139, 300, 29, 19);
		panel_1.add(textDia);
		
		textMes = new JTextField();
		textMes.setForeground(Color.BLACK);
		textMes.setColumns(10);
		textMes.setBackground(Color.WHITE);
		textMes.setBounds(209, 300, 29, 19);
		panel_1.add(textMes);
		
		lblNewLabel_1 = new JLabel("mes");
		lblNewLabel_1.setBounds(209, 320, 45, 13);
		panel_1.add(lblNewLabel_1);
		
		textAnio = new JTextField();
		textAnio.setForeground(Color.BLACK);
		textAnio.setColumns(10);
		textAnio.setBackground(Color.WHITE);
		textAnio.setBounds(282, 300, 60, 19);
		panel_1.add(textAnio);
		
		lblNewLabel_2 = new JLabel("a\u00F1o");
		lblNewLabel_2.setBounds(282, 320, 45, 13);
		panel_1.add(lblNewLabel_2);
		
		textNombre2 = new JTextField();
		textNombre2.setForeground(Color.BLACK);
		textNombre2.setColumns(10);
		textNombre2.setBackground(Color.WHITE);
		textNombre2.setBounds(139, 257, 203, 19);
		panel_1.add(textNombre2);
		
		textNombre1 = new JTextField();
		textNombre1.setForeground(Color.BLACK);
		textNombre1.setColumns(10);
		textNombre1.setBackground(Color.WHITE);
		textNombre1.setBounds(139, 219, 203, 19);
		panel_1.add(textNombre1);
		
		lblModificacionDeUsuarios = new JLabel("Modificacion de usuarios");
		lblModificacionDeUsuarios.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblModificacionDeUsuarios.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblModificacionDeUsuarios.setBounds(9, 20, 333, 25);
		panel_1.add(lblModificacionDeUsuarios);
		
		lblId = new JLabel("Id Persona");
		lblId.setBounds(24, 70, 105, 13);
		panel_1.add(lblId);
		
		textId = new JTextField();
		textId.setForeground(Color.BLACK);
		textId.setColumns(10);
		textId.setBackground(Color.WHITE);
		textId.setBounds(139, 67, 60, 19);
		panel_1.add(textId);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBackground(SystemColor.menu);
		btnAceptar.setBounds(245, 465, 97, 21);
		panel_1.add(btnAceptar);
		btnAceptar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed (ActionEvent e) {
				if(!(textDocumento.getText().isEmpty() || textApellido1.getText().isEmpty() || textNombre1.getText().isEmpty() || textDia.getText().isEmpty() 
				  || textMes.getText().isEmpty() || textAnio.getText().isEmpty() || textCorreo.getText().isEmpty() || password.getText().isEmpty())) {
							
							String id = textId.getText();
							int idP = Integer.parseInt(id);
							
							String doc = textDocumento.getText();
							String a1 = textApellido1.getText();
							String a2 = textApellido2.getText();
							String n1 = textNombre1.getText();
							String n2 = textNombre2.getText();
							
							String correo = textCorreo.getText();
							String clave = password.getText();
							
							String d = textDia.getText();
							int day = Integer.parseInt(d);
							String m = textMes.getText();
							int month = Integer.parseInt(m);
							String an = textAnio.getText(); 
							int year = Integer.parseInt(an);
							
							LocalDate fecNac = LocalDate.of(year, month, day);
							
							String r = (String) comboRol.getSelectedItem();
							Rol rol = DAORol.findRol(r);
							
							try {
								Persona p = new Persona();
								p.setIdPersona(idP);
								p.setDocumento(doc);
								p.setApellido1(a1);
								p.setApellido2(a2);
								p.setNombre1(n1);
								p.setNombre2(n2);
								p.setMail(correo);
								p.setClave(clave);
								p.setFechaNac(fecNac);
								p.setRol(rol);
								
								if(DAOPersona.edit(p)) {
									JOptionPane.showMessageDialog(null, "Éxito");
									listaP();
									cuenta();
								}
								else {
									JOptionPane.showMessageDialog(null, "El registro que acaba de ingresar, no se encuentra en el sistema");
								}
								
							}catch(Exception ex) {
								JOptionPane.showMessageDialog(null, "No es posible actualizar el registro");
							}
							
						}
						else {
							JOptionPane.showMessageDialog(null, "No es posible actualizar el registro, campos obligatorios sin rellenar");
						}	
						
						
					}
			
		});
		
		lblCamposObligatorios = new JLabel("Campos obligatorios *");
		lblCamposObligatorios.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCamposObligatorios.setForeground(Color.GRAY);
		lblCamposObligatorios.setBounds(187, 67, 155, 19);
		panel_1.add(lblCamposObligatorios);
		
		lblNewLabel_3 = new JLabel("*");
		lblNewLabel_3.setBounds(9, 70, 15, 13);
		panel_1.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("*");
		lblNewLabel_4.setBounds(9, 107, 15, 13);
		panel_1.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("*");
		lblNewLabel_5.setBounds(9, 145, 15, 13);
		panel_1.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("*");
		lblNewLabel_6.setBounds(9, 222, 15, 13);
		panel_1.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("*");
		lblNewLabel_7.setBounds(9, 303, 15, 13);
		panel_1.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("*");
		lblNewLabel_8.setBounds(9, 426, 15, 13);
		panel_1.add(lblNewLabel_8);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBackground(SystemColor.menu);
		btnLimpiar.setBounds(9, 465, 97, 21);
		panel_1.add(btnLimpiar);
		
		lblNewLabel_9 = new JLabel("*");
		lblNewLabel_9.setBounds(9, 346, 15, 13);
		panel_1.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("*");
		lblNewLabel_10.setBounds(9, 385, 15, 13);
		panel_1.add(lblNewLabel_10);
		
		lblCorreo = new JLabel("Correo electr\u00F3nico");
		lblCorreo.setBounds(21, 346, 111, 13);
		panel_1.add(lblCorreo);
		
		lblClave = new JLabel("Contrase\u00F1a");
		lblClave.setBounds(21, 385, 67, 13);
		panel_1.add(lblClave);
		
		textCorreo = new JTextField();
		textCorreo.setBounds(139, 343, 203, 19);
		panel_1.add(textCorreo);
		textCorreo.setForeground(Color.BLACK);
		textCorreo.setColumns(10);
		textCorreo.setBackground(Color.WHITE);
		
		password = new JPasswordField();
		password.setBounds(140, 382, 202, 19);
		panel_1.add(password);
		
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				textId.setText("");
				textDocumento.setText("");
				textApellido1.setText("");
				textApellido2.setText("");
				textNombre1.setText("");
				textNombre2.setText("");
				textDia.setText("");
				textMes.setText("");
				textAnio.setText("");
				textCorreo.setText("");
				password.setText("");
			}
		});
		
		
		lblListado = new JLabel("Listado Personas");
		lblListado.setFont(new Font("Bookman Old Style", Font.BOLD, 40));
		lblListado.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblListado.setBounds(10, 10, 496, 42);
		panel.add(lblListado);
		
		lblSelect = new JLabel("Seleccione un registro para realizar alguna modificaci\u00F3n");
		lblSelect.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSelect.setForeground(Color.DARK_GRAY);
		lblSelect.setBounds(666, 35, 397, 19);
		panel.add(lblSelect);
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1445, 532);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
		
		}
	
	public void listaP() {
		DefaultTableModel model = new DefaultTableModel();
		Object[] columns = {"Id Persona","Documento", "Apellido1", "Apellido2", "Nombre1", "Nombre2", "Fecha Nacimiento", "Correo Electrónico", "Contraseña", "Rol"};
		
		model.setColumnIdentifiers(columns);
		
		Object [] fila = new Object[columns.length];
		table.setModel(model);
		
		LinkedList<Persona> allPersona = DAOPersona.findAll();
		
		for (int i=0;i<allPersona.size();i++){
			
			int id=allPersona.get(i).getIdPersona();
			String doc = allPersona.get(i).getDocumento();
			String a1 = allPersona.get(i).getApellido1();
			String a2 = allPersona.get(i).getApellido2();
			String n1 = allPersona.get(i).getNombre1();
			String n2 = allPersona.get(i).getNombre2();
			LocalDate fn = allPersona.get(i).getFechaNac();
			String c = allPersona.get(i).getMail();
			String cont = allPersona.get(i).getClave();
			String r = allPersona.get(i).getRol().getNombreRol();
			
			fila[0] = id;
			fila[1] = doc;
			fila[2] = a1;
			fila[3] = a2;
			fila[4] = n1;
			fila[5] = n2;
			fila[6] = fn;
			fila[7] = c;
			fila[8] = cont;
			fila[9] = r;
			model.addRow(fila); 
			
		}
		
		
		
	}
	public void cuenta() {
		textCantidad = new JTextPane();
		textCantidad.setEditable(false);
		textCantidad.setBackground(SystemColor.inactiveCaptionBorder);
		textCantidad.setBounds(812, 468, 58, 21);
		panel.add(textCantidad);
		
		int cuenta = DAOPersona.cuentaPersonas();
		textCantidad.setText(""+ cuenta +"");
		
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
			
				LocalDate fn = (LocalDate) table.getValueAt(filaSeleccionada, 6);
				
				int dia = fn.getDayOfMonth();
				String d = String.valueOf(dia);
				int mes = fn.getMonthValue();
				String m = String.valueOf(mes);
				int anio = fn.getYear();
				String a = String.valueOf(anio);
				
				textId.setText(table.getValueAt(filaSeleccionada, 0 ).toString());
				textDocumento.setText(table.getValueAt(filaSeleccionada, 1 ).toString());
				textApellido1.setText(table.getValueAt(filaSeleccionada, 2 ).toString());
				textApellido2.setText(table.getValueAt(filaSeleccionada, 3 ).toString());
				textNombre1.setText(table.getValueAt(filaSeleccionada, 4 ).toString());
				textNombre2.setText(table.getValueAt(filaSeleccionada, 5 ).toString());
				textDia.setText(d);
				textMes.setText(m);
				textAnio.setText(a);
				textCorreo.setText(table.getValueAt(filaSeleccionada, 7).toString());
				password.setText(table.getValueAt(filaSeleccionada, 8).toString());
				comboRol.setPopupVisible(true);

			}
		}catch(Exception ex) {
			 JOptionPane.showMessageDialog(null, " .::Error En la Operacion::.");
		}
	}
}

