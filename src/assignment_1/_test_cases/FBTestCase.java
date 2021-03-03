package assignment_1._test_cases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import assignment_1.setup.DriverSetup;
import assignment_1.pages.FBLoginPage;
import assignment_1.pages.FBHomePage;

public class FBTestCase {

	public static void main(String args[]) throws IOException, InterruptedException 
	{
		//Load config.properties file to read data
		File src = new File("./properties/config.properties");
		FileInputStream fis = new FileInputStream(src);
		Properties pro = new Properties();
		pro.load(fis);
		
		//Driver Setup
		String browserName = pro.getProperty("BROWSER_NAME");
		DriverSetup driverSetup = new DriverSetup();
		WebDriver driver = driverSetup.initDriver(browserName);
		
		/* 1. Login to Facebook. Username and Password should be on a variable we can change. */
		FBLoginPage loginPage = new FBLoginPage(driver);
		loginPage.setUserName(pro.getProperty("FACEBOOK_USER_NAME"));
		loginPage.setPassword(pro.getProperty("FACEBOOK_PASSWORD"));
		loginPage.clickSigninButton();
		FBHomePage homePage = new FBHomePage(driver);
		homePage.verifyHomePage();
		
		/* 2. Post a status message "Hello World"*/
		//Post status
		homePage.writeStatus(pro.getProperty("FACEBOOK_POST_DATA"));
		homePage.clickPostButton();
		
		//Verify post
		homePage.verifyPost();
		
		//Quit driver
		driver.quit();
	}
}