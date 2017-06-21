package com.ruh.eng.databse.constants;

/**
 * Created by DimRu on 6/5/2017.
 */
public class DatabaseKeys
{
	private static final String HOST = "localhost";
	private static final String PORT = "3306";
	private static final String DATABASE = "std_hub_db";
	private static final String USERNAME = "root";
	private static final String PASSWORD = getDbPassword();
	
	public static String getHOST()
	{
		return HOST;
	}
	
	public static String getPORT()
	{
		return PORT;
	}
	
	public static String getDATABASE()
	{
		return DATABASE;
	}
	
	public static String getUSERNAME()
	{
		return USERNAME;
	}
	
	public static String getPASSWORD()
	{
		return PASSWORD;
	}
	
	private static String getDbPassword()
	{
	
		return "root";
	}
	
}
