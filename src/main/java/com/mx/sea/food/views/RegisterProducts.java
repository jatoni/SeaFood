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
import com.mx.sea.food.entity.TbPiecepackage;
import com.toedter.calendar.JDateChooser;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class RegisterProducts extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JDateChooser dateChooser;
	private RegisterController registerController;

	/**
	 * Create the frame.
	 */
	public RegisterProducts() {
		try {
			initialize();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("Registrar Producto");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 23));

		JLabel lblNewLabel_1 = new JLabel("Nombre del Producto");

		textField = new JTextField();
		textField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Descripcion");

		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);

		JLabel lblNewLabel_3 = new JLabel("Fecha de ingreso");

		this.dateChooser = new JDateChooser();
		this.dateChooser.setMinSelectableDate(new Date());
		this.dateChooser.setMaxSelectableDate(new Date());
		Date fechaIngreso = this.dateChooser.getDate();

		JLabel lblNewLabel_4 = new JLabel("Cantidad");

		JSpinner spinner = new JSpinner();

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

		JButton btnNewButton_1 = new JButton("Cancelar");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(33).addGroup(gl_contentPane
								.createParallelGroup(Alignment.LEADING, false).addComponent(lblNewLabel_1)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
								.addComponent(lblNewLabel_2).addComponent(lblNewLabel_3).addComponent(lblNewLabel_4)
								.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
								.addComponent(paquete, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(dateChooser, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(textArea).addComponent(lblNewLabel_6)))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(77).addComponent(lblNewLabel)))
				.addContainerGap(40, Short.MAX_VALUE)).addGroup(Alignment.TRAILING,
						gl_contentPane.createSequentialGroup().addContainerGap(78, Short.MAX_VALUE)
								.addComponent(btnNewButton).addGap(59).addComponent(btnNewButton_1).addGap(108)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap().addComponent(lblNewLabel)
				.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblNewLabel_1)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_2)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblNewLabel_3)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_4)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_5)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(paquete, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_6).addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
				.addGap(55)));
		contentPane.setLayout(gl_contentPane);
	}
}
