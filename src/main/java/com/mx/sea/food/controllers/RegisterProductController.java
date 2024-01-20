/**
 * 
 */
package com.mx.sea.food.controllers;

import com.mx.sea.food.dao.ProductsDao;
import com.mx.sea.food.daoimpl.ProductsDaoImpl;
import com.mx.sea.food.dto.ProductDto;

/**
 * 
 */
public class RegisterProductController {

	private ProductsDao productDaoImpl;

	public RegisterProductController() {
		this.productDaoImpl = new ProductsDaoImpl();
	}

	public boolean saveProduct(ProductDto productDto) {
		if (this.productDaoImpl.createItem(productDto)) {

		}
		return false;
	}
}
