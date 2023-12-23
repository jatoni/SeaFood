package com.mx.sea.food.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;

import com.mx.sea.food.controllers.RegisterController;
import com.mx.sea.food.dto.EmployeeDto;
import com.mx.sea.food.entity.TbPiecepackage;
import com.toedter.calendar.JDateChooser;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterProducts extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nombreProducto;
	private JDateChooser fechaRegistro;
	private RegisterController registerController;
	private EmployeeDto employeeDto;
	private JTextField empleado;

	/**
	 * Create the frame.
	 */
	public RegisterProducts(EmployeeDto employeeDto) {
		try {
			this.employeeDto = employeeDto;
			initialize();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 585);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("Registrar Producto");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 23));
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nombre del Producto");

		nombreProducto = new JTextField();
		nombreProducto.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Descripcion");

		JTextArea descripcion = new JTextArea();
		descripcion.setLineWrap(true);

		JLabel lblNewLabel_3 = new JLabel("Fecha de ingreso");

		this.fechaRegistro = new JDateChooser();
		this.fechaRegistro.setMinSelectableDate(new Date());
		this.fechaRegistro.setMaxSelectableDate(new Date());
		Date fechaIngreso = this.fechaRegistro.getDate();

		JLabel lblNewLabel_4 = new JLabel("Cantidad");

		JSpinner cantidad = new JSpinner();

		JLabel lblNewLabel_5 = new JLabel("Tipo de producto (pieza o por paquete)");

		this.registerController = new RegisterController();
		JComboBox paquete;

		List<TbPiecepackage> paquetes = this.registerController.getAllPieces();
		List<String> piecesName = new ArrayList<String>();

		paquetes.forEach(paqueteList -> piecesName.add(paqueteList.getType()));

		paquete = new JComboBox(piecesName.toArray());
		paquete.setToolTipText("Escoge el tipo de paquete");
		paquete.setBorder(null);

		JLabel lblNewLabel_6 = new JLabel("");

		JButton btnNewButton = new JButton("Gaurdar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (nombreProducto.getText().isEmpty() || descripcion.getText().isEmpty()) {

				}
			}
		});

		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Dashboard(employeeDto).setVisible(true);
				closeWindow();
			}
		});

		JLabel lblNewLabel_7 = new JLabel("Empleado que Registra");

		empleado = new JTextField();
		empleado.setEnabled(false);
		empleado.setColumns(10);
		empleado.setText(this.employeeDto.getName() + " " + this.employeeDto.getLastName());
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(33).addGroup(gl_contentPane
								.createParallelGroup(Alignment.LEADING, false).addComponent(lblNewLabel_1)
								.addComponent(nombreProducto, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
								.addComponent(lblNewLabel_2)
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(descripcion, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
														350, Short.MAX_VALUE)
												.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
														.addComponent(lblNewLabel_6)
														.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																.addComponent(lblNewLabel_3).addComponent(fechaRegistro,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
												.addComponent(lblNewLabel_7, Alignment.LEADING).addComponent(empleado,
														Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 350,
														Short.MAX_VALUE))
										.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(btnNewButton)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btnNewButton_1).addGap(20))
								.addComponent(paquete, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_5, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(cantidad, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_4)))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(77).addComponent(lblNewLabel)))
				.addContainerGap(40, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap().addComponent(lblNewLabel)
				.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblNewLabel_1)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(nombreProducto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_2)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(descripcion, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblNewLabel_7)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(empleado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addGap(12).addComponent(lblNewLabel_3).addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
						.createSequentialGroup().addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblNewLabel_6).addGap(96))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(fechaRegistro, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_4)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(cantidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_5)
										.addGap(18)))
						.addPreferredGap(ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnNewButton)
								.addComponent(btnNewButton_1))
						.addContainerGap())
						.addGroup(Alignment.TRAILING,
								gl_contentPane.createSequentialGroup().addGap(103)
										.addComponent(paquete, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(45)))));
		contentPane.setLayout(gl_contentPane);
	}

	private void closeWindow() {
		this.setVisible(false);
	}
}
