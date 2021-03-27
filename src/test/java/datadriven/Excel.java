package datadriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;



public class Excel {
	int column;
	@Test
	public void test() throws IOException  {

		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\testing.xlsx");
		XSSFWorkbook workbook1 = new XSSFWorkbook(fis);
		int sheetcount = workbook1.getNumberOfSheets();
		for (int i = 0; i < sheetcount; i++) {
			if (workbook1.getSheetName(i).equalsIgnoreCase("sheet1")) {
				XSSFSheet sheet = workbook1.getSheetAt(i);
				Iterator<Row> iter = sheet.iterator();
				while (iter.hasNext()) {
					Row expectedrow = iter.next();
					Iterator<Cell> cell = expectedrow.cellIterator();
					int k=0;
					while (cell.hasNext()) {
						Cell intendedcell = cell.next();
						if (intendedcell.getStringCellValue().equalsIgnoreCase("data3")) {
							column = k;;
							break;
						}
						k++;
					}

				}
			}
System.out.println(column);
		}
		
	}

}
