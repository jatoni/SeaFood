package com.mx.sea.food.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JTextField;

import com.mx.sea.food.controllers.RegisterController;
import com.mx.sea.food.dto.EmployeeDto;
import com.mx.sea.food.dto.RoleDto;
import com.mx.sea.food.entity.TbRole;
import com.mx.sea.food.entity.TbTypework;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import java.awt.Component;
import javax.swing.Box;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import net.miginfocom.swing.MigLayout;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Rectangle;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.awt.Window.Type;
import javax.swing.border.LineBorder;
import javax.xml.registry.infomodel.User;
import javax.swing.ImageIcon;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Register extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EmployeeDto employee;
	private RegisterController _registroController;
	private JTextField Nombres;
	private JTextField Apellidos;
	private JTextField Username;
	private JTextField Email;
	private JPasswordField Password;
	private JPasswordField ConfirmarPassword;
	private JComboBox ComboRol;
	private JComboBox TypeWorkCombo;
	private boolean editMode;
	private JButton btnNewButton;
	private List<TbRole> roles;
	private List<String> rolesName;
	private List<TbTypework> types;
	private List<String> typesName;

	/**
	 * Create the application.
	 */
	public Register() {
		try {
			initialize();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		_registroController = new RegisterController();
		this.employee = new EmployeeDto();
		
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		this.setType(Type.POPUP);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setBounds(100, 100, 629, 407);

		JPanel panel = new JPanel();
		panel.setBounds(new Rectangle(5, 5, 0, 0));
		panel.setBorder(UIManager.getBorder("ToolBar.border"));
		panel.setToolTipText("Ingresa tu nombre o nombres");
		panel.setBackground(SystemColor.menu);
		panel.setForeground(new Color(64, 0, 0));

		JLabel lblNewLabel = new JLabel("Nombre(s):");

		Nombres = new JTextField();
		Nombres.setBorder(UIManager.getBorder("List.noFocusBorder"));
		Nombres.setToolTipText("Ingresa tu nombre o nombres");
		Nombres.setBackground(SystemColor.window);
		Nombres.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("X");
		lblNewLabel_1.setForeground(new Color(255, 51, 0));
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel lblNewLabel_3 = new JLabel("Apellidos: ");

		Apellidos = new JTextField();
		Apellidos.setToolTipText("Ingresa tus apellidos");
		Apellidos.setColumns(10);
		Apellidos.setBorder(UIManager.getBorder("List.noFocusBorder"));
		Apellidos.setBackground(SystemColor.window);

		JLabel lblNewLabel_3_1 = new JLabel("Username:");

		Username = new JTextField();
		Username.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (_registroController.isUserName(Username.getText())) {
					JOptionPane.showMessageDialog(null, "El Username: " + Username.getText() + " ya existe",
							"Username Invalido", JOptionPane.ERROR_MESSAGE);
					Username.setText("");
				}
			}
		});
		Username.setToolTipText("Ingresa tu username");
		Username.setColumns(10);
		Username.setBorder(UIManager.getBorder("List.noFocusBorder"));
		Username.setBackground(SystemColor.window);

		Email = new JTextField();
		Email.setToolTipText("Ingresa tu email");
		Email.setColumns(10);
		Email.setBorder(UIManager.getBorder("List.noFocusBorder"));
		Email.setBackground(SystemColor.window);

		JLabel lblNewLabel_3_1_1 = new JLabel("Email:");

		JLabel lblNewLabel_3_1_1_1 = new JLabel("Password:");

		Password = new JPasswordField();
		Password.setToolTipText("Ingresa tu password");
		Password.setColumns(10);
		Password.setBorder(UIManager.getBorder("List.noFocusBorder"));
		Password.setBackground(SystemColor.window);

		JLabel lblNewLabel_3_1_1_1_1 = new JLabel("Confirmar Password:");

		ConfirmarPassword = new JPasswordField();
		ConfirmarPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {

			}
		});
		ConfirmarPassword.setToolTipText("Confirma tu password");
		ConfirmarPassword.setColumns(10);
		ConfirmarPassword.setBorder(UIManager.getBorder("List.noFocusBorder"));
		ConfirmarPassword.setBackground(SystemColor.window);

		JComboBox IdRol = null;
		roles = _registroController.getRoleList();
		rolesName = new ArrayList<String>();
		roles.forEach(rol -> rolesName.add(rol.getName()));
		ComboRol = new JComboBox(rolesName.toArray());
		ComboRol.setToolTipText("Escoge un rol\r\n");
		ComboRol.setBorder(null);

		JLabel lblNewLabel_3_1_1_1_1_1 = new JLabel("Rol:");

		JLabel lblNewLabel_3_1_1_1_1_1_1 = new JLabel("Type Work:");

		types = _registroController.getTypeWorkList();
		typesName = new ArrayList<String>();
		types.forEach(type -> typesName.add(type.getName()));
		TypeWorkCombo = new JComboBox(typesName.toArray());
		TypeWorkCombo.setToolTipText("Escoge tu rol de trabajo");

		TypeWorkCombo.setBorder(null);

		btnNewButton = new JButton("Registrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validateForm()) {
					JOptionPane.showMessageDialog(null, "No puedes dejar ni un espacio en blanco", "Mensajes vacios",
							JOptionPane.ERROR_MESSAGE);
				} else {
					if (!Password.getText().equals(ConfirmarPassword.getText())) {
						JOptionPane.showMessageDialog(null, "No son iguales los passwords", "Password no hacen match",
								JOptionPane.ERROR_MESSAGE);
					} else {
						employee.setName(Nombres.getText());
						employee.setUsername(Username.getText());
						employee.setLastName(Apellidos.getText());
						employee.setEmail(Email.getText());
						employee.setPass(Password.getText());
						employee.setIdRole(roles.get(ComboRol.getSelectedIndex()).getId());
						employee.setIdTypeWork(types.get(TypeWorkCombo.getSelectedIndex()).getId());
						
						
						if (_registroController.Registrarse(employee)) {
							JOptionPane.showMessageDialog(null,
									"El Usuario: " + employee.getName() + " se guardo con exito", "No se guardo",
									JOptionPane.INFORMATION_MESSAGE);
							vaciarCeldas();
							dispose();
							if(!editMode) new Login().setVisible(true);
						} else {
							JOptionPane.showMessageDialog(null,
									"Hubo un problema al guardar el Usuario: " + employee.getName(), "No se guardo",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
		});
		btnNewButton.setBorder(UIManager.getBorder("Button.border"));

		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(editMode) {
					
					dispose();
				}else {
					new Login().setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton_1.setBorder(UIManager.getBorder("Button.border"));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel
								.createSequentialGroup().addGap(39)
								.addGroup(
										gl_panel.createParallelGroup(Alignment.TRAILING)
												.addGroup(gl_panel.createSequentialGroup().addComponent(lblNewLabel)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(Nombres, GroupLayout.PREFERRED_SIZE, 152,
																GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_panel.createSequentialGroup().addGroup(gl_panel
														.createParallelGroup(Alignment.TRAILING)
														.addComponent(lblNewLabel_3_1_1_1, GroupLayout.PREFERRED_SIZE,
																78, GroupLayout.PREFERRED_SIZE)
														.addComponent(lblNewLabel_3_1_1).addComponent(lblNewLabel_3_1)
														.addComponent(lblNewLabel_3)
														.addComponent(lblNewLabel_3_1_1_1_1_1,
																GroupLayout.PREFERRED_SIZE, 37,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblNewLabel_3_1_1_1_1))
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
																.addGroup(gl_panel
																		.createParallelGroup(Alignment.LEADING, false)
																		.addComponent(Apellidos,
																				GroupLayout.DEFAULT_SIZE, 152,
																				Short.MAX_VALUE)
																		.addComponent(Username,
																				GroupLayout.DEFAULT_SIZE, 152,
																				Short.MAX_VALUE)
																		.addComponent(Email, GroupLayout.DEFAULT_SIZE,
																				152, Short.MAX_VALUE)
																		.addComponent(Password,
																				GroupLayout.DEFAULT_SIZE, 152,
																				Short.MAX_VALUE)
																		.addComponent(ConfirmarPassword,
																				GroupLayout.DEFAULT_SIZE, 152,
																				Short.MAX_VALUE))
																.addComponent(ComboRol, 0, 152, Short.MAX_VALUE))))
								.addGap(95))
						.addGroup(Alignment.LEADING,
								gl_panel.createSequentialGroup().addGap(81).addComponent(lblNewLabel_3_1_1_1_1_1_1)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(TypeWorkCombo,
												GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING,
						gl_panel.createSequentialGroup().addContainerGap(125, Short.MAX_VALUE)
								.addComponent(btnNewButton).addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnNewButton_1).addGap(85))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup().addContainerGap(324, Short.MAX_VALUE)
						.addComponent(lblNewLabel_1).addGap(66)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap().addComponent(lblNewLabel_1).addGap(51)
				.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
								.addComponent(Nombres, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 6, GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addComponent(lblNewLabel_3).addComponent(
						Apellidos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addComponent(lblNewLabel_3_1).addComponent(
						Username, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addComponent(lblNewLabel_3_1_1).addComponent(
						Email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(Password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3_1_1_1))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addComponent(lblNewLabel_3_1_1_1_1)
						.addComponent(ConfirmarPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(11)
				.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addComponent(lblNewLabel_3_1_1_1_1_1)
						.addComponent(ComboRol, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(TypeWorkCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3_1_1_1_1_1_1))
				.addGap(27).addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
				.addContainerGap(51, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		GroupLayout groupLayout = new GroupLayout(this.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 390, Short.MAX_VALUE).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE));

		JLabel lblNewLabel_2_1 = new JLabel("REGISTRAR EMPLEADO");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 17));

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(
				new ImageIcon("C:\\Users\\jat_a\\eclipse-workspace\\SeaFood\\src\\main\\resources\\Mariscos(1).jpg"));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1
				.setHorizontalGroup(
						gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
										.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 193,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap(14, Short.MAX_VALUE))
								.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
										.addContainerGap(32, Short.MAX_VALUE).addComponent(lblNewLabel_2,
												GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
										.addGap(31)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addGap(102)
						.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(88, Short.MAX_VALUE)));
		panel_1.setLayout(gl_panel_1);
		this.getContentPane().setLayout(groupLayout);

	}

	public void vaciarCeldas() {
		Nombres.setText("");
		Apellidos.setText("");
		Email.setText("");
		Username.setText("");
		Password.setText("");
		ConfirmarPassword.setText("");

	}
	
	public boolean validateForm() {
		return (Nombres.getText().isEmpty() || Apellidos.getText().isEmpty() || Username.getText().isEmpty()
				|| Email.getText().isEmpty() || Password.getText().isEmpty()
				|| ConfirmarPassword.getText().isEmpty());
	}

	public void setEditMode(EmployeeDto editEmployee) {
		this.editMode = true;
		Nombres.setText(editEmployee.getName());
		Apellidos.setText(editEmployee.getLastName());
		Email.setText(editEmployee.getEmail());
		Username.setText(editEmployee.getUsername());
		Password.setText(editEmployee.getPass());
		ConfirmarPassword.setText(editEmployee.getPass());
		
		for(TbRole rol : roles) {
			if(rol.getId() == editEmployee.getIdRole()) {
				ComboRol.setSelectedItem(rol.getName());
				break;
			}
		}
		
		for(TbTypework type : types) {
			if(type.getId() == editEmployee.getIdTypeWork()) {
				TypeWorkCombo.setSelectedItem(type.getName());
				break;
			}
		}
		
		
		
		employee.setId(editEmployee.getId());
		
		employee.setIdRole(editEmployee.getIdRole());
		employee.setIdTypeWork(editEmployee.getIdTypeWork());
		
		btnNewButton.setText("Editar Usuario: "+ editEmployee.getUsername());
		
	}
}
