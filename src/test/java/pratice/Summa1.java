package pratice;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Summa1 {
	@Test(dataProvider="summa1")
	public void test(String testing ) throws InterruptedException{

		String chromepath = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromepath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> radios = driver.findElements(By.cssSelector("input[value*='radio']"));
		for (WebElement radio : radios) {
			if (radio.getAttribute("value").equals("radio3")) {
				radio.click();
			}
		}
		driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys(testing);

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.ui-menu-item")));
		List<WebElement> drops = driver.findElements(By.cssSelector("li.ui-menu-item"));
		for (WebElement drop : drops) {
			if (drop.getText().equalsIgnoreCase("india")) {
				drop.click();
			}
		}
		WebElement selec = driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
		Select select = new Select(selec);
		select.selectByVisibleText("Option2");
		List<WebElement> checks = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for (WebElement check : checks) {
			if (check.getAttribute("name").contains("Option2")) {
				check.click();
			}
		}
		driver.findElement(By.id("openwindow")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iter = windows.iterator();
		String parent = iter.next();
		String child =  iter.next();

		driver.switchTo().window(child);
		driver.findElement(By.xpath("//a[text()='Videos']")).click();
		Thread.sleep(5000);
		driver.close();
		driver.switchTo().window(parent);
		driver.findElement(By.id("name")).sendKeys("naveen");
		driver.findElement(By.id("alertbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		driver.findElement(By.id("name")).sendKeys("naveen");
		driver.findElement(By.id("confirmbtn")).click();
		driver.switchTo().alert().dismiss();
	}

	@DataProvider(name="summa1")
	public Object[][] summa1(){
		Object[][] test = new Object[1][1];
		test[0][0] = "ind";
		return test;
		
	}
	
}
