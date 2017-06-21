package com.ruh.eng.databse.dataaccess.impl;

import com.ruh.eng.models.Users;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by DimRu on 14-Jun-17.
 *
 */
public class UsersDAOTest
{
	@Test
	public void getAllData() throws Exception {
		Field field = UsersDAO.class.getDeclaredField( "connection" );
		field.setAccessible( true );
		Connection connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/std_hub_db","root","root" );
	//	field.set( connection , null );
	}
	
	@Test
	public void insertUsers() throws Exception {
		
	}
	
	@Test
	public void TestTwoConnections()
	{
		UsersDAO usersDAO = new UsersDAO();
		Object users = new Users( 2, "newnamw", "mpass" );
		List<Object> userList = Arrays.asList(users);
		usersDAO.insertUsers( userList );
		
		ResultSet rs =usersDAO.getAllData();
		try {
			while ( rs.next() ) {
				int name = rs.getInt( "user_id" );
				String username = rs.getString( "username" );
				String password = rs.getString( "password" );
			}
		}catch ( SQLException e ){
			e.getMessage();
		}
	}
}
























