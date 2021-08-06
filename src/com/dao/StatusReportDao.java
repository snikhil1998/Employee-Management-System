package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.StatusReport;

@Repository
public class StatusReportDao
{
	@Autowired
	EntityManagerFactory emf;
	
	public List<StatusReport> getAllStatusReportsDetails()
	{
		EntityManager manager = emf.createEntityManager();
		Query qry = manager.createQuery("select sr from StatusReport sr");
		return qry.getResultList();
	}
}