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
public class EmployeeDao {
	@Autowired
	EntityManagerFactory emf;
	@Autowired
	LoginDao loginDao;
	
	public boolean storeEmployeeDetails(Employee emp)
	{
		EntityManager manager = emf.createEntityManager();
		EntityTransaction tran = manager.getTransaction();
		tran.begin();
		manager.persist(emp);
		tran.commit();
		Login ll = new Login();
		ll.setUserid(emp.getEmpid());
		ll.setPassword("emp");
		ll.setRole("user");
		return loginDao.addLoginCredentials(ll) && manager.find(Employee.class, emp.getEmpid())!=null;
	}
	public List<Employee> getAllEmployeesDetails()
	{
		EntityManager manager = emf.createEntityManager();
		Query qry = manager.createQuery("select e from Employee e");
		return qry.getResultList();
	}
	public Employee getEmployeeDetails(long empid)
	{
		EntityManager manager = emf.createEntityManager();
		return manager.find(Employee.class, empid);
	}
	public boolean updateEmployeeDetails(Employee emp)
	{
		EntityManager manager = emf.createEntityManager();
		EntityTransaction tran = manager.getTransaction();
		tran.begin();
		manager.merge(emp);
		tran.commit();
		return !(manager.find(Employee.class, emp.getEmpid()).equals(emp));
	}
	public boolean deleteEmployeeDetails(long empid)
	{
		if(empid==1)
		{
			return false;
		}
		boolean loginCredentialsRemoved = loginDao.deleteLoginCredentials(empid);
		EntityManager manager = emf.createEntityManager();
//		Employee emp = manager.find(Employee.class, empid);
		EntityTransaction tran = manager.getTransaction();
		tran.begin();
		manager.remove(manager.find(Employee.class, empid));
		tran.commit();
		return loginCredentialsRemoved && manager.find(Employee.class, empid)==null;
	}
}