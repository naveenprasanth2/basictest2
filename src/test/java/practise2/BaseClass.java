package practise2;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
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

public class BaseClass {
	@Test
	public void test() throws IOException{
		String chromePath = System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe";
		String reportPath = System.getProperty("user.dir")+"\\reports\\summa.html";
		String screenPath = System.getProperty("user.dir")+"\\src\\main\\java\\screenshots\\summa.png";

		System.setProperty("webdriver.chrome.driver",chromePath);
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
		dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--headless");
		co.addArguments("--window-size=1920,1080");
		co.addArguments("--disable-infobars");
		co.merge(dc);
		WebDriver driver = new ChromeDriver(co);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
		spark.config().setReportName("regression");
		spark.config().setDocumentTitle("regression");

		ExtentReports report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("tester","naveen");
		ExtentTest  test = report.createTest("test");
		TakesScreenshot sc = (TakesScreenshot) driver;
		File src = sc.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(screenPath));
		test.addScreenCaptureFromPath(screenPath);
		report.flush();
		driver.quit();

	}

}
