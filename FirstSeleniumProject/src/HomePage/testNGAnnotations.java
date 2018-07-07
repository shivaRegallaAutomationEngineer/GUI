package HomePage;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testNGAnnotations {
 
	
	@BeforeClass(groups={"sanity","regression"})
	public void login(){
		System.out.println("Login application");
	}
	
	@Test(priority=3,groups={"sanity"})
	public void testA(){
		Assert.assertEquals("Google", "Google");
		System.out.println("test case A");
	}
	@Test(priority=2,groups={"regression"})
	public void testD(){
		Assert.assertEquals("Google", "Google");
		System.out.println("test case D");
	}
	@Test(priority=1,groups={"sanity"})
	public void testC(){
		Assert.assertEquals("Google", "Google");
		System.out.println("test case C");
	}
	@AfterClass(groups={"sanity","regression"})
	public void logout(){
		System.out.println("Logout application");
	}
	
}


