package datadriven;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class JavaScriptExecutor1 {

	@Test
	public void test() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriver driver;
		String webpath = System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe";
		String reportpath = System.getProperty("user.dir")+"\\reports\\newtest.html";
		String screenpath = System.getProperty("user.dir")+"\\src\\main\\java\\screenshots\\summa.png";
		System.setProperty("webdriver.chrome.driver",webpath);

		ExtentSparkReporter spark = new ExtentSparkReporter(reportpath);
		spark.config().setReportName("regression");
		spark.config().setDocumentTitle("phase1");

		ExtentReports report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("naveen","tester");

		ExtentTest test = report.createTest("summa");

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);

		ChromeOptions co = new ChromeOptions();
		co.addArguments("headless");
		co.addArguments("disable-infobars");
		co.addArguments("--window-size=1920,1080");
		co.merge(dc);
		
		driver = new ChromeDriver(co);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,500)");
		Thread.sleep(5000);
		js.executeScript("document.querySelector('div.tableFixHead').scrollTop=5000");

		TakesScreenshot sc = (TakesScreenshot) driver;
		File src = sc.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(screenpath));

		test.addScreenCaptureFromPath(screenpath);
		report.flush();

		driver.quit();
	}
}
