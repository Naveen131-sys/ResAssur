package APIII_Testng_Project_Resting_Assurance.APIII_Testng_Project_Resting_Assurance;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelllllingUtils {
	
	File file;
	FileInputStream fis;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFRow row;
	
	
	public int GetRowCount(String path,String Sheetname) throws IOException {
		file=new File(path);
		fis=new FileInputStream(file);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet(Sheetname);
		int rows=sheet.getLastRowNum();
		
		return rows;
		
		
		
	}
	
	public int GetColumnCount(String path,String Sheetname,int rownum) throws IOException {
		file=new File(path);
		fis=new FileInputStream(file);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet(Sheetname);
		row=sheet.getRow(rownum);
		int column=row.getLastCellNum();
		
		return column;
		
		
		
	}
	
	
	public String GetData(String path,String Sheetname,int rows,int columns) throws IOException {
		
		file=new File(path);
		fis=new FileInputStream(file);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet(Sheetname);
		
		String data=sheet.getRow(rows).getCell(columns).getStringCellValue();
				
		return data;

		
		
		
	}

}
