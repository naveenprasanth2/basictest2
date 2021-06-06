package extraPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class MultiSelect {
	@Test
	public void test() {
		String chromePath = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.orangehrm.com/orangehrm-30-day-trial/");
		WebElement emp = driver.findElement(By.name("NoOfEmployees"));
		WebElement ind = driver.findElement(By.name("Industry"));
		WebElement cou = driver.findElement(By.name("Country"));

		MultiSelect.selectby(emp, Dropdown.INDEX.toString(), "2");
		MultiSelect.selectby(ind, Dropdown.VALUE.toString(), "Automotive");
		MultiSelect.selectby(cou, Dropdown.VISIBLETEXT.toString(), "Benin");

	}

	public static void selectby(WebElement ele, String type, String value) {

		Select select = new Select(ele);
		switch (type) {
		case "index":
			select.selectByIndex(Integer.parseInt(value));
			break;
		case "value":
			select.selectByValue(value);
			break;
		case "visibletext":
			select.selectByVisibleText(value);
		default:
			System.out.println("Please enter valid value");
		}
	}
}
