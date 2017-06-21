package com.ruh.eng.databse.dataaccess.dao;

import java.sql.ResultSet;
import java.util.List;

/**
 * Created by DimRu on 13-Jun-17.
 *
 */
public abstract class TableDAO
{
	public abstract ResultSet getAllData();
	
	public abstract void insertUsers( List<Object> objectList );
}
