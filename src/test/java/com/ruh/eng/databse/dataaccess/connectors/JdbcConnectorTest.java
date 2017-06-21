package com.ruh.eng.databse.dataaccess.connectors;

import com.ruh.eng.databse.constants.DatabaseKeys;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by DimRu on 6/10/2017.
 *
 */
public class JdbcConnectorTest
{
	JdbcConnector jdbcConnector;
	private String username;
	private String password;
	private String connectionUrl;
	
	private Connection localCon = null;
	
	@Before
	public void init()
	{
		
		String host = DatabaseKeys.getHOST();
		String port = DatabaseKeys.getPORT();
		String database = DatabaseKeys.getDATABASE();
		username = DatabaseKeys.getUSERNAME();
		password = DatabaseKeys.getPASSWORD();
		
		connectionUrl = "jdbc:mysql://" + host + ":" + port + "/" + database;
	}
	
	@Test
	public void jdbcDriverTest()
	{
		Class<?> clas = null;
		try
		{
			clas = Class.forName( "com.mysql.jdbc.Driver" );
		}
		catch ( ClassNotFoundException e )
		{
			System.out.println( e.getMessage() );
		}
		
		Assert.assertTrue( clas.getName().equals( "com.mysql.jdbc.Driver" ) );
	}
	
	@Test
	public void jdbcConnectionTest()
	{
		try
		{
			this.localCon = DriverManager.getConnection( connectionUrl, username, password );
		}
		catch ( SQLException e )
		{
			System.out.println( e.getMessage() );
		}
		Assert.assertTrue( localCon != null );
	}
	
	@Test
	public void connectionTest1()
	{
		this.localCon = JdbcConnector.mySqlConnector();
		boolean isOpen;
		try {
			isOpen = !localCon.isClosed();
		}
		catch ( SQLException e ) {
			e.printStackTrace();
			isOpen = false;
		}
		
		if ( isOpen )
		{
			try
			{
				this.localCon.close();
			}
			catch ( SQLException e )
			{
				e.printStackTrace();
			}
		}
		Assert.assertTrue( isOpen);
	}
	
	@After
	public void connectionTest2()
	{
		if(localCon!= null){
			try {
				localCon.close();
			}
			catch ( SQLException e ) {
				e.printStackTrace();
			}
		}
	}
}