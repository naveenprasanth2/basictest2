package datadriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestExcel {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\testing.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
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
					System.out.println(result);
				}
			}
		}
	}

}
