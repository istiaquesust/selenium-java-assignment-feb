package assignment_1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FBLoginPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public FBLoginPage(WebDriver driver)
	{
        this.driver = driver;
        wait = new WebDriverWait(driver, 25);
    }
	
	public void verifyHomePage()
	{
		By verify_login_page_locator = By.className("_8ice");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(verify_login_page_locator)));
		if(driver.findElement(verify_login_page_locator) != null) 
		{
			System.out.println("Landed on login page");
		}
	}
	
	public void setUserName(String user_name)
	{
		By user_name_locator = By.name("email");
		driver.findElement(user_name_locator).sendKeys(user_name);
	}
	
	public void setPassword(String password)
	{
		By pasword_locator = By.name("pass");
		driver.findElement(pasword_locator).sendKeys(password);
	}
	
	public void clickSigninButton()
	{
		By login_button_locator = By.xpath("//button[text()='Log In']");
		driver.findElement(login_button_locator).click();
	}
	
}
