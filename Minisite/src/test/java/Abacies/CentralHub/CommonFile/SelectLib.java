package Abacies.CentralHub.CommonFile;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
public class SelectLib
{
public static void selectByVisibleText(String name,String xpath){
	WebElement wb=Driver.driver.findElement(By.xpath(xpath));
	Select sel=new Select(wb);
	sel.selectByVisibleText(name);   
}
public static void selectByValue(String value,String xpath){
	WebElement wb=Driver.driver.findElement(By.xpath(xpath));
	Select sel=new Select(wb);
	sel.selectByValue(value);
}
public static void selectByIndex(int index,String xpath){
	WebElement wb=Driver.driver.findElement(By.xpath(xpath));
	Select sel=new Select(wb);
	sel.selectByIndex(index);
}
public static void dynamicBoxByName(String name,String xpath){
	WebElement wb=Driver.driver.findElement(By.xpath(xpath));
	Select sel=new Select(wb);
	List<WebElement> data=sel.getOptions();
	for(int i=0;i<data.size();i++)
	{
		if(data.get(i).getText().equals(name)){
			sel.selectByVisibleText(name);
		}
		else{
			System.out.println("name is not present");
		}
	}
}
public static void dynamicBoxByValue(String value,String xpath){
	WebElement wb=Driver.driver.findElement(By.xpath(xpath));
	Select sel=new Select(wb);
	List<WebElement> data=sel.getOptions();
	for(int i=0;i<data.size();i++){
		if(data.get(i).getText().equals(value)){
			sel.selectByValue(value);
		}
		else{
			System.out.println("value is not present");
		}
	}
}
}
