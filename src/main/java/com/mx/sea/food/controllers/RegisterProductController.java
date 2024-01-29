/**
 * 
 */
package com.mx.sea.food.controllers;

import java.util.ArrayList;
import java.util.List;

import com.mx.sea.food.dao.ProductsDao;
import com.mx.sea.food.daoimpl.ProductsDaoImpl;
import com.mx.sea.food.dto.ProductDto;
import com.mx.sea.food.entity.TbProduct;

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

	public List<ProductDto> searchProducts() {
		List<TbProduct>productList = this.productDaoImpl.getAllProducts();
		if (productList.isEmpty()) return new ArrayList<>();
		
		List<ProductDto> newProductList = new ArrayList<>();
		
		productList.forEach(product -> {
			ProductDto newProduct = new ProductDto();
			newProduct.setDescription(product.getDescription());
			newProduct.setId(product.getId());
			newProduct.setItemName(product.getName());
			newProduct.setStock(product.getCurrentStock());
			newProductList.add(newProduct);
		});
		return newProductList;
	}

}
