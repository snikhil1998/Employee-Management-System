package com.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Compliance;
import com.bean.StatusReport;
import com.dao.ComplianceDao;

@Service
public class ComplianceService
{
	@Autowired
	ComplianceDao complianceDao;
	
	public String storeComplianceInformation(Compliance c) throws Exception
	{
		return complianceDao.storeComplianceInformation(c)?"Regulation created successfully":"Unable to create Regulation";
	}
	public List<Compliance> getAllCompliancesDetails() throws Exception
	{
		return complianceDao.getAllCompliancesDetails();
	}
	public List<Compliance> getEmployeeRemainingCompliancesDetails(long empid) throws Exception
	{
		return complianceDao.getEmployeeRemainingCompliancesDetails(empid);
	}
	public HashMap<StatusReport, Compliance> getEmployeeCompliancesDetails(long empid) throws Exception
	{
		return complianceDao.getEmployeeCompliancesDetails(empid);
	}
}