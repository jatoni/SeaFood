package com.mx.sea.food.views;

import javax.swing.JFrame;
import javax.swing.JMenu;

import com.mx.sea.food.controllers.DashboardController;
import com.mx.sea.food.controllers.RegisterProductController;
import com.mx.sea.food.dto.EmployeeDto;
import com.mx.sea.food.dto.ProductDto;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class Dashboard extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String[] columnas = { "Id", "Nombre", "Apellidos", "Username", "Email", "Role" };

	private EmployeeDto employee;
	private DefaultTableModel dashboardTableModel;
	private DashboardController dashboardController;
	private JTable dashboardTable;
	private JPanel dashboardPanel;
	private JButton dashboardButton;
	private String ventana;
	private JLabel dashboardLabel;
	private EmployeeDto editEmployee;
	private ProductDto editProduct;
	private boolean dashboardEditMode;
	private List<EmployeeDto> employeesList;
	private List<ProductDto> productList;
	private JButton dashboardDeleteButton;
	private JButton dashboardCancelButton;
	private long userId;
	JMenuBar mb;
	JMenu menu;
	JMenuItem usuarios;
	JMenuItem productos;
	GroupLayout groupLayout;
	GroupLayout gl_dashboardPanel;
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
		dashboardController = new DashboardController();

		registerProductController = new RegisterProductController();
		productostable = new JTable();
		this.setBounds(100, 100, 770, 510);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		configureMenu();
		configureUsuarioPanel();

	}

	private void configureMenu() {
		mb = new JMenuBar();
		this.setJMenuBar(mb);

		menu = new JMenu("Menu");
		mb.add(menu);

		usuarios = new JMenuItem("Usuarios");
		usuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana = "USUARIOS";
				showUsuariosSection();
			}
		});
		menu.add(usuarios);

		productos = new JMenuItem("Productos");
		productos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana = "PRODUCTOS";
				showProductsSection();
			}
		});
		menu.add(productos);
	}

	private void configureUsuarioPanel() {
		dashboardPanel = new JPanel();
		dashboardPanel.setVisible(false);
		groupLayout = new GroupLayout(this.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(dashboardPanel,
				Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(dashboardPanel,
				Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE));

		configureUsuariosComponents();

		gl_dashboardPanel = new GroupLayout(dashboardPanel);
		gl_dashboardPanel.setHorizontalGroup(gl_dashboardPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dashboardPanel.createSequentialGroup().addContainerGap()
						.addGroup(gl_dashboardPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(dashboardTable, GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
								.addComponent(dashboardLabel)
								.addGroup(gl_dashboardPanel.createSequentialGroup().addComponent(dashboardCancelButton)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(dashboardDeleteButton)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(dashboardButton)))
						.addContainerGap()));
		gl_dashboardPanel.setVerticalGroup(gl_dashboardPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dashboardPanel.createSequentialGroup().addContainerGap().addComponent(dashboardLabel)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(dashboardTable, GroupLayout.PREFERRED_SIZE, 345, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(
								gl_dashboardPanel.createParallelGroup(Alignment.BASELINE).addComponent(dashboardButton)
										.addComponent(dashboardDeleteButton).addComponent(dashboardCancelButton))
						.addContainerGap(41, Short.MAX_VALUE)));
		dashboardPanel.setLayout(gl_dashboardPanel);

		this.getContentPane().setLayout(groupLayout);
	}

	private void showUsuariosSection() {
		dashboardPanel.setVisible(true);
		dashboardLabel.setText("Panel de usuarios");
		cleanTable();
		if (dashboardTableModel.getRowCount() <= 0) {
			employeesList = dashboardController.searchEmployees();

			if (!employeesList.isEmpty()) {

				employeesList.forEach(employee -> {
					Object[] tableEmployee = { employee.getId(), employee.getName(), employee.getLastName(),
							employee.getUsername(), employee.getEmail(), employee.getTbRole().getId(), };
					dashboardTableModel.addRow(tableEmployee);
				});

				dashboardTableModel.fireTableDataChanged();
			} else {
				cleanTable();
				JOptionPane.showMessageDialog(null, "No hay usuarios en la base de datos", "Lista vacia",
						JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	private void showProductsSection() {
		dashboardPanel.setVisible(true);
		dashboardLabel.setText("Panel de products");
		cleanTable();
		if (dashboardTableModel.getRowCount() <= 0) {
			productList = dashboardController.searchProducts();
			if (!productList.isEmpty()) {
				productList.forEach(product -> {
					Object[] tableProduct = { product.getId(), product.getName(), product.getDescription() };
					dashboardTableModel.addRow(tableProduct);
				});
				dashboardTableModel.fireTableDataChanged();
			}

		} else {
			cleanTable();
			dashboardLabel.setText("Vacio");
			JOptionPane.showMessageDialog(null, "No hay productos en la base de datos", "Lista vacia",
					JOptionPane.ERROR_MESSAGE);
		}
//		modifyTableModel(titulos);

	}

	private void cleanTable() {
		dashboardTableModel.setRowCount(0);
		dashboardTableModel.fireTableDataChanged();
	}

	private void configureUsuariosComponents() {

		dashboardEditMode = false;
		dashboardLabel = new JLabel("Usuarios");
		dashboardLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));

		modifyTableModel(columnas);

		dashboardTable = new JTable(dashboardTableModel);
		dashboardTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		dashboardTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {

				if (dashboardTable.getSelectedRow() != -1) {
					switch (ventana) {
					case "USUARIOS":
						userId = (long) dashboardTableModel.getValueAt(dashboardTable.getSelectedRow(), 0);
						editEmployee = employeesList.stream().filter(employee -> employee.getId() == userId).findFirst()
								.orElse(new EmployeeDto());
						showEditModeButtons();
						break;
					case "PRODUCTOS":
						userId = (long) dashboardTableModel.getValueAt(dashboardTable.getSelectedRow(), 0);
						editProduct = productList.stream().filter(product -> product.getId() == userId).findFirst()
								.orElse(new ProductDto());
						showEditModeButtons();
						break;
					case "MOVIMIENTOS":
						break;
					}

				}

			}
		});

		dashboardButton = new JButton("Nuevo");
		dashboardButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (ventana) {
				case "USUARIOS":
					if (dashboardEditMode) {
						if (editEmployee.getId() != 0) {
							cleanTable();
							Register editView = new Register();
							editView.setVisible(true);
							editView.setEditMode(editEmployee);
							dispose();
						}
					} else {
						new Register().setVisible(true);
						dispose();
					}
					break;
				case "PRODUCTOS":
					if (dashboardEditMode) {
						if (editProduct.getId() != 0) {
							cleanTable();
							int opcionSeleccionada = JOptionPane.showConfirmDialog(null,
									"Desea ingresar un nuevo producto o hacer un registro con un producto ya existente",
									"Mensaje de opcion", JOptionPane.YES_NO_CANCEL_OPTION);
							if(registerProductController)
							RegisterNewProduct registerNewProduct = new RegisterNewProduct(employee);
							registerNewProduct.setVisible(true);
							registerNewProduct.setEditMode(editProduct);
							dispose();
						}
					} else {
						new RegisterNewProduct(employee).setVisible(true);
						dispose();
					}
					break;
				}

			}
		});

		dashboardDeleteButton = new JButton("Borrar");
		dashboardDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cancelResult = JOptionPane.showConfirmDialog(null, "¿Seguro que deseas borrar el usuario?",
						"Borrar Usuario", JOptionPane.OK_CANCEL_OPTION);
				if (cancelResult == JOptionPane.OK_OPTION) {
					if (userId > 0) {
						if (dashboardController.deleteEmployeeById(userId)) {
							JOptionPane.showMessageDialog(null, "Usuario Borrado Correctamente", "Usuario Borrado",
									JOptionPane.PLAIN_MESSAGE);
							dashboardTableModel.setNumRows(0);
							dashboardTableModel.fireTableDataChanged();
							showUsuariosSection();
						} else {

						}
					} else {
						JOptionPane.showConfirmDialog(null, "Usuario no seleccionado", "No Usuario",
								JOptionPane.OK_CANCEL_OPTION);
					}
				} else {

				}
			}
		});

		dashboardCancelButton = new JButton("Cancelar");
		dashboardCancelButton.setVisible(false);
		dashboardCancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dashboardTable.clearSelection();
				dashboardEditMode = false;
				dashboardButton.setText("Nuevo");
				dashboardDeleteButton.setVisible(false);
				dashboardCancelButton.setVisible(false);
			}
		});
	}

	public void modifyTableModel(String[] columnas) {
		dashboardTableModel = new DefaultTableModel(columnas, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

	}

	private void showEditModeButtons() {
		dashboardEditMode = true;
		dashboardCancelButton.setVisible(true);
		dashboardDeleteButton.setVisible(true);
		dashboardButton.setText("Editar");
	}

	public EmployeeDto get_employee() {
		return employee;
	}

	public void set_employee(EmployeeDto _employee) {
		this.employee = _employee;
	}
}
