package test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import Connection.CaptureScreen;
import Connection.ConnectionUtils;
import Connection.HttpDownloadUtility;
import Connection.TestLinkIntergration;
import Connection.testlinkAPI;
import testlink.api.java.client.TestLinkAPIResults;


public class LoginScenarios {

	private static final int CONNECT_TIMEOUT = 0;
	private static final int READ_TIMEOUT = 0;
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
			System.out.println("Test valid Login");
			driver.get(url);
			driver.findElement(By.xpath("/html/body/div[3]/div[1]/form/p[1]/input")).sendKeys("huudg.qc");
			driver.findElement(By.xpath("/html/body/div[3]/div[1]/form/p[2]/input[2]")).sendKeys("123456789HuU");
			driver.findElement(By.xpath("/html/body/div[3]/div[1]/form/div[3]/a")).click();
			String title = driver.findElement(By.xpath("/html/body/div[4]/div/div/form/h3[1]")).getText();			
			Assert.assertEquals("Thông tin cá nhân", title);
			System.out.println("Test Passed!");
			TestLinkIntergration.updateResults("validLogin", null, TestLinkAPIResults.TEST_PASSED);
					
		}catch(Exception e) {
			System.out.println("Test Failed");
			TestLinkIntergration.updateResults("validLogin", e.getMessage(), TestLinkAPIResults.TEST_FAILED);
			CaptureScreen.captureScreen("validLogin", driver);
			System.out.println(ConnectionUtils.getLastExId(1408)); 
			testlinkAPI.attachmentImage("D:\\Diep_Gia_Huu\\Java Source Code\\Selenium_Integrating_TestLink-main\\Selenium_Integrating_TestLink-main\\TP002\\src\\Image\\validLogin.jpg", ConnectionUtils.getLastExId(1408), "bug");
		}
	}
	@After
	public void closeBrowser() {
		//FileUtils.copyFile("http://localhost/testlink_1_9_20/lib/results/printDocument.php?level=testproject&id=1407&type=testreport&docTestPlanId=1408&summary=y&passfail=y&step_exec_status=y&format=4", "D:\\Diep_Gia_Huu\\Java Source Code\\Selenium_Integrating_TestLink-main\\Selenium_Integrating_TestLink-main\\TP002\\src\\report\\TestReport.doc");
		driver.quit();
	}
			
}
