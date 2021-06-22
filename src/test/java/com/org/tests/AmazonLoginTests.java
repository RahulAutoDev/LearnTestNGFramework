package com.org.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static com.org.base.Base.driver;

import com.org.base.Base;
import com.org.pages.AmazonLoginPage;

import junit.framework.Assert;

import static com.org.config.ProjectProperties.props;

import java.util.regex.Pattern;

public class AmazonLoginTests extends Base{
	
	public AmazonLoginPage loginPage;
	public Pattern pattern;
	
	@BeforeMethod
	public void LoginPage()
	{
		loginPage = new AmazonLoginPage(driver);
	}
	
	@Test(priority=2)
	public void validateSuccesslogin() throws InterruptedException
	{
		report.createTest("validateSuccesslogin");
		loginPage.emailSignInBtn().click();
		loginPage.emailTextBox().sendKeys(props.getProperty("LoginUsername"));
		loginPage.emailSubmit().click();
		loginPage.passwordTextBox().sendKeys(props.getProperty("LoginPassword"));
		//loginPage.loginSignInBtn().click();
		loginPage.AmazonLogo().click();
	}
	
	@Test(priority=1)
	public void validateEnteredUserName()
	{
		report.createTest("validateEnteredUserName");
		String userName = props.getProperty("LoginUsername");
		boolean result = Pattern.matches("^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$", userName);
		Assert.assertEquals(result, true);
	}
	
	@Test(priority=3)
	public void validateUsernameTextBox()
	{
		report.createTest("validateUsernameTextBox");
		loginPage.emailSignInBtn().click();
		loginPage.emailTextBox().sendKeys(props.getProperty("LoginUsername"));
		loginPage.emailSubmit().click();
		String username = loginPage.emailTextBox().getAttribute("value");
		Assert.assertEquals(username, props.getProperty("LoginUsername"));
	}
	
	@Test(priority=4)
	public void validateEnteredPassword()
	{
		report.createTest("validateEnteredPassword");
		String password = props.getProperty("LoginPassword");
		boolean result = Pattern.matches("^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$", password);
		Assert.assertEquals(result, true);
	}
	
	

}
