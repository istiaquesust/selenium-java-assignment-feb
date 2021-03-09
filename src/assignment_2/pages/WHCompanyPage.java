package assignment_2.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WHCompanyPage {
	
	WebDriver driver;
	WebDriverWait wait;
	Actions action;
	
	//Assign variable to load config.properties file to read data
  	File src = new File("./properties/config.properties");
  	FileInputStream fis = new FileInputStream(src);
  	Properties pro = new Properties();
	
	public WHCompanyPage(WebDriver driver) throws IOException
	{
        this.driver = driver;
        wait = new WebDriverWait(driver, 25);
        
        //load config.properties file to read data
    	pro.load(fis);   
    }

	public void naviagateToCompany() 
	{
		String companyName = pro.getProperty("COMPANY_URL");
		driver.navigate().to(companyName);
	}
	
	public void verifyCompnyPage()
	{
		String companyName = pro.getProperty("COMPANY_NAME");
		String companyNameXPath = "//h1[text()=" + "\'" + companyName + "\']";
		By verify_company_page_locator = By.xpath(companyNameXPath);
		wait.until(ExpectedConditions.presenceOfElementLocated(verify_company_page_locator));
        	System.out.println("Landed on company page");
	}
	
	public void getRatingOption() 
	{		
		//scroll to rating option
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement we = driver.findElement(By.cssSelector("review-star.rvs-svg:nth-child(2)"));
		je.executeScript("arguments[0].scrollIntoView(true);", we);
	}
	
	public void selectRatingStar() 
	{
		driver.findElement(By.cssSelector("#reviews-section > div.review-stat-box > div.rv.review-action.ng-enter-element > review-star > div > svg:nth-child(4)")).click();	
	}
	
	public void selectReviewType() 
	{
		//verify review option appearance
		WebElement we = driver.findElement(By.xpath("//*[contains(text(), 'Submit')]"));
		wait.until(ExpectedConditions.visibilityOf(we));
		
		//select review type
        	driver.findElement(By.xpath("//span[text()='Select...']")).click();	
       		String reviewType = pro.getProperty("REVIEW_TYPE");
        	String reviewTypeXPath = "//li[text()=" + "\'" + reviewType + "\']";
		driver.findElement(By.xpath(reviewTypeXPath)).click();	
	}

	public void writeReview() 
	{
		WebElement we = driver.findElement(By.xpath("//div/div[1]/textarea"));	
		wait.until(ExpectedConditions.elementToBeClickable(we));
		String reviewText = pro.getProperty("REVIEW_TEXT");
		we.sendKeys(reviewText);
	}

	public void submitReview() 
	{
		driver.findElement(By.xpath("//*[contains(text(), 'Submit')]")).click();
	}
}
