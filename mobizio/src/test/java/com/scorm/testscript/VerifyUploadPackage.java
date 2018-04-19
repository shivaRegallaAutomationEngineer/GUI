package com.scorm.testscript;

import java.util.ArrayList;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.scorm.dataproviders.DataProviders;
import com.scorm.pages.AdministratorMenuPage;
import com.scorm.selenium.framework.BaseTest;
import com.scorm.selenium.framework.Configuration;
import com.scorm.selenium.framework.ExcelReadWrite;

public class VerifyUploadPackage extends BaseTest {
	AdministratorMenuPage administartorPage;
	ArrayList<String> fileNames = new ArrayList<String>();

	@Factory(dataProvider = "Config", dataProviderClass = DataProviders.class)
	public VerifyUploadPackage(String browser) {
		super(browser);
		System.out.println(browser);
	}

	@Test(description = "Upload zip package and verify uploaded package")
	public void uploadPackage() throws Exception {
		ExcelReadWrite.deleteFile();
		ExcelReadWrite.createExcelFile();
		String alertMessege=Configuration.readApplicationFile("FileUploadAlertMessage");
		reportLog("Change appliation language to English");
		loginPage = loginPage.selectLanguage();

		reportLog("Login with user name " + userName + " and password " + password);
		dashBoardPage = loginPage.login(userName, password);

		reportLog("verify user login succesfully");
		dashBoardPage.verifyLoginSuccess();
		

		reportLog("Click on Administrator Tab");
		administartorPage = dashBoardPage.clickOnAdministartorMenu();
		//administartorPage.showAlertMessge("hi");

		reportLog("Click on Scorm Package Link");
		administartorPage = administartorPage.clickOnScormPackageLink();

		fileNames = ExcelReadWrite.getValueFromExcel();
		for (String file : fileNames) {
			reportLog("Click on upload package image");
			administartorPage = administartorPage.clickOnUploadPackage();

			reportLog("Click on choose file button");
			administartorPage = administartorPage.clickOnChooseFileButton();

			reportLog("Choose file");
			administartorPage = administartorPage.uploadPackage(file);

			reportLog("Click on upload button");
			administartorPage = administartorPage.clickOnUploadButton();
			
			String status = administartorPage.checkStatus(file);
			
			if(status.contains("File Not Found")){
				reportLog("File: "+file +" Not found in drive" );
			}
			
			//boolean status= administartorPage.checkForfailure();
			
		/*	if(status.contains("File Not Found")){
				reportLog("Click on upload package image");
				administartorPage = administartorPage.clickOnUploadPackage();

				reportLog("Click on choose file button");
				administartorPage = administartorPage.clickOnChooseFileButton();

				reportLog("Choose file");
				administartorPage = administartorPage.uploadPackage(file);

				reportLog("Click on upload button");
				administartorPage = administartorPage.clickOnUploadButton();
			}*/

			//reportLog("Verify upload file");
			//administartorPage.checkStatus(file);
			
		}
		
		reportLog("Show alert message");
		administartorPage=administartorPage.showAlertMessge(alertMessege);
		reportLog("Logout from application");
		loginPage = dashBoardPage.logOut();
	}
}
