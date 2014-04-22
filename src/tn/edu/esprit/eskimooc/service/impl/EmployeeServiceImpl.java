package tn.edu.esprit.eskimooc.service.impl;

import java.util.List;

import javax.ejb.Stateless;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.edu.esprit.eskimooc.domain.Employee;
import tn.edu.esprit.eskimooc.service.interfaces.EmployeeServiceILocal;
import tn.edu.esprit.eskimooc.service.interfaces.EmployeeServiceRemote;


/**
 * Session Bean implementation class EmployeeServiceImpl
 */
@Stateless(name="employee-service")
public class EmployeeServiceImpl implements EmployeeServiceRemote, EmployeeServiceILocal {

    
	@PersistenceContext(unitName="eSkiMOOC")
	private EntityManager entityManager;

	
    public EmployeeServiceImpl() {
    
    }
    
    @Override
    public boolean insert(Employee employee) {
    	entityManager.persist(employee);
		return true;
    }

	@Override
	public boolean delete(Employee employee) {
		entityManager.remove(entityManager.merge(employee));
		return true;
	}

	@Override
	public boolean update(Employee employee) {
		entityManager.merge(employee);
		return true;
	}

	@Override
	public Employee findById(int id) {
		return entityManager.find(Employee.class, id);
	}

	
	@Override
	@SuppressWarnings("unchecked")
	public List<Employee> findAll() {
		return entityManager.createQuery("SELECT p FROM Employee p").getResultList();
	}
    
    
 

}
