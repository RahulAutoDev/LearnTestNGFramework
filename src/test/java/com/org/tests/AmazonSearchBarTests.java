package com.org.tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import static com.org.base.Base.driver;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.google.common.io.Files;
import com.org.base.Base;
import com.org.pages.AmazonSearchBar;
import com.org.util.SharedLibrary;
import com.sun.tools.doclets.internal.toolkit.util.DocFinder.Output;
import static com.org.config.ProjectProperties.props;

public class AmazonSearchBarTests extends Base{

	public AmazonSearchBar amazonSearch;
	public SoftAssert softAssert;
	public Actions action;
	
	@BeforeMethod
	public void searchBar()
	{
		amazonSearch = new AmazonSearchBar();
		softAssert = new SoftAssert();
		Actions action = new Actions(driver);
	}
	
	@Test(priority=7)
	public void validateProductNameAfterSearch()
	{
		report.createTest("validateProductNameAfterSearch");
		amazonSearch.searchBar.sendKeys(props.getProperty("validateProductNameAfterSearch"));	
		amazonSearch.clickSearchBar.click();
		WebElement verifySearchItem = driver.findElement(By.linkText(props.getProperty("validateProductNameAfterSearch")));
		boolean searchItemValue = verifySearchItem.isDisplayed();
		Assert.assertEquals(searchItemValue, true);
		//amazonSearch.searchBar.clear();
	}
	
	@Test(priority=1)
	public void validateClearOnSearchBar() throws IOException
	{
		report.createTest("validateClearOnSearchBar");
		amazonSearch.searchBar.sendKeys("New Apple iPhone 11 (64GB) - Purple");
		amazonSearch.searchBar.clear();
		//testCase.addScreenCaptureFromPath(SharedLibrary.takeScreenshots("validateClearOnSearchBar"));
	}
	
	@Test(priority=2)
	public void validateClickOnSearchButton() throws IOException
	{
		testCase = report.createTest("validateClickOnSearchButton");
		String pageTitleBefSearch = driver.getTitle();
		amazonSearch.searchBar.click();
		String pageTitleAftSearch = driver.getTitle();
		if(pageTitleBefSearch == pageTitleAftSearch)
		{
			testCase.pass("validateClickOnSearchButton");
		}
		else {
			testCase.fail("validateClickOnSearchButton");
			testCase.addScreenCaptureFromPath(SharedLibrary.takeScreenshots("validateClickOnSearchButton"));
		}
		//Assert.assertEquals(pageTitleBefSearch, pageTitleAftSearch);
		//Assert.assertEquals(pageTitleBefSearch, "Amazon");
		amazonSearch.searchBar.clear();
	}
	
	@Test(priority=3)
	public void validateSearchDataSuggestions() throws InterruptedException, IOException
	{
		report.createTest("validateSearchDataSuggestions");
		amazonSearch.searchBar.sendKeys("Test");
		//testCase.addScreenCaptureFromPath(SharedLibrary.takeScreenshots("validateSearchDataSuggestions"));
		Thread.sleep(5000);
		
		String searchSuggestions = driver.findElement(By.xpath("//*[contains(@id,'suggestions-template')]")).getText();
		//System.out.println(amazonSearch.searchSuggestions);
		System.out.println(searchSuggestions);
		amazonSearch.searchBar.clear();
	}
	
	@Test(priority=4)
	public void validateDepartmentProductName() throws InterruptedException
	{
		report.createTest("validateDepartmentProductName");
		Select options = new Select(amazonSearch.selectDepartment);
		options.selectByVisibleText("Gift Cards");
		Thread.sleep(3000);
		amazonSearch.searchBar.sendKeys("amazon gift card voucher");
		String searchSuggestions = driver.findElement(By.xpath("//*[contains(@id,'suggestions-template')]")).getText();
		System.out.println("The depart product name is :"+ searchSuggestions);
		amazonSearch.searchBar.clear();
	}
	
	@Test(priority=5)
	public void validateCopySearchBarValue() throws InterruptedException
	{
		try {
			report.createTest("validateCopySearchBarValue");
			amazonSearch.searchBar.sendKeys("amazon gift card voucher1234");
			amazonSearch.clickSearchBar.click();
			Thread.sleep(3000);
			WebElement data = driver.findElement(By.xpath("//*[contains(@id,'twotabsearchtextbox')]"));
			String attValue = data.getAttribute("value");
			System.out.println("AttValue is..... : "+ attValue);
			data.clear();
			
//			action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
//			action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
//			action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
//			action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
//			action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
	}
	
	@Test(priority=6)
	public void validateHighlightText() throws InterruptedException
	{ 
		report.createTest("validateHighlightText");
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;  
		jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')", amazonSearch.searchBar);  
		Thread.sleep(3000);
		amazonSearch.searchBar.clear();
	}
	
	
	
	
	
}

