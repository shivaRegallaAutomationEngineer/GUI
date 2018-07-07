package HomePage;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\shiva selenium  important\\Latest_Jars\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.naukri.com/"); 
		 
		  String Parent = driver.getWindowHandle();
		  System.out.println(Parent); 
		 
		
		 
		  Set<String> ww=driver.getWindowHandles(); 
		  System.out.println("Number of windows opened:" +ww.size()); 
		  
		Iterator<String> it=ww.iterator();
		
		while(it.hasNext()){
			String childWindow=it.next();
			
			if(!Parent.equals(childWindow)){
				driver.switchTo().window(childWindow);
				System.out.println(driver.switchTo().window(childWindow).getTitle());
			}
		}
	
	} 

}
