package BusinesFile;

import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.By;

import Abacies.CentralHub.CommonFile.Driver;
import Abacies.CentralHub.CommonFile.ExcelLib;
import Abacies.CentralHub.CommonFile.WebdriverWaitLib;

public class CreateSlug 
{
	  ExcelLib eLib;
	   WebdriverWaitLib wLib;
	   String sn;
	public void createslug() throws IOException{
		
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
			
			/*enter the slug name*/
			 System.out.println("enter ur slug name");
	         Scanner scn=new Scanner(System.in);
	         sn=scn.nextLine();
			 Properties slugneditbox=eLib.getPropertyData("minisite");
				String slugneditbox1=slugneditbox.getProperty("slugneditbox");
				Driver.driver.findElement(By.xpath(slugneditbox1)).sendKeys(sn);
				/*enter the description*/
				 Properties slugdes=eLib.getPropertyData("minisite");
					String slugdes1=slugdes.getProperty("slugdes");
					Driver.driver.findElement(By.xpath(slugdes1)).sendKeys("wnnwed");
					/*enter the colour*/
					Properties slugcol=eLib.getPropertyData("minisite");
					String slugcol1=slugcol.getProperty("slugcol");
					Driver.driver.findElement(By.xpath(slugcol1)).sendKeys("#2e0505");
					/*click on submit*/
					Properties slugsubmit=eLib.getPropertyData("minisite");
					String slugsubmit1=slugsubmit.getProperty("slugsubmit");
					Driver.driver.findElement(By.xpath(slugsubmit1)).click();
					
	}

}
