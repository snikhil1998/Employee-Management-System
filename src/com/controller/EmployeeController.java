package com.controller;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Employee;
import com.service.DepartmentService;
import com.service.EmployeeService;

@Controller
public class EmployeeController
{
	@Autowired
	DepartmentService departmentService;
	@Autowired
	EmployeeService employeeService;
		
	@RequestMapping(value = "addEmployeeDetails", method = RequestMethod.GET)
	public ModelAndView addEmployeeDetailsPage(HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		session.setAttribute("allDepartmentsDetails", departmentService.getAllDepartmentsDetails());
		mav.setViewName("addEmployeeDetails.jsp");
		return mav;
	}
	@RequestMapping(value = "storeEmployeeDetails", method = RequestMethod.POST)
	public ModelAndView addEmployeeDetails(HttpServletRequest req, HttpSession session)
	{
		Employee emp = new Employee();
		emp.setFirstname(req.getParameter("firstname"));
		emp.setLastname(req.getParameter("lastname"));
		emp.setDob(Date.valueOf(req.getParameter("dob")));
		emp.setEmail(req.getParameter("email"));
		emp.setDepartment_id(Long.parseLong(req.getParameter("department_id")));
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", employeeService.storeEmployeeDetails(emp));
		mav.setViewName("adminHome.jsp");
		return mav;
	}
	@RequestMapping(value = "viewEmployeesDetails")
	public ModelAndView viewAllEmployeesDetails(HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		session.setAttribute("allEmployeesDetails", employeeService.getAllEmployeesDetails());
		mav.setViewName("listEmployees.jsp");
		return mav;
	}
	@RequestMapping(value = "inputEmployeeId")
	public ModelAndView editEmployeeDetailsPage(HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("inputEmployeeId.jsp");
		return mav;
	}
	@RequestMapping(value = "submitEmployeeId", method = RequestMethod.POST)
	public ModelAndView loadEmployeeDetailsInEditPage(HttpServletRequest req, HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		session.setAttribute("employeeDetails", employeeService.getEmployeeDetails(Long.parseLong(req.getParameter("empid"))));
		session.setAttribute("allDepartmentsDetails", departmentService.getAllDepartmentsDetails());
		mav.setViewName("editEmployeeDetails.jsp");
		return mav;
	}
	@RequestMapping(value = "editEmployeeDetails", method = RequestMethod.POST)
	public ModelAndView editEmployeeDetails(HttpServletRequest req, HttpSession session)
	{
		Employee emp = new Employee();
		emp.setEmpid(Long.parseLong(req.getParameter("empid")));
		emp.setFirstname(req.getParameter("firstname"));
		emp.setLastname(req.getParameter("lastname"));
		emp.setDob(Date.valueOf(req.getParameter("dob")));
		emp.setEmail(req.getParameter("email"));
		emp.setDepartment_id(Long.parseLong(req.getParameter("department_id")));
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", employeeService.updateEmployeeDetails(emp));
		mav.setViewName("adminHome.jsp");
		return mav;
	}
	@RequestMapping(value = "deleteEmployeeDetails")
	public ModelAndView deleteEmployeeDetailsPage(HttpServletRequest req, HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("deleteEmployeeDetails.jsp");
		return mav;
	}
	@RequestMapping(value = "removeEmployeeDetails", method = RequestMethod.POST)
	public ModelAndView deleteEmployeeDetails(HttpServletRequest req, HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", employeeService.deleteEmployeeDetails(Long.parseLong(req.getParameter("empid"))));
		mav.setViewName("adminHome.jsp");
		return mav;
	}
}