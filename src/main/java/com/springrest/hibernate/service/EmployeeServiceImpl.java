package com.springrest.hibernate.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.hibernate.DAO.EmployeeDAO;
import com.springrest.hibernate.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDAO employeeDAO;
	
	@Override
	@Transactional 
	public Employee addEmployee(Employee theEmployee) {
		// TODO Auto-generated method stub
			
		return employeeDAO.addEmployee(theEmployee);
	}

	@Override
	@Transactional
	public void deleteEmployee(Employee theEmployee) {
		// TODO Auto-generated method stub
		employeeDAO.deleteEmployee(theEmployee);

	}

	@Override
	@Transactional
	public Employee getByEmployeeId(int theEmployeeId) {
		// TODO Auto-generated method stub
		return employeeDAO.getByEmployeeId(theEmployeeId);
	}

	@Override
	@Transactional
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeDAO.getAllEmployee();
	}

}
