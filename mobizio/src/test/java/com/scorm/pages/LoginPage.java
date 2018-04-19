package com.scorm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.scorm.selenium.framework.BasePage;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(className = "languageSelect")
	private WebElement dd_SelectLanguage;

	@FindBy(id = "username")
	private WebElement userNameField;

	@FindBy(id = "password")
	private WebElement passwordField;

	@FindBy(id = "btnLogin")
	private WebElement loginButton;
	
	@FindBy(id = "iframe_login")
	private WebElement loginFrame;

	public LoginPage selectLanguage() {
		selectDropDownByText(dd_SelectLanguage, "English");
		return PageFactory.initElements(getDriver(), LoginPage.class);
	}

	public DashboardPage login(String userName, String password) {
		_waitForJStoLoad();
		switchToFrame(loginFrame);
		inputText(userNameField, userName);
		inputText(passwordField, password);
		clickOn(loginButton);
		return PageFactory.initElements(getDriver(), DashboardPage.class);
	}

	public LoginPage verifyLoginPage() {
		waitForElement(userNameField);
		Assert.assertTrue(isElementPresent(userNameField), "User is not panding on login page");
		Assert.assertTrue(isElementPresent(loginButton), "User is not panding on login page");
		Assert.assertTrue(isElementPresent(passwordField), "User is not panding on login page");
		return this;
	}
}
