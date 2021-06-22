package com.org.util;
import static com.org.base.Base.driver;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.google.common.io.Files;

public class SharedLibrary {
	public static String basePath = "/Users/rahulsingh/eclipse-workspace/LearnTestNGFramework/ScreenShots/";
	
	public static String takeScreenshots(String testCaseName)
	{
		TakesScreenshot screenShot = (TakesScreenshot)driver;
		File file = screenShot.getScreenshotAs(OutputType.FILE);
		String imagePath = basePath + testCaseName +".png";
		File targetFile = new File(imagePath);
		try {
			Files.copy(file, targetFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return imagePath;
		
	}
	

}
