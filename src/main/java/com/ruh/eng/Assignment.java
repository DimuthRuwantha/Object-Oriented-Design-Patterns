package com.ruh.eng;

import com.ruh.eng.Loggers.LogMessage;
import com.ruh.eng.dataImport.FileReaderFactory;
import com.ruh.eng.dataImport.FilePath;
import com.ruh.eng.databse.dataaccess.connectors.JdbcConnector;
import com.ruh.eng.databse.dataaccess.dao.FactoryDAO;
import com.ruh.eng.exceptions.CsvFormatException;
import com.ruh.eng.mapper.ObjectMapper;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by DimRu on 6/1/2017.
 *
 */
public class Assignment
{
	public static void main( String[] args ) {
		
		// initializing objects
		String filename;
		FileReaderFactory fileReaderFactory = new FileReaderFactory();  // Setting the file path to the folder. this can be set in any where
		FilePath filePath = new FilePath();
		FactoryDAO factoryDAO = new FactoryDAO();
		List<List<String>> dataList = null;
		
		filePath.setFilePath( "D:/Academics/7th Semester/EE7205 OOP Design Patterns & Principles/csv files/users.csv" );
		
		filename = filePath.getFilePath(); //Get the file path
		
		try {
			dataList = fileReaderFactory.FileReader( filename );
		}
		catch ( CsvFormatException e ) {
			Logger.getLogger( Assignment.class.getName() ).log( Level.WARNING, "CSV Format Exception", e );
		}
		if ( dataList != null ) {
			ObjectMapper objectMapper = new ObjectMapper();
			List<Object> objectList = objectMapper.MappedObject( dataList );
			factoryDAO.insertDataFactory( objectList, dataList.get( 0 ) );
		}
		else {
			LogMessage.out( "File is empty or not exist" );
		}
		JdbcConnector.closeConnection();
	}
}
