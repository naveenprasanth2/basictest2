package datadriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Excel {
	int column;

	@Test
	public void test() throws IOException {

		Iterator<Row> rows = null;
		int column = 0;
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\testing.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int noofsheets = workbook.getNumberOfSheets();
		for (int i = 0; i < noofsheets; i++) {
			if (workbook.getSheetAt(i).getSheetName().equalsIgnoreCase("sheet1")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				rows = sheet.iterator();
				Row row = rows.next();
				Iterator<Cell> cells = row.iterator();
				int k = 0;
				while (cells.hasNext()) {
					Cell cell = cells.next();
					if (cell.getStringCellValue().equalsIgnoreCase("testcases")) {
						column = k;
					}
					k++;
				}
			}
		}

		System.out.println(column);
		while (rows.hasNext()) {
			Row row = rows.next();
			if (row.getCell(column).getStringCellValue().contains("purchase")) {
				Iterator<Cell> cells = row.iterator();
				while (cells.hasNext()) {
					Cell cell = cells.next();
					if (cell.getCellType() == CellType.STRING) {
						System.out.println(cell.getStringCellValue());
					} else {
						System.out.println(cell.getNumericCellValue());
					}
				}
				break;
			}
		}
	}

}
