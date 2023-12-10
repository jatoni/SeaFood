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

public class Dashboard extends JFrame{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EmployeeDto _employee;
	private JTable userTable;
	private DefaultTableModel usuariosTableModel;
	private DashboardController _dashboardController;
	private JLabel usuariosLabel = new JLabel("Usuarios");
	private JButton editButton;

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
		menu.add(productos);
		
		
		usuariosLabel.setHorizontalAlignment(SwingConstants.CENTER);
		usuariosLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		usuariosLabel.setVisible(false);
		
		
		String[] columnas = {"Nombre","Apellidos","Username","Email","Role","Tipo Trabajador"};
		
		usuariosTableModel = new DefaultTableModel(columnas,0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		userTable = new JTable(usuariosTableModel);
		userTable.setBounds(EXIT_ON_CLOSE, ABORT, WIDTH, HEIGHT);
		userTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		userTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                System.out.println("Evento de selección detectado");
                
                    
                    int selectedRow = userTable.getSelectedRow();
                    
                    	System.out.println(selectedRow);
                    	editButton.setVisible(true);
                    
                
            }
        });
		
		userTable.setVisible(false);
		
		editButton = new JButton("Editar");
		editButton.setVisible(false);
		
		GroupLayout groupLayout = new GroupLayout(this.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(userTable, GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
						.addComponent(usuariosLabel)
						.addComponent(editButton, Alignment.TRAILING))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(usuariosLabel)
					.addGap(20)
					.addComponent(userTable, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(editButton)
					.addContainerGap(43, Short.MAX_VALUE))
		);
		
		this.getContentPane().setLayout(groupLayout);
	}

	public EmployeeDto get_employee() {
		return _employee;
	}
	
	private void showUsuariosSection() {
//		userTable = new JTable();
		
		usuariosLabel.setVisible(true);
		userTable.setVisible(true);
		
		
		List<EmployeeDto> employeesList = _dashboardController.lookupEmployees();
		
		if(!employeesList.isEmpty()) {
			
			employeesList.forEach(employee -> {
				Object[] tableEmployee = {
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
	private void hiddeUsuariosSection() {
		userTable.setVisible(false);
		usuariosLabel.setVisible(false);
	}

	public void set_employee(EmployeeDto _employee) {
		this._employee = _employee;
	}
}
