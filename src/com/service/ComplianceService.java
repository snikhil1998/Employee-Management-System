package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Compliance;
import com.dao.ComplianceDao;

@Service
public class ComplianceService
{
	@Autowired
	ComplianceDao complianceDao;
	
	public String storeComplianceInformation(Compliance c)
	{
		return complianceDao.storeComplianceInformation(c)?"Regulation created successfully":"Unable to create Regulation";
	}
	public List<Compliance> getAllCompliancesDetails()
	{
		return complianceDao.getAllCompliancesDetails();
	}
	public List<Compliance> getDepartmentCompliancesDetails(long department_id)
	{
		return complianceDao.getDepartmentCompliancesDetails(department_id);
	}
}