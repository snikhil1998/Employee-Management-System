package com.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Compliance;

@Repository
public class ComplianceDao
{
	@Autowired
	EntityManagerFactory emf;
	
	public boolean storeComplianceInformation(Compliance c)
	{
		EntityManager manager = emf.createEntityManager();
		EntityTransaction tran = manager.getTransaction();
		tran.begin();
		manager.persist(c);
		tran.commit();
		return manager.find(Compliance.class, c.getComplianceid())!=null;
	}
	public List<Compliance> getAllCompliancesDetails()
	{
		EntityManager manager = emf.createEntityManager();
		Query qry = manager.createQuery("select c from Compliance c");
		return qry.getResultList();
	}
}