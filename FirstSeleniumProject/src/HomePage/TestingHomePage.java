package HomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestingHomePage {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","D:\\shiva selenium  important\\Latest_Jars\\chromedriver.exe");
		
		//instantiating object and variables
		WebDriver driver= new ChromeDriver();
		//WebDriver -----> Interface
		//driver----> reference variable
		//ChromeDriver----->class
		//to open the URl
		driver.get("https://wordpress.com/log-in");
		//to maximize the window
		driver.manage().window().maximize();
		String firsturl=driver.getCurrentUrl();
		System.out.println(firsturl);
		Thread.sleep(3000);
		driver.navigate().refresh();//refresh the browser
		String refresh=driver.getCurrentUrl();
		System.out.println(refresh);
		/*driver.navigate().to("https://www.freecrm.com/index.html");
		//driver.get("https://www.freecrm.com/index.html");
		String secondurl=driver.getCurrentUrl();
		System.out.println(secondurl);
		
		driver.navigate().back(); //moves single item back in browser history
		String back=driver.getCurrentUrl();
		System.out.println(back);

		
		driver.navigate().forward();//moves single item forward in browser history
		String forward=driver.getCurrentUrl();
		System.out.println(forward);
		
		driver.navigate().refresh();//refresh the browser
*/	}
	

}
