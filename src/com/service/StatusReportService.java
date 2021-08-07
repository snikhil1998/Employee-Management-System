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
	
	public String storeStatusReport(StatusReport sr)
	{
		return statusreportDao.storeStatusReport(sr)?"Comments submitted successfully":"Unable to submit comments";
	}
	public List<StatusReport> getAllStatusReportsDetails()
	{
		return statusreportDao.getAllStatusReportsDetails();
	}
	public String storeUpdatedStatusReport(StatusReport sr)
	{
		return statusreportDao.storeUpdatedStatusReport(sr)?"Comments updated successfully":"Unable to update comments";
	}
}