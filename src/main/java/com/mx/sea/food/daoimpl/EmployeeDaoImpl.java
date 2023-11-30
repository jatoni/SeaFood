/**
 * 
 */
package com.mx.sea.food.daoimpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.mx.sea.food.dao.EmployeeDao;
import com.mx.sea.food.dao.RoleDao;
import com.mx.sea.food.dao.TypeWorkDao;
import com.mx.sea.food.dto.EmployeeDto;
import com.mx.sea.food.entity.TbEmployee;

import static com.mx.sea.food.tools.ToolsSeaFood.map;

/**
 * 
 */
public class EmployeeDaoImpl implements EmployeeDao {

	private TbEmployee TBEM_EMPLOYEE = new TbEmployee();
	private EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("SeaFood");
	private RoleDao roleDao;
	private TypeWorkDao typeWorkDaoImpl;

	public EmployeeDaoImpl() {
		this.roleDao = new RoleDaoImpl();
		this.typeWorkDaoImpl = new TypeWorkDaoImpl();
	}

	@Override
	public boolean saveEmployee(EmployeeDto employeeDto) {
		TbEmployee employee = map(employeeDto, TBEM_EMPLOYEE);
		employee.setId(0);
		employee.setTbRole(this.roleDao.findById(employeeDto.getIdRole()));
		employee.setTbTypework(this.typeWorkDaoImpl.findById(employeeDto.getIdTypeWork()));
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.persist(employee);
			et.commit();
			return true;
		} catch (Exception e) {
			if (et != null) {
				et.rollback();
			}
			e.printStackTrace();
			return false;
		} finally {
			em.close();
		}
	}

	@Override
	public boolean existUsername(String username) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

		TypedQuery<TbEmployee> usuario = (TypedQuery<TbEmployee>) em
				.createQuery("FROM TbEmployee t WHERE t.username = :user");
		usuario.setParameter("user", username);
		if (usuario.getResultList().size() > 0)
			return true;
		return false;
	}

}
