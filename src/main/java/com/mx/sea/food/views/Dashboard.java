package com.mx.sea.food.views;

import javax.swing.JFrame;
import javax.swing.JMenu;

import com.mx.sea.food.controllers.RegisterProductController;
import com.mx.sea.food.dto.EmployeeDto;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Dashboard extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3975461486339003064L;
	private EmployeeDto _employee;
	Object[][] data = {};
	String[] titulos = { "id", "Producto", "Fecha de Ingreso", "Tipos de producto", "Stock" };
	private JTable productostable;
	private DefaultTableModel productosmodeloTable;
	private RegisterProductController registerProductController;

	/**
	 * Create the application.
	 */
	public Dashboard(EmployeeDto employee) {
		try {
			this.set_employee(employee);
			initialize();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Dashboard() {
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
		registerProductController = new RegisterProductController();
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

		JLabel NombreSesion = new JLabel(
				" Bienvenido " + this._employee.getName() + " " + this._employee.getLastName());
		mb.add(NombreSesion);

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

		JButton btnNewButton = new JButton("Movimientos Producto");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcionSeleccionada = JOptionPane.showConfirmDialog(null,
						"Quieres agregar un nuevo producto o un producto existente", "Mensaje de opcion",
						JOptionPane.YES_NO_CANCEL_OPTION);
				switch (opcionSeleccionada) {
				case JOptionPane.YES_OPTION:
					if (registerProductController.listProducts().isEmpty()
							|| registerProductController.listProducts() == null) {
						JOptionPane.showMessageDialog(null, "No hay productos existente", "No existe ni un producto",
								JOptionPane.ERROR_MESSAGE);
						new RegisterProducts(_employee).setVisible(true);
						closeWindow();
					} else {
						new RegisterNewProduct(_employee).setVisible(true);
						closeWindow();
					}
					break;
				case JOptionPane.NO_OPTION:
					new RegisterProducts(_employee).setVisible(true);
					closeWindow();
					break;
				}
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(40).addComponent(productostable,
						GroupLayout.PREFERRED_SIZE, 656, GroupLayout.PREFERRED_SIZE))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup().addContainerGap(532, Short.MAX_VALUE)
						.addComponent(btnNewButton).addGap(133)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(89)
						.addComponent(productostable, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
						.addGap(32).addComponent(btnNewButton).addContainerGap(34, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
		this.getContentPane().setLayout(groupLayout);

	}

	private void closeWindow() {
		this.setVisible(false);
	}

	public EmployeeDto get_employee() {
		return _employee;
	}

	public void set_employee(EmployeeDto _employee) {
		this._employee = _employee;
	}
}
