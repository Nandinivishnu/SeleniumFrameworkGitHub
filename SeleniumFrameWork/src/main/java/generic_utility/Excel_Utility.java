package generic_utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {
	/**
	 * used to fetch data from excel sheet
	 * 
	 * @param sheet
	 * @param rowNum
	 * @param rowNum
	 * @return
	 * @throws throwable
	 * @author nandini
	 * 
	 * 
	 */

	public String getExcelData(String sheetName, int rowNum, int cellNum) throws Throwable {

		FileInputStream fes = new FileInputStream("./src/test/resources/ExcelData.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String value = cell.getStringCellValue();
		return value;

	}
	
	public String getExcelDataFormatter(String sheetName, int rowNum, int cellNum) throws Throwable {
		FileInputStream fes = new FileInputStream("./src/test/resources/ExcelData.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		DataFormatter format=new DataFormatter();
		String data = format.formatCellValue(book.getSheet(sheetName).getRow(rowNum).getCell(cellNum));
		return data;
		
	}

	public Object[][] getDataProviderData(String sheetname) throws Throwable {
		FileInputStream fes=new FileInputStream("./src/test/resources/ExcelData.xlsx");
		Workbook book=WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet(sheetname);
		 int lastRow = sheet.getLastRowNum()+1;
		int lastCell = sheet.getRow(0).getLastCellNum();
		
	//	Sheet sheet = book.getSheet(sheetname);
		// int lastRow = sheet.getPhysicalNumberOfRows();
	//	int lastCell = sheet.getRow(0).getLastCellNum();
		
		Object[][] objarr=new Object[lastRow][lastCell];
		{
			for(int i=0;i<lastRow;i++) {
				for(int j=0;j<lastCell;j++) {
					objarr[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
					
				}
			}
			return objarr;
	
	
	}
	}
	
}
