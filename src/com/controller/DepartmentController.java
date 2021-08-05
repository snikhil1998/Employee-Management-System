package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Department;
import com.service.DepartmentService;

@Controller
public class DepartmentController
{
	@Autowired
	DepartmentService departmentService;
	
	@RequestMapping(value = "createDepartment", method = RequestMethod.GET)
	public ModelAndView addDepartmentDetailsPage()
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("createDepartment.jsp");
		return mav;
	}
	@RequestMapping(value = "addDepartmentDetails", method = RequestMethod.POST)
	public ModelAndView addDepartmentDetails(HttpServletRequest req, HttpSession session)
	{
		Department dpt = new Department();
		dpt.setDepartment_nm(req.getParameter("department_nm"));
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", departmentService.storeDepartmentDetails(dpt));
		mav.setViewName("adminHome.jsp");
		return mav;
	}
	@RequestMapping(value = "viewDepartmentsDetails", method = RequestMethod.GET)
	public ModelAndView viewAllDepartmentsDetails(HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		session.setAttribute("allDepartmentsDetails", departmentService.getAllDepartmentsDetails());
		mav.setViewName("listDepartments.jsp");
		return mav;
	}
}