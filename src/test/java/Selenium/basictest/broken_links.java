package Selenium.basictest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class broken_links {

	@Test

	public void broken() throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		WebElement Interactions = driver.findElement(By.xpath("//h3[text()='Interactions']/parent::aside"));
		List<WebElement> elements = Interactions.findElements(By.xpath("ul/li/a"));
		List<String> Links = elements.stream().map(s -> s.getAttribute("href")).collect(Collectors.toList());
		Links.forEach(s -> System.out.println(s));
		int i =0;
		for (String Link : Links) {
			URL link = new URL(Link);
			HttpURLConnection connect = (HttpURLConnection) link.openConnection();
			connect.setRequestMethod("HEAD");
			connect.connect();
			int response = connect.getResponseCode();
			if (response > 400) {
				System.out.println("Link is broken " + Interactions.findElements(By.xpath("ul/li/a")).get(i).getText());
			} else {
				System.out.println("Link is working fine " + Interactions.findElements(By.xpath("ul/li/a")).get(i).getText());
			}
			i++;
		}

	}

	}


