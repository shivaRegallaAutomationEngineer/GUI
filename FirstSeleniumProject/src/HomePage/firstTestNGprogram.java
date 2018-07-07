package HomePage;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class firstTestNGprogram {
	
	
	@Test
	public void Search(){
		Assert.assertEquals("gmail", "gmail");
		System.out.println("BeforeTestSearch get passed");
	}
	@Test
	public void AdvancedSearch(){
		Assert.assertEquals("gmail", "gmail");
		System.out.println("BeforeTestAdvancedSearch get passed");
	}
	
	
	@BeforeSuite
	public void beforeSuite(){
		System.out.println("before suite execution");
		
	}
	@BeforeTest
	public void BeforeTest(){
		Assert.assertEquals("Google", "Google");
		System.out.println("BeforeTest get passed");
	}
	
	@BeforeClass
	public void beforeClass(){
		System.out.println("Before class execution");
	}
	
	
	@AfterClass
	public void afterClass(){
		System.out.println("After class execution");
	}
	
	@BeforeMethod
	public void beforMethod(){
		System.out.println("beforemethod execution");
	}
	@AfterMethod
	public void AfterMethod(){
		System.out.println("aftermethod execution");
	}
	
	@AfterTest
	public void AfterTest(){
		Assert.assertEquals("facebook", "facebook");
		System.out.println("AfterTestLogout get passed");
	}

}
