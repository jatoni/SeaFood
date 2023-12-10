package com.mx.sea.food.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
<<<<<<< HEAD
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
=======

import com.mx.sea.food.dto.EmployeeDto;
>>>>>>> 48b0998aa5904e71b937d84f6227b8adfde5bde7

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
<<<<<<< HEAD
		frame.setBounds(100, 100, 770, 510);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuItem i1, i2, i3, i4, i5;
		JMenu usuarios, productos;

		JPanel productosDashboard = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(productosDashboard, GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(productosDashboard, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(439, Short.MAX_VALUE))
		);
		JMenuBar mb = new JMenuBar();
		productosDashboard.add(mb);
		
				usuarios = new JMenu("Usuarios");
				productos = new JMenu("Productos");
				
						mb.add(usuarios);
						mb.add(productos);
						
								productos.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										productosDashboard.setVisible(true);
									}
								});
		frame.getContentPane().setLayout(groupLayout);
	}
=======
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

>>>>>>> 48b0998aa5904e71b937d84f6227b8adfde5bde7
}
