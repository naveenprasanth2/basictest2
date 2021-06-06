package practise2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SelectFunction {
	@Test
	public void test() {
		String chromePath = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.orangehrm.com/orangehrm-30-day-trial/");
		driver.manage().window().maximize();
		WebElement emp = driver.findElement(By.name("NoOfEmployees"));
		WebElement ind = driver.findElement(By.name("Industry"));
		WebElement cou = driver.findElement(By.name("Country"));
		SelectFunction.selecting(emp, DropDown.INDEX.toString(), "2");
		SelectFunction.selecting(ind, DropDown.VALUE.toString(), "Education");
		SelectFunction.selecting(cou, DropDown.VISIBLETEXT.toString(), "Bangladesh");

	}

	public static void selecting(WebElement element, String type, String value) {
		Select select = new Select(element);
		switch (type) {
		case "index":
			select.selectByIndex(Integer.parseInt(value));
			break;
		case "value":
			select.selectByValue(value);
			break;
		case "visibletext":
			select.selectByVisibleText(value);
			break;
		default:
			System.out.println("please enter a valid value");
		}

	}

}
