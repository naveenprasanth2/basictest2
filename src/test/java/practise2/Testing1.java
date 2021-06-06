package practise2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Testing1 {
	@Test
	public void test() {
		String chromePath = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebElement seleParent = driver.findElement(By.id("dropdown-class-example"));
		Select select = new Select(seleParent);
		List<WebElement> lists = select.getOptions();
		for (WebElement list : lists) {
			if (list.getText().contains("Option2")) {
				list.click();
			}
		}
		System.out.println(driver.findElement(By.xpath("//input[@value='option2']")).isSelected());
		driver.findElement(By.xpath("//input[@value='option2']")).click();
		System.out.println(driver.findElement(By.xpath("//input[@value='option2']")).isSelected());

	}
}
