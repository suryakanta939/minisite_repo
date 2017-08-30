package CentralHub.Minisite;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Functional {
	 WebDriver driver;
	 boolean flag;
	 String sn;
  @Test(priority=0)
  public void Slug()
  {
	   driver=new FirefoxDriver();
	  driver.get("https://tshirtbomb.herokuapp.com/?535460971e050720f1ba2b982e4966388212867b:20d99ea5935fe4f0:8UT2BR54jdYzyqqJeLJDmuYUUo0Ud5R6ws1oc77Mb2VLEWMNLm2Fz2lkpSVYsr1b");
	  driver.manage().window().maximize();
	  driver.findElement(By.xpath("//input[@id='username']")).sendKeys("lenin");
	  driver.findElement(By.id("password")).sendKeys("reset123");
       driver.findElement(By.id("login")).click();
         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
         
         /* click on acess apps */
         
         driver.findElement(By.xpath("//span[text()='Access Apps']")).click();
         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
         
         /*click on minisite*/
         WebDriverWait wait=new WebDriverWait(driver,20);
         wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(@href,'https://minisites.herokuapp.com')]"))));
         driver.findElement(By.xpath("//a[contains(@href,'https://minisites.herokuapp.com')]")).click();
         /*handel the window with*/
         Set<String> window=driver.getWindowHandles();
         Iterator<String> itr=window.iterator();
         String pid=itr.next();
         String cid=itr.next();
         driver.switchTo().window(cid);
         /*do functional testing on slug*/
         
         driver.findElement(By.xpath("//span[text()='Slug']")).click();
        	
         /*check the slug is created or not*/
         System.out.println("enter ur slug name");
         Scanner scn=new Scanner(System.in);
         sn=scn.nextLine();
             List<WebElement> slugs=driver.findElements(By.xpath("//table[@id='groupTable1']/tbody/tr/td[5]/button"));
             for(int i=0;i<slugs.size();i++){
            	 driver.findElement(By.xpath("//span[text()='Slug']")).click();
            //	 String slugName=slugs.get(i).getText();
            //	 Assert.assertEquals("  autotest (0)",slugName);
            	 
            	 List<WebElement> slname=driver.findElements(By.xpath("//table[@id='groupTable1']/tbody/tr/td[2]"));
          	   slname.get(i).click();
          	   List<WebElement> slug1= driver.findElements(By.xpath("//table[@id='groupTable1']/tbody/tr/td[5]/button"));
          	slug1.get(i).click();
          
          	 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
          	String name=driver.findElement(By.xpath("//input[@id='group_name']")).getAttribute("value");
            	if(sn.equals(name))
            	{
            	 System.out.println(name+"  is already present");
            	 break;	 
             }
            	 
             
         }
             driver.findElement(By.xpath("//span[text()='Slug']")).click();
        	 driver.findElement(By.xpath("//button[text()='ADD SLUG']")).click();
             /*start with positve value*/
             
             driver.findElement(By.xpath("//input[@id='group_name']")).sendKeys(sn);
             driver.findElement(By.xpath("//textarea[@id='description']")).sendKeys("weknknjknd");
             driver.findElement(By.xpath("//input[@id='mycolor']")).sendKeys("#2e0505");
             driver.findElement(By.xpath("//button[text()='Submit']")).click();
             
            /*wait till the slug is created*/
             WebDriverWait wait1=new WebDriverWait(driver,10);
             wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3")));
  
         
  /*check with duplicate value*/
         
         driver.findElement(By.xpath("//button[text()='ADD SLUG']")).click();
         driver.findElement(By.xpath("//input[@id='group_name']")).sendKeys("autotest");
         driver.findElement(By.xpath("//textarea[@id='description']")).sendKeys("weknknjknd");
         driver.findElement(By.xpath("//input[@id='mycolor']")).sendKeys("#2e0505");
         driver.findElement(By.xpath("//button[text()='Submit']")).click();
         
         WebDriverWait wait2=new WebDriverWait(driver,20);
         wait2.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h4[text()='Slug Already Exist']"))));
         
        String errormsg= driver.findElement(By.xpath("//h4[text()='Slug Already Exist']")).getText();
        Assert.assertEquals("Slug Already Exist", errormsg,"working fine");
         }
  
  @Test(priority=1,enabled=false)
  public void templatefunctional(){
	  
	  /*check the functionality of template*/
	  driver.findElement(By.xpath("//span[text()='Page Templates']")).click();
	  try{
		 List<WebElement> tempName=driver.findElements(By.xpath("//table[@id='templateTable']/tbody/tr/td[2]"));
		 for(int i=0;i<tempName.size();i++){
			 String name=tempName.get(i).getText();
			 System.out.println(name);
			 Assert.assertEquals("surya",name);
			 break;
		 }
	  }
	  catch(Throwable t){
		  /*create a template*/
		  System.out.println("checking");
		  driver.findElement(By.xpath("//button[text()='ADD TEMPLATE']")).click();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  driver.findElement(By.xpath("//input[@id='page_name']")).sendKeys("surya");
		  driver.findElement(By.xpath("//button[@id='addpagetemplate']")).click();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//		  /*wait for the visibilty of the elemnt and go back*/
//		  WebDriverWait visiblity=new WebDriverWait(driver,10); 
//		  visiblity.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//em[text()='Set the appearance of campaign page']"))));
		  driver.navigate().back();
	  }
  }
  @Test(priority=2,enabled=false)
  public void dashboardfunctionalNonPrimary(){
	  /*check the functionalit of dash board*/
	  driver.findElement(By.xpath("//span[text()='Dashboard']")).click();
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//button[@class='btn btn-primary pull-right']")).click();
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  /*test with positive value*/
	  driver.findElement(By.xpath("//input[@id='campaign_title']")).sendKeys("test auto");
	  /*select the domain name from the select box*/
	  Select sel=new Select(driver.findElement(By.xpath("//select[@id='domain_id']")));
	  sel.selectByVisibleText("shirtgen.in");
	  
	  /*select the slug*/
	  Select slug=new Select(driver.findElement(By.xpath("//select[@id='group_id']")));
	  slug.selectByVisibleText("autotest");
	  
	  /*select the template*/
	  
	  Select template=new Select(driver.findElement(By.xpath("//select[@id='template_id']")));
	  
	  template.selectByVisibleText("test");
	  
	  driver.findElement(By.xpath("//input[@name='input_url[]']")).sendKeys("https://teespring.com/grampsvet?utm_source=ts_homepage");
	  driver.findElement(By.xpath("//button[text()='+']")).click();
	  driver.findElement(By.xpath("//html/body/div[1]/div[2]/section/div/div[2]/div[2]/form/div[9]/div/input")).sendKeys("https://teespring.com/tachy?utm_source=ts_homepage");
	  
	  driver.findElement(By.xpath("//button[@id='addCampaignurl']")).click();
//	  
//	  WebDriverWait waiting=new WebDriverWait(driver,20);
//	  waiting.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h4[text()='Campaign added successfully']"))));
//	  
//	  String msg=driver.findElement(By.xpath("//h4[text()='Campaign added successfully']")).getText();
//	  System.out.println(msg);
	  String part1="//tr[td[text()='";
	  String part2="']]//a";
	  /*check the url*/
	  System.out.println("entr ur campaign name");
	  Scanner scn=new Scanner(System.in);
	  String campaignName=scn.nextLine();
	  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	  List<WebElement> camp=driver.findElements(By.xpath("//table[@id='campaignTable']/tbody/tr/td[2]"));
	  while(flag=true){
	  for(int i=0;i<camp.size();i++){
		  String campname=camp.get(i).getText();
		  System.out.println(campname);
		  if(campname.equals(campaignName)){
			  String url=driver.findElement(By.xpath(part1+campaignName+part2)).getAttribute("href");
			  System.out.println(url);
			  /*open a new tab*/
			  Actions act=new Actions(driver);
			  act.sendKeys(Keys.CONTROL+"t").perform();
			  act.sendKeys(Keys.chord(Keys.CONTROL,Keys.TAB)).perform();
		    	 String main1 = driver.getWindowHandle();
		         driver.switchTo().window(main1);
			  driver.get(url);
			  driver.findElement(By.xpath("//button[text()='More Info']")).click();
		  }
		 
	  }
	  break;
	  
  }
  }
  
}