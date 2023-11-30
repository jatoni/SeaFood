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
import com.mx.sea.food.entity.TbRole;
import com.mx.sea.food.entity.TbTypework;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Register {

	private JFrame frame;
	private JTextField nombres;
	private JTextField apellidos;
	private JTextField username;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JPasswordField passwordField;
	private JPasswordField passwordField2;
	private EmployeeDto employee;
	private JButton btnNewButton;

	private RegisterController _registroController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
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
	public Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		_registroController = new RegisterController();
		this.employee = new EmployeeDto();
		frame = new JFrame("Register");
		frame.setResizable(false);
		frame.setBounds(100, 100, 293, 437);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		panel.setBackground(Color.CYAN);
		frame.getContentPane().add(panel, BorderLayout.CENTER);

		JLabel lblNewLabel = new JLabel("Nombre");
		panel.add(lblNewLabel);

		nombres = new JTextField();
		nombres.setColumns(24);
		panel.add(nombres);

		JLabel lblNewLabel_1 = new JLabel("Apellidos");
		panel.add(lblNewLabel_1);

		apellidos = new JTextField();
		apellidos.setColumns(24);
		panel.add(apellidos);

		lblNewLabel_2 = new JLabel("Username");
		panel.add(lblNewLabel_2);

		username = new JTextField();
		username.setColumns(24);
		panel.add(username);

		lblNewLabel_3 = new JLabel("Email");
		panel.add(lblNewLabel_3);

		JTextField email = new JTextField();
		email.setColumns(24);
		panel.add(email);

		JLabel label_4 = new JLabel("Password");
		panel.add(label_4);

		passwordField = new JPasswordField();
		passwordField.setColumns(24);
		panel.add(passwordField);

		JLabel label_5 = new JLabel("Confirmar Password");
		panel.add(label_5);

		passwordField2 = new JPasswordField();
		passwordField2.setColumns(24);
		panel.add(passwordField2);

		JLabel label_6 = new JLabel("Escoge un rol");
		panel.add(label_6);

		List<TbRole> roles = _registroController.getRoleList();
		List<String> rolesNames = new ArrayList<>();
		roles.forEach(rol -> rolesNames.add(rol.getName()));

		List<TbTypework> types = _registroController.getTypeWorkList();
		List<String> typesNames = new ArrayList<String>();

		types.forEach(type -> typesNames.add(type.getName()));

		JComboBox<String> typesWorks = new JComboBox(typesNames.toArray());

		JComboBox<String> dropDown = new JComboBox(rolesNames.toArray());
		panel.add(dropDown);
		JLabel label_7 = new JLabel("Escoge un rol de trabajo");
		panel.add(label_7);
		panel.add(typesWorks);

		btnNewButton = new JButton("Registrarse");

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				employee.setName(nombres.getText());
				employee.setLastName(apellidos.getText());
				employee.setUsername(username.getText());
				employee.setEmail(email.getText());
				employee.setIdRole(roles.get(dropDown.getSelectedIndex()).getId());
				if (passwordField.equals(passwordField2)) {
					employee.setPass(passwordField.getText());
					_registroController.Registrarse();
				} else {

				}

			}
		});
		panel.add(btnNewButton);

	}

}
