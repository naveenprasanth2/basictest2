package intervew;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

public class SummaAll {
	@Test
	public void test() {
		String chromepath = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromepath);
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> lists = driver.findElements(By.xpath("//input[contains(@value,'radio')]"));
		for (WebElement list : lists) {
			if (list.getAttribute("value").contains("radio3")) {
				list.click();
			}
		}
		driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys("ind");
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(Exception.class);
		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			@Override
			public WebElement apply(WebDriver t) {
				if (t.findElement(By.xpath("//li[@class='ui-menu-item']/div")).isDisplayed()) {
					return t.findElement(By.xpath("//li[@class='ui-menu-item']/div"));
				} else {
					return null;
				}
			}
		});

		List<WebElement> lists1 = driver.findElements(By.xpath("//li[@class='ui-menu-item']/div"));
		for (WebElement list : lists1) {
			if (list.getText().contains("Indonesia")) {
				list.click();
			}
		}
		
	}
}
