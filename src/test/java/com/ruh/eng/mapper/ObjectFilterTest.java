package com.ruh.eng.mapper;

import com.ruh.eng.models.Location;
import com.ruh.eng.models.Users;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by DimRu on 15-Jun-17.
 */
public class ObjectFilterTest
{
	@Test
	public void listFilterTest1() {
		
		Object object1 = new Users( 1, "myname1", "mypass1" );
		Object object2 = new Users( 2, "myname2", "mypass2" );
		
		List<Object> objects = Arrays.asList( object1, object2 );
		
		List<Users> users = ObjectFilter.listFilter( objects, Users.class );
		
		Assert.assertTrue( users.size() == 2 );
	}
	
	@Test
	public void listFilterTest2() {
		
		Object object1 = new Location( 1, 2.2, 3.4 );
		Object object2 = new Location( 2, 3.3, 4.3 );
		
		List<Object> objects = Arrays.asList( object1, object2 );
		
		List<Location> locations = ObjectFilter.listFilter( objects, Location.class );
		
		Assert.assertTrue( locations.size() == 2 );
	}
}