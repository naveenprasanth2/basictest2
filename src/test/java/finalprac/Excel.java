package finalprac;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Excel {
	@Test
	public void test() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\testing.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int column = 0;
		int no_of_sheets = workbook.getNumberOfSheets();
		for(int i=0;i<no_of_sheets;i++) {
			if(workbook.getSheetAt(i).getSheetName().equalsIgnoreCase("Sheet1")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rows = sheet.iterator();
				Row row = rows.next();
				Iterator<Cell> cell = row.iterator();
				int k = 0;
				while(cell.hasNext()) {
					if(cell.next().getStringCellValue().equalsIgnoreCase("testcases")) {
						column = k;
					}
				}
				System.out.println(column);
			}
		}
	}

}
