package lastprac;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Rahulshetty {

	@Test
	public void test() throws InterruptedException {
		String path = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		List<WebElement> radios = driver.findElements(By.xpath("//label[contains(@for,'radio')]"));
		radios.stream().filter(s -> s.getText().contains("Radio2"))
				.forEach(s -> s.findElement(By.xpath("input")).click());
		driver.findElement(By.id("autocomplete")).sendKeys("ind");
		List<WebElement> items = driver.findElements(By.className("ui-menu-item"));
		for (WebElement item : items) {
			WebElement ite = item.findElement(By.xpath("div"));
			if (ite.getText().equalsIgnoreCase("Indonesia")) {
				ite.click();
				break;
			}
		}
		WebElement element = driver.findElement(By.id("dropdown-class-example"));
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText("Option3");

		List<WebElement> checkboxes = driver.findElements(By.xpath("//label[contains(text(),Option)]"));
		for (WebElement checkbox : checkboxes) {
			if (checkbox.getText().equalsIgnoreCase("option3")) {
				checkbox.findElement(By.xpath("input")).click();
				break;
			}
		}
		
		driver.findElement(By.id("openwindow")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> ite = windows.iterator();
		String parent = ite.next();
		String child = ite.next();
		driver.switchTo().window(child);
		String title = driver.getCurrentUrl();
		System.out.println(title);
		driver.close();
		driver.switchTo().window(parent);
		System.out.println(driver.getTitle());
		
		driver.findElement(By.id("name")).sendKeys("naveen");
		driver.findElement(By.id("alertbtn")).click();
		String alerttext = driver.switchTo().alert().getText();
		System.out.println(alerttext);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		driver.findElement(By.id("name")).sendKeys("naveen");
		driver.findElement(By.id("confirmbtn")).click();
		driver.switchTo().alert().dismiss();
		
		System.out.println(driver.findElement(By.id("displayed-text")).isDisplayed());
		driver.findElement(By.id("hide-textbox")).click();
		System.out.println(driver.findElement(By.id("displayed-text")).isDisplayed());
		driver.findElement(By.id("show-textbox")).click();
		System.out.println(driver.findElement(By.id("displayed-text")).isDisplayed());
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,500)");
		js.executeScript("document.querySelector('div.tableFixHead').scrollTop=5000");
		
	}

}
