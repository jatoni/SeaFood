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
import com.mx.sea.food.dto.EmployeeDto;
import com.mx.sea.food.entity.TbEmployee;

import static com.mx.sea.food.tools.ToolsSeaFood.map;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class EmployeeDaoImpl implements EmployeeDao {

	private TbEmployee TBEM_EMPLOYEE = new TbEmployee();
	private EntityManagerFactory ENTITY_MANAGER_FACTORY;
	private RoleDao roleDao;

	public EmployeeDaoImpl() {
		this.roleDao = new RoleDaoImpl();
		this.ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("SeaFood");
	}

	@Override
	public boolean saveEmployee(EmployeeDto employeeDto) {
		TbEmployee existEmployee = getEmployeeById(employeeDto.getId());

		TbEmployee employee = map(employeeDto, TBEM_EMPLOYEE);
		if (existEmployee == null)
			employee.setId(0L);
		employee.setTbRole(this.roleDao.findById(employeeDto.getTbRole().getId()));
		
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			if (existEmployee == null) {
				em.persist(employee);
			} else {
				em.merge(employee);
			}
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

	@Override
	public TbEmployee getEmployeeByEmailAndPassword(EmployeeDto employee) {
		try {
			EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
			TypedQuery<TbEmployee> usuario = (TypedQuery<TbEmployee>) em
					.createQuery("FROM TbEmployee t WHERE t.email = :email AND t.password = :pass");
			usuario.setParameter("email", employee.getEmail());
			usuario.setParameter("pass", employee.getPassword());
			return usuario.getResultStream().findFirst().orElse(null);
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public List<TbEmployee> getAllEmployees() {
		try {
			EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
			TypedQuery<TbEmployee> usuarios = (TypedQuery<TbEmployee>) em.createNamedQuery("TbEmployee.findAll",
					TbEmployee.class);
			List<TbEmployee> listEmployees = usuarios.getResultList();
			if (!listEmployees.isEmpty())
				return listEmployees;
			return new ArrayList<TbEmployee>();
		} catch (Exception e) {
			return new ArrayList<TbEmployee>();
		}
	}

	@Override
	public TbEmployee getEmployeeById(long id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		return em.find(TbEmployee.class, id);

	}

	@Override
	public boolean deleteEmployeeById(long id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			TbEmployee existEmployee = em.find(TbEmployee.class, id);
			et.begin();
			if(existEmployee == null) return false;
			em.remove(existEmployee);
			et.commit();
			return true;
		} catch (Exception e) {
			if (et.isActive()) {
                et.rollback();
            }
			e.printStackTrace();
			return false;
		}finally {
			em.close();
		}
	}

}
