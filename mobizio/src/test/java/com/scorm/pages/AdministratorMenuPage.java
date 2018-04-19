package com.scorm.pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.gargoylesoftware.htmlunit.javascript.host.media.webkitAudioContext;
import com.scorm.selenium.framework.BasePage;
import com.scorm.selenium.framework.BaseTest;
import com.scorm.selenium.framework.Configuration;
import com.scorm.selenium.framework.ExcelReadWrite;

public class AdministratorMenuPage extends BasePage {

	@FindBy(xpath = "//a[text()='SCORM Packages']")
	private WebElement link_Package;

	@FindBy(xpath = "(//a[@onclick='doUpload();'])[1]")
	private WebElement img_UploadPackage;

	@FindBy(xpath = "//input[@id='file']")
	private WebElement tb_ChooseFile;

	@FindBy(xpath = "//input[@id='btnUpload']")
	private WebElement bt_Upload;

	@FindBy(xpath = "//iframe[@class='fancybox-iframe']")
	private WebElement iFrame_ChooseFile;

	@FindBy(xpath = "//input[@id='search']")
	private WebElement tb_Search;

	@FindBy(xpath = "//input[@id='btnSearch']")
	private WebElement btn_Search;

	@FindBy(xpath = "//img[@title='Modify']/..")
	private WebElement link_Modify;

	@FindBy(xpath = "(//a[@onclick='doImport();'])[1]")
	private WebElement img_Import;

	@FindBy(xpath = "//input[@id='btnClose']")
	private WebElement btn_Close;

	@FindBy(xpath = "//a[text()='Courses']")
	private WebElement course;

	@FindBy(xpath = "//img[contains(@src,'lesson')]/..")
	private WebElement link_Lesson;

	@FindBy(xpath = "//input[@id='name']")
	private WebElement tb_Name;

	@FindBy(xpath = "//select[@id='lessontype']")
	private WebElement dd_LessonType;

	@FindBy(xpath = "//textarea[@id='shortDescription']")
	private WebElement text_sortDescription;
	
	@FindBy(xpath = "//input[@id='width']")
	private WebElement text_width;
	
	@FindBy(xpath = "//input[@id='height']")
	private WebElement text_height;

	@FindBy(xpath = "//input[@value='Save Changes']")
	private WebElement btn_Save;

	@FindBy(xpath = "//span[@class='description']")
	private WebElement msg_Save;

	@FindBy(xpath = "//a[contains(@href,'lessons')]")
	private WebElement lnk_Lesson;

	@FindBy(xpath = "//img[contains(@src,'lesson')]/../../a")
	private WebElement img_NewLesson;

	@FindBy(xpath = "//input[@id='btnSelectPackage']")
	private WebElement btn_SelectPackage;

	@FindBy(xpath = "//select[@id='pid']")
	private WebElement dd_SelectPackage;

	@FindBy(xpath = "//select[@id='rid']")
	private WebElement dd_SelectResource;

	@FindBy(xpath = "//input[@id='btnOK']")
	private WebElement btn_OK;

	@FindBy(xpath = "//table[@id='grid_admin_lessons']/tbody/tr/td/label")
	private List<WebElement> lessonNames;

	@FindBy(xpath = "//div[@id='breadCrumb']/a")
	private List<WebElement> breadcrumb;

	@FindBy(xpath = "//a[text()='New Online Lesson']/../..//a")
	private WebElement newOnlineLesson;

	@FindBy(xpath = "//input[@id='code']")
	private WebElement tb_Code;

	String fileStatus = "//div[@id='status' and contains(text(),'Please wait.')]";

	String failedStatus = "//span[@id='pageTitle' and text()='Failed']";
	String backbutton = "//input[@value='Back']";

	@FindBy(xpath = "//input[@id='btnCancel']")
	private WebElement btn_Cancel;
	
	@FindBy(xpath = "//iframe[@id='description_ifr']")
	private WebElement iFrame_Description;
	
	@FindBy(xpath = "//textarea[@id='shortDescription']")
	private WebElement tb_Description;
	
	@FindBy(xpath = "//textarea[@id='shortDescription']")
	private WebElement tb_longDescription;
	

	public AdministratorMenuPage(WebDriver driver) {
		super(driver);

	}

