package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.StatusReport;
import com.dao.StatusReportDao;

@Service
public class StatusReportService
{
	@Autowired
	StatusReportDao statusreportDao;
	
	public List<StatusReport> getAllStatusReportsDetails()
	{
		return statusreportDao.getAllStatusReportsDetails();
	}
}