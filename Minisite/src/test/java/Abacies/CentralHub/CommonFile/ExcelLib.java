package Abacies.CentralHub.CommonFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLib 
{
	public static String getExcelData(String name,int row,int col) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\ad\\Desktop\\New TestData\\testdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(name);
		Row rw=sh.getRow(row);
		String value=rw.getCell(col).getStringCellValue();
		return value;
	}

	public static Properties getPropertyData(String filename) throws IOException
     {
	FileInputStream fis=new FileInputStream("E:\\SELENIUM_PROGRAM\\Minisite\\src\\test\\java\\PageObjectRepository\\"+filename+".properties");
	Properties pro=new Properties();
	pro.load(fis);
	return pro;
     }
	
	public static Object[][] getExcelmultipleData(String filepath,String sheetname) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		
		FileInputStream fis=new FileInputStream(filepath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
		int rwno=sh.getLastRowNum();
		Object[][] arrayExcelData=new Object[rwno][2];
		for(int i=1;i<4;i++){
			Row cel=sh.getRow(i);
			for(int j=0;j<2;j++){
				String data =cel.getCell(j).getStringCellValue();
				arrayExcelData[i][j]=data;
			}
		
		}
		return arrayExcelData;
		
		
		
		
	}

}
