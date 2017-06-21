package com.ruh.eng.databse.dataaccess.impl;

import com.ruh.eng.Loggers.LogMessage;
import com.ruh.eng.databse.dataaccess.connectors.JdbcConnector;
import com.ruh.eng.databse.dataaccess.dao.TableDAO;
import com.ruh.eng.mapper.ObjectFilter;
import com.ruh.eng.models.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by DimRu on 6/7/2017.
 * CRUD operations for Users
 */
public class UsersDAO extends TableDAO
{
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	
	public ResultSet getAllData() {
		
		ResultSet rs = null;
		try {
			String getQueryStatement = "SELECT * FROM users_test_table";
			connection = JdbcConnector.mySqlConnector();
			preparedStatement = connection.prepareStatement( getQueryStatement );
			
			// Execute the Query, and get a java ResultSet
			rs = preparedStatement.executeQuery();
			
		}
		catch ( SQLException e ) {
			Logger.getLogger( UsersDAO.class.getName() ).log( Level.WARNING, "Transaction from database unsucces", e );
		}
		return rs;
	}
	
	public void insertUsers( List<Object> objects ) {
		
		List<Users> users = ObjectFilter.listFilter( objects, Users.class );
		connection = JdbcConnector.mySqlConnector();
		String insertQueryStatement = "INSERT  INTO  users_test_table (`user_id`,`username`,`password`)  VALUES  (?,?,?)";
		try {
			preparedStatement = connection.prepareStatement( insertQueryStatement );
			
			for ( Users user : users ) {
				int uId = user.getUserId();
				String username = user.getUserName();
				String password = user.getPassword();
				
				preparedStatement.setInt( 1, uId );
				preparedStatement.setString( 2, username );
				preparedStatement.setString( 3, password );
				
				// execute insert SQL statement
				preparedStatement.executeUpdate();
			}
			connection.commit();
			LogMessage.out( "inserted data to user table" );
		}
		catch ( SQLException e ) {
			try {
				connection.rollback();
				Logger.getLogger( UsersDAO.class.getName() )
						.log( Level.WARNING, "Transaction to the database was roll backed", e );
			}
			catch ( SQLException e1 ) {
				LogMessage.out( e1.getMessage() );
				Logger.getLogger( UsersDAO.class.getName() ).log( Level.SEVERE, "Transaction rollback unsuccessful", e1 );
			}
		}
	}
}
