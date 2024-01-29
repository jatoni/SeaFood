/**
 * 
 */
package com.mx.sea.food.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.mx.sea.food.dao.ProductsDao;
import com.mx.sea.food.dto.ProductDto;
import com.mx.sea.food.entity.TbEmployee;
import com.mx.sea.food.entity.TbProduct;
import com.mx.sea.food.tools.ToolsSeaFood;

/**
 * 
 */
public class ProductsDaoImpl implements ProductsDao {

	private EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("SeaFood");
	private TbProduct item = new TbProduct();

	public ProductsDaoImpl() {

	}

	@Override
	public List<TbProduct> getAllProducts() {
		try {
			EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
			TypedQuery<TbProduct> products = em.createNamedQuery("TbProduct.findAll", TbProduct.class);
			List<TbProduct> listProducts = products.getResultList();
			if(!listProducts.isEmpty()) return listProducts;
			return new ArrayList<TbProduct>();
		} catch (Exception e) {
			return new ArrayList<TbProduct>();
		}
	}

	@Override
	public boolean createItem(ProductDto prodctDto) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			TbProduct itemToSave = ToolsSeaFood.map(prodctDto, item);
			em.persist(itemToSave);
			et.commit();
			return true;
		} catch (Exception e) {
			if (et != null) {
				et.rollback();
			}
			return false;
		} finally {
			if (em != null) {
				em.close();
			}
		}

	}

}
