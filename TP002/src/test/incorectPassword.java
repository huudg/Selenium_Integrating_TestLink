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


public class incorectPassword {
	public static WebDriver driver;
	public static String url = "https://id.zing.vn/";

	int id = 45;
	@Before
	public void openBrowser() throws MalformedURLException{
		System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	public void incorect() throws Exception{
		try {
			driver.get(url);
			driver.findElement(By.xpath("/html/body/div[3]/div[1]/form/p[1]/input")).sendKeys("huudg.qc");
			driver.findElement(By.xpath("/html/body/div[3]/div[1]/form/p[2]/input[2]")).sendKeys("123456789HuU");
			driver.findElement(By.xpath("/html/body/div[3]/div[1]/form/div[3]/a")).click();
			String title = driver.findElement(By.xpath("//*[@id=\"login_error\"]/div/div")).getText();
			System.out.println(title);
			Assert.assertEquals("Tài khoản hoặc mật khẩu không đúng", title);
			System.out.println("Test Passed!");
			TestLinkIntergration.updateResults("incorectPassword", null, TestLinkAPIResults.TEST_PASSED);			
		}catch(Exception e) {
			System.out.println("Test Failed");
			TestLinkIntergration.updateResults("incorectPassword", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
			testlinkAPI.attachmentImage("C:\\Users\\diepg\\Code\\TP002\\src\\Image\\A.jpg", id, "bug");
		}
	}
	@After
	public void closeBrowser() {
		driver.quit();		
	}
}
