package Selenium.basictest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentreports {
	
	ExtentReports report = new ExtentReports();
	
	@BeforeTest
	
	public void report()
	{
		//ExtentReports, ExtenSparkReporter
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter spark = new ExtentSparkReporter(path);
		spark.config().setReportName("Naveen Report");
		spark.config().setDocumentTitle("Shetty Test");
		
		
		//Extentreport declaration on the top
		report.attachReporter(spark);
		report.setSystemInfo("Tester", "Naveen");
		
		
	}
	
	@Test
	
	public void extent()
	{
		ExtentTest test = report.createTest("ExtentReports");
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.getTitle());
		test.fail("summa");
		report.flush();
		
	}

}
