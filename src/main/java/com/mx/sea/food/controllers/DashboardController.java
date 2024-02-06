package com.mx.sea.food.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.mx.sea.food.dao.EmployeeDao;
import com.mx.sea.food.dao.ProductsDao;
import com.mx.sea.food.daoimpl.EmployeeDaoImpl;
import com.mx.sea.food.daoimpl.ProductsDaoImpl;
import com.mx.sea.food.dto.EmployeeDto;
import com.mx.sea.food.dto.ProductDto;
import com.mx.sea.food.entity.TbEmployee;
import com.mx.sea.food.entity.TbProduct;

public class DashboardController {
	private EmployeeDao employeeDaoImpl;
	private ProductsDao productDaoImpl;

	public DashboardController() {
		this.employeeDaoImpl = new EmployeeDaoImpl();
		this.productDaoImpl = new ProductsDaoImpl();
	}

	public List<EmployeeDto> searchEmployees() {
		List<TbEmployee> employeeList = employeeDaoImpl.getAllEmployees();
		if (employeeList.isEmpty())
			return new ArrayList<EmployeeDto>();

		List<EmployeeDto> newEmployeeList = new ArrayList<>();

		employeeList.forEach(employee -> {
			EmployeeDto newEmployee = new EmployeeDto();
			newEmployee.setEmail(employee.getEmail());
			newEmployee.setTbRole(employee.getTbRole());
			newEmployee.setLastName(employee.getLastName());
			newEmployee.setName(employee.getName());
			newEmployee.setPassword(employee.getPassword());
			newEmployee.setUsername(employee.getUsername());
			newEmployee.setId(employee.getId());
			newEmployeeList.add(newEmployee);
		});

		return newEmployeeList;
	}

	public List<ProductDto> searchProducts() {
		List<TbProduct> productList = this.productDaoImpl.getAllProducts();
		if (productList.isEmpty())
			return new ArrayList<ProductDto>();

		List<ProductDto> newProductList = new ArrayList<ProductDto>();

		productList.forEach(product -> {
			ProductDto newProduct = new ProductDto();
			newProduct.setDescription(product.getDescription());
			newProduct.setId(product.getId());
			newProduct.setName(product.getName());
			newProduct.setCurrentStock(product.getCurrentStock());
			newProductList.add(newProduct);
		});
		return newProductList;
	}

	public boolean deleteEmployeeById(long id) {
		return employeeDaoImpl.deleteEmployeeById(id);
	}
}
