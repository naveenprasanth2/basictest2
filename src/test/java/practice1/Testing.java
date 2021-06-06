package practice1;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

public class Testing {
	@Test
	public void test() throws InterruptedException {
		String chromePath = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> lists1 = driver.findElements(By.cssSelector("input.radioButton"));
		for (WebElement list : lists1) {
			if (list.getAttribute("value").contains("3")) {
				list.click();
			}
		}
		driver.findElement(By.id("autocomplete")).sendKeys("ind");
//		WebDriverWait wait = new WebDriverWait(driver, 5);
//		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[@class='ui-menu-item']/div")));
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(Throwable.class);
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
		List<WebElement> lists2 = driver.findElements(By.xpath("//li[@class='ui-menu-item']/div"));
		for (WebElement list : lists2) {
			if (list.getText().equalsIgnoreCase("india")) {
				list.click();
			}
		}
		Thread.sleep(2000);
		String key = Keys.chord(Keys.CONTROL + "A", Keys.DELETE);
		driver.findElement(By.id("autocomplete")).sendKeys(key);
		driver.navigate().refresh();
		driver.quit();
	}

}
