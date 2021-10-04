package datadriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelcode {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Iterator<Row> rows = null;
		int column = 0;
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\testing.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int activesheets = workbook.getNumberOfSheets();
		for (int i = 0; i < activesheets; i++) {
			if (workbook.getSheetAt(i).getSheetName().equalsIgnoreCase("Sheet1"))
				;
			XSSFSheet sheet = workbook.getSheetAt(i);
			rows = sheet.iterator();
			Row row = rows.next();
			Iterator<Cell> cells = row.iterator();
			int k = 0;
			while (cells.hasNext()) {
				Cell cell = cells.next();
				if (cell.getStringCellValue().contains("Testcases")) {
					column = k;
				}
			}
			k++;
		}

		while (rows.hasNext()) {
			Row row = rows.next();
			if (row.getCell(column).getStringCellValue().equalsIgnoreCase("purchase")) {
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
		fis.close();
	}
}
