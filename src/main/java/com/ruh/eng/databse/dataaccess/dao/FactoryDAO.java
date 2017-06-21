package com.ruh.eng.databse.dataaccess.dao;

import com.ruh.eng.databse.dataaccess.impl.LocationDAO;
import com.ruh.eng.databse.dataaccess.impl.UsersDAO;
import com.ruh.eng.models.Location;
import com.ruh.eng.models.Users;

import java.sql.ResultSet;
import java.util.List;

/**
 * Created by DimRu on 6/8/2017.
 * Factory Class for inserting data to the database
 */
public class FactoryDAO
{
	public void insertDataFactory( List<Object> objectList, List<String> headers ) {
		
		if ( headers.containsAll( Users.columns ) ) {
			UsersDAO usersDAO = new UsersDAO();
			usersDAO.insertUsers( objectList );
		}
		else if ( headers.containsAll( Location.columns ) ) {
			
			LocationDAO locationDAO = new LocationDAO();
			locationDAO.insertUsers( objectList );
		}
	}
	
	public ResultSet getAllDataFactory() {
		// TODO Write the business logic for the code
		return null;
	}
}
