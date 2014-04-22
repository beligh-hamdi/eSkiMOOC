package tn.edu.esprit.eskimooc.service.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.edu.esprit.eskimooc.domain.Employee;



@Remote
public interface EmployeeServiceRemote {

	 boolean insert(Employee employee);
	 boolean delete(Employee employee);
	 boolean update(Employee employee);
	 Employee findById(int id);
	 List<Employee> findAll();
	 
	 
}
