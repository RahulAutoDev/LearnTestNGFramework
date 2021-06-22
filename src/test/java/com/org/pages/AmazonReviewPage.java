package com.org.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AmazonReviewPage {
	
	private WebDriver driver;
	
	public AmazonReviewPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using="//*[contains(@class,'a-input-text ryp__review-title__input')]")
	WebElement reviewAddHeading;
	
	@FindBy(how = How.XPATH, using = "//*[contains(@class,'a-input-text-wrapper')]/textarea")
	WebElement reviewAddComment;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Water resistance')]"
			+ "//ancestor::div[3]//div[contains(@class,'a-section a-spacing-top-micro "
			+ "ryp__interval-product-attribute-input')]\n" + 
			"")
	WebElement selectWaterResistanceStars;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Easy to clean')]"
			+ "//ancestor::div[3]//div[contains"
			+ "(@class,'a-section a-spacing-top-micro ryp__interval-product-attribute-input')]/button/img")
	WebElement selectEasytocleanStars;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Value for money')]"
			+ "//ancestor::div[3]//div[contains"
			+ "(@class,'a-section a-spacing-top-micro ryp__interval-product-attribute-input')]/button/img[@alt='two stars']")
	
	WebElement selectValueformoneyStars;
	
	@FindBy(how = How.XPATH, using= "//button[contains(text(),'Submit')]")
	WebElement submitReviewBtn;
	
	@FindBy(how = How.XPATH, using = "//h3[contains(text(),'Overall rating')]//ancestor::div[3]"
			+ "//div[contains(@class,'a-section a-spacing-top-micro')]"
			+ "/button/img[@alt='select to rate item five star.']")
	WebElement finalRating;
	
	@FindBy(how = How.XPATH, using="//input[@id='ryp__media-upload-banner-input']")
	WebElement uploadImage;
	
	@FindBy(how = How.XPATH, using= "//select[@id='sort-order-dropdown']")
	WebElement selectSortReview;
	
	@FindBy(how = How.XPATH, using= "//span[@data-hook='review-body']")
	WebElement storeReview;
	
	
	public List<WebElement> storeReview()
	{
		List<WebElement> storeReview = driver.findElements(By.xpath("//span[@data-hook='review-body']"));
		return storeReview;
	}
	
	public WebElement selectSortReview()
	{
		return selectSortReview;
	}
	
	public WebElement uploadImage()
	{
		return uploadImage;
	}
	
	public WebElement finalRating()
	{
		return finalRating;
	}
	
	public WebElement reviewAddHeading()
	{
		return reviewAddHeading;
	}
	
	public WebElement reviewAddComment()
	{
		return reviewAddComment;
	}
	
	public WebElement selectWaterResistanceStars()
	{
		return selectWaterResistanceStars;
	}
	
	public WebElement selectEasytocleanStars()
	{
		return selectEasytocleanStars;
	}
	
	public WebElement selectValueformoneyStars(String starValue)
	{
		WebElement valueForMoney = driver.findElement(By.xpath("//span[contains(text(),'Value for money')]"
				+ "//ancestor::div[3]//div[contains(@class,'a-section a-spacing-top-micro ryp__interval-product-attribute-input')]"
				+ "/button/img[@alt='" + starValue + "']"));
		
		return valueForMoney;
		
		
		//return selectValueformoneyStars;
	}
	
	public WebElement submitReviewBtn()
	{
		return submitReviewBtn;
	}
	
	
	

}
