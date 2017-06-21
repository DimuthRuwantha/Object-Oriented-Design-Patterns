package com.ruh.eng.databse.dataaccess.connectors;

import com.ruh.eng.Loggers.LogMessage;
import com.ruh.eng.databse.constants.DatabaseKeys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by DimRu on 6/2/2017.
 * Singleton class for the connection
 */
public class JdbcConnector
{
	private Connection connection;
	
	private JdbcConnector()
	{
		String host = DatabaseKeys.getHOST();
		String port = DatabaseKeys.getPORT();
		String database = DatabaseKeys.getDATABASE();
		String username = DatabaseKeys.getUSERNAME();
		String password = DatabaseKeys.getPASSWORD();
		
		String connectionUrl = "jdbc:mysql://" + host + ":" + port + "/" + database;
		try
		{
			Class.forName( "com.mysql.jdbc.Driver" );
			
			// DriverManager: The basic service for managing a set of JDBC drivers.
			connection = DriverManager.getConnection( connectionUrl, username, password );
			connection.setAutoCommit( false );
			LogMessage.out( "connection creation successful" );
		}
		catch ( SQLException e )
		{
			Logger.getLogger( JdbcConnector.class.getName() ).log( Level.SEVERE, null, e );
			LogMessage.out( "MySQL Connection Failed! \n"+ e.getMessage() );
		}
		catch ( ClassNotFoundException e )
		{
			Logger.getLogger( JdbcConnector.class.getName() ).log( Level.SEVERE, null, e );
			LogMessage.out( e.getMessage() );
		}
	}
	
	private static class DbConnector
	{
		
		static JdbcConnector jdbcConnector = new JdbcConnector();
		private DbConnector()
		{
			
		}
	}
	
	public static Connection mySqlConnector()
	{
		return DbConnector.jdbcConnector.connection;
	}
	
	public static void closeConnection()
	{
		try
		{
			if ( !DbConnector.jdbcConnector.connection.isClosed() )
			{
				DbConnector.jdbcConnector.connection.close();
				LogMessage.out( "closing connection" );
			}
			else
			{
				LogMessage.out( "Connection has been closed already" );
			}
		}
		catch ( SQLException e )
		{
			Logger.getLogger( JdbcConnector.class.getName() ).log( Level.SEVERE, null, e );
		}
	}
}
