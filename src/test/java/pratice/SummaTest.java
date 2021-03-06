package pratice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class SummaTest {

	@Test
	public void test() throws IOException {
		String path = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		String reportPath = System.getProperty("user.dir") + "\\reports\\newReport.html";
		String screenPath = System.getProperty("user.dir") + "\\src\\main\\java\\screenshots\\summa.png";
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

		ChromeOptions co = new ChromeOptions();
		co.addArguments("--headless");
		co.addArguments("--window-size=1920,1080");
		co.merge(dc);

		WebDriver driver = new ChromeDriver(co);
		driver.get("https://rahulshettyacademy.com");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);


		ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
		spark.config().setDocumentTitle("regression");
		spark.config().setReportName("regression");

		ExtentReports report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("tester","naveen");

		ExtentTest test = report.createTest("summa");

		TakesScreenshot sc = (TakesScreenshot) driver;
		File src = sc.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src , new File(screenPath));
		test.addScreenCaptureFromPath(screenPath);

		report.flush();
		driver.quit();
	}

}
