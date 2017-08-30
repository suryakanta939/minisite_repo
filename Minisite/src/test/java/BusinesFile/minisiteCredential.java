package BusinesFile;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

import Abacies.CentralHub.CommonFile.Driver;
import Abacies.CentralHub.CommonFile.ExcelLib;
import Abacies.CentralHub.CommonFile.WebdriverWaitLib;

public class minisiteCredential
{
	Driver d;
	ExcelLib eLib;
	   WebdriverWaitLib wLib;
     public void login() throws IOException
     {
    	 d.getDriver();
    	 Driver.driver.get("https://tshirtbomb.herokuapp.com/?535460971e050720f1ba2b982e4966388212867b:20d99ea5935fe4f0:8UT2BR54jdYzyqqJeLJDmuYUUo0Ud5R6ws1oc77Mb2VLEWMNLm2Fz2lkpSVYsr1b");
    	 Driver.driver.manage().window().maximize();
    	 wLib.implicitlyWait();
          
    	 Properties proUn=eLib.getPropertyData("minisite");
			String un=proUn.getProperty("username");
			Properties proPwd=eLib.getPropertyData("minisite");
			String pwd=proPwd.getProperty("passwordID");
			                                
			Driver.driver.findElement(By.xpath(un)).sendKeys("lenin");
			Driver.driver.findElement(By.id(pwd)).sendKeys("reset123");
        //get the xpath of login btn
			 Properties prologin=eLib.getPropertyData("minisite");
			 String login=prologin.getProperty("loginBtn");
			Driver.driver.findElement(By.id(login)).click();
        	wLib.implicitlyWait();
     }
}
