package Selenium.basictest;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class dryrun {

	@Test
	public void dry() throws IOException {
		String path = System.getProperty("user.dir") + "\\reports\\ippotest.html";
		String screenpath = System.getProperty("user.dir") + "\\path\\summa1.png";
		String webpath = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe";
		String filepath = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\testing.xlsx";
		FileInputStream fis = new FileInputStream(filepath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheetCount = workbook.getNumberOfSheets();
		

	}

}
