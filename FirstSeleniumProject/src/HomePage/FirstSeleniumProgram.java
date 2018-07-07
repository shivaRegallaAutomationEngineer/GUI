package HomePage;




import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.lang.*;
import java.io.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.base.Function;

import org.openqa.selenium.TakesScreenshot;

public class FirstSeleniumProgram {


	
	static WebDriver driver;
		
		@Test
		public void Setup(){
			
		
			
			System.setProperty("webdriver.gecko.driver", "D:\\shiva selenium  important\\geckodriver-v0.18.0-win64\\geckodriver.exe");
			System.out.println("Getfirefox Method is running on Thread : " + Thread.currentThread().getId());
			// DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		      //  capabilities.setCapability("marionette", true);
//			System.setProperty("webdriver.gecko.driver","D:\\Firefox\\geckodriver.exe");
//			
//			FirefoxOptions options = new FirefoxOptions();
//			options.setBinary("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe"); //This is the location where you have installed Firefox on your machine
//	 
//			WebDriver driver = new FirefoxDriver(options);
//			driver.get("http://www.google.com");
		        driver = new FirefoxDriver();	
		       
		        driver.get("https://www.facebook.com/");
			
			
			
//		 driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://www.facebook.com/");
//	
		
		
	
//	}
//		@AfterMethod
//		public void teardown(){
//			driver.quit();
//		}
//		
//		@Test(dataProvider="LoginCredentials")
//		public void Login_Test(String username,String password) throws InterruptedException{
//			Thread.sleep(3000);
//			driver.findElement(By.id("email")).sendKeys(username);
//			driver.findElement(By.id("pass")).sendKeys(password);
//		}
//		
//		@DataProvider
//		public  Object[][] LoginCredentials(){
//			
//			Object[][] cred= new Object[4][2];
//			cred[0][0]="UserId1";
//			cred[0][1]="Password1";
//			cred[1][0]="UserId2";
//			cred[1][1]="Password2";
//			cred[2][0]="UserId3";
//			cred[2][1]="Password3";
//			cred[3][0]="UserId4";
//			cred[3][1]="Password4";
//			
//			return cred;
//			
//		}
//		
}
		
		@Test
		public void Setup2(){
			System.setProperty("webdriver.chrome.driver", "D:\\shiva selenium  important\\Latest_Jars\\chromedriver.exe");
			
			System.out.println("GetChrome Method is running on Thread : " + Thread.currentThread().getId());
			driver = new ChromeDriver();
				driver.manage().window().maximize();
			driver.get("https://www.facebook.com/");
			
		}

}	

	