	public AdministratorMenuPage clickOnUploadPackage() {
		waitForElement(img_UploadPackage);
		hoverOverElementAndClick(img_UploadPackage, img_UploadPackage);
		return PageFactory.initElements(driver, AdministratorMenuPage.class);
	}

	public AdministratorMenuPage clickOnScormPackageLink() {
		waitForElement(link_Package);
		clickOn(link_Package);
		return PageFactory.initElements(driver, AdministratorMenuPage.class);
	}

	public AdministratorMenuPage clickOnCourseLink() {
		waitForElement(course);
		clickOn(course);
		return PageFactory.initElements(driver, AdministratorMenuPage.class);
	}

	public AdministratorMenuPage clickOnChooseFileButton() {
		switchToFrame(iFrame_ChooseFile);
		clickOn(tb_ChooseFile);
		return PageFactory.initElements(driver, AdministratorMenuPage.class);
	}

	public AdministratorMenuPage uploadPackage(String packageName) throws Exception {
		String path = Configuration.readApplicationFile("DrivePath") + packageName + ".zip";
		Screen sc = new Screen();
		Pattern image1 = new Pattern(BaseTest.getPath() + "//src//test//resources//testdata//textbar.PNG");
		sc.type(image1, path);
		Pattern image2 = new Pattern(BaseTest.getPath() + "//src//test//resources//testdata//openButton.PNG");
		sc.click(image2);
		return PageFactory.initElements(driver, AdministratorMenuPage.class);
	}

	public boolean checkForfailure(){
		boolean status =false;
		switchToFrame(iFrame_ChooseFile);
		if(isElementPresent(backbutton))
		{
			clickOn(backbutton);
			switchToFrame(iFrame_ChooseFile);
			waitForElement(btn_Cancel);
			clickOn(btn_Cancel);
			status= true;
		}
		return status;
		
	}
	
	public String checkStatus(String packageName) throws Exception {
		int i = 1;
		String status = "Fail";
		Screen sc = new Screen();
		Pattern fileNotFound = new Pattern(BaseTest.getPath() + "//src//test//resources//testdata//FileNotFoundException.PNG");
		if (sc.exists(fileNotFound) != null) {
			System.out.println("In if block check status");
			Pattern okButton = new Pattern(BaseTest.getPath() + "//src//test//resources//testdata//OK_Button.PNG");
			sc.click(okButton);
			Pattern cancelButton = new Pattern(
					BaseTest.getPath() + "//src//test//resources//testdata//CancelButton.PNG");
			sc.click(cancelButton);
			switchToFrame(iFrame_ChooseFile);
			waitForElement(backbutton);
			clickOn(backbutton);
			switchToFrame(iFrame_ChooseFile);
			waitForElement(btn_Cancel);
			clickOn(btn_Cancel);
			status = "File Not Found";
		} else {
			System.out.println("In else block check status");
			switchToFrame(iFrame_ChooseFile);
			//waitForTextNotToBeVisible("Please wait.", 3600);
			waitForElementToBecomeInvisible(fileStatus);
			if(isElementPresent(fileStatus)){
				System.out.println("Still uploading");
			}
			while (i <= 3) {
				if (isElementPresent(failedStatus)) {
					clickOn(backbutton);
					clickOnChooseFileButton();
					uploadPackage(packageName);
					clickOnUploadButton();
					waitForElementToBecomeInvisible(fileStatus);
					i++;
				} else {
					status = "Pass";
					System.out.println("PAss");
					break;
				}
			}
		}
		ExcelReadWrite.setValueInExcel(packageName, status);
		if (status.equals("Pass")) {
			switchToDefaultWindow();
			clickOnCloseButton();
		}
		return status;
	}

	public AdministratorMenuPage clickOnUploadButton() throws Exception {
		clickOn(bt_Upload);
		switchToDefaultWindow();
		return PageFactory.initElements(driver, AdministratorMenuPage.class);
	}

	public AdministratorMenuPage searchCourse(String courseName) {
		inputText(tb_Search, courseName);
		clickOn(btn_Search);
		return PageFactory.initElements(driver, AdministratorMenuPage.class);
	}

	public AdministratorMenuPage clickOnModifyButton() {
		waitForElement(link_Modify);
		clickOn(link_Modify);
		return PageFactory.initElements(driver, AdministratorMenuPage.class);
	}

