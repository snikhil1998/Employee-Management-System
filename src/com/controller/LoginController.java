package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Login;
import com.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public ModelAndView openLoginPage()
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login.jsp");
		return mav;
	}
	@RequestMapping(value = "loginCheck",method = RequestMethod.POST)
	public ModelAndView loginRedirect(HttpServletRequest req, Login login, HttpSession session)
	{
		login.setUserid(Long.parseLong(req.getParameter("userid")));
		login.setPassword(req.getParameter("password"));
		String employeeResult = loginService.checkEmployeeUser(login);
		ModelAndView mav = new ModelAndView();
		if(employeeResult==null)
		{
			mav.addObject("msg", "Invalid username or password");
			mav.setViewName("index.jsp");
			return mav;
		}
		login.setRole(employeeResult);
		if(login.getRole().equals("admin"))
		{
			mav.setViewName("adminHome.jsp");
		}
		else
		{
			session.setAttribute("user", login.getUserid());
			mav.setViewName("employeeHome.jsp");
		}
		return mav;
	}
	@RequestMapping(value = "adminDashboard",method = RequestMethod.GET)
	public ModelAndView adminDashboard()
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("adminHome.jsp");
		return mav;
	}
	@RequestMapping(value = "logout",method = RequestMethod.GET)
	public ModelAndView logOut()
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index.jsp");
		return mav;
	}
}