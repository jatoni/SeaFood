package com.mx.sea.food.views;

import java.awt.EventQueue;

import javax.swing.JFrame;

import com.mx.sea.food.dto.EmployeeDto;

public class Dashboard {

	private JFrame frame;
	private EmployeeDto _employee;

	/**
	 * Launch the application.
	 */
	public void run(EmployeeDto employee) {
		this._employee = employee;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard window = new Dashboard();
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
	public Dashboard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
