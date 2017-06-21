package com.ruh.eng.models;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by DimRu on 13-Jun-17.
 *
 */
public class TablesTest
{
	@Test
	public void TableTest()
	{
		Users users = new Users( 1, "dimru","mypass" );
		Location location = new Location( 2,2.3,3.4 );
		Assert.assertTrue( users.getUserName().equals( "dimru" ));
		Assert.assertTrue( !(location.getLatitude() != 2.3));
	}
}