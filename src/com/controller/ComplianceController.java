package com.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Compliance;
import com.bean.Department;
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
		if(!session.getAttribute("role").equals("admin"))
		{
			mav.setViewName("WEB-INF/employeeHome.jsp");
			return mav;
		}
		session.setAttribute("allDepartmentsDetails", departmentService.getAllDepartmentsDetails());
		mav.setViewName("WEB-INF/createCompliance.jsp");
		return mav;
	}
	@RequestMapping(value = "storeComplianceInformation", method = RequestMethod.POST)
	public ModelAndView createCompliance(HttpServletRequest req, HttpSession session)
	{
		Compliance c = new Compliance();
		c.setRltype(req.getParameter("rltype"));
		c.setDetails(req.getParameter("details"));
		c.setCreatedate(Date.valueOf(req.getParameter("createdate")));
		c.setDepartment_id(Long.parseLong(req.getParameter("department_id")));
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", complianceService.storeComplianceInformation(c));
		mav.setViewName("WEB-INF/adminHome.jsp");
		return mav;
	}
	@RequestMapping(value = "viewCompliancesDetails")
	public ModelAndView viewAllEmployeesDetails(HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		if(!session.getAttribute("role").equals("admin"))
		{
			mav.setViewName("WEB-INF/employeeHome.jsp");
			return mav;
		}
		session.setAttribute("allCompliancesDetails", complianceService.getAllCompliancesDetails());
		HashMap<Long, String> hm = new HashMap<Long, String>();
		for(Department dpt : departmentService.getAllDepartmentsDetails())
		{
			hm.put(dpt.getDepartment_id(), dpt.getDepartment_nm());
		}
		session.setAttribute("allDepartmentsDetails", hm);
		mav.setViewName("WEB-INF/listCompliances.jsp");
		return mav;
	}
	@RequestMapping(value = "viewAssignedCompliancesDetails")
	public ModelAndView viewAssignedEmployeesDetails(HttpSession session)
	{

		ModelAndView mav = new ModelAndView();
		if(!session.getAttribute("role").equals("user"))
		{
			mav.setViewName("WEB-INF/adminHome.jsp");
			return mav;
		}
		session.setAttribute("allAssignedCompliancesDetails", complianceService.getDepartmentCompliancesDetails((Long)session.getAttribute("userid")));
		/*HashMap<Long, String> hm = new HashMap<Long, String>();
		for(Department dpt : departmentService.getAllDepartmentsDetails())
		{
			hm.put(dpt.getDepartment_id(), dpt.getDepartment_nm());
		}
		session.setAttribute("allDepartmentsDetails", hm);*/
		mav.setViewName("WEB-INF/listAssignedCompliances.jsp");
		return mav;
	}
}