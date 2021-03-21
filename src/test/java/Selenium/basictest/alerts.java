package Selenium.basictest;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class alerts {
	
	@Test
	
	public void alert() throws IOException, InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
		String downloadPath = System.getProperty("user.dir");
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		ChromeOptions options=new ChromeOptions();
		options.merge(dc);
		options.setExperimentalOption("prefs", chromePrefs);

		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.get("http://admin:admin@the-internet.herokuapp.com");
		//driver.findElement(By.cssSelector("a[href*='basic_auth']")).click();
		driver.get("https://smallpdf.com/pdf-to-word");
		driver.findElement(By.cssSelector("button.l3tlg0-0.hrcxSS span.sc-1rkezdt-7.cxlSWI")).click();
		Thread.sleep(5000);
		Runtime.getRuntime().exec("C:\\Users\\navee\\Desktop\\Selenium\\Upload\\fileupload.exe");
		driver.findElement(By.cssSelector("div.sc-6ytb27-3.hWnCPt")).click();
		driver.findElement(By.cssSelector("button.sc-1mvwhop-0.bqmdbl")).click();
		WebDriverWait explicit = new WebDriverWait(driver, 20);
		explicit.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("span.wnolmd-2.etrSPs"))));
		driver.findElement(By.cssSelector("span.wnolmd-2.etrSPs")).click();
		File src = new File(downloadPath+"/test-converted.docx");
		Thread.sleep(5000);
		if(src.exists())
		{
			System.out.println("file exists");
			if(src.delete())
			{
				System.out.println("deleted");
			}
		}
		
	}

}
