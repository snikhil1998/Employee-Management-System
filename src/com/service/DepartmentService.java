package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.DepartmentDao;

@Service
public class DepartmentService
{
	@Autowired
	DepartmentDao departmentDao;
}