package com.controller;

import java.sql.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Compliance;
import com.bean.Department;
import com.bean.StatusReport;
import com.service.ComplianceService;
import com.service.DepartmentService;

@Controller
public class ComplianceController
{
	@Autowired
	ComplianceService complianceService;
	@Autowired
	DepartmentService departmentService;
	
	private static Logger logger = Logger.getLogger(ComplianceController.class);
	
	@RequestMapping(value = "createCompliance", method = RequestMethod.GET)
	public ModelAndView createCompliancePage(HttpSession session)
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
			mav.setViewName("WEB-INF/createCompliance.jsp");
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
	@RequestMapping(value = "storeComplianceInformation", method = RequestMethod.POST)
	public ModelAndView createCompliance(HttpServletRequest req, HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		try
		{
			Compliance c = new Compliance();
			c.setRltype(req.getParameter("rltype"));
			c.setDetails(req.getParameter("details"));
			c.setCreatedate(Date.valueOf(req.getParameter("createdate")));
			c.setDepartment_id(Long.parseLong(req.getParameter("department_id")));
			mav.addObject("msg", complianceService.storeComplianceInformation(c));
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
	@RequestMapping(value = "viewCompliancesDetails")
	public ModelAndView viewAllCompliancesDetails(HttpSession session)
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
			session.setAttribute("allCompliancesDetails", complianceService.getAllCompliancesDetails());
			HashMap<Long, String> hm = new HashMap<Long, String>();
			for(Department dpt : departmentService.getAllDepartmentsDetails())
			{
				hm.put(dpt.getDepartment_id(), dpt.getDepartment_nm());
			}
			session.setAttribute("allDepartmentsDetails", hm);
			mav.setViewName("WEB-INF/listCompliances.jsp");
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
	@RequestMapping(value = "viewAssignedCompliancesDetails")
	public ModelAndView viewAssignedCompliancesDetails(HttpSession session)
	{

		ModelAndView mav = new ModelAndView();
		try
		{
			if(session.getAttribute("role")==null)
			{
				mav.setViewName("index.jsp");
				return mav;
			}
			if(!session.getAttribute("role").equals("user"))
			{
				mav.setViewName("WEB-INF/adminHome.jsp");
				return mav;
			}
			session.setAttribute("allAssignedCompliancesDetails", complianceService.getEmployeeRemainingCompliancesDetails((Long)session.getAttribute("userid")));
			/*HashMap<Long, String> hm = new HashMap<Long, String>();
			for(Department dpt : departmentService.getAllDepartmentsDetails())
			{
				hm.put(dpt.getDepartment_id(), dpt.getDepartment_nm());
			}
			session.setAttribute("allDepartmentsDetails", hm);*/
			mav.setViewName("WEB-INF/listAssignedCompliances.jsp");
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
	@RequestMapping(value = "addComplianceComments", method = RequestMethod.POST)
	public ModelAndView submitComplianceComments(HttpServletRequest req, HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		try
		{
			Compliance c = new Compliance();
			c.setComplianceid(Long.parseLong(req.getParameter("complianceid")));
			c.setRltype(req.getParameter("rltype"));
			c.setDetails(req.getParameter("details"));
			c.setCreatedate(Date.valueOf(req.getParameter("createdate")));
			c.setDepartment_id(Long.parseLong(req.getParameter("department_id")));
			/*System.out.println(req.getParameter("complianceid"));
			System.out.println(req.getParameter("rltype"));
			System.out.println(req.getParameter("details"));
			System.out.println(req.getParameter("createdate"));
			System.out.println(req.getParameter("department_id"));*/
			session.setAttribute("currentCompliance", c);
			mav.setViewName("WEB-INF/submitComplianceComments.jsp");
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
	@RequestMapping(value = "viewEmployeeStatusReportsDetails")
	public ModelAndView viewEmployeeStatusReportsDetails(HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		try
		{
			if(session.getAttribute("role")==null)
			{
				mav.setViewName("index.jsp");
				return mav;
			}
			if(!session.getAttribute("role").equals("user"))
			{
				mav.setViewName("WEB-INF/adminHome.jsp");
				return mav;
			}
			/*session.setAttribute("allStatusReportsDetails", statusreportService.getAllStatusReportsDetails());
			HashMap<Long, String> hm = new HashMap<Long, String>();
			for(Department dpt : departmentService.getAllDepartmentsDetails())
			{
				hm.put(dpt.getDepartment_id(), dpt.getDepartment_nm());
			}
			session.setAttribute("allDepartmentsDetails", hm);*/
			session.setAttribute("submittedCompliancesDetails", complianceService.getEmployeeCompliancesDetails((Long)session.getAttribute("userid")));
			mav.setViewName("WEB-INF/listEmployeeStatusReports.jsp");
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
	@RequestMapping(value = "updateComplianceComments", method = RequestMethod.POST)
	public ModelAndView viewEmployeeStatusReportsDetails(HttpServletRequest req, HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		try
		{
			Compliance c = new Compliance();
			StatusReport sr = new StatusReport();
			c.setComplianceid(Long.parseLong(req.getParameter("complianceid")));
			c.setRltype(req.getParameter("rltype"));
			c.setDetails(req.getParameter("details"));
			c.setCreatedate(Date.valueOf(req.getParameter("createdate")));
			c.setDepartment_id(Long.parseLong(req.getParameter("department_id")));
			sr.setStatusrptid(Long.parseLong(req.getParameter("statusrptid")));
			sr.setComplianceid(Long.parseLong(req.getParameter("complianceid")));
			sr.setEmpid((Long)session.getAttribute("userid"));
			sr.setCreatedate(Date.valueOf(req.getParameter("createdate")));
			sr.setComments(req.getParameter("comments"));
			sr.setDepartment_id(Long.parseLong(req.getParameter("department_id")));
			session.setAttribute("currentCompliance", c);
			session.setAttribute("currentStatusReport", sr);
			mav.setViewName("WEB-INF/updateComplianceComments.jsp");
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