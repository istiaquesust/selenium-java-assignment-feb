package assignment_2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WHLoginPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public WHLoginPage(WebDriver driver)
	{
        this.driver = driver;
        wait = new WebDriverWait(driver, 25);
    }
	
	public void verifyLoginPage()
	{
		By verify_login_page_locator = By.name("em");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(verify_login_page_locator)));
		if(driver.findElement(verify_login_page_locator) != null) 
		{
			System.out.println("Landed on login page");
		}
	}

	public void setUserName(String user_name)
	{
		By user_name_locator = By.name("em");
		driver.findElement(user_name_locator).sendKeys(user_name);
	}
	
	public void setPassword(String password)
	{
		By password_locator = By.name("pw");
		driver.findElement(password_locator).sendKeys(password);
	}
	
	public void clickSigninButton()
	{
		By signin_button_locator = By.xpath("//span[text()='Login']");
		driver.findElement(signin_button_locator).click();
	}
}