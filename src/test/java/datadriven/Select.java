package datadriven;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

public class Select {
	@Test
	public void test() {
		String path = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		ArrayList<String> cart = new ArrayList<String>();
		cart.add("Cucumber");
		cart.add("Pumpkin");
		cart.add("Apple");

		List<WebElement> items = driver.findElements(By.cssSelector(".product-name"));
		for (WebElement item : items) {
			if (item.getText().length() > 8) {
				String test = item.getText().substring(0, item.getText().length() - 7);
				System.out.println(test);
				if (cart.contains(test)) {
					WebElement addcart = item
							.findElement(By.xpath("parent::div //div[@class='product-action']/button"));
					addcart.click();
				}

			}
		}
		driver.quit();
	}

}
