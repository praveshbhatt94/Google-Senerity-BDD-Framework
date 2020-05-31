package ascend.ati.evaluation.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtil {
	
	static Sheet wrksheet;
    static Workbook wrkbook =null;
    static Hashtable dict= new Hashtable();
    
    public ExcelUtil(String ExcelSheetPath, String fileName, String sheetName) throws IOException 
    {
        
    	//Create an object of File class to open xlsx file

        File file =    new File(ExcelSheetPath+"\\"+fileName);
        //Create an object of FileInputStream class to read excel file

        FileInputStream inputStream = new FileInputStream(file);

      //Initialize
        //wrkbook = Workbook.getWorkbook(new File(ExcelSheetPath+"\\"+fileName));
      
        
      //Find the file extension by splitting file name in substring  and getting only extension name

        String fileExtensionName = fileName.substring(fileName.indexOf("."));

        //Check condition if the file is xlsx file

        if(fileExtensionName.equals(".xlsx")){

        //If it is xlsx file then create object of XSSFWorkbook class

        	wrkbook = new XSSFWorkbook(inputStream);
        	
        }

        //Check condition if the file is xls file

        else if(fileExtensionName.equals(".xls")){

            //If it is xls file then create object of HSSFWorkbook class

        	wrkbook = new HSSFWorkbook(inputStream);
        	
        }

        //Read sheet inside the workbook by its name

        wrksheet = wrkbook.getSheet(sheetName);
       
        //Call the Column Dictionary to store column Names
        ColumnDictionary();
    }
    
  //Returns the Number of Rows
    public static int RowCount()
    {
        return wrksheet.getLastRowNum()-wrksheet.getFirstRowNum();
    }
    
  //Returns the Cell value by taking row and Column values as argument
    private static String ReadCell(int column,int row)
    {
        return wrksheet.getRow(row).getCell(column).getStringCellValue().toString();
        
    }

    public static String ReadCell(String columnName, int rowNumber)
    {
    	return ReadCell(GetCell(columnName), rowNumber);
        
    }

    
    //Create Column Dictionary to hold all the Column Names
    private static void ColumnDictionary()
    {
        //Iterate through all the columns in the Excel sheet and store the value in Hashtable
    	for (int row=0; row<RowCount()+1; row++){
    		Row row1 = wrksheet.getRow(row);
    		
    		 for(int col=0;col <row1.getLastCellNum();col++)
    	        {
    	            dict.put(ReadCell(col,0), col);
    	        }
    		
    	}
       
    }

    //Read Column Names
    private static int GetCell(String colName)
    {
        try {
            int value;
            value = ((Integer) dict.get(colName)).intValue();
            return value;
        } catch (NullPointerException e) {
            return (0);

        }
    }

    


}
