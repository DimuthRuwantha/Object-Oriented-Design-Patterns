package com.ruh.eng.dataImport;

import com.ruh.eng.dataImport.impl.CSVFileReader;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by DimRu on 6/9/2017.
 *
 */
public class CSVFileReaderTest
{
	@Test
	public void fileReader() throws Exception
	{
		CSVFileReader csvFileReader = new CSVFileReader();
		String fileName = "D:/Academics/7th Semester/EE7205 OOP Design Patterns & Principles/csv files/users.csv";
		List<List<String>> dataList = csvFileReader.fileReader( fileName );
		
		Assert.assertTrue( dataList.size() > 0 );
		
	}
	
}