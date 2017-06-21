package com.ruh.eng.exceptions;

/**
 * Created by DimRu on 6/9/2017.
 *
 */
public class CsvFormatException extends Exception
{
	private static final long serialVersionUID = 1L;
	
	public CsvFormatException()
	{
		super();
		System.out.println("CSV file format error");
	//	LogMessage.out( "CSV File format error" );
	}
	public CsvFormatException(String s){
		super(s);
	}
}
