package io.testhubinua.ghost.util;



import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils1 {

	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	private static XSSFRow Row;

public static Object[][] getTableArray(String FilePath, String SheetName,int StartRow, int StartCol, int TotalCols) throws Exception {   

   String[][] tabArray = null;
   String[][] testCaseArray = null;

   try {

	   FileInputStream ExcelFile = new FileInputStream(FilePath);

	   // Access the required test data sheet

	   ExcelWBook = new XSSFWorkbook(ExcelFile);

	   ExcelWSheet = ExcelWBook.getSheet(SheetName);

	   int startRow = StartRow;

	   int startCol = StartCol;

	   int ci,cj;

	   int totalRows = ExcelWSheet.getLastRowNum();

	   // you can write a function as well to get Column count

	   int totalCols = TotalCols;

	   tabArray=new String[totalRows][totalCols];
	   testCaseArray=new String[totalRows][totalCols];
	   

	   ci=0;

	   for (int i=startRow;i<=totalRows;i++, ci++) {           	   

		  cj=0;

		   for (int j=startCol;j<=totalCols;j++, cj++){

			   tabArray[ci][cj]=getCellData(i,j);
			   testCaseArray[ci][cj]=getCellData(i,0);

			   System.out.print(testCaseArray[ci][cj] +"			"); 
			   System.out.print(tabArray[ci][cj]);
			   System.out.println(""); 

				}

			}

		}

	catch (FileNotFoundException e){

		System.out.println("Could not read the Excel sheet");

		e.printStackTrace();

		}

	catch (IOException e){

		System.out.println("Could not read the Excel sheet");

		e.printStackTrace();

		}

	return(tabArray);

	}

public static String getCellData(int RowNum, int ColNum) throws Exception {

	try{

		Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

		int dataType = Cell.getCellType();

		if  (dataType == 3) {

			return "";

		}else{

			String CellData = Cell.getStringCellValue();

			return CellData;

		} 
		}catch (Exception e){

		System.out.println(e.getMessage());

		throw (e);

		}

	}

}