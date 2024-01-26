package com.mx.sea.food.controllers;

import com.mx.sea.food.dao.EmployeeDao;
import com.mx.sea.food.daoimpl.EmployeeDaoImpl;
import com.mx.sea.food.dto.EmployeeDto;
import com.mx.sea.food.entity.TbEmployee;

public class LoginController {
	
	private EmployeeDao _employeeDaoImpl;
	
	public LoginController() {
		_employeeDaoImpl = new EmployeeDaoImpl();
	}
	
	public EmployeeDto IniciarSesion(EmployeeDto employeeDto) {
		TbEmployee existEmployee = _employeeDaoImpl.getEmployeeByEmailAndPassword(employeeDto);
		if(existEmployee != null) {
			EmployeeDto employee = new EmployeeDto();
			employee.setEmail(existEmployee.getEmail());
			employee.setIdRole(existEmployee.getTbRole().getId());
			employee.setLastName(existEmployee.getLastName());
			employee.setName(existEmployee.getName());
			employee.setPassword(existEmployee.getPassword());
			employee.setUsername(existEmployee.getUsername());
			
			return employee;
		}else {
			return null;
		}
	}

}
