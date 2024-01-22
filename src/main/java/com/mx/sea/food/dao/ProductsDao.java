/**
 * 
 */
package com.mx.sea.food.dao;

import java.util.List;

import com.mx.sea.food.dto.ProductDto;

import com.mx.sea.food.entity.TbProduct;

/**
 * 
 */
public interface ProductsDao {

	List<TbProduct> getAllProducts();

	boolean createItem(ProductDto prodctDto);

}
