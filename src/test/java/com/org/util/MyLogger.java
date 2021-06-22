package com.org.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class MyLogger {
	
	private static Properties prop = new Properties();
	private static FileInputStream fis;
	public static Logger log;
	
	static {
		
		File file = new File("/Users/rahulsingh/eclipse-workspace/LearnTestNGFramework/Log4j.properties");
		try {
			fis = new FileInputStream(file);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		PropertyConfigurator.configure(prop);
	}
	
	public static Logger getLogger(String name)
	{
		log = Logger.getLogger(name);
		return log;
	}

	
	
}
