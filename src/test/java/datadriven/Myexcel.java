package datadriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Myexcel {

	@Test
	public void test() throws IOException {
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\testing.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int column = 0;
		Iterator<Row> row = null;
		Iterator<Cell> cell = null;
		Iterator<Cell> cell1 = null;
		int sheetcount = workbook.getNumberOfSheets();
		for (int i = 0; i < sheetcount; i++) {
			if (workbook.getSheetAt(i).getSheetName().equals("Sheet1")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				row = sheet.iterator();
				Row activerow = row.next();
				cell = activerow.iterator();
				int k = 0;
				while (cell.hasNext()) {
					String value = cell.next().getStringCellValue();
					if (value.equalsIgnoreCase("testcases")) {
						column = k;
					}
					k++;
				}

			}
		}
		while (row.hasNext()) {
			Row activerow1 = row.next();
			if (activerow1.getCell(column).getStringCellValue().equalsIgnoreCase("purchase")) {
				cell1 = activerow1.iterator();
				while (cell1.hasNext()) {
					Cell c = cell1.next();
					if (c.getCellType() == CellType.STRING) {
						String test = c.getStringCellValue();
						System.out.println(test);
					} else {
						double test = c.getNumericCellValue();
						System.out.println(String.valueOf(test));
					}
				}
				break;
			}
		}
		fis.close();
	}

}
