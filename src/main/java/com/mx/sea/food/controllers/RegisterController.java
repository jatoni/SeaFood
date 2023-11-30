package com.mx.sea.food.controllers;

import java.util.List;

import javax.inject.Inject;

import com.mx.sea.food.dao.RoleDao;
import com.mx.sea.food.daoimpl.RoleDaoImpl;
import com.mx.sea.food.entity.TbRole;

public class RegisterController {
	
	
	private RoleDao roleDaoImpl;
	public RegisterController() {
		roleDaoImpl = new RoleDaoImpl();
	}
	
	public boolean Registrarse() {
	return true;	
	}
	
	public List<TbRole> getRoleList(){
		
		return roleDaoImpl.getRoles();
	}
}
