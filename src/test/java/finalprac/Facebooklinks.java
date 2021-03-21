package finalprac;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Facebooklinks {
	@Test
	public void test() throws IOException {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");
		ChromeOptions co = new ChromeOptions();
		int i = 0;
		co.addArguments("headless");
		WebDriver driver = new ChromeDriver(co);
		driver.get("https://www.facebook.com/help/instagram/728869160569983");
		List<WebElement> links = driver.findElements(By.xpath("//link"));
		System.out.println(links.size());
		for (WebElement link : links) {
			i++;
			URL url = new URL(link.getAttribute("href"));
			HttpURLConnection connect = (HttpURLConnection) url.openConnection();
			connect.connect();
			connect.getHeaderField("HEAD");
			int response = connect.getResponseCode();
			if (response > 400) {
				System.out.println("link is not working " + link.getText());
			}
			else {
				System.out.println("link is working " + link.getText());
			}
		}
System.out.println(i);
	}

}
