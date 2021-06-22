package com.org.util;

import static com.org.config.ProjectProperties.props;
import org.openqa.selenium.WebDriver;
import com.org.pages.AmazonLoginPage;
import static com.org.base.Base.driver;

public class SharedMethods {
	
	//public WebDriver driver;
	public AmazonLoginPage loginPage = new AmazonLoginPage(driver);
	
	
	public void loginAmazon()
	{
		loginPage.emailSignInBtn().click();
		loginPage.emailTextBox().sendKeys(props.getProperty("LoginUsername"));
		loginPage.emailSubmit().click();
		loginPage.passwordTextBox().sendKeys(props.getProperty("LoginPassword"));
		loginPage.loginSignInBtn().click();
	}

}
