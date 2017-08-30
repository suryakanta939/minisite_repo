package TestNgLib;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Abacies.CentralHub.CommonFile.Driver;
import Abacies.CentralHub.CommonFile.ExcelLib;
import Abacies.CentralHub.CommonFile.WebdriverWaitLib;
import BusinesFile.CreateSlug;
import BusinesFile.minisiteCredential;

public class slug {
	Driver d;
	ExcelLib eLib;
	minisiteCredential ml=new minisiteCredential();
	RemoteWebDriver Rdriver;
	CreateSlug cs=new CreateSlug();
	 WebdriverWaitLib wLib;
	 @BeforeTest
	 public void configbeftes(){
		 System.out.println("chek for all test");
	 }
	 
	 @BeforeMethod
	 public void configTest() throws IOException{
		 /*login to the site*/
		DesiredCapabilities cap= DesiredCapabilities.firefox();
		cap.setBrowserName("firefox");
		cap.setPlatform(Platform.VISTA);
		cap.setVersion("43.0.4");
		Rdriver=new RemoteWebDriver(new URL("http://192.168.1.16:5556/wd/hub"),cap);
		 ml.login();
		 }
  @Test(priority=0)
  public void slugcreate() throws IOException
  {
	  cs.createslug();
  }
  @Test(dataProvider="readslugname",priority=1)
  public void checkCreatedslug(String slugname,String description) throws IOException
  {
		/*click on acess apps*/
		Properties acessapp=eLib.getPropertyData("minisite");
		String aceap=acessapp.getProperty("acessApps");
		Driver.driver.findElement(By.xpath(aceap)).click();
		/*click on minisite*/
		
		Properties minisitelink=eLib.getPropertyData("minisite");
		String minisite1=minisitelink.getProperty("minisiteLink");
		wLib.explicitlywaitVisibility(minisite1);
		Driver.driver.findElement(By.xpath(minisite1)).click();
		
		 /*handel the window with*/
      Set<String> window=Driver.driver.getWindowHandles();
      Iterator<String> itr=window.iterator();
      String pid=itr.next();
      String cid=itr.next();
     Driver.driver.switchTo().window(cid);
     
     /*click on slug*/
     Properties slug=eLib.getPropertyData("minisite");
		String slug1=slug.getProperty("slug");
		Driver.driver.findElement(By.xpath(slug1)).click();
		
		/*click on add slug*/
		 Properties addslug=eLib.getPropertyData("minisite");
			String addslug1=addslug.getProperty("addslug");
			Driver.driver.findElement(By.xpath(addslug1)).click();
	        wLib.implicitlyWait();
	     Properties slugneditbox=eLib.getPropertyData("minisite");
		String slugneditbox1=slugneditbox.getProperty("slugneditbox");
		Driver.driver.findElement(By.xpath(slugneditbox1)).sendKeys(slugname);
		
		/*enter the description*/
		 Properties slugdes=eLib.getPropertyData("minisite");
			String slugdes1=slugdes.getProperty("slugdes");
			Driver.driver.findElement(By.xpath(slugdes1)).sendKeys(description);
			
			/*enter the color*/
			Properties slugcol=eLib.getPropertyData("minisite");
			String slugcol1=slugcol.getProperty("slugcol");
			Driver.driver.findElement(By.xpath(slugcol1)).sendKeys("#2e0505");
			
			/*click on submit*/
			Properties slugsubmit=eLib.getPropertyData("minisite");
			String slugsubmit1=slugsubmit.getProperty("slugsubmit");
			Driver.driver.findElement(By.xpath(slugsubmit1)).click();
			
			
  }
  @DataProvider(name="readslugname")
  public Object[][] exceldata() throws EncryptedDocumentException, InvalidFormatException, IOException
  {
	 
	Object[][] name1=eLib.getExcelmultipleData("C:\\Users\\ad\\Desktop\\New TestData\\minisitedata.xlsx","slugname");
	return name1;
  }
  @AfterMethod
  public void configAftermtehod(){
	  /*close the site*/
	  Driver.driver.close();
  }
  @AfterTest
  public void configaftertest(){
	 Driver.driver.quit();
  }
}
