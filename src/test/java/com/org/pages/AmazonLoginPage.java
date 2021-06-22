package com.org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static com.org.base.Base.driver;

public class AmazonLoginPage {
	
	public WebDriver driver;
	
	public AmazonLoginPage(WebDriver driver)
	{
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'ap_email')]")
	WebElement loginEmail;
	
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'ap_password')]")
	WebElement loginpassword;
	
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Hello, Sign in')]")
	WebElement clickSignInLink;
	
	@FindBy(how = How.XPATH, using = "//*[contains(@type,'submit')]")
	WebElement loginEmailSubmitBtn;
	
	@FindBy(how = How.XPATH, using = "//input[@id='signInSubmit']")
	WebElement loginSignInBtn;
	
	@FindBy(how = How.XPATH, using = "//*[contains(@class,'nav-action-inner')]")
	WebElement loginHoverSignIn;
	
	@FindBy(how = How.XPATH, using="//*[contains(@class,'a-icon a-icon-logo')]")
	WebElement AmazonLogo;
	
	public WebElement emailTextBox()
	{
		return loginEmail;
	}
	
	public WebElement passwordTextBox()
	{
		return loginpassword;
	}
	
	public WebElement emailSignInBtn()
	{
		return clickSignInLink;
	}
	
	public WebElement emailSubmit()
	{
		return loginEmailSubmitBtn;
	}
	
	public WebElement loginSignInBtn()
	{
		return loginSignInBtn;
	}
	
	public WebElement loginHoverSignIn()
	{
		return loginHoverSignIn;
	}
	
	public WebElement AmazonLogo()
	{
		return AmazonLogo;
	}
	
	
	
	

	//public WebElement loginEmail = driver.findElement(By.xpath("//*[contains(@id,'ap_email')]"));
	//public WebElement loginpassword = driver.findElement(By.xpath("//*[contains(@id,'ap_password')]"));
	//public WebElement clickSignInLink = driver.findElement(By.xpath("//*[contains(text(),'Hello, Sign in')]"));
	//public WebElement loginEmailSubmitBtn = driver.findElement(By.xpath("//*[contains(@type,'submit')]"));
	//public WebElement loginSignInBtn = driver.findElement(By.xpath("//*[contains(@id,'auth-signin-button-announce')]"));
	//public WebElement loginHoverSignIn = driver.findElement(By.xpath("//*[contains(@class,'nav-action-inner')]"));

}
