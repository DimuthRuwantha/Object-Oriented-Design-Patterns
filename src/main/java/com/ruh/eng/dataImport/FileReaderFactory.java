package com.ruh.eng.dataImport;

import com.ruh.eng.Loggers.LogMessage;
import com.ruh.eng.dataImport.impl.CSVFileReader;
import com.ruh.eng.dataImport.impl.EXELFileReader;
import com.ruh.eng.exceptions.CsvFormatException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DimRu on 6/3/2017.
 * This Factory returns any kind of a list
 */
public class FileReaderFactory
{
	private List<List<String>> dataList = new ArrayList<>();
	
	public List<List<String>> FileReader( String filename ) throws CsvFormatException {
		
		IReader reader;
		if ( filename == null ) {
			return dataList;
		}
		else {
			if ( filename.contains( ".csv" ) ) {    // for csv files
				LogMessage.out( "File was identified as a csv file" );
				reader = new CSVFileReader();
				dataList = reader.fileReader( filename );
			}
			else if ( filename.contains( ".xlsx" ) ) {  // for excel sheets
				LogMessage.out( "File was identified as a excel file" );
				reader = new EXELFileReader();
				dataList = reader.fileReader( filename );
			}
		}
		return dataList;
	}
}
