package practice1;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Testing2 {
	static WebDriver driver;
	@Test
	public void test() throws IOException, InterruptedException {
		String chromePath = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Testing2.windowSwitch(driver.findElement(By.id("openwindow")));
		Testing2.windowSwitch(driver.findElement(By.id("opentab")));

		driver.quit();
	}
	public static Integer windowSwitch(WebElement value) throws InterruptedException{
		value.click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iter = windows.iterator();
		String parent = iter.next();
		String child = iter.next();
		driver.switchTo().window(child);
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(parent);
		Thread.sleep(2000);
		return 0;
		}
}
