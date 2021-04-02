package datadriven;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class SummaTest1 {

	public static void main(String[] args) throws IOException, InterruptedException {
		String path = System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",path);
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);

		ChromeOptions co = new ChromeOptions();
		co.addArguments("headless");
		co.addArguments("disable-infobars");
		co.addArguments("--window-size= 1920,1080");
		co.merge(dc);
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(By.id("opentab")).click();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iter = windows.iterator();
		String parent = iter.next();
		String child = iter.next();
		driver.switchTo().window(child);
		driver.findElement(By.linkText("Courses")).click();
		Thread.sleep(5000);
		driver.switchTo().window(parent);
		
		String reportpath = System.getProperty("user.dir")+"\\reports\\testing.html";
		String screenpath = System.getProperty("user.dir")+"\\src\\main\\java\\screenshots\\phase1.png";
		ExtentSparkReporter spark = new ExtentSparkReporter(reportpath);
		spark.config().setReportName("regression");
		spark.config().setDocumentTitle("regressionPhase1");

		ExtentReports report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("naveen","tester");

		ExtentTest test = report.createTest("test1");

		TakesScreenshot sc = (TakesScreenshot) driver;
		File src = sc.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src , new File(screenpath));

		test.addScreenCaptureFromPath(screenpath);

		report.flush();
		driver.quit();

	}

}
