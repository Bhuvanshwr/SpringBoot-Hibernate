package com.springrest.hibernate.DAO;

import java.util.List;

import com.springrest.hibernate.entity.Employee;

public interface EmployeeDAO {
	
	public Employee addEmployee(Employee theEmployee);

	public void deleteEmployee(Employee theEmployee);
	
	public Employee getByEmployeeId(int theEmployeeId);

	public 	List<Employee> getAllEmployee();

}
