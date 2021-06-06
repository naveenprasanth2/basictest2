package intervew;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GreenKart {
	WebDriver driver;

	@Test(dataProvider = "data")
	public void test(ArrayList<String> test) {
		String chromePath = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		List<WebElement> values = driver.findElements(By.cssSelector("h4.product-name"));
		for (WebElement value : values) {
			if (test.contains(value.getText().split("-")[0].strip())) {
				WebElement parent = value.findElement(By.xpath("parent::div"));
				parent.findElement(By.xpath("div[2]/input")).sendKeys(Keys.CONTROL + "A", Keys.DELETE);
				parent.findElement(By.xpath("div[2]/input")).sendKeys("20");
				parent.findElement(By.xpath("div[3]/button")).click();
			}

		}
	}

	@DataProvider(name = "data")
	public Object[][] data() {
		Object[][] o = new Object[1][];
		String[] name = { "Brocolli", "Tomato", "Onion", "Raspberry", "Capsicum" };
		ArrayList<String> test = new ArrayList<String>(Arrays.asList(name));
		o[0] = new Object[] { test };
		return o;
	}
}
