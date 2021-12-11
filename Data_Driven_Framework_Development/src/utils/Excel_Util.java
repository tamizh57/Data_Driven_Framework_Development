package utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import base.TestBase;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Excel_Util {
    public static XSSFWorkbook workbook;
    private static XSSFSheet sheet;
    private static XSSFCell cell;
  //problem exist here
   public static void setExcelFile(String sheetName) throws IOException {
       //Create an object of File class to open xls file
	   //creating workbook instance that refers to .xls file
       workbook=new XSSFWorkbook(new FileInputStream(TestBase.getConfigProperty("testdata_path")));
       //creating a Sheet object
        sheet=workbook.getSheet(sheetName);

   }
   
   public static void deleterow(int from,int to)
   {
	   for(int row=from;row<=to;row++)
	   {
		   sheet.removeRow(sheet.getRow(row));
	   }
   }

    public static String getCellValue(int rowNumber,int cellNumber){
       //getting the cell value from rowNumber and cell Number
        cell =sheet.getRow(rowNumber).getCell(cellNumber);
      //returning the cell value as string
        if(cell.getCellType()==cell.CELL_TYPE_NUMERIC)
        	return cell.getRawValue();
        else
        return cell.getStringCellValue();

           }

    public static int getRowCount(){
       int rowcount = sheet.getLastRowNum()+1;
       return rowcount;
    }
    
    public static  int getColCount(){
        int colcount = sheet.getRow(1).getLastCellNum();
        return colcount;
     }

    public static void setCellValue(int rowNum,int cellNum,String cellValue) throws IOException 
    {
    	//creating a new cell in row and setting value to it      
    	sheet.getRow(rowNum).getCell(cellNum).setCellValue(cellValue);
    }
    
    public static void printexcel()
    {
    	int index = 0;
    	for(int row=0;row<Excel_Util.getRowCount();row++)
		{
			for(int col=0;col<Excel_Util.getColCount();col++)
			{
				System.out.print(Excel_Util.getCellValue(row, col)+" ");
			}			
			System.out.println();
			
			index++;
		}
    	
    }
    	
    
    
}