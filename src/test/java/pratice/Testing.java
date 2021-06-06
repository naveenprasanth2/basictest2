package pratice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Testing {
	@Test
	public void test() throws InterruptedException {
		String chromepath = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromepath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		Actions act = new Actions(driver);
		WebElement frame = driver.findElement(By.cssSelector("iframe.demo-frame.lazyloaded"));
		driver.switchTo().frame(frame);
		WebElement ele1 = driver.findElement(By.xpath("//img[@alt='The peaks of High Tatras']"));
		WebElement ele2 = driver.findElement(By.xpath("//div[@id='trash']"));
		act.clickAndHold(ele1).moveToElement(ele2).click().release(ele1).perform();
	}
}
