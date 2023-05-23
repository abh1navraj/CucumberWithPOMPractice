package BasePackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import Pages.GooglePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	
	public static WebDriver driver;
	public static Properties prop;
	
	public Base(){
		prop = new Properties();
		try {
			FileInputStream fis  = new FileInputStream("./src/main/java/config/config.properties");
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("no configuration file present in specified path");
			e.printStackTrace();
		}
		
	}
	
	
	public static void openBrowser(String browser) {
		
		if(browser.equalsIgnoreCase("Chrome"))
		{
			driver = WebDriverManager.chromedriver().create();
		}
		else
		{
			driver = WebDriverManager.safaridriver().create();	
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	public static void closeBrowser() {
		driver.close();
		driver.quit();
		
	}
	
	public static GooglePage openUrl(String url)
	{
		driver.get(url);
		return new GooglePage();
	}
	
	public String getPageTile()
	{
		return driver.getTitle();
	}
}
