package lastprac;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Rahulshetty1 {
	@Test
	public void test() throws IOException {
		String path = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		ArrayList<String> names = new ArrayList<String>();
		names.add("Dwayne");
		names.add("Jack");

		List<WebElement> tableValues = driver.findElements(By.xpath("//div[@class='tableFixHead'] //tbody/tr/td[1]"));
		for (WebElement values : tableValues) {
			if (names.contains(values.getText())) {
				System.out.println(values.findElement(By.xpath("following-sibling::td[3]")).getText());
			}
		}

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,1000)");

		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.id("mousehover"))).build().perform();
		List<WebElement> mouse = driver.findElements(By.xpath("//div[@class='mouse-hover-content']/a"));
		for (WebElement value : mouse) {
			if (value.getText().equalsIgnoreCase("Reload")) {
				act.moveToElement(value).build().perform();
			}
		}
		driver.switchTo().frame("courses-iframe");
		driver.findElement(By.xpath("//a[text()='Mentorship']")).click();
		js.executeScript("window.scroll(0,1000)");
		driver.switchTo().parentFrame();
		int position = 0;
		List<WebElement> table = driver.findElements(By.xpath("//tbody/tr/th"));

		for (int i = 0; i < table.size(); i++) {
			if (table.get(i).getText().equalsIgnoreCase("price")) {
				position = i + 1;
				System.out.println(table.get(i).getText());
				break;
			}
		}
		List<WebElement> data = driver.findElements(By.xpath("//tbody/tr/td" + "[" + position + "]"));
		for (int i = 0; i < data.size() / 2; i++) {
			System.out.println(data.get(i).getText());
		}

		List<WebElement> urlls = driver.findElements(By.cssSelector("li.gf-li a"));
		for (WebElement list : urlls) {
			URL url = new URL(list.getAttribute("href"));
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.connect();
			con.getHeaderField("HEAD");
			int response = con.getResponseCode();
			if (response > 400) {
				System.out.println("link not working");
			} else {
				System.out.println("link working");
			}
		}

		driver.close();
	}

}
