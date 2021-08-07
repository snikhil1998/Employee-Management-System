package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
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
	
	private static Logger logger = Logger.getLogger(DepartmentController.class);
	
	@RequestMapping(value = "createDepartment", method = RequestMethod.GET)
	public ModelAndView addDepartmentDetailsPage(HttpSession session)
	{

		ModelAndView mav = new ModelAndView();
		try
		{
			if(session.getAttribute("role")==null)
			{
				mav.setViewName("index.jsp");
				return mav;
			}
			if(!session.getAttribute("role").equals("admin"))
			{
				mav.setViewName("WEB-INF/employeeHome.jsp");
				return mav;
			}
			mav.setViewName("WEB-INF/createDepartment.jsp");
		}
		catch(Exception e)
		{
			PropertyConfigurator.configure(getClass().getProtectionDomain().getCodeSource().getLocation().getPath() + "log4j.properties");
			logger = Logger.getLogger(getClass());
			logger.error("Error occurred. Please check logs.", e);
			mav.setViewName("error.jsp");
		}
		return mav;
	}
	@RequestMapping(value = "addDepartmentDetails", method = RequestMethod.POST)
	public ModelAndView addDepartmentDetails(HttpServletRequest req, HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		try
		{
			Department dpt = new Department();
			dpt.setDepartment_nm(req.getParameter("department_nm"));
			mav.addObject("msg", departmentService.storeDepartmentDetails(dpt));
			mav.setViewName("WEB-INF/adminHome.jsp");
		}
		catch(Exception e)
		{
			PropertyConfigurator.configure(getClass().getProtectionDomain().getCodeSource().getLocation().getPath() + "log4j.properties");
			logger = Logger.getLogger(getClass());
			logger.error("Error occurred. Please check logs.", e);
			mav.setViewName("error.jsp");
		}
		return mav;
	}
	@RequestMapping(value = "viewDepartmentsDetails", method = RequestMethod.GET)
	public ModelAndView viewAllDepartmentsDetails(HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		try
		{
			if(session.getAttribute("role")==null)
			{
				mav.setViewName("index.jsp");
				return mav;
			}
			if(!session.getAttribute("role").equals("admin"))
			{
				mav.setViewName("WEB-INF/employeeHome.jsp");
				return mav;
			}
			session.setAttribute("allDepartmentsDetails", departmentService.getAllDepartmentsDetails());
			mav.setViewName("WEB-INF/listDepartments.jsp");
		}
		catch(Exception e)
		{
			PropertyConfigurator.configure(getClass().getProtectionDomain().getCodeSource().getLocation().getPath() + "log4j.properties");
			logger = Logger.getLogger(getClass());
			logger.error("Error occurred. Please check logs.", e);
			mav.setViewName("error.jsp");
		}
		return mav;
	}
}