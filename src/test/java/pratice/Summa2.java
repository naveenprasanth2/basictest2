package pratice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Summa2 {
	@Test
	public void test() throws IOException, MalformedURLException {
		String chromepath = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromepath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		SoftAssert assert1 = new SoftAssert();
		List<WebElement> links = driver.findElements(By.cssSelector("li.gf-li a"));
		for (WebElement link : links) {
			String value = link.getAttribute("href");
			URL url = new URL(value);
			HttpURLConnection connect = (HttpURLConnection) url.openConnection();
			connect.connect();
			connect.getHeaderField("HEAD");
			int response = connect.getResponseCode();
			if (response < 400) {
				System.out.println("link working");
			} else {
				System.out.println("link not working");
			}
		}


		driver.findElement(By.id("autocomplete")).sendKeys("ind");
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(50))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(Exception.class);
		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			@Override
			public WebElement apply(WebDriver t) {
				if (t.findElement(By.xpath("//li[@class='ui-menu-item']")).isDisplayed()) {
					return t.findElement(By.xpath("//li[@class='ui-menu-item']"));
				} else {
					return null;
				}
			}
		});

		List<WebElement> lists = driver.findElements(By.xpath("//li[@class='ui-menu-item']"));
		for (WebElement list : lists) {
			if (list.getText().equalsIgnoreCase("india")) {
				list.click();
			}
		}
	}
}
