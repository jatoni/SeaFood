package com.mx.sea.food.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.mx.sea.food.dao.EmployeeDao;
import com.mx.sea.food.daoimpl.EmployeeDaoImpl;
import com.mx.sea.food.dto.EmployeeDto;
import com.mx.sea.food.entity.TbEmployee;

public class DashboardController {
	private EmployeeDao employeeDaoImpl;

	public DashboardController() {
		this.employeeDaoImpl = new EmployeeDaoImpl();
	}

	public List<EmployeeDto> lookupEmployees() {
		List<TbEmployee> employeeList = employeeDaoImpl.getAllEmployees();
		if (employeeList.isEmpty())
			return new ArrayList<EmployeeDto>();

		List<EmployeeDto> newEmployeeList = new ArrayList<>();

		employeeList.forEach(employee -> {
			EmployeeDto newEmployee = new EmployeeDto();
			newEmployee.setEmail(employee.getEmail());
			newEmployee.setTbRole(employee.getTbRole());
			newEmployee.setTbRole(employee.getTbRole());
			newEmployee.setLastName(employee.getLastName());
			newEmployee.setName(employee.getName());
			newEmployee.setPassword(employee.getPassword());
			newEmployee.setUsername(employee.getUsername());
			newEmployee.setId(employee.getId());
			newEmployeeList.add(newEmployee);
			;
		});

		return newEmployeeList;
	}

}
