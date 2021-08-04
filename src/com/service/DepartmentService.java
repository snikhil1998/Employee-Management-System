package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Department;
import com.dao.DepartmentDao;

@Service
public class DepartmentService
{
	@Autowired
	DepartmentDao departmentDao;
	
	public String storeDepartmentDetails(Department dpt)
	{
		return departmentDao.storeDepartmentDetails(dpt)?"Department details added successfully":"Unable to add department details";
	}
}