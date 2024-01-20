/**
 * 
 */
package com.mx.sea.food.dao;

import java.util.List;

import com.mx.sea.food.dto.ProductDto;
import com.mx.sea.food.entity.TbItem;

/**
 * 
 */
public interface ProductsDao {

	List<TbItem> getAllProducts();

	boolean createItem(ProductDto prodctDto);

}
