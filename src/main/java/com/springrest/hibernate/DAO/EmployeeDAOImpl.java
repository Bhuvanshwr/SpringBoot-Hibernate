package com.springrest.hibernate.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springrest.hibernate.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	public EntityManager entitymanager;
	
	@Override
	public Employee addEmployee(Employee theEmployee) {
		
		Session session = entitymanager.unwrap(Session.class);
	
		
		session.saveOrUpdate(theEmployee);
	
		return theEmployee;
	}

	@Override
	public void deleteEmployee(Employee theEmployee) {
		// TODO Auto-generated method stub
		
		Session session = entitymanager.unwrap(Session.class);
	
		
		session.delete(theEmployee);
	
		
	}

	@Override
	public Employee getByEmployeeId(int theEmployeeId) {
		// TODO Auto-generated method stub
		
		
		Session session = entitymanager.unwrap(Session.class);
	
		Employee tempEmployee=session.get(Employee.class,theEmployeeId);

		return tempEmployee;
		
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		
		Session session = entitymanager.unwrap(Session.class);
	
		List<Employee> tempAllEmployee=session.createQuery("FROM Employee", Employee.class).getResultList();   

		return tempAllEmployee;
	}
	


}
