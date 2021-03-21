package lastprac;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class RahulShetty2 {
	WebDriver driver;
	
	@Test
	public void test() throws IOException, InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		driver = new ChromeDriver();
//		ExtentSparkReporter spark = new ExtentSparkReporter(path);
//		spark.config().setReportName("regression");
//		spark.config().setDocumentTitle("test");
//
//		ExtentReports report = new ExtentReports();
//		report.attachReporter(spark);
//		report.setSystemInfo("naveen","tester");
//		ExtentTest test = report.createTest("testname");
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//		
//		TakesScreenshot sc = (TakesScreenshot) driver;
//		File src = sc.getScreenshotAs(OutputType.FILE);
//		String path1 = System.getProperty("user.dir")+"\\src\\main\\java\\screenshots\\test.png";
//		String path2 = System.getProperty("user.dir")+"\\src\\main\\java\\screenshots\\test1.png"; 
//		FileUtils.copyFile(src, new File(path1));
//		test.addScreenCaptureFromPath((path1));
		JavascriptExecutor js = (JavascriptExecutor) driver;
////		js.executeScript("window.scroll(0,500)");
//		js.executeScript("document.querySelector('div.tableFixHead').scrollTop=5000");
//		WebElement element = driver.findElement(By.xpath("//input[@value='radio1']"));
//		js.executeScript("arguments[0].click();", element);
		js.executeScript("document.getElementById('autocomplete').value='ind'");
		Thread.sleep(5000);
//		js.executeScript("document.getElementById('checkBoxOption1').click();");
//		File src1 = sc.getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(src1, new File(path2));
		List<WebElement> lists = driver.findElements(By.xpath("//li[@class='ui-menu-item']"));
		for(WebElement list : lists) {
			if(list.findElement(By.xpath("div")).getText().contains("India")) {
				list.click();
			}
		}


//		test.addScreenCaptureFromPath(path2);
//		report.flush();
	}

}
