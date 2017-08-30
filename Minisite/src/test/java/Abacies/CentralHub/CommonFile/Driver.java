package Abacies.CentralHub.CommonFile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Driver
{
	public static WebDriver driver;
	public static WebDriver getDriver()
	{
		
//			FirefoxProfile pro=new FirefoxProfile();
//			pro.setPreference("browser.download.folderList",0);
//			pro.setPreference("browser.helperApps.neverAsk.saveToDisk","give the mime type in Driver" );
		if(Constant.browser.equals("firefox")){
			driver=new FirefoxDriver();
		}
		else if(Constant.browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver","C:\\Users\\ad\\Desktop\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		return driver;
	}
	

}
