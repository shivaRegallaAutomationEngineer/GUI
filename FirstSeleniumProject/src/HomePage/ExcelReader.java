package HomePage;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelReader {

	public static void main(String[] args) throws Exception, IOException {

		
		File srcfile= new File("C:\\Users\\SRINIVAS\\Desktop\\Data1.xls");
		System.out.println("Excel file got loaded successfully");
		
		Workbook wb= Workbook.getWorkbook(srcfile);
		Sheet sh =wb.getSheet(0);
		//total number of rows availbe in sheet
		int totalrows=sh.getRows();
		System.out.println("Total number of rows in excel---->: " +totalrows);
		int totalColum= sh.getColumns();
		System.out.println("Total number of columns in excel----->: "+totalColum);
		
		//
		for(int row=0;row<totalrows;row++){
			//System.out.println("Rows value in the Excel sheet: "+row);
			for(int column=0;column<totalColum;column++){
				
				String data=sh.getCell(column,row).getContents();
				System.out.println("Test data in excel sheet:--->" +data);
			}
			
		}
		

	}

}
