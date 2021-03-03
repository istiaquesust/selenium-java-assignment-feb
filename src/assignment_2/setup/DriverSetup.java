package assignment_2.setup;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetup 
{
	//after deciding browser type, call actual method to launch site 
	public WebDriver initDriver(String browserName) throws IOException
	{
		WebDriver driver = null;
		String getBrowser = browserName.toLowerCase();
		
		//to decide browser
		switch (getBrowser) 
		{
		case "chrome": 
			driver = ChromeDriver();
			break;
		
		case "firefox": 
			driver = FirefoxDriver();
			break;
		}
		
		return driver;
	}
	
	//launch Chrome browser
	public WebDriver ChromeDriver() throws IOException 
	{
		//Load config.properties file to read data
		File src = new File("./properties/config.properties");
        FileInputStream fis = new FileInputStream(src);
        Properties pro = new Properties();
        pro.load(fis);
        
        //If push notification appears, block
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        //launch site
        String driverPath = pro.getProperty("DRIVER_PATH");
        System.setProperty("webdriver.chrome.driver", driverPath);
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(pro.getProperty("WALLETHUB_LAUNCH_URL"));
        
        return driver;
     }
	
	//launch Firefox browser
	public WebDriver FirefoxDriver() throws IOException 
	{
		//Load config.properties file to read data
		File src = new File("./properties/config.property");
        FileInputStream fis = new FileInputStream(src);
        Properties pro = new Properties();
        pro.load(fis);

        // launch site
        String driverPath = pro.getProperty("DRIVER_FIREFOX_PATH");
        System.setProperty("webdriver.gecko.driver", driverPath);
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(pro.getProperty("WALLETHUB_LAUNCH_URL"));
        
        return driver;
     }
}