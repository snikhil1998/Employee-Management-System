package com.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Department;
import com.service.DepartmentService;
import com.service.StatusReportService;

@Controller
public class StatusReportController
{
	@Autowired
	StatusReportService statusreportService;
	@Autowired
	DepartmentService departmentService;
	
	@RequestMapping(value = "viewStatusReportsDetails")
	public ModelAndView viewAllStatusReportsDetails(HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		session.setAttribute("allStatusReportsDetails", statusreportService.getAllStatusReportsDetails());
		HashMap<Long, String> hm = new HashMap<Long, String>();
		for(Department dpt : departmentService.getAllDepartmentsDetails())
		{
			hm.put(dpt.getDepartment_id(), dpt.getDepartment_nm());
		}
		session.setAttribute("allDepartmentsDetails", hm);
		mav.setViewName("WEB-INF/listStatusReports.jsp");
		return mav;
	}
}