package practise;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Testing4 {
	WebDriver driver;

	@Test
	public void test() {
		String chromepath = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromepath);
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		List<String> test = Testing4.datavalue();
		List<WebElement> lists = driver.findElements(By.xpath("//h4[@class='product-name']"));

		for (WebElement list : lists) {
			if (test.contains(list.getText().split("-")[0].strip())) {
				WebElement temp = list.findElement(By.xpath("parent::div"));
				String key = Keys.chord(Keys.CONTROL + "A", Keys.DELETE);
				temp.findElement(By.xpath("div[2]/input")).sendKeys(key + "20");
				temp.findElement(By.xpath("div[3]/button")).click();
			}
		}
	}

	private static List<String> datavalue() {
		List<String> test = Arrays.asList("Brocolli", "Brinjal", "Capsicum", "Banana", "Raspberry", "Nuts Mixture");
		return test;
	}

	@AfterTest
	public void summa() {
		driver.quit();
	}
}
