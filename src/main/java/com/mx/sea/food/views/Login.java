package com.mx.sea.food.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mx.sea.food.controllers.LoginController;
import com.mx.sea.food.dto.EmployeeDto;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login {

	private LoginController _loginController;
	private EmployeeDto _employee;
	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		_loginController = new LoginController();
		_employee = new EmployeeDto();
		frame = new JFrame();
		frame.setBounds(100, 100, 274, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);

		JLabel lblNewLabel = new JLabel("Correo Electronico");
		panel.add(lblNewLabel);

		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(20);

		JLabel lblNewLabel_1 = new JLabel("Clave");
		panel.add(lblNewLabel_1);

		passwordField = new JPasswordField();
		passwordField.setColumns(20);
		panel.add(passwordField);

		JButton btnNewButton = new JButton("Iniciar Sesion");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().isEmpty() || passwordField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Uno de los campos esta vacio");
				} else {

					_employee.setEmail(textField.getText());
					_employee.setPass(passwordField.getText());
					_employee = _loginController.IniciarSesion(_employee);
					if (_employee != null) {
						new Dashboard().run(_employee);
						frame.setVisible(false);
					} else {
						_employee = new EmployeeDto();
						JOptionPane.showMessageDialog(null, "Usuario no encontrado");
					}
				}
			}
		});
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Registrarse");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Register().run();
				frame.setVisible(false);
			}
		});
		panel.add(btnNewButton_1);
	}

}
