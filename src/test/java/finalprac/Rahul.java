package finalprac;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Rahul {
	
	@Test
	public void test() throws IOException{
		WebDriver driver;
		String path = System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",path);
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
		SoftAssert soft = new SoftAssert();
		
		ChromeOptions co = new ChromeOptions();
		co.addArguments("headless");
		co.addArguments("disable-infobars");
		co.addArguments("window-size=1920,1080");
		co.merge(cap);
		driver = new ChromeDriver(co);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		String reportpath = System.getProperty("user.dir")+"\\reports";
		String screenpath = System.getProperty("user.dir")+"\\path\\screen.png";
		ExtentSparkReporter spark = new ExtentSparkReporter(reportpath);
		spark.config().setReportName("regression");
		spark.config().setDocumentTitle("regressionPhase1");

		ExtentReports report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("naveen","Tester");

		ExtentTest test = report.createTest("summa");

		TakesScreenshot sc = (TakesScreenshot) driver;
		File src = sc.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src , new File(screenpath));
		test.addScreenCaptureFromPath(screenpath);
		
		List<WebElement> lists = driver.findElements(By.cssSelector("li.gf-li a"));
		for(WebElement list : lists){
		URL url = new URL(list.getAttribute("href"));
		HttpURLConnection connect = (HttpURLConnection) url.openConnection();
		connect.connect();
		connect.getHeaderField("HEAD");
		int response = connect.getResponseCode();
		soft.assertTrue(response<400);
		report.flush();
	}
		soft.assertAll();
		driver.quit();
	}
}
