package com.springrest.hibernate.service;

import java.util.List;

import com.springrest.hibernate.entity.Employee;

public interface EmployeeService {
	
	public Employee addEmployee(Employee theEmployee);

	public void deleteEmployee(Employee theEmployee);
	
	public Employee getByEmployeeId(int theEmployeeId);

	public 	List<Employee> getAllEmployee();

}
