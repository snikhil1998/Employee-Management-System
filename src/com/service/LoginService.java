package com.service;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Login;
//import com.dao.LoginDao;

@Service
public class LoginService {
	/*@Autowired
	LoginDao loginDao;*/
	
	public String checkAdminUser(Login login)
	{
		if(login.getUserid()==1 && login.getPassword().equals("admin"))
		{
			return "success";
		}
		else
		{
			return "failure";
		}
	}
	
	public String checkEmployeeUser(Login login)
	{
		/*if(loginDao.checkLoginDetails(login) > 0)
		{
			return "success";
		}
		else*/
		{
			return "failure";
		}
	}
}