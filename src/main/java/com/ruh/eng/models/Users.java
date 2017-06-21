package com.ruh.eng.models;

import java.util.Arrays;
import java.util.List;

/**
 * Created by DimRu on 6/3/2017.
 *
 */
public class Users extends Tables
{
	private int userId;
	private String userName;
	private String password;
	public final static List<String> columns = Arrays.asList("id","username","password");
	
	public Users(int userId, String userName, String password){
		
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}
	
	public int getUserId()
	{
		return userId;
	}
	
	public void setUserId( int userId )
	{
		this.userId = userId;
	}
	
	public String getUserName()
	{
		return userName;
	}
	
	public void setUserName( String userName )
	{
		this.userName = userName;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword( String password )
	{
		this.password = password;
	}
}
