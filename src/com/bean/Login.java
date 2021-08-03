package com.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "login_master")
public class Login {
	@Id
	private int userid;
	private String password;
	private String role;
	
	public int getUserid()
	{
		return userid;
	}
	public void setUserid(int userid)
	{
		this.userid = userid;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getRole()
	{
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}	
}