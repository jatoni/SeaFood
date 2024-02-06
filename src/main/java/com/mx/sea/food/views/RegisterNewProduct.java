package com.mx.sea.food.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JTextArea;

import com.mx.sea.food.controllers.RegisterProductController;
import com.mx.sea.food.dto.EmployeeDto;
import com.mx.sea.food.dto.ProductDto;
import com.mx.sea.food.entity.TbProduct;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterNewProduct extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private EmployeeDto employeeDto;
	private RegisterProductController registerProductController;

	public RegisterNewProduct(EmployeeDto employeeDto) {
		try {
			this.employeeDto = employeeDto;
			initialize();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initialize() {
		this.registerProductController = new RegisterProductController();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 606);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JPanel contentPane_1 = new JPanel();
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(contentPane_1);

		JLabel lblNewLabel = new JLabel("Registrar Producto");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 23));

		JTextArea descripcion = new JTextArea();
		descripcion.setLineWrap(true);

		JLabel lblNewLabel_6 = new JLabel("");

		JLabel lblNewLabel_3 = new JLabel("Fecha de ingreso");

		JDateChooser fechaRegistro = new JDateChooser();

		JLabel lblNewLabel_7 = new JLabel("Empleado que Registra");

		textField_1 = new JTextField();
		textField_1.setText(this.employeeDto.getName() + " " + this.employeeDto.getLastName());
		textField_1.setEnabled(false);
		textField_1.setColumns(10);

		JButton btnNewButton = new JButton("Gaurdar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Dashboard(employeeDto).setVisible(true);
				closeWindow();
			}
		});

		JButton btnNewButton_1 = new JButton("Cancelar");

		JComboBox paquete = new JComboBox(new Object[] {});
		paquete.setToolTipText("Escoge el tipo de paquete");
		paquete.setBorder(null);

		JLabel lblNewLabel_5 = new JLabel("Tipo de producto (pieza o por paquete)");

		textField_2 = new JTextField();
		textField_2.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Cantidad");

		JLabel lblNewLabel_1 = new JLabel("Nombre del Producto");

		JLabel lblNewLabel_2 = new JLabel("Descripcion");

		List<ProductDto> productosList = this.registerProductController.searchProducts();

		List<String> productosName = new ArrayList<>();

		productosList.forEach(paqueteFor -> productosName.add(paqueteFor.getName()));

		JComboBox productosCombo = new JComboBox(productosName.toArray());

		productosCombo.setToolTipText("Escoge el producto");
		productosCombo.setBorder(null);
		GroupLayout gl_contentPane_1 = new GroupLayout(contentPane_1);
		gl_contentPane_1.setHorizontalGroup(gl_contentPane_1.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 433, Short.MAX_VALUE)
				.addGroup(gl_contentPane_1.createSequentialGroup().addGroup(gl_contentPane_1
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane_1.createSequentialGroup().addGap(33).addGroup(gl_contentPane_1
								.createParallelGroup(Alignment.LEADING)
								.addComponent(descripcion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addGroup(gl_contentPane_1.createSequentialGroup().addComponent(lblNewLabel_6)
										.addGroup(gl_contentPane_1.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabel_3).addComponent(fechaRegistro,
														GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)))
								.addComponent(lblNewLabel_7)
								.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
								.addGroup(gl_contentPane_1.createSequentialGroup().addComponent(btnNewButton)
										.addPreferredGap(ComponentPlacement.RELATED, 199, Short.MAX_VALUE)
										.addComponent(btnNewButton_1).addGap(20))
								.addComponent(paquete, 0, 365, Short.MAX_VALUE)
								.addComponent(lblNewLabel_5, GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_4).addComponent(lblNewLabel_1).addComponent(lblNewLabel_2)
								.addComponent(productosCombo, GroupLayout.PREFERRED_SIZE, 370,
										GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane_1.createSequentialGroup().addGap(77).addComponent(lblNewLabel)))
						.addContainerGap(25, Short.MAX_VALUE)));
		gl_contentPane_1.setVerticalGroup(gl_contentPane_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane_1.createSequentialGroup().addContainerGap().addComponent(lblNewLabel).addGap(4)
						.addComponent(lblNewLabel_1).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(productosCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(16).addComponent(lblNewLabel_2).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(descripcion, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblNewLabel_7)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(12).addComponent(lblNewLabel_3).addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane_1.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane_1
								.createSequentialGroup()
								.addGroup(gl_contentPane_1.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane_1.createSequentialGroup().addComponent(lblNewLabel_6)
												.addGap(96))
										.addGroup(gl_contentPane_1.createSequentialGroup()
												.addComponent(fechaRegistro, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGap(12).addComponent(lblNewLabel_4)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(textField_2, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_5)
												.addGap(18)))
								.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
								.addGroup(gl_contentPane_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnNewButton).addComponent(btnNewButton_1))
								.addContainerGap()).addGroup(
										gl_contentPane_1.createSequentialGroup().addGap(103)
												.addComponent(paquete, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGap(45)))));
		contentPane_1.setLayout(gl_contentPane_1);

	}

	/**
	 * @return the employeeDto
	 */
	public EmployeeDto getEmployeeDto() {
		return employeeDto;
	}

	/**
	 * @param employeeDto the employeeDto to set
	 */
	public void setEmployeeDto(EmployeeDto employeeDto) {
		this.employeeDto = employeeDto;
	}

	public void setEditMode(ProductDto product) {

	}

	private void closeWindow() {
		this.setVisible(false);
	}

}
