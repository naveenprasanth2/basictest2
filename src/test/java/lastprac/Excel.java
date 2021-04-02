package lastprac;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int column = 1;
		Iterator<Row> rows = null;
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\testing.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheetcount = workbook.getNumberOfSheets();
		for (int i = 0; i < sheetcount; i++) {
			if (workbook.getSheetAt(i).getSheetName().equalsIgnoreCase("sheet1")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				rows = sheet.iterator();
				Row intendedrow = rows.next();
				Iterator<Cell> cells = intendedrow.iterator();
				int k = 0;
				while (cells.hasNext()) {
					if (cells.next().getStringCellValue().equalsIgnoreCase("TestCases")) {
						column = k;
					}
					k++;
				}
			}
			while(rows.hasNext()) {
				Row intendedrow = rows.next();
				if(intendedrow.getCell(column).getStringCellValue().contains("purchase")) {
					Iterator<Cell> cell = intendedrow.iterator();
					while(cell.hasNext()) {
						Cell c = cell.next();
						if(c.getCellType()==CellType.STRING) {
							System.out.println(c.getStringCellValue());
						}
						else {
							System.out.println(c.getNumericCellValue());
						}
					}
					break;
				}
			}
		}
		fis.close();
	}
}