	public AdministratorMenuPage clickOnImportThisPackage() {
		waitForElement(img_Import);
		clickOn(img_Import);
		try {
			if (isAlertPresent()) {
				Alert alert = driver.switchTo().alert();
				alert.accept();
			}
		} catch (NoAlertPresentException ex) {
			System.out.println("No alert present on the screen");
		}

		return PageFactory.initElements(driver, AdministratorMenuPage.class);
	}

	public AdministratorMenuPage clickOnCloseButton() {
		switchToFrame(iFrame_ChooseFile);
		waitForElement(btn_Close);
		clickOn(btn_Close);
		switchToDefaultWindow();
		return PageFactory.initElements(driver, AdministratorMenuPage.class);
	}

	public AdministratorMenuPage fillLessonDetails(String name, String shortDescription, String windowwidth, String windowheight) {
		inputText(tb_Name, name);
		//selectDropDownByText(dd_LessonType, lessonType);
		inputText(text_sortDescription, shortDescription);
		inputText(text_width, windowwidth);
		inputText(text_height, windowheight);
		
		return PageFactory.initElements(driver, AdministratorMenuPage.class);
	}

	public AdministratorMenuPage clickOnSavebutton() {
		scrollDownToElement(btn_Save);
		waitForElement(btn_Save);
		javascriptButtonClick(btn_Save);
		return PageFactory.initElements(driver, AdministratorMenuPage.class);
	}

	public boolean verifySaveMessage() {
		boolean flag = false;
		String sucessfullMsg = "Lesson has been saved successfully.";
		if (msg_Save.getText().trim().equals(sucessfullMsg)) {
			flag = true;
		}
		return flag;
	}

	public AdministratorMenuPage clickOnLessonLink() {
		waitForElement(lnk_Lesson);
		hoverOverElementAndClick(lnk_Lesson, lnk_Lesson);
		return PageFactory.initElements(driver, AdministratorMenuPage.class);
	}

	public AdministratorMenuPage selectPackage(String packageName) throws InterruptedException {
		waitForElement(btn_SelectPackage);
		scrollDownToElement(btn_SelectPackage);
		clickOn(btn_SelectPackage);
		switchToFrame(iFrame_ChooseFile);
		String packageName1 =packageName+".zip";
		searchCourse(packageName1);
		clickOn("//option[text()='" + packageName1 + "'][1]");
		clickOn(btn_OK);
		Thread.sleep(3000);
		//searchCourse(resource);
		//clickOn("//option[text()='" + resource + "'][1]");
		clickOn("//option[1]");
		clickOn(btn_OK);
		switchToDefaultWindow();
		return PageFactory.initElements(driver, AdministratorMenuPage.class);
	}

	public boolean verifyAddedNewLesson(String lessonName) {
		boolean flag = false;
		int size = lessonNames.size();
		for (int i = 1; i <= size; i++) {
			String loc = "(//table[@id='grid_admin_lessons']/tbody/tr/td/label)[" + i + "]";
			WebElement el = driver.findElement(By.xpath(loc));
			if (el.getText().trim().contains(lessonName)) {
				flag = true;
			}
		}
		return flag;
	}

	public AdministratorMenuPage clickOnLastBreadcumLink() {
		int size = breadcrumb.size();
		String link = "(//div[@id='breadCrumb']/a)[" + size + "]";
		clickOn(link);
		return PageFactory.initElements(driver, AdministratorMenuPage.class);
	}

	public AdministratorMenuPage clickOnNewOnlineLessonLink() {
		waitForElement(newOnlineLesson);
		hoverOverElementAndClick(newOnlineLesson, newOnlineLesson);
		return PageFactory.initElements(driver, AdministratorMenuPage.class);
	}

	public AdministratorMenuPage fillCourseDetails(String code, String name, String description, String longDescription) {
		inputText(tb_Code, code);
		inputText(tb_Name, name);
		//switchToFrame(iFrame_Description);
		inputText(tb_Description, description);
		//inputText(tb_longDescription, description);
		//switchToDefaultWindow();
		return PageFactory.initElements(driver, AdministratorMenuPage.class);
	}

	public AdministratorMenuPage showAlertMessge(String alertMessege) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('" + alertMessege + "');");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Alert alert = driver.switchTo().alert();
		alert.accept();
		return PageFactory.initElements(driver, AdministratorMenuPage.class);
	}
}
