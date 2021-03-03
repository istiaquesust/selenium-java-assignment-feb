package assignment_1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FBHomePage 
{	
	WebDriver driver;
	WebDriverWait wait;
	Actions action;

	public FBHomePage(WebDriver driver)
	{
        this.driver = driver;
        wait = new WebDriverWait(driver, 25);
    }
	
	public void verifyHomePage()
	{
		By verify_home_page_locator = By.xpath("//*[contains(text(), 'Create a Story')]");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(verify_home_page_locator)));
		if(driver.findElement(verify_home_page_locator) != null) 
		{
			System.out.println("Landed on home page");
		}
	}
	
	public void writeStatus(String status_data)
	{
		//click on post field
		By status_field_locator = By.xpath("//*[contains(text(), 'on your mind')]");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(status_field_locator)));
		driver.findElement(status_field_locator).click();
		
		//write post on modal post field
		By status_field_modal_locator = By.xpath("//*[contains(@class, '_1mf') and contains(@class, '_1mj')]");
		wait.until(ExpectedConditions.presenceOfElementLocated(status_field_modal_locator));
		driver.findElement(status_field_modal_locator).sendKeys(status_data);
	}
	
	public void clickPostButton()
	{
		By post_button_locator = By.xpath("//span[text()='Post']");
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(post_button_locator)));
		driver.findElement(post_button_locator).click();
	}
	
	public void verifyPost()
	{
		By verify_post_locator = By.xpath("//div[text()='Hello World']");
		try {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(verify_post_locator)));
			if(driver.findElement(verify_post_locator) != null) 
			{
				System.out.println("Successfully post status");
			}
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Post status fails");
		}		
	}
}