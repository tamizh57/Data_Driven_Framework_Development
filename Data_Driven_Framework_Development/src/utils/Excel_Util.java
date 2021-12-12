package utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import base.TestConfiguration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Excel_Util {
    public static XSSFWorkbook workbook;
    private static XSSFSheet sheet;
    private static XSSFCell cell;
    
    public static void setup_testdata()
    {
	   //creating workbook instance that refers to .xlsx file
    	System.out.println("excel setup");
        try {
			workbook=new XSSFWorkbook(new FileInputStream(TestConfiguration.getConfigProperty("testdata_path")));
       //creating a Sheet object
        System.out.println(TestConfiguration.getConfigProperty("testdata_path"));
        sheet=workbook.getSheet(TestConfiguration.getConfigProperty("testdata_sheetname"));
        	}
        catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
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
        if(cell.getCellType()==cell.CELL_TYPE_NUMERIC ||cell.getCellType()==cell.CELL_TYPE_BLANK)
        	return cell.getRawValue();
        else
        return cell.getStringCellValue();

           }

    public static int getRowCount()
    {
    	int rowcount = sheet.getLastRowNum()+1;
       return rowcount;
    }
    
    public static int getColCount(){
        int colcount = sheet.getRow(1).getLastCellNum();
        return colcount;
     }

    public static void setCellValue(int rowNum,int cellNum,String cellValue) throws IOException 
    {
    	//creating a new cell in row and setting value to it      
    	sheet.getRow(rowNum).getCell(cellNum).setCellValue(cellValue);
    }
    
    public static void writeexcel()
    {
    	try (FileOutputStream out=new FileOutputStream(TestConfiguration.getConfigProperty("testdata_path"))){
			
			workbook.write(out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static void printexcel()
    {
    	int index = 0;
    	for(int row=0;row<getRowCount();row++)
		{
			for(int col=0;col<getColCount();col++)
			{
				System.out.print(getCellValue(row, col)+" ");
			}			
			System.out.println();
			
			index++;
		}
    	
    }
    	
    
    
}