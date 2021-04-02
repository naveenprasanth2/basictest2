package finalprac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Summatest {

	@Test
	public void test() {
		WebDriver driver;
		String path = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("hide-textbox")).click();
		System.out.println(driver.findElement(By.id("displayed-text")).isEnabled());
		System.out.println(driver.findElement(By.cssSelector("legend.switch-tab")).isEnabled());
	}

}
