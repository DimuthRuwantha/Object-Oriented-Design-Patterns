package com.ruh.eng.mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DimRu on 13-Jun-17.
 *
 */
public class ObjectFilter
{
	private ObjectFilter(){}
	
	public static  <T> List<T> listFilter( List<?> objectList, Class<T> classType ) {
		List<T> returnList = new ArrayList<>();
		
		for ( Object object : objectList ) {
			returnList.add( classType.cast( object ) );
		}
		return returnList;
	}
}

