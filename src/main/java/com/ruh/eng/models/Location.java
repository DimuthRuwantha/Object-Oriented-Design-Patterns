package com.ruh.eng.models;

import java.util.Arrays;
import java.util.List;

/**
 * Created by DimRu on 13-Jun-17.
 *
 */
public class Location extends Tables
{
	private int locationId;
	private double latitude;
	private double longitude;
	
	public static final List<String> columns = Arrays.asList("locationId","latitude","longitude");
	
	public Location(int locationId,double latitude,double longitude){
		
		this.locationId = locationId;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public int getLocationId() {
		return locationId;
	}
	
	public void setLocationId( int locationId ) {
		this.locationId = locationId;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public void setLatitude( long latitude ) {
		this.latitude = latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}
	
	public void setLongitude( long longitude ) {
		this.longitude = longitude;
	}
	
	
}
