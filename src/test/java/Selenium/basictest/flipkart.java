package Selenium.basictest;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class flipkart {
	
	@Test
	
	public void flip() throws InterruptedException, IOException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		WebElement drop = driver.findElement(By.xpath("//span[text()='Electronics']/parent::div"));
		Actions act = new Actions(driver);
		Thread.sleep(5000);
		act.moveToElement(drop).build().perform();
		WebDriverWait explicit = new WebDriverWait(driver,5);
		explicit.until(ExpectedConditions.visibilityOf(drop));
		
		TakesScreenshot sc = (TakesScreenshot) driver;
		File src = sc.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File ("c:\screenshots\newone.png"));
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		ChromeOptions co = (ChromeOptions) driver;
		co.merge(cap);
		WebDriver driver1 = new ChromeDriver(co);
		
		String urlvalue = "www.google.com" ;
		
		URL url = new URL(urlvalue);
		HttpURLConnection connect = (HttpURLConnection)  url.openConnection();
		connect.setRequestMethod("HEAD");
		connect.connect();
		int code = connect.getResponseCode();
		
		
		
		
		
	}

}
