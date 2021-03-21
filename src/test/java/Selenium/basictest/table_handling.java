package Selenium.basictest;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class table_handling {
	
	@Test
	
	public void table()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
		List <WebElement> heads = driver.findElements(By.tagName("th"));
		int i = 0;
		for (WebElement head : heads)
		{
			if(head.getText().contains("Strcture"))
			{
				break;
			}
			i++;
		}
		System.out.println(i);

	}}
