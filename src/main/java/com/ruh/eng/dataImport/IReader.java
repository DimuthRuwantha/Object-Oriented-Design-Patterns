package com.ruh.eng.dataImport;

import com.ruh.eng.exceptions.CsvFormatException;

import java.util.List;

/**
 * Created by DimRu on 6/3/2017.
 *
 */
public interface IReader
{
	List<List<String>> fileReader(String fileName) throws CsvFormatException;
}
