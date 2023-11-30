/**
 * 
 */
package com.mx.sea.food.daoimpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.mx.sea.food.dao.EmployeeDao;
import com.mx.sea.food.dao.RoleDao;
import com.mx.sea.food.dto.EmployeeDto;
import com.mx.sea.food.entity.TbEmployee;

import static com.mx.sea.food.tools.ToolsSeaFood.map;

/**
 * 
 */
public class EmployeeDaoImpl implements EmployeeDao {

	private TbEmployee TBEM_EMPLOYEE = new TbEmployee();
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("SeaFood");
	private EntityManager em;
	private EntityTransaction et;
	private RoleDao roleDao;

	public EmployeeDaoImpl() {
		this.em = emf.createEntityManager();
		this.et = em.getTransaction();
		this.roleDao = new RoleDaoImpl();
	}

	@Override
	public boolean saveEmployee(EmployeeDto employeeDto) {
		et.begin();

		TbEmployee employee = map(employeeDto, TBEM_EMPLOYEE);
		employee.setTbRole(this.roleDao.findById(employeeDto.getIdRole()));
//		employee.setTbTypework();
		try {
			em.persist(employee);
			et.commit();
			return true;
		} catch (Exception e) {
			if (et == null || em == null) {
				et.rollback();
				em.close();
			}
			e.printStackTrace();
			return false;
		} finally {
			em.close();
		}
	}

}
