package com.mx.sea.food.controllers;

import java.util.List;

import javax.inject.Inject;

import com.mx.sea.food.dao.RoleDao;
import com.mx.sea.food.dao.TypeWorkDao;
import com.mx.sea.food.daoimpl.RoleDaoImpl;
import com.mx.sea.food.daoimpl.TypeWorkDaoImpl;
import com.mx.sea.food.entity.TbRole;
import com.mx.sea.food.entity.TbTypework;

public class RegisterController {

	private RoleDao roleDaoImpl;

	private TypeWorkDao typeWorkDaoImpl;

	public RegisterController() {
		roleDaoImpl = new RoleDaoImpl();
		this.typeWorkDaoImpl = new TypeWorkDaoImpl();
	}

	public boolean Registrarse() {
		return true;
	}

	public List<TbRole> getRoleList() {
		return roleDaoImpl.getRoles();
	}

	public List<TbTypework> getTypeWorkList() {
		return this.typeWorkDaoImpl.getTypesWoks();
	}
}
