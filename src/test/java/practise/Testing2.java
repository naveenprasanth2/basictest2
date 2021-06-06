package practise;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

public class Testing2 {

	@Test
	public void test() throws InterruptedException {
		String chromepath = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromepath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> lists = driver.findElements(By.xpath("//input[@type='radio']"));
		for (WebElement list : lists) {
			if (list.getAttribute("value").equalsIgnoreCase("radio3")) {
				list.click();
			}
		}
		driver.findElement(By.cssSelector("input[id='autocomplete']")).sendKeys("Ind");
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(Exception.class);
		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			@Override
			public WebElement apply(WebDriver t) {
				if (t.findElement(By.cssSelector("li.ui-menu-item")).isDisplayed()) {
					return t.findElement(By.cssSelector("li.ui-menu-item"));
				} else {
					return null;
				}
			}
		});
		List<WebElement> lists1 = driver.findElements(By.cssSelector("li.ui-menu-item"));
		for (WebElement list : lists1) {
			if (list.getText().equalsIgnoreCase("Indonesia")) {
				list.click();
			}
		}
		WebElement element1 = driver.findElement(By.id("dropdown-class-example"));
		Select select = new Select(element1);
		List<WebElement> lists2 = select.getOptions();
		for (WebElement list : lists2) {
			if (list.getText().equalsIgnoreCase("option2")) {
				list.click();
			}
		}
		
		System.out.println(driver.findElement(By.xpath("//input[@value='option1']")).isSelected());
		driver.findElement(By.xpath("//input[@value='option1']")).click();
		System.out.println(driver.findElement(By.xpath("//input[@value='option1']")).isSelected());
		
		driver.findElement(By.id("openwindow")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iter = windows.iterator();
		String parent = iter.next();
		String child = iter.next();
		driver.switchTo().window(child);
		driver.findElement(By.xpath("//a[text()='Courses']")).click();
		Thread.sleep(5000);
		driver.close();
		driver.switchTo().window(parent);
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("naveen");
		Thread.sleep(5000);
		driver.quit();
		
	}
}
