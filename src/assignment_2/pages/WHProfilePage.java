package assignment_2.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WHProfilePage {
	
	WebDriver driver;
	WebDriverWait wait;
	Actions action;
	
	//Assign variable to load config.properties file to read data
  	File src = new File("./properties/config.properties");
  	FileInputStream fis = new FileInputStream(src);
  	Properties pro = new Properties();
	
	public WHProfilePage(WebDriver driver) throws IOException
	{
        this.driver = driver;
        wait = new WebDriverWait(driver, 25);
        action = new Actions(driver);
        
        //load config.properties file to read data
    	pro.load(fis);   
    }

	public void goToProfile() 
	{
		WebElement we = driver.findElement(By.xpath("//div[contains(@class, 'brgm-button') and contains(@class, 'brgm-user') and contains(@class, 'brgm-list-box')]"));
		wait.until(ExpectedConditions.visibilityOf(we));
		action.moveToElement(we).build().perform();
		
		WebElement we2 = driver.findElement(By.linkText("Profile"));
		wait.until(ExpectedConditions.visibilityOf(we2));
		action.moveToElement(we2).build().perform();
		action.moveToElement(we2).click().perform();
	}
	
	public void verifyProfilePage()
	{
		By verify_profile_page_locator = By.xpath("//button[text()='Edit Profile']");
		wait.until(ExpectedConditions.presenceOfElementLocated(verify_profile_page_locator));
		if(driver.findElement(verify_profile_page_locator) != null) 
		{
			System.out.println("Landed on profile page");
		}
	}

	public void verifySuccessfulReview() 
	{
		String companyName = pro.getProperty("COMPANY_NAME");
		 
		if(driver.findElement(By.linkText(companyName)) != null) 
		{
			System.out.println("Review is successful");
		}
		else 
		{
			System.out.println("No review found!");
		}
	}
}
