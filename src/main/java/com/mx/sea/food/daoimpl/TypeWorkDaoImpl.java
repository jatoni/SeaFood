/**
 * 
 */
package com.mx.sea.food.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.mx.sea.food.dao.TypeWorkDao;
import com.mx.sea.food.entity.TbTypework;

/**
 * 
 */
public class TypeWorkDaoImpl implements TypeWorkDao {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("SeaFood");
	private EntityManager em;
	private EntityTransaction et;

	public TypeWorkDaoImpl() {
		this.em = emf.createEntityManager();
		this.et = em.getTransaction();
	}

	@Override
	public TbTypework findById(Long id) {
		TbTypework tbTypework = em.find(TbTypework.class, id);
		return null;
	}

	@Override
	public List<TbTypework> getTypesWoks() {
		TypedQuery<TbTypework> query = em.createNamedQuery("TbTypework.findAll", TbTypework.class);
		List<TbTypework> result = query.getResultList();
		return result;
	}

}
