package com.generic.FileUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String getDataFromExcel(String sheetName,int rownum,int cellnum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/vtiger_org_contact_testcase.xlsx");
	    Workbook wb= WorkbookFactory.create(fis);
	    String data = wb.getSheet(sheetName).getRow(rownum).getCell(cellnum).toString();
		return data;
	}
	
	public int getLastRowNum(String SheetName) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/vtiger_org_contact_testcase.xlsx");
        Workbook wb=WorkbookFactory.create(fis);
        int lastrow=wb.getSheet(SheetName).getLastRowNum();
        return lastrow;
	}
	
	public void writeDataIntoExcel(String sheetname,int rownum,int cellnum,String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/vtiger_org_contact_testcase.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		    Cell cell =wb.getSheet(sheetname).getRow(rownum).createCell(cellnum);
		    cell.setCellValue(data);
		     
		             
		FileOutputStream fos=new FileOutputStream("./src/test/resources/vtiger_org_contact_testcase.xlsx");
		                      wb.write(fos);
		                 wb.close();
	}
}
