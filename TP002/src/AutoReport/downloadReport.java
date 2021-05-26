package AutoReport;

import java.io.File;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.Select;

import Connection.getReport;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class downloadReport {
	public static WebDriver driver;
	public static String url = "http://localhost/testlink_1_9_20/login.php";

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
			System.out.println("Download Report");
			//driver.navigate().to("http://localhost/testlink_1_9_20/lib/results/printDocument.php?level=testproject&id=1407&type=testreport&docTestPlanId=1408&summary=y&passfail=y&step_exec_status=y&format=4");
			driver.get("http://localhost/testlink_1_9_20/lnl.php?apikey=b4c9b1a3ccdf78399b10b64d745a27e017e90108e5b032f7741926a3b5ef1d5a&tproject_id=1407&tplan_id=1408&type=test_report");
			driver.findElement(By.xpath("/html/body/div/div[3]/form/div[1]/input")).sendKeys("admin");
			driver.findElement(By.xpath("/html/body/div/div[3]/form/div[2]/input")).sendKeys("admin");
			driver.findElement(By.xpath("/html/body/div/div[3]/form/div[3]/input")).click();
			//driver.navigate().to("http://localhost/testlink_1_9_20/lib/results/printDocument.php?level=testproject&id=1407&type=testreport&docTestPlanId=1408&summary=y&passfail=y&step_exec_status=y&format=4");
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/a[3]")).click();
			Select drpType = new Select(driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/span[1]/select")));
			drpType.selectByVisibleText("Pseudo MS Word");
			driver.findElement(By.xpath("/html/body/div[2]/span[2]/a")).click();
			driver.findElement(By.xpath("/html/body/div[2]/div/div/ul/li/div/a/span")).click();
			String title = driver.findElement(By.xpath("/html/body/div[1]/form/p/text()")).getText();	
			Assert.assertEquals("Click on tree root to generate full doc, or an specific folder for branch doc", title);
			System.out.println("Dowloaded");
		}catch(Exception e) {
			System.out.println("Dowload failed");
		}
	}
	@After
	public void closeBrowser() {
		driver.quit();		
	}
}
