package com.mx.sea.food.tools;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.mx.sea.food.dto.EmployeeDto;

public class EmployeeTableModel extends AbstractTableModel{
	
	private List<EmployeeDto> _employeesList;
	
	public EmployeeTableModel(List<EmployeeDto> employeesList) {
		this._employeesList = employeesList;
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		EmployeeDto employee = _employeesList.get(rowIndex);
		switch (columnIndex) {
        case 0:
            return employee.getName();
        case 1:
            return employee.getLastName();
        case 2:
            return employee.getUsername();
        case 3:
            return employee.getEmail();
        case 4:
            return employee.getIdRole();
        case 5:
            return employee.getIdTypeWork();
        case 6:
            return employee.getId();  // Agregamos la columna del ID del empleado
        default:
            return null;
		}
	}
}
