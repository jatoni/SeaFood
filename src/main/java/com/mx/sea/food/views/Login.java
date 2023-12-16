package com.mx.sea.food.views;

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

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private LoginController _loginController;
	private EmployeeDto _employee;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Create the application.
	 */
	public Login() {
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
		_loginController = new LoginController();
		_employee = new EmployeeDto();

		this.setBounds(100, 100, 274, 420);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		this.getContentPane().add(panel, BorderLayout.CENTER);

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
						new Dashboard(_employee).setVisible(true);
						closeWindow();
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
				new Register().setVisible(true);
				closeWindow();
			}
		});
		panel.add(btnNewButton_1);
	}

	private void closeWindow() {
		this.setVisible(false);
	}

}
