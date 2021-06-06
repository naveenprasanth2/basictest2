package extraPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FindAndReplace {
	@Test
	public void test() throws InterruptedException {
		String chromePath = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String keys = Keys.chord(Keys.CONTROL,Keys.RETURN);
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(keys);
		Thread.sleep(5000);
		driver.quit();
	}
}
