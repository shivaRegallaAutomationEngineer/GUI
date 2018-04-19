package com.scorm.selenium.framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookType;

public class ExcelReadWrite {

	public static ArrayList getValueFromExcel() throws IOException {
		String excelFilePath = BaseTest.getPath() + "//src//test//resources//testdata//PackageFileName.xlsx";
		ArrayList al = new ArrayList();
		int totalColumns;
		Row row;
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		int totalRows = sheet.getLastRowNum();
		for (int i = 1; i <= totalRows; i++) {
			row = sheet.getRow(i);
			totalColumns = row.getLastCellNum();

			for (int y = 0; y < totalColumns; y++) {
				al.add(row.getCell(y).getStringCellValue());
			}
		}
		return al;
	}
	
	public static int getNumberOfRows() throws IOException {
		String excelFilePath = BaseTest.getPath() + "//src//test//resources//testdata//CourseDataTemplate.xlsx";
		Row row;
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		int totalRows = sheet.getLastRowNum();
		return totalRows;
	}
	
	
	public static String getPackageNameFromExcel(int rownum) throws IOException {
		String excelFilePath = BaseTest.getPath() + "//src//test//resources//testdata//CourseDataTemplate.xlsx";
		Row row;
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		row= sheet.getRow(rownum);
		
		String packagename= row.getCell(0).getStringCellValue();
			
		return packagename;
	}
	
	public static String getCourseNameFromExcel(int rownum) throws IOException {
		String excelFilePath = BaseTest.getPath() + "//src//test//resources//testdata//CourseDataTemplate.xlsx";
		Row row;
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		row= sheet.getRow(rownum);
		
		String coursename= row.getCell(2).getStringCellValue();
			
		return coursename;
	}
	
	public static String getLessonNameFromExcel(int rownum) throws IOException {
		String excelFilePath = BaseTest.getPath() + "//src//test//resources//testdata//CourseDataTemplate.xlsx";
		Row row;
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		row= sheet.getRow(rownum);
		
		String lessonname= row.getCell(5).getStringCellValue();
			
		return lessonname;
	}
	
	public static String getLessonShortDecFromExcel(int rownum) throws IOException {
		String excelFilePath = BaseTest.getPath() + "//src//test//resources//testdata//CourseDataTemplate.xlsx";
		Row row;
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		row= sheet.getRow(rownum);
		
		String lessonshortdesc= row.getCell(6).getStringCellValue();
			
		return lessonshortdesc;
	}
	
	public static String getLessonWidthFromExcel(int rownum) throws IOException {
		String excelFilePath = BaseTest.getPath() + "//src//test//resources//testdata//CourseDataTemplate.xlsx";
		Row row;
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		row= sheet.getRow(rownum);
		Cell cell =  row.getCell(8);
		String lessonwidth1= String.valueOf(cell.getNumericCellValue());
		//System.out.println(lessonwidth);
		
		String[] lessonwidth = lessonwidth1.split("\\.");
		//double lessonwidth1= row.getCell(8).getNumericCellValue();
		//int lessonwidth2 = (int) lessonwidth1;
		//String lessonwidth= Double.toString(lessonwidth2);
			
		return lessonwidth[0];
	}
	
	public static String getLessonHeightFromExcel(int rownum) throws IOException, ArrayIndexOutOfBoundsException {
		String excelFilePath = BaseTest.getPath() + "//src//test//resources//testdata//CourseDataTemplate.xlsx";
		Row row;
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		row= sheet.getRow(rownum);
		
		Cell cell =  row.getCell(9);
		String lessonhieght1= String.valueOf(cell.getNumericCellValue());
		System.out.println(lessonhieght1);
		String[] lessonhieght2 = lessonhieght1.split("\\.");
		String lessonhieght = lessonhieght2[0];
		System.out.println(lessonhieght);
		//double lessonhieght1= row.getCell(9).getNumericCellValue();
		//int lessonhieght2 = (int) lessonhieght1;	
		//String lessonhieght= Double.toString(lessonhieght2);
				
		return lessonhieght;
	}
	
	public static String getCourseCodeFromExcel(int rownum) throws IOException {
		String excelFilePath = BaseTest.getPath() + "//src//test//resources//testdata//CourseDataTemplate.xlsx";
		Row row;
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		row= sheet.getRow(rownum);
		
		String coursecode= row.getCell(1).getStringCellValue();
			
		return coursecode;
	}
	
	public static String getCourseShortDescExcel(int rownum) throws IOException {
		String excelFilePath = BaseTest.getPath() + "//src//test//resources//testdata//CourseDataTemplate.xlsx";
		Row row;
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		row= sheet.getRow(rownum);
		
		String courseshorddesc= row.getCell(3).getStringCellValue();
			
		return courseshorddesc;
	}
	
	public static String getCourseLongDescExcel(int rownum) throws IOException {
		String excelFilePath = BaseTest.getPath() + "//src//test//resources//testdata//CourseDataTemplate.xlsx";
		Row row;
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		row= sheet.getRow(rownum);
		
		String courselongdesc= row.getCell(4).getStringCellValue();
			
		return courselongdesc;
	}

	public static void deleteFile() {
		try {

			File file = new File(BaseTest.getPath() + "//src//test//resources//testdata//Result.xlsx");

			if (file.delete()) {
				System.out.println(file.getName() + " is deleted!");
			} else {
				System.out.println("File not exist.");
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	public static void createExcelFile() {
		try {
			String filename = BaseTest.getPath() + "//src//test//resources//testdata//Result.xlsx";
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("Result");
			
			FileOutputStream fileOut = new FileOutputStream(filename);
			workbook.write(fileOut);
			fileOut.close();
			System.out.println("file created");
		} catch (Exception e) {

			e.printStackTrace();

		}
	}
	
	public static void setValueInExcel(String moduleName, String status) throws IOException {
		try {
			File fileName = new File(BaseTest.getPath() + "//src//test//resources//testdata//Result.xlsx");
			
			FileInputStream ExcelFile = new FileInputStream(fileName);
            XSSFWorkbook workbook = new XSSFWorkbook(ExcelFile);
            XSSFSheet sheet = workbook.getSheet("Result");
            XSSFRow row = sheet.createRow(0);
            row.createCell(0).setCellValue("Module Name");
            row.createCell(1).setCellValue("Status");
            int lastRow= sheet.getLastRowNum();
            XSSFRow rowhead = sheet.createRow(lastRow+1);
            rowhead.createCell(0).setCellValue(moduleName);
            rowhead.createCell(1).setCellValue(status);
            FileOutputStream fileOut = new FileOutputStream(fileName);
            workbook.write(fileOut);
            fileOut.close();
	} catch (Exception e) {

		e.printStackTrace();

	}

	}

}
