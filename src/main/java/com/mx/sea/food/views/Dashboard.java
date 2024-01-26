package com.mx.sea.food.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;

import com.mx.sea.food.controllers.DashboardController;
import com.mx.sea.food.dto.EmployeeDto;
import com.mx.sea.food.tools.ButtonColumn;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;



import java.util.List;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class Dashboard extends JFrame{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EmployeeDto _employee;
	private DefaultTableModel usuariosTableModel;
	private DashboardController _dashboardController;
	private JTable userTable;
	private JPanel userPanel;
	private JButton userButton;
	private JLabel usuariosLabel;
	private EmployeeDto _editEmployee;
	private boolean userEditMode;
	private List<EmployeeDto> employeesList;
	private JButton userDeleteButton;
	private JButton userCancelButton;
	private long userId;
	

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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		_dashboardController = new DashboardController();
		this.setBounds(100, 100, 770, 510);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuItem i1, i2, i3, i4, i5;
		JMenuBar mb = new JMenuBar();
		this.setJMenuBar(mb);
		
		JMenu menu = new JMenu("Menu");
		mb.add(menu);
		
		JMenuItem usuarios = new JMenuItem("Usuarios");
		usuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showUsuariosSection();
			}
		});
		menu.add(usuarios);
		
		JMenuItem productos = new JMenuItem("Productos");
		productos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hiddeUsuariosSection();
			}
		});
		menu.add(productos);
		
		
		String[] columnas = {"Id","Nombre","Apellidos","Username","Email","Role"};
		
		usuariosTableModel = new DefaultTableModel(columnas,0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		userPanel = new JPanel();
		userPanel.setVisible(false);
		GroupLayout groupLayout = new GroupLayout(this.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(userPanel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(userPanel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
		);
		
		
		
		configureUsuariosComponents();
		
		
		
		
		GroupLayout gl_userPanel = new GroupLayout(userPanel);
		gl_userPanel.setHorizontalGroup(
			gl_userPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_userPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_userPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(userTable, GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
						.addComponent(usuariosLabel)
						.addGroup(Alignment.TRAILING, gl_userPanel.createSequentialGroup()
							.addComponent(userCancelButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(userDeleteButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(userButton)))
					.addContainerGap())
		);
		gl_userPanel.setVerticalGroup(
			gl_userPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_userPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(usuariosLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(userTable, GroupLayout.PREFERRED_SIZE, 345, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_userPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(userButton)
						.addComponent(userDeleteButton)
						.addComponent(userCancelButton))
					.addContainerGap(41, Short.MAX_VALUE))
		);
		userPanel.setLayout(gl_userPanel);
		
		this.getContentPane().setLayout(groupLayout);
	}

	
	
	private void showUsuariosSection() {
		
		userPanel.setVisible(true);
		
		
		if(usuariosTableModel.getRowCount() <= 0) {
			employeesList = _dashboardController.searchEmployees();
			
			if(!employeesList.isEmpty()) {
				
				employeesList.forEach(employee -> {
					Object[] tableEmployee = {
							employee.getId(),
							employee.getName(), 
							employee.getLastName(), 
							employee.getUsername(),
							employee.getEmail(),
							employee.getIdRole(),
							employee.getIdTypeWork()
							};
					usuariosTableModel.addRow(tableEmployee);
				});
				
				usuariosTableModel.fireTableDataChanged();
			}else {
				JOptionPane.showMessageDialog(null, "No hay usuarios en la base de datos", "Lista vacia", JOptionPane.ERROR_MESSAGE);
			}
		}

	}
	private void hiddeUsuariosSection() {
		userPanel.setVisible(false);
		
	}
	private void configureUsuariosComponents() {
		userEditMode = false;
		usuariosLabel = new JLabel("Usuarios");
		usuariosLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		String[] columnas = {"Id","Nombre","Apellidos","Username","Email","Role","Tipo Trabajador"};
		
		usuariosTableModel = new DefaultTableModel(columnas,0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		userTable = new JTable(usuariosTableModel);
		userTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		userTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                	
                    if(userTable.getSelectedRow() != -1) {
                    	userId = (long)usuariosTableModel.getValueAt(userTable.getSelectedRow(), 0);
                    	_editEmployee = employeesList.stream().filter(employee -> employee.getId() == userId).findFirst().orElse(new EmployeeDto());
                    	userEditMode = true;
                    	userCancelButton.setVisible(true);
                    	userDeleteButton.setVisible(true);
                    	userButton.setText("Editar");
                    }
                    
                
            }
        });
		
		userButton = new JButton("Nuevo");
		userButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(userEditMode) {
					if(_editEmployee.getId() != 0) {
						usuariosTableModel.setNumRows(0);
						usuariosTableModel.fireTableDataChanged();
						userPanel.setVisible(false);
						Register editView = new Register();
						editView.setVisible(true);
						editView.setEditMode(_editEmployee);
						dispose();
					}
				}else {
					new Register().setVisible(true);
					dispose();
				}
				
			}
		});
		
		userDeleteButton = new JButton("Borrar");
		userDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cancelResult = JOptionPane.showConfirmDialog(null, "¿Seguro que deseas borrar el usuario?", "Borrar Usuario", JOptionPane.OK_CANCEL_OPTION);
				if(cancelResult == JOptionPane.OK_OPTION) {
					if(userId > 0) {
						if(_dashboardController.deleteEmployeeById(userId)) {
							JOptionPane.showMessageDialog(null, "Usuario Borrado Correctamente", "Usuario Borrado", JOptionPane.PLAIN_MESSAGE);
							usuariosTableModel.setNumRows(0);
							usuariosTableModel.fireTableDataChanged();
							showUsuariosSection();
						}else {
							
						}
					}else {
						JOptionPane.showConfirmDialog(null, "Usuario no seleccionado", "No Usuario", JOptionPane.OK_CANCEL_OPTION);
					}
				}else {
					
				}
			}
		});
		
		userCancelButton = new JButton("Cancelar");
		userCancelButton.setVisible(false);
		userCancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userTable.clearSelection();
				userEditMode = false;
				userButton.setText("Nuevo");
				userDeleteButton.setVisible(false);
				userCancelButton.setVisible(false);
			}
		});
	}
	public EmployeeDto get_employee() {
		return _employee;
	}
	public void set_employee(EmployeeDto _employee) {
		this._employee = _employee;
	}
}
