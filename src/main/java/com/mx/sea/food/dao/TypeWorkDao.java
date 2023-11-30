package com.mx.sea.food.dao;

import java.util.List;

import com.mx.sea.food.entity.TbTypework;

public interface TypeWorkDao {
	TbTypework findById(Long id);

	List<TbTypework> getTypesWoks();
}
