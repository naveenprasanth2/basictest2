package datadriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Exceldata {
	WebDriver driver;
	@Test(dataProvider = "excel")
	
	public void exceldata(String first, String last) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("disable-infobars");
		WebDriver driver = new ChromeDriver();
		driver.get("http://google.com");
		driver.navigate().to(driver.getCurrentUrl()+"\\gmail");
		driver.findElement(By.name("q")).sendKeys(first);
		driver.findElement(By.name("q")).sendKeys(last);
	}

	@DataProvider(name="summa")
	
	public Object[][] data()
	{
		Object[][] testing = new Object[2][2];
		testing[0][0] = "naveen";
		testing[0][1] = "prasanth";
		testing[1][0] = "naveen1";
		testing[1][1] = "prasanth1";
		return testing;
	}
	
	@DataProvider(name="excel")
	public Object[][] excel() throws IOException
	{
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\testing.xlsx");
		XSSFWorkbook excel = new XSSFWorkbook(file);
		int sheets = excel.getNumberOfSheets();
		for(int i=0;i<sheets;i++)
		{
			if(excel.getSheetName(i).equalsIgnoreCase("sheet1")) {
				XSSFSheet sheet = excel.getSheetAt(i);
				Iterator<Row> rows = sheet.iterator();
				while(rows.hasNext()) {
					if(rows.next().getCell(1).getStringCellValue().contains("purchase")) {
						System.out.println("its working");
					}
				}
			}
		}
		return null;
	}
	@AfterTest
	public void after() {
		driver.quit();
	}
}
