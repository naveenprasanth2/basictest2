package lastprac;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelNotepad {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Iterator<Row> rows = null;
		int column = 0;
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\testing.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheetcount = workbook.getNumberOfSheets();
		for (int i = 0; i < sheetcount; i++) {
			if (workbook.getSheetAt(i).getSheetName().equalsIgnoreCase("sheet1")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				rows = sheet.iterator();
				Row row = rows.next();
				int k = 0;
				Iterator<Cell> cell = row.iterator();
				while (cell.hasNext()) {
					Cell intendedcell = cell.next();
					if (intendedcell.getStringCellValue().equalsIgnoreCase("testcases")) {
						column = k;
					}
				}
				k++;
			}

			while (rows.hasNext()) {
				Row row = rows.next();
				if (row.getCell(column).getStringCellValue().contains("purchase")) {
					Iterator<Cell> cell = row.iterator();
					while (cell.hasNext()) {
						Cell intendedcell = cell.next();
						if (intendedcell.getCellType() == CellType.STRING) {
							System.out.println(intendedcell.getStringCellValue());
						} else {
							System.out.println(intendedcell.getNumericCellValue());
						}
					}
					break;
				}
			}
		}

	}
}