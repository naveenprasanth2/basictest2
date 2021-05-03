package Selenium.basictest;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class draganddrop {

	@Test(dataProvider="test")

	public void drag(String name, String name1) throws IOException {
//		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://jqueryui.com/droppable/");
//		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
//		WebElement drag = driver.findElement(By.id("draggable"));
//		WebElement drop = driver.findElement(By.id("droppable"));
//		Actions act = new Actions(driver);
//		act.click(drag).dragAndDrop(drag, drop).build().perform();;
//		System.out.println(drop.getText());
//		driver.switchTo().parentFrame();
//		System.out.println(driver.findElement(By.cssSelector("aside.widget a[href*='sortable']")).getText());

//		Actions act = new Actions(driver);
//		act.click(drop).build().perform();
//		act.doubleClick(drop).build().perform();
//		act.keyDown(Keys.F5).build().perform();
//		act.keyUp(Keys.ALT).build().perform();
//		act.dragAndDrop(drag,drop).build().perform();
//		act.moveToElement(drop).build().perform();
//		act.clickAndHold(drop).build().perform();

//		List<WebElement> dropdown = driver.findElements(By.xpath("//div[@class='li']"));
//		for (WebElement drop1 : dropdown) {
//			if (drop1.getText().contains("india")) {
//				drop1.click();
//			}
//		}
		System.out.println(name +" "+name1);

	}
	@DataProvider(name="test")
	public Object[][] test(){
		Object[][] summa = new Object[2][2];
		summa[0][0] = "test00";
		summa[0][1] = "test01";
		summa[1][0] = "test10";
		summa[1][1] = "test11";
		return summa;
	}
}
