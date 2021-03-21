package finalprac;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Rahulshetty {
	WebDriver driver;

	@Test
	public void test() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");
		String screenpath = System.getProperty("user.dir")+"\\src\\main\\java\\screenshots";
		String reportpath = System.getProperty("user.dir")+"\\reports";
		ChromeOptions co = new ChromeOptions();
		co.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		co.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		co.addArguments("headless");
		co.addArguments("window-size=1366,768");
		driver = new ChromeDriver(co);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		ExtentSparkReporter spark = new ExtentSparkReporter(reportpath);
		spark.config().setReportName("regression");
		spark.config().setDocumentTitle("phase1");

		ExtentReports report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("tester","naveen");
		ExtentTest test = report.createTest("summa");


		List<WebElement> radios = driver.findElements(By.xpath("//label[contains(@for,'radio')]"));
		for (WebElement radio : radios) {
			if (radio.getText().equalsIgnoreCase("radio3")) {
				radio.findElement(By.xpath("input")).click();
			}
		}
		driver.findElement(By.id("autocomplete")).sendKeys("afr");
		WebDriverWait wait = new WebDriverWait(driver, 5, 1);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-menu-item")));
		List<WebElement> suggestions = driver.findElements(By.className("ui-menu-item"));
		for (WebElement suggestion : suggestions) {
			if (suggestion.findElement(By.xpath("div")).getText().equalsIgnoreCase("South Africa")) {
				suggestion.findElement(By.xpath("div")).click();
			}
		}
		WebElement element = driver.findElement(By.id("dropdown-class-example"));
		Select dropdown = new Select(element);
		List<WebElement> values = dropdown.getOptions();
		for (WebElement value : values) {
			if (value.getText().contains("Option3")) {
				value.click();
			}
		}
		
		driver.findElement(By.id("openwindow")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iter = windows.iterator();
		String parent = iter.next();
		String child = iter.next();
		driver.switchTo().window(child);
		driver.findElement(By.xpath("(//li/a) [8]")).click();
		Thread.sleep(5000);
		driver.close();
		driver.switchTo().window(parent);
		driver.findElement(By.id("name")).sendKeys(Keys.SHIFT,"naveen");
		driver.findElement(By.id("opentab")).click();
		Set<String> windows1 = driver.getWindowHandles();
		Iterator<String> iter1 = windows1.iterator();
		String parent1 = iter1.next();
		String child1 = iter1.next();
		driver.switchTo().window(child1);
		driver.findElement(By.linkText("Articles")).click();
		Thread.sleep(3000);
		driver.close();
		driver.switchTo().window(parent1);
		driver.findElement(By.id("alertbtn")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().dismiss();
		driver.findElement(By.id("confirmbtn")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		TakesScreenshot sc = (TakesScreenshot) driver;
		File src = sc.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(screenpath+"\\test.png"));
		test.addScreenCaptureFromPath(screenpath+"\\test.png");
		report.flush();
		Thread.sleep(5000);
		driver.quit();

	}

}
