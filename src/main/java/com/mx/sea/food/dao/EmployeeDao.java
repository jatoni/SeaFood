/**
 * 
 */
package com.mx.sea.food.dao;

import java.util.List;

import com.mx.sea.food.dto.EmployeeDto;
import com.mx.sea.food.entity.TbEmployee;

/**
 * 
 */
public interface EmployeeDao {
	boolean saveEmployee(EmployeeDto employeeDto);

	boolean existUsername(String username);
	
	TbEmployee getEmployeeByEmailAndPassword(EmployeeDto employee);
	
	public List<TbEmployee> getAllEmployees();
}
