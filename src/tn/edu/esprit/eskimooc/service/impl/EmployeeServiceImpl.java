package tn.edu.esprit.eskimooc.service.impl;

import java.util.List;

import javax.ejb.Stateless;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
    	boolean result = false;	
		try {
			entityManager.persist(employee);
			result  = true;
		} catch (Exception e) {
			System.out.println("Error !!");
		}	
    	return result;
    }

	@Override
	public boolean delete(Employee employee) {
		
		boolean result = false;	
		try {
			entityManager.remove(entityManager.merge(employee));
			result  = true;
		} catch (Exception e) {
			System.out.println("Error !!");
		}	
    	return result;
	}

	@Override
	public boolean update(Employee employee) {
		
		boolean result = false;	
		try {
			entityManager.merge(employee);
			result  = true;
		} catch (Exception e) {
			System.out.println("Error !!");
		}	
    	return result;
	}

	@Override
	public Employee findById(int id) {
		return entityManager.find(Employee.class, id);
	}

	
	@Override
	@SuppressWarnings("unchecked")
	public List<Employee> findAll() {	
		
		List<Employee> result = null;
		try{
			String jpql = "SELECT e FROM Employee e";	
			Query query = entityManager.createQuery(jpql);
			result = query.getResultList(); 
		}catch(Exception e)
		{
			e.printStackTrace();
		}		
		return result;
		
	}
	
	@Override
	@SuppressWarnings("unchecked")
    public List<Employee> findEmployeesWithAddressParam(String address) {		
		
		List<Employee> result = null;
		try{
			
			String jpql = "SELECT e FROM Employee e WHERE e.address= :p1";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("p1", address);	
			result = query.getResultList(); 
		}catch(Exception e)
		{
			e.printStackTrace();
		}		
		return result;
		
	}
    
    
 

}
