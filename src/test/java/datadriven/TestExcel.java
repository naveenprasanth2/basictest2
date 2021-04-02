package datadriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestExcel {
	
	@Test(dataProvider="test")
	public void summa(String test, String test1)
	{
		System.out.println(test);
		System.out.println(test1+" summa");
	}
	
	
	
	
	
	
	
	@DataProvider(name="test")
	public Object[][] test() throws IOException {
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\testing.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		Object[][] list = new Object[1][2];
		int sheetcount = workbook.getNumberOfSheets();
		int columnvalue = 0;
		int rowvalue = 0;
		Iterator<Row> row = null;
		Iterator<Cell> cell = null;
		for (int i = 0; i < sheetcount; i++) {
			if (workbook.getSheetName(i).contains("Sheet1")) {
				XSSFSheet activesheet = workbook.getSheetAt(i);
				row = activesheet.iterator();
				int j = 0;
				Row expectedrow = row.next();
				cell = expectedrow.cellIterator();
				int k = 0;
				while (cell.hasNext()) {
					Cell intendedcell = cell.next();
					if (intendedcell.getStringCellValue().equalsIgnoreCase("testcases")) {
						columnvalue = k;
						rowvalue = j;
					}
					k++;
				}
				j++;
			}
		}
		while (row.hasNext()) {
			Row expectedrow1 = row.next();
			if (expectedrow1.getCell(columnvalue).getStringCellValue().contains("purchase")) {
				Iterator<Cell> intendedcell1 = expectedrow1.cellIterator();
				while (intendedcell1.hasNext()) {
					String result = intendedcell1.next().getStringCellValue();
					list[0][0] = result;
					list[0][1] = result;
				}
				break;
			}
		}
		return list;
	}

}
