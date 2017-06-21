package com.ruh.eng.mapper;

import com.ruh.eng.models.Users;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by DimRu on 12-Jun-17.
 *
 */
public class ObjectMapperTest
{
	@Test
	public void MappedObjectTest()
	{
		List<String> header = Arrays.asList("id","username","password");
		List<String> list1 = Arrays.asList( "34","dimru","mypassword");
		List<List<String>> dataList = new ArrayList<>(  );
		dataList.add( header );
		dataList.add( list1 );
		ObjectMapper objectMapper = new ObjectMapper();
		List<Object> objectList = objectMapper.MappedObject( dataList );
		Users object = (Users ) objectList.get( 0 );
		
		Assert.assertTrue( object.getUserName().equals( "dimru" ) );
	}
	
	@Test
	public void mapToUser(){
		
		Method method = null;
		ObjectMapper objectMapper = new ObjectMapper();
		
		List<String> list1 = Arrays.asList( "id","username","password" );
		List<String> list2 = Arrays.asList( "2","name2","pwd2" );
		List<String> list3 = Arrays.asList( "3","name3","pwd3" );
		
		List<List<String>> myDataList = new ArrayList<>(  ); //Arrays.asList( list1,list2,list3 );
		myDataList.add( list1 );
		myDataList.add( list2 );
		myDataList.add( list3 );
		//Object objects = myDataList;
		
		try {
			Field dataList = objectMapper.getClass().getDeclaredField( "dataList" );
			dataList.setAccessible( true );
			try {
				dataList.set( objectMapper, myDataList );
			}
			catch ( IllegalAccessException e ) {
				e.printStackTrace();
			}
		}
		catch ( NoSuchFieldException e ) {
			e.printStackTrace();
		}
		
		try {
			method = objectMapper.getClass().getDeclaredMethod( "MapToUser");
			method.setAccessible( true );
		}
		catch ( NoSuchMethodException e ) {
			e.printStackTrace();
		}
		List<Object> objectList = new ArrayList<>(  );
		try {
			objectList = (List<Object>) method.invoke( objectMapper );
		}
		catch ( IllegalAccessException e ) {
			e.printStackTrace();
		}
		catch ( InvocationTargetException e ) {
			e.printStackTrace();
		}
		Assert.assertTrue( objectList.size()> 0 );
	}
}