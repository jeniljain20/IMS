package com.ead.ims.util;

import java.io.FileReader;
import java.util.List;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class ReadCSV {
	public static List<String[]> allData=null;
	
	public static List<String[]> readfile(String filename){
	try { 
       
        FileReader filereader = new FileReader(filename); 
        CSVParser parser = new CSVParserBuilder().withSeparator(',').build(); 
        CSVReader csvReader = new CSVReaderBuilder(filereader)
        						  .withSkipLines(1)
                                  .withCSVParser(parser) 
                                  .build(); 

        allData = csvReader.readAll(); 

    } 
    catch (Exception e) { 
        e.printStackTrace(); 
    }
	return allData;
	}

}
