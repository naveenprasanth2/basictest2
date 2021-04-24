package Selenium.basictest;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class test2 {

	@Test

	public void basictest() throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platform", "windows 7");
		dc.setCapability("version", "26.0");
		ChromeOptions co = new ChromeOptions();
		co.merge(dc);
		WebDriver driver = new RemoteWebDriver(new URL(
				"https://cewefah472:3de100ba7c9f43a0ac753afb98df7d7e@ondemand.us-west-1.saucelabs.com:443/wd/hub"), co);
		driver.get("https://www.google.com");
		TakesScreenshot sc = (TakesScreenshot) driver;
		File src = sc.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("D:\\Screenshots\firefox"));
		System.out.println(driver.getTitle());
		List<WebElement> lists = driver.findElements(By.xpath(""));
		for (WebElement list : lists) {
			URL url = new URL(list.getAttribute("href"));
			HttpURLConnection connect = (HttpURLConnection) url.openConnection();
			connect.connect();
			connect.setRequestMethod("HEAD");
			int response = connect.getResponseCode();
			if (response < 400) {
				System.out.println("link is working fine");
			} else {
				System.out.println("link is not working fine");
			}
		}
		driver.quit();
		driver.switchTo().alert().dismiss();

	}
}
