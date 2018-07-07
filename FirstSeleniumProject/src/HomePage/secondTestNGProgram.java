package HomePage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class secondTestNGProgram {

	@BeforeClass
	public void beforeLogin(){
		System.out.println("Before login execution");
	}
	@Test(priority=0,groups={"sanity"})
	public void Search(){
		System.out.println("search execution");
	}
	@Test(priority=1,groups={"sanity","regression"})
	public void Additem(){
		System.out.println("Adding item to the cart");
	}
	
	@Test(priority=2,groups={"regression"})
	public void ViewCart(){
		System.out.println("ViewCart ");
	}
	
	@Test(priority=3,groups={"sanity"})
	public void PlaceOrder(){
		System.out.println("Placing Order");
	}
	
	
	@AfterClass
	public void afterLogin(){
		System.out.println("After login execution");
	}
}
