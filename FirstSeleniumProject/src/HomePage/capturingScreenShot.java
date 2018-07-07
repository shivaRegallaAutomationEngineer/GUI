package HomePage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class capturingScreenShot {

	
	
	public static void takeScreenshot(String screenshotname,WebDriver driver) throws Exception{
		File scrcfile=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(scrcfile, new File(".\\Screenshots\\"+screenshotname+".png"));
	}
}
