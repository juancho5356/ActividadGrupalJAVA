package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

import Controlador.DAOPersona;
import Controlador.DAORol;
import Modelo.Persona;
import Modelo.Rol;

import javax.swing.JPasswordField;

public class RegistroJefe {

	JFrame frame;
	private JPanel panel_Registro;
	private JLabel lblApellido1;
	private JTextField textApellido1;
	private JLabel lblApellido2;
	private JTextField textApellido2;
	private JLabel lblNombre1;
	private JTextField textNombre1;
	private JLabel lblFechaNacimiento;
	private JTextField textDia;
	private JLabel lblDia;
	private JTextField textMes;
	private JLabel lblNewLabel;
	private JTextField textAnio;
	private JLabel lblNewLabel_1;
	private JButton btnIngresar;
	private JLabel lblNombre2;
	private JTextField textNombre2;
	private JLabel lblRegistro;
	private JLabel lblDocumento;
	private JTextField textDocumento;
	private JLabel lblCorreo;
	private JTextField textCorreo;
	private JLabel lblClave;
	private JLabel lblRol;
	private JComboBox<Object> comboBoxRol;
	private JLabel lblCamposObligatorios;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JButton btnIr;
	private JLabel lblVerListado;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroJefe window = new RegistroJefe();
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
	public RegistroJefe() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBackground(new Color(255, 255, 255));
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setLayout(null);
		
		panel_Registro = new JPanel();
		panel_Registro.setLayout(null);
		panel_Registro.setBackground(SystemColor.inactiveCaption);
		panel_Registro.setBounds(0, 0, 706, 496);
		frame.getContentPane().add(panel_Registro);
		
		lblApellido1 = new JLabel("Apellido 1");
		lblApellido1.setBounds(22, 119, 67, 13);
		panel_Registro.add(lblApellido1);
		
		textApellido1 = new JTextField();
		textApellido1.setForeground(SystemColor.desktop);
		textApellido1.setBackground(SystemColor.textHighlightText);
		textApellido1.setColumns(10);
		textApellido1.setBounds(137, 116, 203, 19);
		panel_Registro.add(textApellido1);
		
		lblApellido2 = new JLabel("Apellido 2");
		lblApellido2.setBounds(22, 156, 93, 13);
		panel_Registro.add(lblApellido2);
		
		textApellido2 = new JTextField();
		textApellido2.setForeground(SystemColor.desktop);
		textApellido2.setBackground(SystemColor.textHighlightText);
		textApellido2.setColumns(10);
		textApellido2.setBounds(137, 153, 203, 19);
		panel_Registro.add(textApellido2);
		
		lblNombre1 = new JLabel("Nombre 1");
		lblNombre1.setBounds(22, 196, 93, 13);
		panel_Registro.add(lblNombre1);
		
		textNombre1 = new JTextField();
		textNombre1.setForeground(SystemColor.desktop);
		textNombre1.setBackground(SystemColor.textHighlightText);
		textNombre1.setColumns(10);
		textNombre1.setBounds(137, 193, 203, 19);
		panel_Registro.add(textNombre1);
		
		lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		lblFechaNacimiento.setBounds(22, 277, 105, 13);
		panel_Registro.add(lblFechaNacimiento);
		
		textDia = new JTextField();
		textDia.setForeground(SystemColor.desktop);
		textDia.setBackground(SystemColor.textHighlightText);
		textDia.setColumns(10);
		textDia.setBounds(137, 274, 29, 19);
		panel_Registro.add(textDia);
		
		lblDia = new JLabel("d\u00EDa");
		lblDia.setBounds(137, 294, 45, 13);
		panel_Registro.add(lblDia);
		
		textMes = new JTextField();
		textMes.setForeground(SystemColor.desktop);
		textMes.setBackground(SystemColor.textHighlightText);
		textMes.setColumns(10);
		textMes.setBounds(207, 274, 29, 19);
		panel_Registro.add(textMes);
		
		lblNewLabel = new JLabel("mes");
		lblNewLabel.setBounds(207, 294, 45, 13);
		panel_Registro.add(lblNewLabel);
		
		textAnio = new JTextField();
		textAnio.setForeground(SystemColor.desktop);
		textAnio.setBackground(SystemColor.textHighlightText);
		textAnio.setColumns(10);
		textAnio.setBounds(280, 274, 60, 19);
		panel_Registro.add(textAnio);
		
