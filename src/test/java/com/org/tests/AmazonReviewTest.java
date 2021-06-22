package com.org.tests;

import static com.org.config.ProjectProperties.props;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.org.base.Base;
import com.org.pages.AmazonLoginPage;
import com.org.pages.AmazonReviewPage;
import com.org.pages.AmazonSearchBar;
import com.org.util.DataDrivenProvider;
import com.org.util.MyLogger;
import com.org.util.SharedLibrary;
import com.org.util.SharedMethods;

public class AmazonReviewTest extends Base{
	
	public AmazonReviewPage reviewPage;
	public AmazonLoginPage loginPage;
	public SharedMethods sharedMethods;
	public Actions actions;
	public AmazonSearchBar searchBar;
	public Select options;
	public BufferedWriter buffer;
	public FileWriter fr;
	public File file;
	public Logger log;
	
	@BeforeMethod
	public void AmazonReview()
	{
		reviewPage = new AmazonReviewPage(driver);
		loginPage = new AmazonLoginPage(driver);
		sharedMethods = new SharedMethods();
		actions = new Actions(driver);
		searchBar = new AmazonSearchBar();
		log = MyLogger.getLogger("AmazonReviewTest");
	}
	
	@DataProvider(name="excel-data")
	public Object[][] getTestData()
	{
		Object[][] data = DataDrivenProvider.getDataProvider();
		return data;
	}
	
//	@Parameters("reviewScreenPath")
//	@Test(priority=1)
//	public void validateAddReview(String reviewScreenPath) throws InterruptedException
//	{
//		report.createTest("validateAddReview");
//		sharedMethods.loginAmazon();
//		Thread.sleep(3000);
//		driver.navigate().to(reviewScreenPath);
//		reviewPage.reviewAddHeading().sendKeys(props.getProperty("ReviewHeading"));
//		reviewPage.reviewAddComment().sendKeys(props.getProperty("ReviewComment"));
//		reviewPage.selectValueformoneyStars(props.getProperty("SelectStarRatingValue")).click();
//		reviewPage.finalRating().click();
//		reviewPage.submitReviewBtn().click();
//		Thread.sleep(10000);
//	}
	
	@Parameters("reviewScreenPath")
	@Test(priority=2)
	public void validateEditReview(String reviewScreenPath) throws InterruptedException
	{
		report.createTest("validateEditReview");
		log.info("INFO");
		sharedMethods.loginAmazon();
		Thread.sleep(3000);
		driver.navigate().to(reviewScreenPath);
		reviewPage.reviewAddHeading().clear();
		reviewPage.reviewAddHeading().sendKeys(props.getProperty("ReviewHeading"));
		//reviewPage.reviewAddHeading().clear();
		//reviewPage.reviewAddHeading().sendKeys(fname);
		reviewPage.reviewAddComment();
		reviewPage.reviewAddComment().sendKeys(props.getProperty("ReviewComment"));
	}
	
	//@Parameters("reviewScreenPath")String reviewScreenPath,
	@Test(priority=3,dataProvider="excel-data")
	public void validateDataProvider(String fname, String lname, String email, String password) throws InterruptedException
	{
		report.createTest("validateEditReview");
		log.info("INFO");
		//driver.navigate().to(reviewScreenPath);
		driver.navigate().to("https://www.amazon.in/review/create-review/?asin=B07YDFQ5D5&amp;channel=unknownChannel-thankyou&amp;ref_=ryp_hz_thnk_l_23");
		System.out.println(fname + "" + lname + "" + email + "" + password);
		reviewPage.reviewAddHeading().clear();
		reviewPage.reviewAddHeading().sendKeys(props.getProperty("ReviewHeading"));
		reviewPage.reviewAddComment();
		reviewPage.reviewAddComment().sendKeys(props.getProperty("ReviewComment"));
	}
	
	@Parameters("reviewScreenPath")
	@Test(priority=4)
	public void validateAddReviewWithImage(String reviewScreenPath) throws InterruptedException
	{
		log.info("INFO");
		log.error("validateAddReviewWithImage");
		report.createTest("validateAddReviewWithImage");
		driver.navigate().to(reviewScreenPath);
		reviewPage.uploadImage().sendKeys("/Users/rahulsingh/Downloads/NewImage.jpg");
		Thread.sleep(10000);
	}
	
	@Parameters("reviewScreenPath")
	@Test(priority=5)
	public void validateAddReviewWithUnwantedImage(String reviewScreenPath) throws InterruptedException, IOException
	{
		testCase = report.createTest("validateAddReviewWithUnwantedImage");
		log.error("Error");
		driver.navigate().to(reviewScreenPath);
		String beforUpload = reviewPage.uploadImage().getAttribute("class");
		reviewPage.uploadImage().sendKeys("/Users/rahulsingh/Downloads/Appointment_slip (1).pdf");
		String AfterUpload = reviewPage.uploadImage().getAttribute("class");
		Thread.sleep(10000);
		if(beforUpload == AfterUpload)
		{
			testCase.pass("Upload Successfull.....");
			testCase.addScreenCaptureFromPath(SharedLibrary.takeScreenshots("validateAddReviewWithUnwantedImage"));
		}
		else {
			testCase.fail("Upload Fail.....");
			testCase.addScreenCaptureFromPath(SharedLibrary.takeScreenshots("validateAddReviewWithUnwantedImage"));
		}
	}
	
	
	@Test(priority=6)
	public void validatesortingReview() throws InterruptedException
	{
		report.createTest("validatesortingReview");
		driver.navigate().to("https://www.amazon.in/Meatup-Chicken-Flavour-Biscuit-Treats/product-re"
				+ "views/B079T87VW1/ref=cm_cr_dp_d_show_all_btm?ie=UTF8&amp;reviewerType=all_reviews");
		
		options = new Select(reviewPage.selectSortReview());
		options.selectByVisibleText("Most recent");
		Thread.sleep(5000);
	}
	
	@Test(priority=7)
	public void validateStoreReviewData()
	{
		report.createTest("validateStoreReviewData");
		driver.navigate().to("https://www.amazon.in/Meatup-Chicken-Flavour-Biscuit-Treats/product-re"
				+ "views/B079T87VW1/ref=cm_cr_dp_d_show_all_btm?ie=UTF8&amp;reviewerType=all_reviews");
		List<WebElement> reviewBodyList = reviewPage.storeReview();
		
		file = new File(props.getProperty("ReviewCommentFilePath"));

		try
		{
			fr = new FileWriter(file.getAbsolutePath());
			buffer = new BufferedWriter(fr);
	
			for(WebElement reviewBodyText : reviewBodyList)
			{
				buffer.write(reviewBodyText.getText());
				buffer.newLine();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				buffer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
}
