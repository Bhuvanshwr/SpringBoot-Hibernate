package com.springrest.hibernate.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.hibernate.entity.Employee;
import com.springrest.hibernate.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	@Autowired
	public EmployeeService employeeService;
	
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee )
	{
		
		theEmployee.setId(0);
		employeeService.addEmployee(theEmployee);
		
	return theEmployee;
	}
	
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee )
	{
		employeeService.addEmployee(theEmployee);
		
	return theEmployee;
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId)
	{
		
		Employee tempEmployee=employeeService.getByEmployeeId(employeeId);
		
		if(tempEmployee==null){
			throw new EmployeeNotFoundException("Employee id not found "+employeeId);
		}
		employeeService.deleteEmployee(tempEmployee);
		
		return "Employee deleted";
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getByEmployeeId(@PathVariable int employeeId)
	{
		
		Employee tempEmployee=employeeService.getByEmployeeId(employeeId);
		
		if(tempEmployee==null){
			throw new EmployeeNotFoundException("Employee id not found "+employeeId);
		}
		
		return tempEmployee;
	}
	
	@GetMapping("/employees")
	public List<Employee> getByEmployeeId() throws Exception
	{
		List<Employee> tempAllEmployee=employeeService.getAllEmployee();
		
		if(tempAllEmployee.isEmpty()){

				throw new Exception("No employee");
	
		}
		return tempAllEmployee;
	}
	
}
