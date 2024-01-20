package com.mx.sea.food.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import com.mx.sea.food.controllers.RegisterController;
import com.mx.sea.food.controllers.RegisterProductController;
import com.mx.sea.food.dto.EmployeeDto;
import com.mx.sea.food.dto.ProductDto;
import com.mx.sea.food.entity.TbEmployee;
import com.mx.sea.food.entity.TbPiecepackage;
import com.mx.sea.food.tools.ToolsSeaFood;
import com.toedter.calendar.JDateChooser;
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
	private JTextField cantidad;
	private RegisterProductController itemController;
	private TbEmployee employee = new TbEmployee();

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
		itemController = new RegisterProductController();
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

		JLabel lblNewLabel_4 = new JLabel("Cantidad");

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
				Date fechaSeleccionado = fechaRegistro.getDate();
				if (nombreProducto.getText().isEmpty() || descripcion.getText().isEmpty()
						|| cantidad.getText().isEmpty() || Objects.isNull(fechaSeleccionado)) {
					JOptionPane.showMessageDialog(null, "No puedes dejar ni un espacio en blanco", "Mensajes vacios",
							JOptionPane.ERROR_MESSAGE);
				} else {
					if (isNumeric(cantidad.getText())) {
						TbEmployee employeeToSave = ToolsSeaFood.map(employeeDto, employee);
						System.out.println(employeeToSave);
						TbPiecepackage paqueteselected = paquetes.get(paquete.getSelectedIndex());
						System.out.println(paqueteselected);
						ProductDto productToSave = new ProductDto(descripcion.getText(), fechaSeleccionado,
								Integer.parseInt(cantidad.getText()), nombreProducto.getText(), employeeToSave,
								paquetes.get(paquete.getSelectedIndex()));
						itemController.saveProduct(productToSave);
					} else {
						JOptionPane.showMessageDialog(null, "No se acepta letras o caracteres especiales en cantidad",
								"Error de cantidad", JOptionPane.ERROR_MESSAGE);
					}
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

		cantidad = new JTextField();
		cantidad.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(33)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(nombreProducto, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
										.addComponent(descripcion, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 350,
												Short.MAX_VALUE)
										.addGroup(Alignment.LEADING,
												gl_contentPane.createSequentialGroup().addComponent(lblNewLabel_6)
														.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																.addComponent(lblNewLabel_3).addComponent(fechaRegistro,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
										.addComponent(lblNewLabel_7, Alignment.LEADING)
										.addComponent(empleado, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 350,
												Short.MAX_VALUE)
										.addGroup(gl_contentPane.createSequentialGroup().addComponent(btnNewButton)
												.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(btnNewButton_1).addGap(20))
										.addComponent(paquete, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNewLabel_5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(cantidad, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 350,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_4, Alignment.LEADING)
										.addComponent(lblNewLabel_1, Alignment.LEADING)
										.addComponent(lblNewLabel_2, Alignment.LEADING)))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(77).addComponent(lblNewLabel)))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap().addComponent(lblNewLabel).addGap(4)
				.addComponent(lblNewLabel_1).addGap(18)
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
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
						.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblNewLabel_6).addGap(96))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(fechaRegistro, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(12).addComponent(lblNewLabel_4)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(cantidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_5)
										.addGap(18)))
						.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnNewButton)
								.addComponent(btnNewButton_1))
						.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup().addGap(103).addComponent(paquete,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(45)))));
		contentPane.setLayout(gl_contentPane);
	}

	private void closeWindow() {
		this.setVisible(false);
	}

	private boolean isNumeric(String cantidad) {
		int letras = 0;
		for (int i = 0; i < cantidad.length(); i++) {
			char c = cantidad.charAt(i);
			if (c < '0' || c > '9') {
				letras += 1;
			}
		}
		if (letras > 0) {
			return false;
		} else {
			return true;
		}
	}
}
