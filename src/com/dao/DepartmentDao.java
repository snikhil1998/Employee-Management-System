package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Department;

@Repository
public class DepartmentDao
{
	@Autowired
	EntityManagerFactory emf;
	
	public List<Department> getDepartmentsList()
	{
		EntityManager manager = emf.createEntityManager();
		Query qry = manager.createQuery("select dpt from Department dpt");
		return qry.getResultList();
	}
}