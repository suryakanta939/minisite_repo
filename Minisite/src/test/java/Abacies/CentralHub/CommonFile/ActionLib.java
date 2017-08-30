package Abacies.CentralHub.CommonFile;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionLib
{
	public static void mouseHover(String xpath)
	{
		WebElement wb=Driver.driver.findElement(By.xpath(xpath));
		Actions act=new Actions(Driver.driver);
     	act.moveToElement(wb).perform();
	}
	public static void dragAndDrop(String srcXpath,String dstXpath){
		WebElement srcwb=Driver.driver.findElement(By.xpath(srcXpath));
		WebElement dstwb=Driver.driver.findElement(By.xpath(dstXpath));
		Actions act=new Actions(Driver.driver);
		act.clickAndHold(srcwb).perform();
		Driver.driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		act.moveToElement(dstwb).perform();
		act.release().perform();
	}
}
