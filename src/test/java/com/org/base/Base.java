package com.org.base;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.org.config.ProjectProperties;
import static com.org.config.ProjectProperties.props;

public class Base {
	
	public static WebDriver driver;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentTest testCase;
	public static ExtentReports report;
	
	@BeforeSuite
	public void generateExtentReport() throws IOException
	{
		//htmlReporter = new ExtentHtmlReporter("/Users/rahulsingh/eclipse-workspace/LearnTestNGFramework/Reports/LearnTestNG_ExtentReport.html");
		//props = ProjectProperties.fetchPropValues();
		htmlReporter = new ExtentHtmlReporter(props.getProperty("reportPath"));
		report = new ExtentReports();
		report.attachReporter(htmlReporter);
	}
	
	@AfterSuite
	public void saveExtentReport()
	{
		report.flush();
	}
	
	@Parameters("url")
	@BeforeClass
	public static void setUp(String url)
	{
		System.setProperty("webdriver.chrome.driver", "/Users/rahulsingh/Desktop/MyComputer/Automation/Drivers/chromedriver_91");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public static void tearDown()
	{
		driver.quit();
	}
	
	
}
