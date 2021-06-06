package practise2;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Testing2 {
	static WebDriver driver;

	@Test
	public void test() throws InterruptedException {
		String chromePath = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.id("openwindow")).click();
		Testing2.switch1("//li/a[text()='Courses']");
		driver.findElement(By.id("opentab")).click();
		Testing2.switch1("//li/a[text()='Courses']");
		driver.quit();
	}

	public static void switch1(String element) throws InterruptedException {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iter = windows.iterator();
		String parent = iter.next();
		String child = iter.next();
		driver.switchTo().window(child);
		driver.findElement(By.xpath(element)).click();
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(parent);
	}
}
