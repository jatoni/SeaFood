package com.mx.sea.food.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;

import com.mx.sea.food.dto.EmployeeDto;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		frame.setBounds(100, 100, 770, 510);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuItem i1, i2, i3, i4, i5;
		JMenu usuarios, productos;
		JMenuBar mb = new JMenuBar();

		usuarios = new JMenu("Usuarios");
		productos = new JMenu("Productos");
		productos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mb.setVisible(true);
			}
		});

		mb.add(usuarios);
		mb.add(productos);
		frame.setJMenuBar(mb);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGap(0, 754, Short.MAX_VALUE));
		groupLayout
				.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGap(0, 449, Short.MAX_VALUE));
		frame.getContentPane().setLayout(groupLayout);
	}
}
