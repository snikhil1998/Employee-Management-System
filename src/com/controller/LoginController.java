package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Login;
import com.service.LoginService;

@Controller
public class LoginController
{
	@Autowired
	LoginService loginService;
	
	private static Logger logger = Logger.getLogger(LoginController.class);
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public ModelAndView openLoginPage()
	{
		ModelAndView mav = new ModelAndView();
		try
		{
			mav.setViewName("login.jsp");
		}
		catch(Exception e)
		{
			PropertyConfigurator.configure(getClass().getProtectionDomain().getCodeSource().getLocation().getPath() + "log4j.properties");
			logger = Logger.getLogger(getClass());
			logger.error("Error occurred. Please check logs.", e);
			mav.setViewName("error.jsp");
		}
		return mav;
	}
	@RequestMapping(value = "loginCheck",method = RequestMethod.POST)
	public ModelAndView loginRedirect(HttpServletRequest req, Login login, HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		try
		{
			login.setUserid(Long.parseLong(req.getParameter("userid")));
			login.setPassword(req.getParameter("password"));
			String employeeResult = loginService.checkEmployeeUser(login);
			if(employeeResult==null)
			{
				mav.addObject("msg", "Invalid username or password");
				mav.setViewName("index.jsp");
				return mav;
			}
			login.setRole(employeeResult);
			session.setAttribute("userid", login.getUserid());
			session.setAttribute("role", login.getRole());
			mav.setViewName(login.getRole().equals("admin")?"WEB-INF/adminHome.jsp":"WEB-INF/employeeHome.jsp");
		}
		catch(Exception e)
		{
			PropertyConfigurator.configure(getClass().getProtectionDomain().getCodeSource().getLocation().getPath() + "log4j.properties");
			logger = Logger.getLogger(getClass());
			logger.error("Error occurred. Please check logs.", e);
			mav.setViewName("error.jsp");
		}
		return mav;
	}
	@RequestMapping(value = "adminDashboard",method = RequestMethod.GET)
	public ModelAndView adminDashboard(HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		try
		{
			if(session.getAttribute("role")==null)
			{
				mav.setViewName("index.jsp");
				return mav;
			}
			if(!session.getAttribute("role").equals("admin"))
			{
				mav.setViewName("WEB-INF/employeeHome.jsp");
				return mav;
			}
			mav.setViewName("WEB-INF/adminHome.jsp");
		}
		catch(Exception e)
		{
			PropertyConfigurator.configure(getClass().getProtectionDomain().getCodeSource().getLocation().getPath() + "log4j.properties");
			logger = Logger.getLogger(getClass());
			logger.error("Error occurred. Please check logs.", e);
			mav.setViewName("error.jsp");
		}
		return mav;
	}
	@RequestMapping(value = "employeeDashboard",method = RequestMethod.GET)
	public ModelAndView employeeDashboard(HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		try
		{
			if(session.getAttribute("role")==null)
			{
				mav.setViewName("index.jsp");
				return mav;
			}
			if(!session.getAttribute("role").equals("user"))
			{
				mav.setViewName("WEB-INF/adminHome.jsp");
				return mav;
			}
			mav.setViewName("WEB-INF/employeeHome.jsp");
		}
		catch(Exception e)
		{
			PropertyConfigurator.configure(getClass().getProtectionDomain().getCodeSource().getLocation().getPath() + "log4j.properties");
			logger = Logger.getLogger(getClass());
			logger.error("Error occurred. Please check logs.", e);
			mav.setViewName("error.jsp");
		}
		return mav;
	}
	@RequestMapping(value = "logout",method = RequestMethod.GET)
	public ModelAndView logOut(HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		try
		{
			session.invalidate();
			mav.setViewName("index.jsp");
		}
		catch(Exception e)
		{
			PropertyConfigurator.configure(getClass().getProtectionDomain().getCodeSource().getLocation().getPath() + "log4j.properties");
			logger = Logger.getLogger(getClass());
			logger.error("Error occurred. Please check logs.", e);
			mav.setViewName("error.jsp");
		}
		return mav;
	}
}