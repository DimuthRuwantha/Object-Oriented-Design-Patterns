package com.ruh.eng.mapper;

import com.ruh.eng.Loggers.LogMessage;
import com.ruh.eng.models.Location;
import com.ruh.eng.models.Users;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by DimRu on 6/8/2017.
 *
 */
public class ObjectMapper
{
	 private List<List<String>> dataList;
	public List<Object> MappedObject( List<List<String>> dataList ) {
		// Select the relevant method comparing csv columns with object model columns
		this.dataList = new ArrayList<>( dataList );
		if ( this.dataList.get( 0 ).containsAll( Users.columns ) ) {
			LogMessage.out( "Mapping dataList to Users Object" );
			return MapToUser(  );
		}
		if ( this.dataList.get( 0 ).containsAll( Location.columns ) ) {
			return MapToLocation( dataList );
		}
		return new ArrayList<>();
	}
	
	private List<Object> MapToUser(  ) {
		List<Object> usersList = new ArrayList<>();
		
		Map<String, Integer> columnMap = new HashMap<>();
		int i = 0;
		for ( String columnTitles : dataList.get( 0 ) ) {
			columnMap.put( columnTitles, i );
			i++;
		}
		
		int usernameColumn = columnMap.get( "username" );
		int idColumn = columnMap.get( "id" );
		int passwordColumn = columnMap.get( "password" );
		
		dataList.remove( 0 ); // remove the header of the csv from the dataList
		for ( List<String> user : dataList ) {
			
			int userId = Integer.parseInt( user.get( idColumn ) );
			String userName = user.get( usernameColumn );
			String passWord = user.get( passwordColumn );
			
			Users users = new Users( userId, userName, passWord );
			
			usersList.add( users );
		}
		LogMessage.out( "Mapped "+usersList.size()+" Objects to user object" );
		return usersList;
	}
	
	private static List<Object> MapToLocation( List<List<String>> dataList ) {
		return new ArrayList<>();
	}
}
