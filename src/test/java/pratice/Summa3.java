package pratice;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Summa3 {
	@Test
	public void test() throws IOException,InterruptedException {
		String chromepath = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe";
		String reportpath = System.getProperty("user.dir") + "\\reports\\summa3.html";
		String screenpath = System.getProperty("user.dir") + "\\src\\main\\java\\screenshots\\summa3.png";
		System.setProperty("webdriver.chrome.driver", chromepath);
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--headless");
		co.addArguments("--window-size=1920,1080");
		co.addArguments("--disable-info-bars");
		co.merge(dc);
		ExtentSparkReporter spark = new ExtentSparkReporter(reportpath);
		spark.config().setDocumentTitle("regression");
		spark.config().setReportName("phase1");

		ExtentReports report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("tester", "naveen");
		ExtentTest test = report.createTest("summa");
		WebDriver driver = new ChromeDriver(co);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String[] veg = { "brocolli", "beans", "mushroom", "banana", "capsicum","mango","musk melon" };
		ArrayList<String> vegg = new ArrayList<String>(Arrays.asList(veg));
		List<WebElement> lists = driver.findElements(By.xpath("//h4[@class='product-name']"));
		for (WebElement list : lists) {
			String temp = list.getText().split("-")[0].strip();
			if (vegg.contains(temp.toLowerCase())) {
				String key = Keys.chord(Keys.CONTROL+"A",Keys.DELETE);
				list.findElement(By.xpath("(parent::div)/div[2]/input")).sendKeys(key+"30");
				list.findElement(By.xpath("(parent::div)/div[3]/button")).click();
			}

		}

		TakesScreenshot sc = (TakesScreenshot) driver;
		File src = sc.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(screenpath));
		test.addScreenCaptureFromPath(screenpath);

		report.flush();
		Thread.sleep(5000);
		driver.quit();
	}

}
