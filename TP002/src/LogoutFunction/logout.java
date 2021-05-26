package LogoutFunction;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Connection.CaptureScreen;
import Connection.ConnectionUtils;
import Connection.TestLinkIntergration;
import Connection.testlinkAPI;
import testlink.api.java.client.TestLinkAPIResults;

public class logout {
	public static WebDriver driver;
	public static String url = "https://id.zing.vn/";
	int id = 40;
	@Before
	public void openBrowser() throws MalformedURLException{
		System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	public void validLogin() throws Exception{
		try {
			System.out.println("Test Logout");
			driver.get(url);
			driver.findElement(By.xpath("/html/body/div[3]/div[1]/form/p[1]/input")).sendKeys("huudg.qc");
			driver.findElement(By.xpath("/html/body/div[3]/div[1]/form/p[2]/input[2]")).sendKeys("123456789HuU");
			driver.findElement(By.xpath("/html/body/div[3]/div[1]/form/div[3]/a")).click();
			driver.findElement(By.xpath("/html/body/div[2]/div/div/span/a")).click();
			String title = driver.findElement(By.xpath("/html/body/div[3]/div[1]/form/div[3]/p/a")).getText();			
			Assert.assertEquals("Quên mật khẩu?", title);			
			System.out.println("Test Passed!");
			TestLinkIntergration.updateResults("logout", null, TestLinkAPIResults.TEST_PASSED);			
		}catch(Exception e) {
			System.out.println("Test Failed");
			TestLinkIntergration.updateResults("logout", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
			CaptureScreen.captureScreen("validLogout", driver);
			System.out.println(ConnectionUtils.getLastExId(1408)); 
			testlinkAPI.attachmentImage("D:\\Diep_Gia_Huu\\Java Source Code\\Selenium_Integrating_TestLink-main\\Selenium_Integrating_TestLink-main\\TP002\\src\\Image\\validLogout.jpg", ConnectionUtils.getLastExId(1408), "bug");
		}
	}
	@After
	public void closeBrowser() {
		driver.quit();		
	}	
}
