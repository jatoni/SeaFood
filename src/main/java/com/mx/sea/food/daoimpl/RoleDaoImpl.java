package com.mx.sea.food.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.mx.sea.food.dao.RoleDao;
import com.mx.sea.food.entity.TbRole;

public class RoleDaoImpl implements RoleDao{
	private EntityManagerFactory emf;
	private EntityManager em;
	private EntityTransaction et;
	
	public RoleDaoImpl() {
		this.emf = Persistence.createEntityManagerFactory("SeaFood");
		this.em = emf.createEntityManager();
		this.et = em.getTransaction();
	}
	
	@Override
	public List<TbRole> getRoles() {
		TypedQuery<TbRole> query = em.createNamedQuery("TbRole.findAll", TbRole.class);
		List<TbRole> result = query.getResultList();
		
		return query.getResultList().isEmpty() ? new ArrayList<>() : query.getResultList();
	}
	
}
