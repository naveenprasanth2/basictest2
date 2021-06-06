package practise2;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Testing3 {
	WebDriver driver;

	@Test
	public void test() throws InterruptedException, MalformedURLException, IOException {
		String chromePath = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> lists = driver.findElements(By.xpath("//li //a"));
		for (WebElement list : lists) {
			URL url = new URL(list.getAttribute("href"));
			HttpURLConnection connect = (HttpURLConnection) url.openConnection();
			connect.setRequestMethod("HEAD");
			connect.connect();
			int response = connect.getResponseCode();
			if (response > 400) {
				System.out.println("link is not working " + list.getText());
			} else {
				System.out.println("link is working " + list.getText());
			}
		}
	}
}
