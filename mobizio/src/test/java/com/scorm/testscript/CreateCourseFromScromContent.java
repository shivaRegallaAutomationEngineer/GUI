package com.scorm.testscript;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.scorm.dataproviders.DataProviders;
import com.scorm.pages.AdministratorMenuPage;
import com.scorm.selenium.framework.BaseTest;
import com.scorm.selenium.framework.Configuration;
import com.scorm.selenium.framework.ExcelReadWrite;
import com.scorm.selenium.framework.Utilities;

public class CreateCourseFromScromContent extends BaseTest {
	AdministratorMenuPage administartorPage;
	ArrayList<String> coursefileNames = new ArrayList<String>();
	String course, courseName, lessonType, shortDescription, description, packageName, resource, code;

	@Factory(dataProvider = "Config", dataProviderClass = DataProviders.class)
	public CreateCourseFromScromContent(String browser) {
		super(browser);
		System.out.println(browser);
	}

	@Test(description = "Verify course Lesson")
	public void verifyCourseLesson() throws Exception {
		String random = Utilities.randomString(4);
		course = Configuration.readApplicationFile("course");
		lessonType = Configuration.readApplicationFile("LessonType");
		courseName = Configuration.readApplicationFile("CourseName");
		shortDescription = Configuration.readApplicationFile("ShortDescription");
		description = Configuration.readApplicationFile("Description");
		//resource = Configuration.readApplicationFile("Resource");
		code = Configuration.readApplicationFile("Code");
		//packageName = Configuration.readApplicationFile("PackageName");
		
		String alertMessege1=Configuration.readApplicationFile("CourseLessonAlertMessage");
		
		reportLog("Change appliation language to English");
		loginPage = loginPage.selectLanguage();

		reportLog("Login with user name " + userName + " and password " + password);
		dashBoardPage = loginPage.login(userName, password);

		reportLog("verify user login succesfully");
		dashBoardPage.verifyLoginSuccess();
		int totalRows= ExcelReadWrite.getNumberOfRows();
		for (int row=1;row<=totalRows;row++) {
			
			System.out.println("Loop Count:"+ Integer.toString(row));
			
			reportLog("Click on Administrator Tab");
			administartorPage = dashBoardPage.clickOnAdministartorMenu();
			
			reportLog("Click on Scorm Package Link");
			administartorPage = administartorPage.clickOnScormPackageLink();
			
			//Get Package name to be searched from excel 
			String packagename= ExcelReadWrite.getPackageNameFromExcel(row);
			String coursecode= ExcelReadWrite.getCourseCodeFromExcel(row);
			//intialize all course details values from excel
			reportLog("Search the SCorm package you want to import");
			administartorPage = administartorPage.searchCourse(packagename);
			
			reportLog("Click on Modify button");
			administartorPage = administartorPage.clickOnModifyButton();
			
			reportLog("Click on Import This package button");
			administartorPage = administartorPage.clickOnImportThisPackage();
			
			reportLog("Click on Close button");
			administartorPage = administartorPage.clickOnCloseButton();
			
			reportLog("Click on Administrator Tab");
			administartorPage = dashBoardPage.clickOnAdministartorMenu();
			
			reportLog("Click on Course Link");
			administartorPage = administartorPage.clickOnCourseLink();
			
			reportLog("Search the SCorm package you want to import");
			administartorPage = administartorPage.searchCourse(packagename);
			
			reportLog("Click on Modify button");
			administartorPage = administartorPage.clickOnModifyButton();
			
			reportLog("Click on Lessons");
			administartorPage = administartorPage.clickOnLessonLink();
			
			reportLog("Click on Modify button");
			administartorPage = administartorPage.clickOnModifyButton();
			
			//Get lesson details from excel
			String courseCode= ExcelReadWrite.getCourseCodeFromExcel(row);
			String coursename= ExcelReadWrite.getCourseNameFromExcel(row);
			String courseshortDesc= ExcelReadWrite.getCourseShortDescExcel(row);
			String courseLongDesc= ExcelReadWrite.getCourseLongDescExcel(row);
			String lessonname= ExcelReadWrite.getLessonNameFromExcel(row);
			String lessonshortDesc = ExcelReadWrite.getLessonShortDecFromExcel(row);
			String lessonwindowwidth = ExcelReadWrite.getLessonWidthFromExcel(row);
			String lessonwindowheight = ExcelReadWrite.getLessonHeightFromExcel(row);
			
			reportLog("Enter Lesson Details");
			administartorPage = administartorPage.fillLessonDetails(lessonname, lessonshortDesc, lessonwindowwidth, lessonwindowheight);
			
			reportLog("Click on save button");
			administartorPage = administartorPage.clickOnSavebutton();
			
			//reportLog("Verify Save lesson message");
			//Assert.assertTrue(administartorPage.verifySaveMessage());
			
			reportLog("Click on Last breadcum");
			administartorPage = administartorPage.clickOnLastBreadcumLink();
			
			if(packagename.contains("Training")){
				
				row++;
				
				String packagetoimport = packagename.replace("Training", "Test");
				lessonname= ExcelReadWrite.getLessonNameFromExcel(row);
				lessonshortDesc = ExcelReadWrite.getLessonShortDecFromExcel(row);
				lessonwindowwidth = ExcelReadWrite.getLessonWidthFromExcel(row);
				lessonwindowheight = ExcelReadWrite.getLessonHeightFromExcel(row);
				
				reportLog("Click on New Online Lesson");
				administartorPage = administartorPage.clickOnNewOnlineLessonLink();
				
				reportLog("Enter Lesson Details");
				administartorPage = administartorPage.fillLessonDetails(lessonname, lessonshortDesc, lessonwindowwidth, lessonwindowheight);
				
				reportLog("Select Package");
				administartorPage = administartorPage.selectPackage(packagetoimport);
				
				reportLog("Click on save button");
				administartorPage = administartorPage.clickOnSavebutton();
		
				//reportLog("Verify Save lesson message");
				//Assert.assertTrue(administartorPage.verifySaveMessage());
				
				reportLog("Click on Last breadcum");
				administartorPage = administartorPage.clickOnLastBreadcumLink();
				
			}
			administartorPage = administartorPage.clickOnLastBreadcumLink();
			
			//Get lesson details from excel
			
			//String courseName = ExcelReadWrite.getCourseNameFromExcel(row);
			//String courseShortDesc = ExcelReadWrite.getCourseShortDescExcel(row);
			
			reportLog("Enter Lesson Details");
			administartorPage = administartorPage.fillCourseDetails(courseCode, coursename, courseshortDesc, courseLongDesc);
	
			reportLog("Click on save button");
			administartorPage = administartorPage.clickOnSavebutton();
		}
		reportLog("Logout from application");
		loginPage = dashBoardPage.logOut();
		reportLog("Show alert message");
		administartorPage=administartorPage.showAlertMessge(alertMessege1);
	}
}
