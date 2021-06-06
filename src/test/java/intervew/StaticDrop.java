package intervew;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class StaticDrop {
	@Test
	public void test() {
		String chromePath = System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.orangehrm.com/orangehrm-30-day-trial/");
		WebElement emp = driver.findElement(By.xpath("//select[@name='NoOfEmployees']"));
		WebElement ind = driver.findElement(By.xpath("//select[@name='Industry']"));
		WebElement country = driver.findElement(By.xpath("//select[@name='Country']"));
		selecting(emp,Values.INDEX.toString(),"5");
		selecting(ind,Values.VISIBLETEXT.toString(),"Business Services / Consultancy - Non IT");
		selecting(country,Values.VALUE.toString(),"Anguilla");
	}
	public static void selecting(WebElement element,String type , String value){
		Select select = new Select(element);
		switch(type) {
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
			System.out.println("Enter valid values");

		}
	}
}
