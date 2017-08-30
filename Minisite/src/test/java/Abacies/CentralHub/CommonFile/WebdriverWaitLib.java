package Abacies.CentralHub.CommonFile;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverWaitLib 
{
	public static void implicitlyWait()
	{
		Driver.driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	public static void explicitlywait(String xpath){
		WebDriverWait wait=new WebDriverWait(Driver.driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
	}
	public static void explicitlywaitTobeClickable(String xpath){
		WebDriverWait wait=new WebDriverWait(Driver.driver,10);
		wait.until(ExpectedConditions.elementToBeClickable( By.xpath(xpath)));
	}
	public static void explicitlywaitTobeSelected(String xpath){
		WebDriverWait wait=new WebDriverWait(Driver.driver,10);
		wait.until(ExpectedConditions.elementToBeSelected(By.xpath(xpath)));
	}
	public static void explicitlywaitTobeVisible(String xpath){
		WebDriverWait wait=new WebDriverWait(Driver.driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
   public static void explicitlywaitAlertToBePresent()
   {
		WebDriverWait wait=new WebDriverWait(Driver.driver,10);
		wait.until(ExpectedConditions.alertIsPresent());
   }
   public static void explicitlywaitVisibility(String xpath){
	   WebDriverWait wait=new WebDriverWait(Driver.driver,10);
		wait.until(ExpectedConditions.visibilityOf(Driver.driver.findElement(By.xpath(xpath))));
   }
}
