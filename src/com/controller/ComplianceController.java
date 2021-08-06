package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Compliance;
import com.service.ComplianceService;
import com.service.DepartmentService;

@Controller
public class ComplianceController
{
	@Autowired
	ComplianceService complianceService;
	@Autowired
	DepartmentService departmentService;
	
	@RequestMapping(value = "createCompliance", method = RequestMethod.GET)
	public ModelAndView createCompliancePage(HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		session.setAttribute("allDepartmentsDetails", departmentService.getAllDepartmentsDetails());
		mav.setViewName("createCompliance.jsp");
		return mav;
	}
	@RequestMapping(value = "storeComplianceInformation", method = RequestMethod.POST)
	public ModelAndView createCompliance(HttpServletRequest req, HttpSession session)
	{
		Compliance c = new Compliance();
		c.setRltype(req.getParameter("rltype"));
		c.setDetails(req.getParameter("details"));
//		c.setCreatedate(Date.valueOf(LocalDate.now()));
		c.setDepartment_id(Long.parseLong(req.getParameter("department_id")));
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", complianceService.storeComplianceInformation(c));
		mav.setViewName("adminHome.jsp");
		return mav;
	}
	@RequestMapping(value = "viewCompliancesDetails")
	public ModelAndView viewAllEmployeesDetails(HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		session.setAttribute("allCompliancesDetails", complianceService.getAllCompliancesDetails());
		mav.setViewName("listCompliances.jsp");
		return mav;
	}
}