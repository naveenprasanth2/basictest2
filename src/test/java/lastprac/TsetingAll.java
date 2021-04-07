package lastprac;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TsetingAll {

	public static void main(String[] args) throws IOException {
		
		String screenpath = System.getProperty("user.dir")+"\\src\\main\\java\\screenshots\\summa.png";

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");
		
		ChromeOptions co = new ChromeOptions();
		co.addArguments("headless");
		co.addArguments("--window-size=1920,1600");
		WebDriver driver = new ChromeDriver(co);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		TakesScreenshot sc = (TakesScreenshot) driver;
		File src = sc.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(screenpath));
		
		
		driver.quit();
	}

}
