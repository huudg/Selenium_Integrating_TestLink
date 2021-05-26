package Connection;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreen {
	public static void captureScreen(String fileName, WebDriver driver) throws InterruptedException, IOException{	
		//Capture entire page screenshot and then store it to destination drive
		  File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(screenshot, new File("D:\\Diep_Gia_Huu\\Java Source Code\\Selenium_Integrating_TestLink-main\\Selenium_Integrating_TestLink-main\\TP002\\src\\Image\\" + fileName +".jpg"));
	}
}
