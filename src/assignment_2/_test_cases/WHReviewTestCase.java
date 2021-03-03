package assignment_2._test_cases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import assignment_2.setup.DriverSetup;
import assignment_2.pages.WHCompanyPage;
import assignment_2.pages.WHLoginPage;
import assignment_2.pages.WHProfilePage;

public class WHReviewTestCase {
	public static void main(String args[]) throws IOException 
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
		
		//instantiate objects
		WHLoginPage loginPage = new WHLoginPage(driver);
		WHProfilePage profilePage = new WHProfilePage(driver);
		WHCompanyPage companyPage = new WHCompanyPage(driver);
		
		//login
		loginPage.verifyLoginPage();
		loginPage.setUserName(pro.getProperty("WALLETHUB_USER_NAME"));
		loginPage.setPassword(pro.getProperty("WALLETHUB_PASSWORD"));
		loginPage.clickSigninButton();
		profilePage.verifyProfilePage();
		
		
		/* 1. Go to this URL: http://wallethub.com/profile/test_insurance_company/ */
		companyPage.naviagateToCompany();
		companyPage.verifyCompnyPage();
		
		/* 2. On the reviews section of the page, hover over the stars and click on 
		 * the fourth star. Yourcode should actually (a) do the hover and 
		 * (b) make sure the stars inside get lit up when youhover over them, then 
		 * (c) click on the fourth star. Simply redirecting the WebDriver to the nextpage isn’t an option. 
		 */
		companyPage.getRatingOption();
		companyPage.selectRatingStar();
		
		/* 3. On the page you get redirected to,
		 * click on the Policy dropdown and change the value to“Health Insurance”.
		 */
		companyPage.selectReviewType();
		
		/* 4. Click on the link “Write a review” and 
		 * write some random text (minimum of 200 characters).
		 */
		companyPage.writeReview();
		
		/* 5. Press submit. */
		companyPage.submitReview();
		
		/* 6. If you are successful, you should see a confirmation screen 
		 * saying you have reviewed the institution. You then have to go to 
		 * your profile and confirm that the “review feed” got updated.
		 */
		
		/* 7. Go to https://wallethub.com/profile/ and assert that you can see the review. */
		profilePage.goToProfile();
		profilePage.verifySuccessfulReview();
		
		
		//quit driver
		driver.quit();
	}
}
