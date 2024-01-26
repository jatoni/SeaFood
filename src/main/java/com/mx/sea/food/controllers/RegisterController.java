package com.mx.sea.food.controllers;

import java.util.List;

import com.mx.sea.food.dao.EmployeeDao;
import com.mx.sea.food.dao.RoleDao;
import com.mx.sea.food.daoimpl.EmployeeDaoImpl;
import com.mx.sea.food.daoimpl.RoleDaoImpl;
import com.mx.sea.food.dto.EmployeeDto;
import com.mx.sea.food.entity.TbRole;

public class RegisterController {

	private RoleDao roleDaoImpl;
	private EmployeeDao employeeDaoImpl;

	public RegisterController() {
		this.roleDaoImpl = new RoleDaoImpl();
		this.employeeDaoImpl = new EmployeeDaoImpl();
	}

	public boolean Registrarse(EmployeeDto employeeDto) {
		return this.employeeDaoImpl.saveEmployee(employeeDto);
		
	}

	public boolean isUserName(String username) {
		boolean status = this.employeeDaoImpl.existUsername(username);
		if (status)
			return true;
		return false;
	}

	public List<TbRole> getRoleList() {
		return roleDaoImpl.getRoles();
	}
}
