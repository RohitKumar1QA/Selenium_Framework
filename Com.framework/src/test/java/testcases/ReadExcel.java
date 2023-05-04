package testcases;

	import java.io.File;
    import java.io.FileInputStream;
    import java.io.FileNotFoundException;
    import java.util.Locale;
    
    import org.apache.poi.ss.usermodel.Cell;
    import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
    import org.apache.poi.xssf.usermodel.XSSFWorkbook;
    
    public class ReadExcel {
    
    public static void main(String[] args) throws Exception 
    {
     
        
      //Path of the excel file
        FileInputStream fs = new FileInputStream(".//TestData//Data.xlsx");
        //Creating a workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFSheet sheet1 = workbook.getSheet("Sheet1");
     
    /*    Row row = sheet.getRow(0);
        Cell cell = row.getCell(0); 
        System.out.println(sheet.getRow(0).getCell(0));
     
        Row row1 = sheet.getRow(1);
        Cell cell1 = row1.getCell(1);
        System.out.println(sheet.getRow(0).getCell(1));*/
      
        DataFormatter df =new DataFormatter();
 //   System.out.println(df.formatCellValue(sheet.getRow(1).getCell(1)));
        
        Row row2 = sheet.getRow(1);
        Cell cell2 = row2.getCell(1);
        System.out.println(sheet.getRow(1).getCell(0));
    
        Row row3 = sheet.getRow(1);
        Cell cell3 = row3.getCell(1);
        System.out.println(df.formatCellValue(sheet.getRow(1).getCell(1)));
      //  System.out.println(sheet.getRow(1).getCell(1));
        //String cellval = cell.getStringCellValue();
        //System.out.println(cellval);
        
        Row row4 =sheet.getRow(2);
        Cell cell4= row4.getCell(2);
        System.out.println(df.formatCellValue(sheet.getRow(2).getCell(0)));
        
        Row row5 =sheet.getRow(2);
        Cell cell5= row5.getCell(2);
        System.out.println(df.formatCellValue(sheet.getRow(2).getCell(1)));
        
        
      }
    }

