package com.scorm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.scorm.selenium.framework.BasePage;

public class DashboardPage extends BasePage {

	@FindBy(id = "mm_myaccount")
	private WebElement myAccountMenu;
	
	@FindBy(id = "mm_adminmenu")
	private WebElement myAdminMenu;

	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logoutButton;

	public DashboardPage(WebDriver driver) {
		super(driver);
	}

	public DashboardPage verifyLoginSuccess() {
		_waitForJStoLoad();
		Assert.assertTrue(isElementPresent(myAccountMenu), "User login successfully");
		Assert.assertTrue(isElementPresent(logoutButton), "User login successfully");
		return this;
	}

	public LoginPage logOut() {
		waitForElement(logoutButton);
		clickOn(logoutButton);
		return PageFactory.initElements(getDriver(), LoginPage.class);
	}
	
	public AdministratorMenuPage clickOnAdministartorMenu() {
		waitForElement(myAdminMenu);
		clickOn(myAdminMenu);
		return PageFactory.initElements(driver, AdministratorMenuPage.class);
	}

}
