package com.org.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ProjectProperties {
	
	public static Properties props = new Properties();
	
	static
	{
		File file = new File("/Users/rahulsingh/eclipse-workspace/LearnTestNGFramework/config/ProjectConfig.properties");
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			props.load(fis);
			
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
	}
	
	
	
	
	
	
	

}
