package pratice;

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

public class Summa {
	@Test
	public void test() throws IOException,InterruptedException {
		String chromepath = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe";
		String screenpath = System.getProperty("user.dir") + "\\src\\main\\java\\screenshots\\summa.png";
		String reportpath = System.getProperty("user.dir") + "\\reports\\Testreport.html";

		System.setProperty("webdriver.chrome.driver",chromepath);

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
		dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);

		ChromeOptions co = new ChromeOptions();
		co.addArguments("--headless");
		co.addArguments("--disable-info-bars");
		co.addArguments("--window-size=1920,1080");
		co.merge(dc);

		WebDriver driver = new ChromeDriver(co);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		ExtentSparkReporter spark = new ExtentSparkReporter(reportpath);
		spark.config().setReportName("regression");
		spark.config().setDocumentTitle("phase1");
		ExtentReports report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("tester","Naveen");
		ExtentTest test = report.createTest("test1");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,500)");
		Thread.sleep(5000);
		js.executeScript("document.querySelector('div.tableFixHead').scrollTop=5000");

		TakesScreenshot sc = (TakesScreenshot) driver;
		File src = sc.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile( src , new File(screenpath));
		test.addScreenCaptureFromPath(screenpath);

		report.flush();
		driver.quit();

	}

}
