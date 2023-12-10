package com.mx.sea.food.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;

import com.mx.sea.food.dto.EmployeeDto;
import javax.swing.JMenuBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class Dashboard extends JFrame {

	private EmployeeDto _employee;
	Object[][] data = {};
	String[] titulos = { "id", "Producto", "Fecha de Ingreso", "Tipos de producto", "Stock" };
	private JTable productostable;
	private DefaultTableModel productosmodeloTable;

	/**
	 * Create the application.
	 */
	public Dashboard(EmployeeDto employee) {
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

		productostable = new JTable();
		this.setBounds(100, 100, 770, 510);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
		this.setJMenuBar(mb);

		productosmodeloTable = new DefaultTableModel(titulos, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Button.shadow"));
		GroupLayout groupLayout = new GroupLayout(this.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(panel,
				Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(panel,
				Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE));

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(48)
						.addComponent(productostable, GroupLayout.PREFERRED_SIZE, 656, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(50, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(64)
						.addComponent(productostable, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(114, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
		this.getContentPane().setLayout(groupLayout);

	}
}
