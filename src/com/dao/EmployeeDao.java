package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Employee;

@Repository
public class EmployeeDao {
	@Autowired
	EntityManagerFactory emf;
	
	public List<Employee> getEmployeesList()
	{
		EntityManager manager = emf.createEntityManager();
		Query qry = manager.createQuery("select e from Employee e");
		return qry.getResultList();
	}
}