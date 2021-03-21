package datadriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Testingdata {

	@Test
	public void test() throws IOException {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		{
			FileInputStream file = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\resources\\testing.xlsx");
			XSSFWorkbook excel = new XSSFWorkbook(file);
			int sheets = excel.getNumberOfSheets();
			for (int i = 0; i < sheets; i++) {
				if (excel.getSheetName(i).equalsIgnoreCase("sheet1")) {
					XSSFSheet sheet = excel.getSheetAt(i);
					Iterator<Row> rows = sheet.iterator();
					Row first = rows.next();
					Iterator<Cell> cells = first.cellIterator();
					while (cells.hasNext()) {
						if (cells.next().getStringCellValue().equalsIgnoreCase("testcases")) {

						}

					}
				}
			}
		}

	}
}
