package Selenium.basictest;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class handling_alerts {
	
	@Test
	
	public void handling() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		SoftAssert ass = new SoftAssert();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.findElement(By.id("name")).sendKeys("test");
		driver.findElement(By.id("alertbtn")).click();
		Thread.sleep(2000);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		driver.findElement(By.id("name")).sendKeys("confirmtest");
		driver.findElement(By.id("confirmbtn")).click();
		Thread.sleep(2000);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		List<WebElement> elements = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr/td[1]"));
		List<Integer> value = elements.stream().map(s-> Integer.parseInt(s.findElement(By.xpath("following-sibling::td[2]"))
				.getText())).collect(Collectors.toList());
		int sum = value.stream().mapToInt(i-> i.intValue()).sum();
		System.out.println(sum);
		
		ass.assertTrue(driver.findElement(By.cssSelector("input[id='displayed-text']")).isDisplayed(),"Displayed");
		driver.findElement(By.cssSelector("input[id='hide-textbox']")).click();
		ass.assertTrue(driver.findElement(By.cssSelector("input[id='displayed-text']")).isDisplayed(),"not Displayed");
		driver.findElement(By.cssSelector("input[id='show-textbox']")).click();
		ass.assertTrue(driver.findElement(By.cssSelector("input[id='displayed-text']")).isDisplayed(),"Displayed");
		
		System.out.println("done");
		WebElement actionelement = driver.findElement(By.cssSelector("button[id='mousehover']"));
		System.out.println(actionelement.getAttribute("class"));
		Actions action = new Actions (driver);
//		js.executeAsyncScript("window.scroll(0,800)");
		action.moveToElement(actionelement).build().perform();
		action.moveToElement(driver.findElement(By.cssSelector("div.mouse-hover-content"))).build().perform();
//		ass.assertAll();
		driver.switchTo().frame(driver.findElement(By.id("courses-iframe")));
		driver.findElement(By.cssSelector("ul.navigation.clearfix  a[href*='courses']")).click();
	
	}
	
}


