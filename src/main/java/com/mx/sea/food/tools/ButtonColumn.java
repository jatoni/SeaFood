package com.mx.sea.food.tools;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import com.mx.sea.food.dto.EmployeeDto;
import com.mx.sea.food.views.Register;

public class ButtonColumn extends AbstractCellEditor implements TableCellEditor, TableCellRenderer{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton button;
    private Object value;
    
    
	public ButtonColumn() {
		this.button = new JButton("Editar");
		this.button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Register().setVisible(true);
			}
		});
	}

	@Override
	public Object getCellEditorValue() {
		return value;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		
		this.value = value;
		return button;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		// TODO Auto-generated method stub
		return button;
	}
	
	
	

}
