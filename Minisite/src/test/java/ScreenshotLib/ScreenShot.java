package ScreenshotLib;

import java.io.File;
import java.io.IOException;



import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import Abacies.CentralHub.CommonFile.Driver;

public class ScreenShot 
{
	public static void takeASnap(String filename) throws IOException{
		EventFiringWebDriver eDriver=new EventFiringWebDriver(Driver.driver);
		File srcfile=eDriver.getScreenshotAs(OutputType.FILE);
		File dstfile=new File("E:\\SELENIUM_PROGRAM\\CentralHub\\ScreenShot\\"+filename+".png");
		FileUtils.copyFile(srcfile, dstfile);
	}

}
