package practise2;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

public class Testing {
	@Test
	public void test() {
		String chromePath = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> lists = driver.findElements(By.cssSelector("input.radioButton"));
		for (WebElement list : lists) {
			if (list.getAttribute("value").equalsIgnoreCase("radio3")) {
				list.click();
			}
		}
		driver.findElement(By.id("autocomplete")).sendKeys("ind");
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(Exception.class);
		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			@Override
			public WebElement apply(WebDriver t) {
				if (driver.findElement(By.cssSelector("li.ui-menu-item div")).isDisplayed()) {
					return driver.findElement(By.cssSelector("li.ui-menu-item div"));
				} else {
					return null;
				}
			}

		});

		List<WebElement> lists1 = driver.findElements(By.cssSelector("li.ui-menu-item div"));
		for (WebElement list1 : lists1) {
			if (list1.getText().contains("Indonesia")) {
				list1.click();
			}
		}
	}

}
