package com.bean;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "statusreport")
public class StatusReport
{
	private int complianceid;
	@Id
	private int statusrptid;
	private int empid;
	private String comments;
	private Date createdate;
	private int department_id;
	
	public int getComplianceid()
	{
		return complianceid;
	}
	public void setComplianceid(int complianceid)
	{
		this.complianceid = complianceid;
	}
	public int getStatusrptid()
	{
		return statusrptid;
	}
	public void setStatusrptid(int statusrptid)
	{
		this.statusrptid = statusrptid;
	}
	public int getEmpid()
	{
		return empid;
	}
	public void setEmpid(int empid)
	{
		this.empid = empid;
	}
	public String getComments()
	{
		return comments;
	}
	public void setComments(String comments)
	{
		this.comments = comments;
	}
	public Date getCreatedate()
	{
		return createdate;
	}
	public void setCreatedate(Date createdate)
	{
		this.createdate = createdate;
	}
	public int getDepartment_id()
	{
		return department_id;
	}
	public void setDepartment_id(int department_id)
	{
		this.department_id = department_id;
	}
}