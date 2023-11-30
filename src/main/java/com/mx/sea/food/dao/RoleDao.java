package com.mx.sea.food.dao;

import java.util.List;

import com.mx.sea.food.entity.TbRole;

public interface RoleDao {
	List<TbRole> getRoles();

	TbRole findById(long id);

}
