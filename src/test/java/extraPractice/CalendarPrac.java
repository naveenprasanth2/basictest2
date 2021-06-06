package extraPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CalendarPrac {
	static WebDriver driver;

	@Test
	public void test() {
		String chromePath = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		driver.findElement(By.id("datepicker")).click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.id("ui-datepicker-div"))));
		CalendarPrac.calender("May", "29", "2021");
	}

	public static String[] splittedValue(String total) {
		String[] values = total.split(" ");
		return values;
	}

	public static void calender(String month, String day, String year) {
		String total = driver.findElement(By.className("ui-datepicker-title")).getText();
		while (!(splittedValue(total)[1].trim().equals(year) && (splittedValue(total)[0].trim().equals(month)))) {
			driver.findElement(By.xpath("//a[@title='Next']")).click();
			total = driver.findElement(By.className("ui-datepicker-title")).getText();
		}
		try {
			driver.findElement(By.xpath("//a[text()='" + day + "']")).click();
		}
		catch(Exception e) {
			System.out.println("Enter a valid date "+month+" is not having a valid date as :"+day);
		}
	}
}
