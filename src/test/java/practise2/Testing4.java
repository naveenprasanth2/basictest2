package practise2;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Testing4 {
	WebDriver driver;

	@Test
	public void test() throws InterruptedException, MalformedURLException, IOException {
		String chromePath = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']"));
//		WebElement frame = driver.findElement(By.cssSelector("iframe.demo-frame.lazyloaded"));
		driver.switchTo().frame(frame);
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//li[1]"))));
		act.clickAndHold(driver.findElement(By.xpath("//li[1]")))
				.moveToElement(driver.findElement(By.xpath("//div[@id='trash']"))).click().release().perform();
		Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(Exception.class);
		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			@Override
			public WebElement apply(WebDriver t) {
				if (t.findElement(By.xpath("")).isDisplayed()) {
					return t.findElement(By.xpath(""));
				} else {
					return null;
				}
			}
		});
	}
}