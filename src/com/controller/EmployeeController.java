package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.service.EmployeeService;

@Controller
public class EmployeeController
{
	@Autowired
	EmployeeService employeeService;
}