package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Employee;
import com.bean.Login;

@Repository
public class LoginDao
{
	@Autowired
	EntityManagerFactory emf;
	
	public String checkLoginDetails(Login ll)
	{
		EntityManager manager = emf.createEntityManager();
		Query qry = manager.createQuery("select l from Login l where l.userid=:userid and l.password=:password");
		qry.setParameter("userid", ll.getUserid());
		qry.setParameter("password", ll.getPassword());
		List<Login> list = qry.getResultList();
		return list.size()>0?list.get(0).getRole():null;
	}
	public boolean addLoginCredentials(Login ll)
	{
		EntityManager manager = emf.createEntityManager();
		EntityTransaction tran = manager.getTransaction();
		tran.begin();
		manager.persist(ll);
		tran.commit();
		return manager.find(Login.class, ll.getUserid())!=null;
	}
	public boolean deleteLoginCredentials(long userid)
	{
		EntityManager manager = emf.createEntityManager();
		EntityTransaction tran = manager.getTransaction();
		tran.begin();
		manager.remove(manager.find(Login.class, userid));
		tran.commit();
		return manager.find(Login.class, userid)==null;
	}
}