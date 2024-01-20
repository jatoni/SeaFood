/**
 * 
 */
package com.mx.sea.food.daoimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.mx.sea.food.dao.ProductsDao;
import com.mx.sea.food.dto.ProductDto;
import com.mx.sea.food.entity.TbEmployee;
import com.mx.sea.food.entity.TbItem;
import com.mx.sea.food.tools.ToolsSeaFood;

/**
 * 
 */
public class ProductsDaoImpl implements ProductsDao {

	private EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("SeaFood");
	private TbItem item = new TbItem();

	public ProductsDaoImpl() {

	}

	@Override
	public List<TbItem> getAllProducts() {
		try {
			EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
			TypedQuery<TbItem> products = (TypedQuery<TbItem>) em.createNamedQuery("TbItem.findAll", TbItem.class);
//			ResponseProductDto productsMap = products.getResultList().stream()
//					.map(product -> new ResponseProductDto()).collect(Collectors.toList());
			return null;
		} catch (Exception e) {
			return new ArrayList<TbItem>();
		}
	}

	@Override
	public boolean createItem(ProductDto prodctDto) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {

			TbItem itemToSave = ToolsSeaFood.map(prodctDto, item);

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
