package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Compliance;

@Repository
public class ComplianceDao
{
	@Autowired
	EntityManagerFactory emf;
	
	public List<Compliance> getCompliancesList()
	{
		EntityManager manager = emf.createEntityManager();
		Query qry = manager.createQuery("select c from Compliance c");
		return qry.getResultList();
	}
}