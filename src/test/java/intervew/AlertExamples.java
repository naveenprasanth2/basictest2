package intervew;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.Collator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AlertExamples {
	WebDriver driver;

	@Test
	public void test() throws InterruptedException, MalformedURLException, IOException {
		String chromePath = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("naveen");
		driver.findElement(By.id("alertbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("summa");
		driver.findElement(By.id("confirmbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.id("mousehover"))).perform();
		act.keyDown(Keys.CONTROL).moveToElement(driver.findElement(By.xpath("//div/a[text()='Reload']"))).click().release().perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,1000)");
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("courses-iframe"));
		driver.findElement(By.xpath("//li/a[text()='Courses']")).click();
		driver.switchTo().parentFrame();
		List<WebElement> links = driver.findElements(By.cssSelector("li.gf-li a"));
		for (WebElement link : links) {
			URL url = new URL(link.getAttribute("href"));
			HttpURLConnection connect = (HttpURLConnection) url.openConnection();
			connect.connect();
			connect.getHeaderField("HEAD");
			int response = connect.getResponseCode();
			if (response > 400) {
				System.out.println("link not working " + link.getText());
			} else {
				System.out.println("link is working " + link.getText());
			}

		}
		driver.quit();
	}

}
