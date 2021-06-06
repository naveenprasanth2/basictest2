package practice1;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Testing1 {
	@Test
	public void test() throws IOException {
		String chromePath = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement ele = driver.findElement(By.id("dropdown-class-example"));
		Testing1.selectmethod(ele, selectenum.VISIBLETEXT.toString(), "Option1");
		List<WebElement> lists = driver.findElements(By.xpath("//li //a"));
		for (WebElement list : lists) {
			URL url = new URL(list.getAttribute("href"));
			HttpURLConnection connect = (HttpURLConnection) url.openConnection();
			connect.connect();
			connect.getHeaderField("HEAD");
			int response = connect.getResponseCode();
			if (response > 400) {
				System.out.println("link is not working " + list.getText());
			} else {
				System.out.println("link is working " + list.getText());
			}
		}
	}

	public static void selectmethod(WebElement ele, String type, String value) {
		Select select = new Select(ele);
		switch (type) {
		case "index":
			select.selectByIndex(Integer.parseInt(value));
			break;
		case "visibletext":
			select.selectByVisibleText(value);
			break;
		case "value":
			select.selectByValue(value);
			break;
		default:
			System.out.println("enter valid data");
		}

	}
}