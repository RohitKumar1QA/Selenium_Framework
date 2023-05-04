package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;


public class ExcelDataProvider1 
{

	@DataProvider(name="LoginData")
	public String[][] getData() throws Exception
	{
		//creating excel file //
		File excelfile = new File(".//TestData//Data.xlsx");
		System.out.println(excelfile.exists());
		//read the Raw data//
		FileInputStream fis= new FileInputStream(excelfile);
		//Converting raw data into Excel format//
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheet("Login");
		int numberOfRows=sheet.getPhysicalNumberOfRows();
		int numberOfColumn=sheet.getRow(0).getLastCellNum();
		//	System.out.println(sheet.getLastRowNum());

		String[][] data =new String[numberOfRows-1][numberOfColumn];


		for(int i=0; i<numberOfRows-1;i++) 
		{
			for(int j=0;j<numberOfColumn;j++)
			{
				//create Instance then which cell value you want to specify//
				DataFormatter df = new DataFormatter();
				//if you want to use data separately so use data formatter. it will convert any type of data in String//
				data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
				//System.out.println(df.formatCellValue(sheet.getRow(i).getCell(j)));
				//System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
			}

		}
		//close the connection of workbook. Because it's memory leakage issues //
		workbook.close();
		fis.close();
		return data;


	}

}
