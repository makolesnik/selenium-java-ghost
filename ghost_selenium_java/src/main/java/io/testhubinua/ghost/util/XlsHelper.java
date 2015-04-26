package io.testhubinua.ghost.util;

import java.io.File;

import jxl.Sheet;
import jxl.Workbook;

public class XlsHelper {



	    // Excel API to read test data from excel workbook
		
	    public String[][] getExcelData(String xlPath, String shtName) throws Exception {
	   	 String[][] tabArray = null;
		    //Workbook workbook;
		    //Sheet sheet;
		    int rowCount, colCount;
		    
	        Workbook workbook = Workbook.getWorkbook(new File(xlPath));
	        Sheet sheet = workbook.getSheet(shtName);
	        rowCount = sheet.getRows();
	        colCount = sheet.getColumns();
	        tabArray = new String[rowCount][colCount - 2];
	        System.out.println("erow: " + rowCount);
	        System.out.println("ecol: " + colCount);
	        for (int i = 1; i < rowCount; i++) {
	            for (int j = 0; j < colCount; j++) {
	                tabArray[i][j] = sheet.getCell(j, i).getContents();
	            }
	        }
	        return (tabArray);
	    }
	
}
