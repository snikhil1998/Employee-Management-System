package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Employee;
import com.dao.EmployeeDao;

@Service
public class EmployeeService
{
	@Autowired
	EmployeeDao employeeDao;
	
	public String storeEmployeeDetails(Employee emp)
	{
		return employeeDao.storeEmployeeDetails(emp)?"Employee details added successfully":"Unable to add employee details";
	}
	public List<Employee> getAllEmployeesDetails()
	{
		return employeeDao.getAllEmployeesDetails();
	}
}