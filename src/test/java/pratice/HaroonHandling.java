package pratice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HaroonHandling {

	@Test
	public void test() throws InterruptedException {
		String chromepath = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromepath);
		WebDriver driver = new ChromeDriver();
		String month = "February";
		String year = "2022";
		driver.get("https://www.spicejet.com/");
		driver.findElement(By.xpath("(//input[@type='text'])[1]")).click();
		Boolean x = true;
		while (x == true) {
			if ((!(driver.findElement(By.xpath("(//span[@class='ui-datepicker-year'])[1]")).getText()
					.contains(year)))) {
				if ((!(driver.findElement(By.xpath("(//span[@class='ui-datepicker-year'])[2]")).getText()
						.contains(year)))) {
					driver.findElement(By.xpath("//a[@title='Next']")).click();
				} else {
					x = false;
				}
			} else {
				x = false;
			}
		}
		x = true;
		while (x == true) {
			if ((!(driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[1]")).getText()
					.contains(month)))) {
				if ((!(driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[2]")).getText()
						.contains(month)))) {
					driver.findElement(By.xpath("//a[@title='Next']")).click();
				} else {
					x = false;
				}
			} else {
				x = false;
			}
		}
		x = true;
		while (x == true) {
			if (((driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[1]")).getText()
					.contains(month)))) {
				WebElement dateAncest = driver
						.findElement(By.xpath("(((//span[@class='ui-datepicker-month'])[1])/parent::div)/parent::div"));
				List<WebElement> finalvalues = dateAncest
						.findElements(By.xpath("(following-sibling::table)/tbody/tr //td/a"));
				for (WebElement value : finalvalues) {
					if (value.getText().equals("23")) {
						value.click();
						x = false;
						break;
					}
				}
			} else if (((driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[2]")).getText()
					.contains(month))) && x) {
				WebElement dateAncest1 = driver
						.findElement(By.xpath("(((//span[@class='ui-datepicker-month'])[2])/parent::div)/parent::div"));
				List<WebElement> finalvalues1 = dateAncest1
						.findElements(By.xpath("(following-sibling::table)/tbody/tr //td/a"));
				for (WebElement value : finalvalues1) {
					if (value.getText().equals("23")) {
						value.click();
						x = false;
						break;
					}
				}
				
			}
		}
		Thread.sleep(5000);
		driver.quit();
	}
}