		lblNewLabel_1 = new JLabel("a\u00F1o");
		lblNewLabel_1.setBounds(280, 294, 45, 13);
		panel_Registro.add(lblNewLabel_1);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setBackground(SystemColor.controlHighlight);
		btnIngresar.setBounds(339, 452, 105, 21);
		panel_Registro.add(btnIngresar);
		btnIngresar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			
			public void actionPerformed(ActionEvent e) {

				if(!(textDocumento.getText().isEmpty() || textApellido1.getText().isEmpty() || textNombre1.getText().isEmpty() || textDia.getText().isEmpty() 
				  || textMes.getText().isEmpty() || textAnio.getText().isEmpty() || textCorreo.getText().isEmpty() || password.getText().isEmpty())) {
					
					String doc = textDocumento.getText();
					String a1 = textApellido1.getText();
					String a2 = textApellido2.getText();
					String n1 = textNombre1.getText();
					String n2 = textNombre2.getText();
					
					String mail = textCorreo.getText();
					String clave = password.getText();
					String r = (String) comboBoxRol.getSelectedItem();
					
					
					String d = textDia.getText();
					int day = Integer.parseInt(d);
					String m = textMes.getText();
					int month = Integer.parseInt(m);
					String an = textAnio.getText(); 
					int year = Integer.parseInt(an);
					
					LocalDate fecNac = LocalDate.of(year, month, day);
					
					
					Rol rol = DAORol.findRol(r);
					
					Persona p = new Persona(doc, a1, a2, n1, n2, fecNac, clave, mail);
					p.setRol(rol);
					
					
					if(DAOPersona.insert(p)) {
						JOptionPane.showMessageDialog(null, "Éxito");
						limpiar();
					}
					else {
						JOptionPane.showMessageDialog(null, "No es posible añadir este registro");
					}
					
				}
				else {
					JOptionPane.showMessageDialog(null, "No es posible añadir el registro, campos obligatorios sin rellenar");
				}	
				
				
			}
		});
		
		lblNombre2 = new JLabel("Nombre 2");
		lblNombre2.setBounds(22, 234, 93, 13);
		panel_Registro.add(lblNombre2);
		
		textNombre2 = new JTextField();
		textNombre2.setForeground(SystemColor.desktop);
		textNombre2.setBackground(SystemColor.textHighlightText);
		textNombre2.setColumns(10);
		textNombre2.setBounds(137, 231, 203, 19);
		panel_Registro.add(textNombre2);
		
		lblRegistro = new JLabel("Registro");
		lblRegistro.setFont(new Font("Bookman Old Style", Font.BOLD, 40));
		lblRegistro.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblRegistro.setBounds(10, 10, 289, 47);
		panel_Registro.add(lblRegistro);
		
		lblDocumento = new JLabel("Documento");
		lblDocumento.setBounds(22, 81, 67, 13);
		panel_Registro.add(lblDocumento);
		
		textDocumento = new JTextField();
		textDocumento.setForeground(SystemColor.desktop);
		textDocumento.setBackground(SystemColor.textHighlightText);
		textDocumento.setColumns(10);
		textDocumento.setBounds(137, 78, 203, 19);
		panel_Registro.add(textDocumento);
		
		lblCorreo = new JLabel("Correo electr\u00F3nico");
		lblCorreo.setBounds(22, 338, 111, 13);
		panel_Registro.add(lblCorreo);
		
		textCorreo = new JTextField();
		textCorreo.setForeground(SystemColor.desktop);
		textCorreo.setBackground(SystemColor.textHighlightText);
		textCorreo.setColumns(10);
		textCorreo.setBounds(137, 335, 203, 19);
		panel_Registro.add(textCorreo);
		
		lblClave = new JLabel("Contrase\u00F1a");
		lblClave.setBounds(22, 377, 67, 13);
		panel_Registro.add(lblClave);
		
		lblRol = new JLabel("Rol");
		lblRol.setBounds(22, 413, 67, 13);
		panel_Registro.add(lblRol);
		
		comboBoxRol = new JComboBox<Object>();
		comboBoxRol.setBounds(137, 409, 203, 21);
		panel_Registro.add(comboBoxRol);
		
		LinkedList<Rol> allRoles = DAORol.findAll();
		
		for (int i=0;i<allRoles.size();i++){
			String rol = allRoles.get(i).getNombreRol();
			comboBoxRol.addItem(rol);
		} 
		
		lblCamposObligatorios = new JLabel("Campos obligatorios *");
		lblCamposObligatorios.setForeground(new Color(128, 128, 128));
		lblCamposObligatorios.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCamposObligatorios.setBounds(178, 41, 162, 19);
		panel_Registro.add(lblCamposObligatorios);
		
		lblNewLabel_3 = new JLabel("*");
		lblNewLabel_3.setBounds(10, 81, 15, 13);
		panel_Registro.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("*");
		lblNewLabel_4.setBounds(10, 119, 15, 13);
		panel_Registro.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("*");
		lblNewLabel_5.setBounds(10, 196, 15, 13);
		panel_Registro.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("*");
		lblNewLabel_6.setBounds(10, 277, 15, 13);
		panel_Registro.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("*");
		lblNewLabel_7.setBounds(10, 338, 15, 13);
		panel_Registro.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("*");
		lblNewLabel_8.setBounds(10, 377, 15, 13);
		panel_Registro.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("*");
		lblNewLabel_9.setBounds(10, 413, 15, 13);
		panel_Registro.add(lblNewLabel_9);
		
		btnIr = new JButton("Ir");
		btnIr.setBackground(SystemColor.controlHighlight);
		btnIr.setBounds(586, 73, 67, 21);
		panel_Registro.add(btnIr);
		btnIr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoJefe window = new ListadoJefe();
				window.frame.setVisible(true);
			}
		});
		
		lblVerListado = new JLabel("Ver Listado de Registros");
		lblVerListado.setBounds(430, 77, 146, 13);
		panel_Registro.add(lblVerListado);
		
		password = new JPasswordField();
		password.setBounds(138, 374, 202, 19);
		panel_Registro.add(password);
		frame.setBounds(100, 100, 710, 524);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void limpiar() {
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
}
