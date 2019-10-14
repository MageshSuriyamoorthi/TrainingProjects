package com.atmecs.TaskKonakart.konakart_automation.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {

	


	
			static File file;
			static FileReader filereader;
		    static Properties properties;


			public static  String getData(String path,String key) throws IOException {
				properties = new Properties();
				file = new File(path);
				filereader = new FileReader(file);
				properties.load(filereader);
			
				String data = properties.getProperty(key);
				return data;
			}

	}



