package intervew;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SummaTest {
	WebDriver driver;

	@Test
	public void test() throws InterruptedException {
		String chromePath = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement button1 = driver.findElement(By.id("openwindow"));
		winswitch(driver, button1);
		WebElement button3 = driver.findElement(By.id("opentab"));
		winswitch(driver, button3);
		driver.quit();
	}

	public static void winswitch(WebDriver driver, WebElement element1)
			throws InterruptedException {
		element1.click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iter = windows.iterator();
		String parent = iter.next();
		String child = iter.next();
		driver.switchTo().window(child);
		Thread.sleep(2000);
		WebElement element2 = driver.findElement(By.xpath("//li/a[text()='Courses']"));
		element2.click();
		driver.close();
		driver.switchTo().window(parent);
	}
}
