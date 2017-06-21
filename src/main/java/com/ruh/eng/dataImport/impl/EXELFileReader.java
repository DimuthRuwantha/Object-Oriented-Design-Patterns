package com.ruh.eng.dataImport.impl;

import com.ruh.eng.dataImport.IReader;
import com.ruh.eng.exceptions.CsvFormatException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DimRu on 13-Jun-17.
 *
 */
public class EXELFileReader implements IReader
{
	public List<List<String>> fileReader(String fileName) throws CsvFormatException{
		return new ArrayList<>(  );
	}
}
