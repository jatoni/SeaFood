/**
 * 
 */
package com.mx.sea.food.daoimpl;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.mx.sea.food.dao.PiecePackageDAO;
import com.mx.sea.food.entity.TbPiecepackage;

/**
 * 
 */
public class PiecePackageDAOImpl implements PiecePackageDAO {

	private EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("SeaFood");

	@Override
	public List<TbPiecepackage> getAllPieces() {
		try {
			EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
			TypedQuery<TbPiecepackage> query = em.createNamedQuery("TbPiecepackage.findAll", TbPiecepackage.class);
			if (Objects.isNull(query.getResultList()) && query.getResultList().isEmpty()) {
				return null;
			} else {
				return query.getResultList();
			}
		} catch (Exception e) {
			return null;
		}
	}
}
