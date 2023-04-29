package KotakTstNGFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelDataProvider {
	
	@DataProvider(name="URLData")
	public String[][] getData() throws IOException 
	{
		File excelfile =new File(".//Data.xlsx");
		System.out.println(excelfile.exists());
		//Read the Raw data//
		FileInputStream fis = new FileInputStream(excelfile);
		//Converting Raw data into Excel Format//
		XSSFWorkbook workbook= new XSSFWorkbook(fis);
		
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int numberOfRows= sheet.getPhysicalNumberOfRows();
		int numberOfColumn= sheet.getRow(0).getLastCellNum();
		
		//String array type 2- dimensional Array//
		String[][]  data=new String[numberOfRows-1][numberOfColumn];
		
		for(int i=0; i<numberOfRows-1;i++)
		{
			for(int j=0;j<numberOfColumn;j++)
			{
				//create Instance then which cell value you want to spcify//
				DataFormatter df =new DataFormatter();
				
				//if you want to use data seperately so use data formatter.it will convert any type data into String value//
				data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
			}
		}
		
		//close the connection of workbook.if you does not close then Memory leakage issues//
		workbook.close();
		fis.close();
		return data;
	}

}
