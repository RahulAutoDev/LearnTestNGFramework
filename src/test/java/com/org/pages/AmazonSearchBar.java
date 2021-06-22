package com.org.pages;

import static com.org.base.Base.driver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class AmazonSearchBar {
	
	public WebElement searchBar;
	public WebElement clickSearchBar;
	//public WebElement verifySearchItem = driver.findElement(By.linkText("New Apple iPhone 11 (64GB) - Purple"));
	public WebElement searchSuggestions;
	//public List<WebElement> searchBar1 = driver.findElement(By.xpath("//*[contains(@id,'twotabsearchtextbox')]")).findElements(By.xpath("//*[contains(@id,'suggestions-template')]"));
	//String suggestion = driver.findElement(By.xpath("//*[@class='nav-searchbar nav-progressive-attribute']/li[@role='presentation']["+i+"]")).getText();
	public WebElement selectDepartment;
	
	
	
	public WebElement getSearchBar() {
		WebElement searchBar = driver.findElement(By.xpath("//*[contains(@id,'twotabsearchtextbox')]"));
		return searchBar;
	}
	public WebElement getClickSearchBar() {
		WebElement clickSearchBar = driver.findElement(By.xpath("//*[contains(@id,'nav-search-submit-button')]"));
		return clickSearchBar;
	}
	public WebElement getSearchSuggestions() {
		WebElement searchSuggestions = driver.findElement(By.xpath("//*[contains(@id,'suggestions-template')]"));
		return searchSuggestions;
	}
	public WebElement getSelectDepartment() {
		WebElement selectDepartment = driver.findElement(By.xpath("//*[contains(@id,'searchDropdownBox')]"));
		return selectDepartment;
	}
	
	
	
	
	
	
}
