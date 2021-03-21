package Selenium.basictest;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class broken_links_scroll {
	
	@Test
	
	public void broken() throws InterruptedException, IOException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.cssSelector("input[value='radio2']")).click();
		WebElement radio = driver.findElement(By.cssSelector("input[value='radio2']"));
		String text = radio.findElement(By.xpath("parent::label")).getText();
		System.out.println(text);
		driver.findElement(By.id("autocomplete")).sendKeys("ger");
		Thread.sleep(4000);
		List<WebElement> countryList = driver.findElements(By.cssSelector("li.ui-menu-item"));
		List<WebElement> country = countryList.stream().filter(s-> s.getText().toLowerCase().contains("germany")).collect(Collectors.toList());
		country.forEach(s-> System.out.println(s));
		int position1 = 0;
		for(WebElement country1 : countryList)
		{
			position1++;
			if(country1.getText().toLowerCase().equals("germany"))
			{
				break;
			}
		}
		System.out.println(position1);
		for(int i = 0; i<position1;i++)
		{
			driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
		}
		
		System.out.println((driver.findElement(By.id("autocomplete")).getAttribute("value")));
		driver.findElement(By.id("autocomplete")).sendKeys(Keys.ENTER);
		TakesScreenshot sc = (TakesScreenshot) driver;
		File src = sc.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("D:\\Screenshots\\rahul.png"));
		File src1 = driver.findElement(By.cssSelector("div.cen-left-align")).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src1, new File("D:\\Screenshots\\element.png"));
		Thread.sleep(2000);
		WebElement seldrop = driver.findElement(By.id("dropdown-class-example"));
		Select drop = new Select(seldrop);
		drop.selectByVisibleText("Option2");
		
		driver.findElement(By.cssSelector("label[for='honda'] input[id='checkBoxOption3']")).click();
		System.out.println(driver.findElement(By.cssSelector("label[for='honda']")).getText());
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,500)");
		
		//WebElement table = driver.findElement(By.cssSelector("div.tableFixHead"));
		js.executeScript("document.querySelector('div.tableFixHead').scrollTop=5000");
		//js.executeScript("document.querySelector('div.tablefixHead').scrollLeft=2000");
		
		List<WebElement> content = driver.findElements(By.xpath("//table[@id='product']/tbody/tr/td[1]"));
		List<String> amo = content.stream().filter(s-> s.getText().toLowerCase().contains("ronaldo"))
		.map(s->newamount(s)).collect(Collectors.toList());
		amo.forEach(s-> System.out.println(s));
		
		List<WebElement> amounts = driver.findElements(By.xpath("//table[@id='product']/tbody/tr/td[4]"));
//		amounts.stream().filter(s-> Integer.parseInt(s.getText())).collect(Collectors.summingInt(Integer::intvalue));
		int total = 0;
		for(WebElement amount : amounts)
		{
			total+=Integer.parseInt(amount.getText());
		}
		
		System.out.println("This the total value "+total);
		
		String giventotal = driver.findElement(By.cssSelector("div.totalAmount")).getText();
		String[] ele = giventotal.split(" ");
		String lastval = "";
		for (String el : ele)
		{
			lastval=el.trim();
		}
//		country.forEach(s-> s.click());
		Assert.assertTrue(Integer.parseInt(lastval)==total, "Both values are same");
	}
public String newamount(WebElement x)
{
	String amount = x.findElement(By.xpath("following-sibling::td[3]")).getText();
	return amount;
	
}
}
