package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ReadXls {
	
	
	static Workbook wkbook;
	static Sheet wksheet;

	public static Object[][] getExcelData(String excelpath,String sheetName) throws InvalidFormatException {
		FileInputStream file = null;
		
		try {
			file = new FileInputStream(excelpath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			//Creates the appropriate HSSFWorkbook / XSSFWorkbook from the given File
			wkbook = WorkbookFactory.create(file);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		wksheet = wkbook.getSheet(sheetName);
		
		
		Object[][] celldata = new Object[wksheet.getLastRowNum()][wksheet.getRow(0).getLastCellNum()];
		
		for (int i = 0; i < wksheet.getLastRowNum(); i++) {
			for (int k = 0; k < wksheet.getRow(0).getLastCellNum(); k++) {
				Cell cell =wksheet.getRow(i + 1).getCell(k);
				cell.setCellType(CellType.STRING);
				celldata[i][k] = cell.getStringCellValue();
			}
		}
		return celldata;
	}
}
