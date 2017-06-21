package com.ruh.eng.dataImport.impl;

import com.opencsv.CSVReader;
import com.ruh.eng.Loggers.LogMessage;
import com.ruh.eng.dataImport.IReader;
import com.ruh.eng.exceptions.CsvFormatException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by DimRu on 6/3/2017.
 * CSVFileReader Checks the number of items in each row of the csv file
 * if the count mismatch with row count, fileReader throws CSVFormatException.
 */
public class CSVFileReader implements IReader
{
	
	public List<List<String>> fileReader( String fileName ) throws CsvFormatException {
		String[] line;
		String[] headersArray;
		List<List<String>> dataList = new ArrayList<>();
		
		try (FileReader fileReader = new FileReader( fileName );
		     CSVReader reader = new CSVReader( fileReader )) {
			
			headersArray = reader.readNext();
			List<String> headersList = Arrays.asList( headersArray );
			dataList.add( headersList );
			
			while ( ( line = reader.readNext() ) != null ) {
				if ( headersArray.length == line.length ) {
					List<String> lineList = Arrays.asList( line );
					dataList.add( lineList );
				}
				else {
					throw new CsvFormatException("no of headers mis match with no of values");
				}
			}
		}
		catch ( IOException e ) {
			Logger.getLogger( CSVFileReader.class.getName() ).log( Level.WARNING, "IOException", e );
		}
		LogMessage.out( "CSV File reader read "+ (dataList.size()-1)+" rows of data" );
		return dataList;
	}
}
