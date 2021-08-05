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
	public Employee getEmployeeDetails(long empid)
	{
		return employeeDao.getEmployeeDetails(empid);
	}
	public String updateEmployeeDetails(Employee emp)
	{
		return employeeDao.updateEmployeeDetails(emp)?"Employee details updated successfully":"Unable to update employee details";
	}
	public String deleteEmployeeDetails(long empid)
	{
		return employeeDao.deleteEmployeeDetails(empid)?"Employee details deleted successfully":"Unable to delete employee details";
	}
}