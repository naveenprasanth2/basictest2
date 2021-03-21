package finalprac;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RahulShetty1 {
	WebDriver driver;

	@Test
	public void test() throws IOException {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		SoftAssert soft = new SoftAssert();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		ArrayList<String> list = new ArrayList<String>();
		list.add("Raymond");
		list.add("Smith");
		List<WebElement> tablevalues = driver.findElements(By.xpath("//div[@class='tableFixHead'] //td[1]"));
		for(WebElement tablevalue : tablevalues){
		if(list.contains(tablevalue.getText())){
		System.out.println(tablevalue.findElement(By.xpath("following-sibling::td[3]")).getText());
		}
		}
}

}
