package datadriven;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class GreenKart {

	@Test
	public void test() throws IOException {
		String chromepath = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe";
		String screenpath = System.getProperty("user.dir") + "\\src\\main\\java\\screenshots\\summa.png";
		String reportpath = System.getProperty("user.dir") + "\\reports\\summareport.html";

		System.setProperty("webdriver.chrome.driver", chromepath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		ExtentSparkReporter spark = new ExtentSparkReporter(reportpath);
		spark.config().setReportName("Regression");
		spark.config().setDocumentTitle("Regression1");

		ExtentReports report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("tester", "naveen");

		ExtentTest test = report.createTest("phase1");
		String[] summa = { "Brocolli", "Capsicum", "Strawberry", "Raspberry", "Pomegranate" };
		ArrayList<String> mylist = new ArrayList<String>(Arrays.asList(summa));

		List<WebElement> lists = driver.findElements(By.xpath("//div/h4"));
		for (WebElement list : lists) {
			if (list.getText().contains("-")) {
				String name = list.getText().split("-")[0].strip();
				if (mylist.contains(name)) {
					WebElement ele = list.findElement(By.xpath("parent::div"));
					ele.findElement(By.xpath("div[3]/button")).click();
				}
			} else {
				String name = list.getText().strip();
				if (mylist.contains(name)) {
					WebElement ele = list.findElement(By.xpath("parent::div"));
					ele.findElement(By.xpath("div[3]/button")).click();
				}
			}
		}
		driver.findElement(By.cssSelector("a.cart-icon img")).click();
		List<WebElement> summa1 = driver
				.findElements(By.xpath("//div[@class='cart-preview active'] //ul[@class='cart-items']/li/div[1]/p[1]"));
		for (WebElement val : summa1) {
			if (mylist.contains(val.getText().split("-")[0].strip())) {
				System.out.println("element is present " + val.getText());
			} else {
				System.out.println("element not present " + val.getText());
			}
		}
		driver.navigate().refresh();

		driver.findElement(By.cssSelector("a.cart-icon img")).click();
		List<WebElement> summa2 = driver
				.findElements(By.xpath("//div[@class='cart-preview active'] //ul[@class='cart-items']/li/div[1]/p[1]"));
		System.out.println(summa2.size());
		if (summa2.size()!=0) {
			for (WebElement val : summa2) {
				if (mylist.contains(val.getText().split("-")[0].strip())) {
					System.out.println("element is present " + val.getText());
				} else {
					System.out.println("element not present " + val.getText());
				}
			}
		} else {
			System.out.println("none of the values exists");
		}
		TakesScreenshot sc = (TakesScreenshot) driver;
		File src = sc.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(screenpath));
		test.addScreenCaptureFromPath(screenpath);
		report.flush();
		driver.quit();
	}
}
