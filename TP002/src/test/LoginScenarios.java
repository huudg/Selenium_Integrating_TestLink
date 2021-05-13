package test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import testlink.api.java.client.TestLinkAPIResults;


public class LoginScenarios {

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
			driver.get(url);
			driver.findElement(By.xpath("/html/body/div[3]/div[1]/form/p[1]/input")).sendKeys("huudg.qc");
			driver.findElement(By.xpath("/html/body/div[3]/div[1]/form/p[2]/input[2]")).sendKeys("123456789Hu");
			driver.findElement(By.xpath("/html/body/div[3]/div[1]/form/div[3]/a")).click();
			String title = driver.findElement(By.xpath("/html/body/div[4]/div/div/form/h3[1]")).getText();			
			Assert.assertEquals("Thông tin cá nhân", title);
			System.out.println("Test Passed!");
			TestLinkIntergration.updateResults("validLogin", null, TestLinkAPIResults.TEST_PASSED);			
		}catch(Exception e) {
			System.out.println("Test Failed");
			TestLinkIntergration.updateResults("validLogin", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
			CaptureScreen.captureScreen("validLogin", driver);
			System.out.println(ConnectionUtils.getLastExId(513)); 
			testlinkAPI.attachmentImage("C:\\Users\\diepg\\Code\\TP002\\src\\Image\\validLogin.jpg", ConnectionUtils.getLastExId(513), "bug");
		}
	}
	@After
	public void closeBrowser() {
		driver.quit();		
	}
			
}
