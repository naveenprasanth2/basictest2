package practise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Testing3 {
	@Test
	public void test() throws InterruptedException {
		String chromepath = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromepath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("naveen");
		driver.findElement(By.id("alertbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("naveen");
		driver.findElement(By.id("confirmbtn")).click();
		driver.switchTo().alert().dismiss();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,500)");
		js.executeScript("document.querySelector('div.tableFixHead').scrollTop=5000");
		List<WebElement> test = driver.findElements(By.xpath("//table[@id='product'] //tr/td[4]"));
		Integer x = 0;
		for (WebElement list : test) {
			x += Integer.parseInt(list.getText());
		}

		if (x == Integer.parseInt(driver.findElement(By.cssSelector("div.totalAmount")).getText()
				.split(":")[1].replace(" ", ""))) {
			System.out.println("equal");
		} else {
			System.out.println("not equal");
		}
	}

}
