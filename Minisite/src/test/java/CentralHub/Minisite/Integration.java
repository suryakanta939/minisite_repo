package CentralHub.Minisite;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Integration {
	WebDriver driver;
	boolean flag;
  @Test
  public void slug() 
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
         /*read all the slug name*/
     
        List<WebElement> slug= driver.findElements(By.xpath("//table[@id='groupTable1']/tbody/tr/td[5]/button"));
        System.out.println(slug.size());
        for(int i=0;i<slug.size();i++){
        	   driver.findElement(By.xpath("//span[text()='Slug']")).click();
        	   
        	   List<WebElement> slname=driver.findElements(By.xpath("//table[@id='groupTable1']/tbody/tr/td[2]"));
        	   slname.get(i).click();
        	   List<WebElement> slug1= driver.findElements(By.xpath("//table[@id='groupTable1']/tbody/tr/td[5]/button"));
        	slug1.get(i).click();
        	 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        	String name=driver.findElement(By.xpath("//input[@id='group_name']")).getAttribute("value");
        	System.out.println("the slugname is "+name);
        		/*check all the slug name in dashboard*/
        		 driver.findElement(By.xpath("//span[text()='Dashboard']")).click();
        		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        		  driver.findElement(By.xpath("//button[@class='btn btn-primary pull-right']")).click();
        		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        		  /*check in slug select box*/
        		  Select slugcheck=new Select(driver.findElement(By.xpath("//select[@id='group_id']")));
        		  List<WebElement> ele=slugcheck.getOptions();
        		  for(int j=0;j<ele.size();j++){
        			  String name1=ele.get(j).getText();
        			  if(name1.equals(name)){
        				  System.out.println("the name that show in dashboard " +name1);
        				break;
        			  }
        			
        		  }
        }
           
        }
}
  

         
         
  

